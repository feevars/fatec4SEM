package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dao.DaoFactory;
import model.dao.EstudanteDao;
import model.entities.Estudante;

public class EstudanteDaoImpl implements EstudanteDao {

	DaoFactory daoFactory;
		
	public EstudanteDaoImpl() {
		daoFactory = new DaoFactory();
	}	
	
	@Override
	public void cadastrar(Estudante usuario) {	
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
}
