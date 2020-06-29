package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.DaoFactory;
import model.dao.EstudanteDao;
import model.entities.Estudante;
import model.entities.Instrutor;

public class EstudanteDaoImpl implements EstudanteDao {
	
	private DaoFactory daoFactory = new DaoFactory();

	@Override
	public void estudanteCadastro(Estudante estudante) {
		try{
			Connection con = daoFactory.getConnection();
			String sql = "INSERT INTO Estudante (username, password, nome, sobrenome, email, telefone, dataNascimento)"
					   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, estudante.getUsername());
			stm.setString(2, estudante.getPassword());
			stm.setString(3, estudante.getNome());
			stm.setString(4, estudante.getSobrenome());
			stm.setString(5, estudante.getEmail());
			stm.setString(6, estudante.getTelefone());
			stm.setDate(7, estudante.getDataNascimento());
			stm.executeUpdate();
			con.close();
			}catch(SQLException se) {
				se.printStackTrace();
				System.out.println("Erro ao cadastrar usuário");
			}
	}

	
	//private Integer id;
	//private String username;
	//private String password;
	//private String email;
	//private Integer pontos;
	
	@Override
	public void estudanteEditarPerfil(Estudante estudante) {
		Connection con = daoFactory.getConnection();
		String sql = "UPDATE Estudante SET nome = ?, sobrenome = ?, telefone = ?, dataNascimento = ?, instrutor = ?"
				   + "WHERE id = ?";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, estudante.getNome());
			stm.setString(2, estudante.getSobrenome());
			stm.setString(3, estudante.getTelefone());
			stm.setDate(4, estudante.getDataNascimento());
			if (estudante instanceof Instrutor) stm.setBoolean(5, true);
			else stm.setBoolean(5, false);
			stm.setInt(6, estudante.getId());
			stm.executeUpdate();
			con.close();
		}catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public void estudanteVerCurso(Integer idCurso) {
		
		
	}

	@Override
	public void estudanteVerAula(Integer idAula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estudanteRealizarExercicios(Integer idAula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean estudanteIniciarCurso(Integer idEstudante, Integer idCurso) {
		Connection con = daoFactory.getConnection();
		String sql = "UPDATE EstudanteCurso SET concluido = ? WHERE estudanteId = ? AND cursoId = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setBoolean(1, true);
			stm.setInt(2, idEstudante);
			stm.setInt(3, idCurso);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException se){
			se.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean estudanteConcluirCurso(Integer idEstudante, Integer idCurso) {
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO EstudanteCurso (estudanteId, cursoId, pontos, concluido)"
				   + "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, idEstudante);
			stm.setInt(2, idCurso);
			stm.setInt(3, 0);
			stm.setBoolean(4, false);
			stm.executeUpdate();
			con.close();
			return true;
		}catch(SQLException se){
			se.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Integer validaCadastroEstudante(Estudante usuario) {
		Connection con = daoFactory.getConnection();
		ResultSet rs;
		try {	
			String sql = "SELECT * FROM Estudante";
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery();	
			while(rs.next()){
				if(usuario.getUsername().equals(rs.getString("username"))){
					con.close();
					return 1;
				}
				if(usuario.getEmail().equals(rs.getString("email"))){
					con.close();
					return 2;
				}
			}
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return 3;
			}
		return 0;
	}

}
