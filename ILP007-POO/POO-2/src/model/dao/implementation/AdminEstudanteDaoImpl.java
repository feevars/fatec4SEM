package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.dao.AdminEstudanteDao;
import model.dao.DaoFactory;
import model.dao.EstudanteDao;
import model.entities.Estudante;

public class AdminEstudanteDaoImpl implements AdminEstudanteDao {

	DaoFactory daoFactory;
		
	public AdminEstudanteDaoImpl() {
		daoFactory = new DaoFactory();
	}	
	
	@Override
	public void cadastrarEstudante(Estudante usuario) {	
		try{
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO Estudante (username, password, nome, sobrenome, email, telefone, dataNascimento)"
				   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, usuario.getUsername());
		stm.setString(2, usuario.getPassword());
		stm.setString(3, usuario.getNome());
		stm.setString(4, usuario.getSobrenome());
		stm.setString(5, usuario.getEmail());
		stm.setString(6, usuario.getTelefone());
		stm.setDate(7, usuario.getDataNascimento());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean excluirEstudante(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudante> listarEstudante() {
		// TODO Auto-generated method stub
		return null;
	}
}