package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.dao.AdminCursoDao;
import model.dao.DaoFactory;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Exercicio;
import model.entities.Instrutor;

public class AdminCursoDaoImpl implements AdminCursoDao {

	private DaoFactory daoFactory;

	public AdminCursoDaoImpl() {
		daoFactory = new DaoFactory();
	}

	@Override
	public Integer cadastrarCurso(Curso curso) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "INSERT INTO Curso (titulo, descricao) VALUES (?, ?)";
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, curso.getTitulo());
			stm.setString(2, curso.getDescricao());
			stm.executeUpdate();

			Integer id = null;

			ResultSet rs = stm.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}

			stm.close();
			return id;
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do curso: " + curso.getTitulo());
			e.printStackTrace();
		} catch (DateTimeException de) {
			System.out.println("Erro na conversao de data do curso: " + curso.getTitulo());
			de.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean excluirCurso(Integer idCurso) {

		try {
			Connection con = daoFactory.getConnection();
			String sql = "DELETE Curso.* FROM Curso WHERE Curso.id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm = con.prepareStatement(sql);
			stm.setInt(1, idCurso);
			stm.executeUpdate();
			con.close();
			return true;

		} catch (SQLException e) {
			System.out.println("Erro ao deletar curso de id " + idCurso);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean editarCurso(Curso curso) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "UPDATE Curso SET titulo = ?, descricao = ? WHERE id = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, curso.getTitulo());
			stm.setString(2, curso.getDescricao());
			stm.setInt(3, curso.getId());
			stm.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Curso: " + curso.getTitulo() + "Não pode ser alterado");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<Aula> listarAulasCurso(Integer cursoId) {
		Set<Aula> lista = new HashSet<Aula>();
		try {
			Connection con = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Aula WHERE cursoId = ? ";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, cursoId);
			rs = stm.executeQuery();
			while (rs.next()) {
				Aula aula = new Aula();
				aula.setId(rs.getInt("id"));
				aula.setTitulo(rs.getString("titulo"));
				aula.setDescricao(rs.getString("descricao"));
				aula.setLinkVideo(rs.getString("linkVideo"));
				aula.setTranscricaoVideo(rs.getString("transcricaoVideo"));
				aula.setTempoVideo(rs.getInt("tempoVideo"));
				aula.setNumAula(rs.getInt("numeroAula"));
				aula.setCursoId(rs.getInt("cursoId"));
				lista.add(aula);
			}
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Instrutor> listarInstrutores() {

		try {
			Connection con = daoFactory.getConnection();
			String sql = "Select * FROM Estudante WHERE instrutor = 1 ORDER BY nome";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			List<Instrutor> instrutores = new ArrayList<Instrutor>();
			while (rs.next()) {
				instrutores.add(new Instrutor(rs.getInt("id"), rs.getString("username"), rs.getString("nome"),
						rs.getString("sobrenome"), listarCursosPorInstrutor(rs.getInt("id"))));
			}
			con.close();
			return instrutores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<Instrutor> listarInstrutoresPorCurso(Integer cursoId) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "Select id, username, nome, sobrenome FROM Estudante LEFT JOIN CursoInstrutor ON Estudante.id=CursoInstrutor.instrutorId WHERE CursoInstrutor.cursoId = "
					+ cursoId.toString();
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			Set<Instrutor> cursosPorInstrutor = new HashSet<Instrutor>();
			while (rs.next()) {
				cursosPorInstrutor.add(new Instrutor(rs.getInt("id"), rs.getNString("username"), rs.getString("nome"),
						rs.getString("sobrenome")));
			}
			con.close();
			return cursosPorInstrutor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<Curso> listarCursosPorInstrutor(Integer instrutorId) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "SELECT id, titulo, descricao FROM Curso LEFT JOIN CursoInstrutor ON Curso.id=CursoInstrutor.cursoId WHERE CursoInstrutor.instrutorId = "
					+ instrutorId.toString();
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			Set<Curso> cursosPorInstrutor = new HashSet<Curso>();
			while (rs.next()) {
				cursosPorInstrutor.add(new Curso(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao")));
			}
			con.close();
			return cursosPorInstrutor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean verificaAutoria(Integer instrutorId, Integer cursoId) {

		try {
			Connection con = daoFactory.getConnection();
			String sql = "SELECT * FROM CursoInstrutor WHERE instrutorId = ? AND cursoId = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, instrutorId);
			stm.setInt(2, cursoId);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				if (rs.getInt("instrutorId") == instrutorId.intValue() && rs.getInt("cursoId") == cursoId.intValue()) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Boolean adicionarInstrutorCurso(Integer instrutorId, Integer cursoId) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "INSERT INTO CursoInstrutor (instrutorId, cursoId) VALUES (?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, instrutorId);
			stm.setInt(2, cursoId);
			stm.executeUpdate();
			con.close();
			return true;

		} catch (SQLException e) {
			System.out.println("Erro no cadastro.");
			e.printStackTrace();
		} catch (DateTimeException de) {
			System.out.println("Erro na conversao de data do curso.");
			de.printStackTrace();
		}
		return false;
	}

	@Override
	public Curso getCursoPorId(Integer cursoId) {
		Curso curso = null;
		try {
			Connection con = daoFactory.getConnection();
			String sql = "SELECT * FROM Curso WHERE id = " + cursoId;
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				curso = new Curso(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"),
						listarInstrutoresPorCurso(cursoId), listarAulasCurso(cursoId), rs.getDate("dataCriacao"),
						rs.getDate("DataAtualizacao"));
			}

			String sql2 = "SELECT * FROM Aula WHERE cursoId = " + cursoId;
			stm = con.prepareStatement(sql2);
			rs = stm.executeQuery();

			Set<Aula> aulas = new HashSet<Aula>();

			while (rs.next()) {
				aulas.add(new Aula(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"),
						rs.getString("linkVideo"), rs.getString("transcricaoVideo"), rs.getInt("tempoVideo"),
						rs.getInt("numeroAula"), cursoId, null));
			}

			curso.setAulas(aulas);

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	@Override
	public Boolean atualizarInstrutoresCurso(Integer cursoId, Set<Instrutor> instrutores) {

		try {
			Connection con = daoFactory.getConnection();
			String sql = "DELETE CursoInstrutor.* FROM CursoInstrutor WHERE cursoId = " + cursoId;
			PreparedStatement stm = con.prepareStatement(sql);

			stm.executeUpdate();
			con.close();

			for (Instrutor i : instrutores) {
				adicionarInstrutorCurso(i.getId(), cursoId);
			}
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
