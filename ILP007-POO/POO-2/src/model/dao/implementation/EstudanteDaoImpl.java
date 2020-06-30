package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.dao.DaoFactory;
import model.dao.EstudanteDao;
import model.entities.Administrador;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class EstudanteDaoImpl implements EstudanteDao {

	private DaoFactory daoFactory = new DaoFactory();

	@Override
	public Boolean estudanteLogin(String username, String email, String password) {

		try {
			Connection con = daoFactory.getConnection();
			String sql = "SELECT username, email, password FROM Estudante WHERE (username=? OR email=?) AND password=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, email);
			stm.setString(3, password);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				if ((username.equals(rs.getString(1)) || email.equals(rs.getString(2)))
						&& password.equals(rs.getString(3))) {
					System.out.println("Logou");
					con.close();
					return true;
				}
			}

			System.out.println("Erro: digite novamente usuário e senha.");
			con.close();
			return false;

		} catch (SQLException e) {
			System.out.println("Erro: problema de acesso ao banco.");
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void estudanteCadastro(Estudante estudante) {
		try {
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
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Erro ao cadastrar usuário");
		}
	}

	// private Integer id;
	// private String username;
	// private String password;
	// private String email;
	// private Integer pontos;

	@Override
	public void estudanteEditarPerfil(Estudante estudante) {
		Connection con = daoFactory.getConnection();
		String sql = "UPDATE Estudante SET nome = ?, sobrenome = ?, telefone = ?, dataNascimento = ?, instrutor = ?"
				+ "WHERE id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, estudante.getNome());
			stm.setString(2, estudante.getSobrenome());
			stm.setString(3, estudante.getTelefone());
			stm.setDate(4, estudante.getDataNascimento());
			if (estudante instanceof Instrutor)
				stm.setBoolean(5, true);
			else
				stm.setBoolean(5, false);
			stm.setInt(6, estudante.getId());
			stm.executeUpdate();
			con.close();
		} catch (SQLException se) {
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
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean estudanteConcluirCurso(Integer idEstudante, Integer idCurso) {
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO EstudanteCurso (estudanteId, cursoId, pontos, concluido)" + "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, idEstudante);
			stm.setInt(2, idCurso);
			stm.setInt(3, 0);
			stm.setBoolean(4, false);
			stm.executeUpdate();
			con.close();
			return true;
		} catch (SQLException se) {
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
			while (rs.next()) {
				if (usuario.getUsername().equals(rs.getString("username"))) {
					con.close();
					return 1;
				}
				if (usuario.getEmail().equals(rs.getString("email"))) {
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

	@Override
	public Estudante getEstudantePorId(Integer id) {
		try {
			Connection con = daoFactory.getConnection();

			String sql = "SELECT * FROM Estudante WHERE id = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			Estudante usuario = null;
			while (rs.next()) {
				if (id == (rs.getInt("id"))) {
					if (rs.getBoolean("instrutor")) {
						usuario = new Instrutor(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
								rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"),
								rs.getString("telefone"), rs.getDate("dataNascimento"), rs.getInt("pontos"), null);
					} else {
						usuario = new Estudante(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
								rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"),
								rs.getString("telefone"), rs.getDate("dataNascimento"), rs.getInt("pontos"), null);
					}
				}
			}

			sql = "SELECT * FROM Curso LEFT JOIN EstudanteCurso ON Curso.id=EstudanteCurso.cursoId WHERE EstudanteCurso.estudanteId = ? AND EstudanteCurso.concluido=1";
			stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();

			Set<Curso> cursosConcluidos = new HashSet<Curso>();

			while (rs.next()) {

				cursosConcluidos.add(new Curso(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao")));

			}

			usuario.setCursosConcluidos(cursosConcluidos);
			con.close();
			return usuario;
		} catch (SQLException e) {
			System.out.println("Erro de conexão com o banco.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Estudante getEstudantePorUsername(String username) {
		try {
			Connection con = daoFactory.getConnection();

			String sql = "SELECT * FROM Estudante WHERE username = ? OR email = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, username);
			ResultSet rs = stm.executeQuery();
			Estudante usuario = null;
			while (rs.next()) {
				if (username.equals(rs.getString("username")) || username.equals(rs.getString("email"))) {
					if (rs.getBoolean("instrutor")) {
						usuario = new Instrutor(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
								rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"),
								rs.getString("telefone"), rs.getDate("dataNascimento"), rs.getInt("pontos"), null);
					} else {
						usuario = new Estudante(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
								rs.getString("nome"), rs.getString("sobrenome"), rs.getString("email"),
								rs.getString("telefone"), rs.getDate("dataNascimento"), rs.getInt("pontos"), null);
					}
				}
			}

			sql = "SELECT * FROM Curso LEFT JOIN EstudanteCurso ON Curso.id=EstudanteCurso.cursoId WHERE EstudanteCurso.estudanteId = ? AND EstudanteCurso.concluido=1";
			stm = con.prepareStatement(sql);
			stm.setInt(1, usuario.getId());
			rs = stm.executeQuery();

			Set<Curso> cursosConcluidos = new HashSet<Curso>();

			while (rs.next()) {

				cursosConcluidos.add(new Curso(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao")));

			}

			usuario.setCursosConcluidos(cursosConcluidos);
			con.close();
			return usuario;
		} catch (SQLException e) {
			System.out.println("Erro de conexão com o banco.");
			e.printStackTrace();
			return null;
		}
	}

}
