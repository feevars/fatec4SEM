package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.AdministradorDao;
import model.dao.DaoFactory;
import model.entities.Administrador;

public class AdminstradorDaoImpl implements AdministradorDao {

	DaoFactory daoFactory;
	
	public AdminstradorDaoImpl() {
		daoFactory = new DaoFactory();
		//daoFactory.getConnection();
	}
	
	
	@Override
	public void cadastrar(Administrador administrador) {
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO Administrador (username, password)"
				+ " VALUES (?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, administrador.getUsername());
			stm.setString(2, administrador.getPassword());
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean logar(String username, String password) {
		
		try {
		Connection con = daoFactory.getConnection();
		ResultSet rs;
		String sql = "SELECT username, password FROM Administrador WHERE username=?";
		
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, username);
			rs = stm.executeQuery();
			
			while(rs.next()){
				if(password.equals(rs.getString("password"))){
					System.out.println("Senha correta!");
					return true;
				}else{
					System.out.println("Senha incorreta");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
