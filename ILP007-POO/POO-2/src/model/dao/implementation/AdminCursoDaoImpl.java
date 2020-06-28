package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import model.dao.AdminCursoDao;
import model.dao.DaoFactory;
import model.entities.Curso;

public class AdminCursoDaoImpl implements AdminCursoDao {
	
	private DaoFactory daoFactory;
	
	public AdminCursoDaoImpl() {
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
			rs = stm.executeQuery();	
			
			while(rs.next()){
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setTitulo(rs.getString("nome"));
				curso.setDescricao(rs.getString("titulo"));
				System.out.println("Curso: " + curso.getTitulo() + " encontrado!");
				lista.add(curso);
				}
			return lista;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	
	@Override
	public void cadastrar(Curso curso) {
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO Curso (titulo, descricao) VALUES (?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, curso.getTitulo());
			stm.setString(2, curso.getDescricao());
			stm.executeUpdate();
			con.close();
		}catch ( SQLException e ){
			e.printStackTrace();
		}catch (DateTimeException de) {
			System.out.println("Erro na conversao de data do curso: " + curso.getDescricao());
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
			String sql = "UPDATE Curso SET titulo = ?, descricao = ? WHERE id = ?)";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, curso.getTitulo());
				stm.setString(2, curso.getDescricao());
				stm.setInt(3, curso.getId());
				stm.executeUpdate();
				con.close();
				System.out.println("Curso: " + curso.getTitulo() + " Alterado com sucesso!");
				return true;	
			} catch (SQLException e) {
				System.out.println("Curso: " + curso.getTitulo() + "Não pode ser alterado");
				e.printStackTrace();
			}catch (DateTimeException de) {
				System.out.println("Erro na conversao de data do curso: " + curso.getTitulo());
				de.printStackTrace();
			}
		return false;
	}
}
