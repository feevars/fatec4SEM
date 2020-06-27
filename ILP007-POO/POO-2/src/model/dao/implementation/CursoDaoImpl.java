package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import model.dao.CursoDao;
import model.dao.DaoFactory;
import model.entities.Curso;

public class CursoDaoImpl implements CursoDao {
	
	private DaoFactory daoFactory;
	
	public CursoDaoImpl() {
		daoFactory = new DaoFactory();
	}
	

	@Override
	public List<Curso> pesquisarPorNome(String nome) {
		List<Curso> lista = new ArrayList<Curso>(); 
		try {	
			Connection con = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Curso";
			PreparedStatement stm = con.prepareStatement(sql);
			//stm.setString(1, nome);
			rs = stm.executeQuery();	
			
			while(rs.next()){
				Curso curso = new Curso();
				curso.setId(rs.getInt("Id"));
				curso.setNome(rs.getString("nome"));
				curso.setDescricao(rs.getString("descricao"));
				curso.setTotalHoras(rs.getInt("totalHoras"));
				curso.setDataCriacao(rs.getDate("dataCriacao"));
				curso.setDataAtualizacao(rs.getDate("dataAtualizacao"));
				System.out.println("Curso: " + curso.getNome() + " encontrado!");
				lista.add(curso);
				}
			return lista;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	
	@Override
	public void cadastrar(Curso c) {
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO Curso (nome, descricao, totalHoras, dataCriacao)"
				+ " VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, c.getNome());
			stm.setString(2, c.getDescricao());
			stm.setLong(3, c.getTotalHoras());
			stm.setDate(4, (java.sql.Date) c.getDataCriacao());
			stm.executeUpdate();
			con.close();
		}catch ( SQLException e ){
			e.printStackTrace();
		}catch (DateTimeException de) {
			System.out.println("Erro na conversao de data do curso: " + c.getNome());
			de.printStackTrace();
		}
		
	}


	@Override
	public void excluir(Integer id) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "DELETE FROM Curso WHERE id = ?";		
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			con.close();
			System.out.println("Curso de id " + id + " deletado!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar curso de id " + id);
			e.printStackTrace();
		}
	}


	@Override
	public boolean editar(Curso curso) {
		try {				
			Connection con = daoFactory.getConnection();
			String sql = "UPDATE Curso SET nome = ?, descricao = ? totalHoras = ? dataAtualizao = ? WHERE id = ?)";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, curso.getNome());
				stm.setString(2, curso.getDescricao());
				stm.setInt(3, curso.getTotalHoras());
				stm.setDate(4, (java.sql.Date) curso.getDataAtualizacao());
				stm.setInt(5, curso.getId());
				stm.executeUpdate();
				con.close();
				System.out.println("Curso: " + curso.getNome() + " Alterado com sucesso!");
				return true;	
			} catch (SQLException e) {
				System.out.println("Curso: " + curso.getNome() + "Não pode ser alterado");
				e.printStackTrace();
			}catch (DateTimeException de) {
				System.out.println("Erro na conversao de data do curso: " + curso.getNome());
				de.printStackTrace();
			}
		return false;
	}



}
