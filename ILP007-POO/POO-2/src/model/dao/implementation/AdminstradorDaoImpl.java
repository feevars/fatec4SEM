package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.AdministradorDao;
import model.dao.DaoFactory;
import model.entities.Administrador;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class AdminstradorDaoImpl implements AdministradorDao {

	DaoFactory daoFactory;

	public AdminstradorDaoImpl() {
		daoFactory = new DaoFactory();
	}

	@Override
	public void cadastrarAdmin(Administrador administrador) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "INSERT INTO Administrador (username, password) VALUES (?, ?)";
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
	public boolean logarAdmin(String username, String password) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "SELECT username, password FROM Administrador WHERE username=? AND password=?";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs;
			stm.setString(1, username);
			stm.setString(2, password);
			rs = stm.executeQuery();
			while (rs.next()) {
				if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					System.out.println("Senha correta!");
					con.close();
					return true;
				} else {
					System.out.println("Senha incorreta");
					con.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Curso> listarCursos() {
		List<Curso> lista = new ArrayList<Curso>();
		Connection con = daoFactory.getConnection();
		ResultSet rs;
		String sql = "SELECT * FROM Curso";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setDescricao(rs.getString("titulo"));
				curso.setTitulo(rs.getString("descricao"));
				lista.add(curso);
			}
			con.close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Estudante> listarEstudantes() {
		List<Estudante> lista = new ArrayList<Estudante>();
		Connection con = daoFactory.getConnection();
		ResultSet rs;
		String sql = "SELECT * FROM Estudante";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {	
				if(!rs.getBoolean("instrutor")) {
				Estudante estudante = new Estudante(rs.getInt("id")
					, rs.getString("username"), rs.getString("nome"), rs.getString("sobrenome")
					, rs.getString("email"), rs.getString("telefone"), rs.getDate("dataNascimento")
					,rs.getInt("pontos"));
					lista.add(estudante);
				}else{
					Estudante instrutor = new Instrutor(rs.getInt("id")
					, rs.getString("username"), rs.getString("nome"), rs.getString("sobrenome")
					, rs.getString("email"), rs.getString("telefone"), rs.getDate("dataNascimento"),
					rs.getInt("pontos"));
					lista.add(instrutor);
				}
			}
			con.close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Administrador getAdministradorPorId(Integer id) {
		try {
			Connection con = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * Administrador WHERE id = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while(rs.next()){
				if(id == (rs.getInt("id"))){
					Administrador admin = new Administrador(rs.getInt("id"), rs.getString("username"));
					con.close();
					return admin;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Administrador getAdministradorPorUsername(String username) {
		try {
			Connection con = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Administrador WHERE username = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, username);
			rs = stm.executeQuery();
			while(rs.next()){
				if(username.equals(rs.getString("username"))){
					Administrador admin = new Administrador(rs.getInt("id"), rs.getString("username"));
					con.close();
					return admin;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException ne) {
			ne.printStackTrace();
		}
		return null;
	}

}
