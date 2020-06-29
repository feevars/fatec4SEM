package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.AdminEstudanteDao;
import model.dao.DaoFactory;
import model.entities.Estudante;
import model.entities.Instrutor;

public class AdminEstudanteDaoImpl implements AdminEstudanteDao {

	DaoFactory daoFactory;
		
	public AdminEstudanteDaoImpl() {
		daoFactory = new DaoFactory();
	}	
	
	@Override
	public void cadastrarEstudante(Estudante usuario) {	
		try{
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO Estudante (username, password, nome, sobrenome, email, telefone, dataNascimento, pontos)"
				   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, usuario.getUsername());
		stm.setString(2, usuario.getPassword());
		stm.setString(3, usuario.getNome());
		stm.setString(4, usuario.getSobrenome());
		stm.setString(5, usuario.getEmail());
		stm.setString(6, usuario.getTelefone());
		stm.setDate(7, usuario.getDataNascimento());
		stm.setInt(8, usuario.getPontos());
		stm.executeUpdate();
		con.close();
		System.out.println("Usuario " + usuario.getNome() + " cadastrado!");
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Erro ao cadastrar usuário");
		}
	}
	
	@Override
	public Boolean editarEstudante(Estudante usuario) {
		Connection con = daoFactory.getConnection();
		String sql = "UPDATE Estudante SET nome = ?, sobrenome = ?, telefone = ?, dataNascimento = ?, instrutor = ? "
				   + "WHERE id = ?";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSobrenome());
			stm.setString(3, usuario.getTelefone());
			stm.setDate(4, usuario.getDataNascimento());
			if (usuario instanceof Instrutor) stm.setBoolean(5, true);
			else stm.setBoolean(5, false);
			stm.setInt(6, usuario.getId());
			stm.executeUpdate();
			con.close();
			return true;
		}catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean excluirEstudante(Integer id) {
		Connection con = daoFactory.getConnection();
		String sql = "DELETE FROM Estudante WHERE id = ?";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			con.close();
		}catch (SQLException se) {
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
			stm.setString(1, usuario.getEmail());
			rs = stm.executeQuery();	
			while(rs.next()){
				if(usuario.getUsername().equals(rs.getString("username"))){
					return 1;
				}
				if(usuario.getEmail().equals(rs.getString("email"))){
					return 2;
				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return 3;
			}
		return 0;
	}
}