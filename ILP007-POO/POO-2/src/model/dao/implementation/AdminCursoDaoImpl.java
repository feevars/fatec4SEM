package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.dao.AdminCursoDao;
import model.dao.DaoFactory;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public class AdminCursoDaoImpl implements AdminCursoDao {

	private DaoFactory daoFactory;

	public AdminCursoDaoImpl() {
		daoFactory = new DaoFactory();
	}

	@Override
	public Boolean cadastrarCurso(Curso curso, Integer... idsInstrutores) {
		Integer novoId = 0;
		try {
			Connection con = daoFactory.getConnection();
			String sql1 = "INSERT INTO Curso (titulo, descricao) VALUES (?, ?)";
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setString(1, curso.getTitulo());
			stm.setString(2, curso.getDescricao());
			stm.executeUpdate();
			System.out.println("Gravou o curso!");

			String sql2 = "SELECT * FROM Curso WHERE id = LAST_INSERT_ID()";
			stm = con.prepareStatement(sql2);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				novoId = rs.getInt("id");
			}
			System.out.println("Pegou o id: " + novoId);

			for (Integer idInstrutor : idsInstrutores) {
				String sql3 = "INSERT INTO CursoInstrutor (cursoId, instrutorId) VALUES (?, ?)";
				stm = con.prepareStatement(sql3);
				stm.setInt(1, novoId);
				stm.setInt(2, idInstrutor);
				stm.executeUpdate();
				System.out.println("Gravou o cursoId: " + novoId + " e o instrutorId: " + idInstrutor);
			}
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do curso: " + curso.getTitulo());
			e.printStackTrace();
		} catch (DateTimeException de) {
			System.out.println("Erro na conversao de data do curso: " + curso.getTitulo());
			de.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean excluirCurso(Integer idCurso) {

		try {
			Connection con = daoFactory.getConnection();
			String sql1 = "DELETE FROM Curso WHERE id = ?";
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setInt(1, idCurso);
			stm.executeUpdate();
			System.out.println("Curso de id " + idCurso + " deletado da tabela Curso!");

			String sql2 = "DELETE * FROM CursoInstrutor WHERE cursoId = ?";
			stm = con.prepareStatement(sql2);
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

			System.out.println("Curso: " + curso.getTitulo() + " Alterado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("Curso: " + curso.getTitulo() + "Não pode ser alterado");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<Aula> listarAulasCurso(Integer id) {
		Set<Aula> lista = new HashSet<Aula>();
		try {
			Connection con = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Aula WHERE cursoId = ? ";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				Aula aula = new Aula();
				aula.setId(rs.getInt("id"));
				aula.setDescricao(rs.getString("titulo"));
				aula.setTitulo(rs.getString("descricao"));
				aula.setLinkVideo(rs.getString("linkVideo"));
				aula.setTranscricaoVideo(rs.getString("transcricaoVideo"));
				aula.setTempoVideo(rs.getInt("tempoVideo"));
				// aula.setNumAula(rs.getInt("numeroAula"));
				System.out.println("Curso: " + aula.getTitulo() + " encontrado!");
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

		List<Instrutor> instrutores = new ArrayList<Instrutor>();
		Connection con = daoFactory.getConnection();
		String sql = "Select * FROM Estudante WHERE instrutor = 1 ORDER BY nome";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				instrutores.add(new Instrutor(rs.getInt("id"), rs.getString("username"), rs.getString("nome"),
						rs.getString("sobrenome")));
			}
			con.close();
			return instrutores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Instrutor> listarInstrutoresCurso(Integer cursoId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Set<Aula> listarAulas() { Set<Aula> lista = new
	 * HashSet<Aula>(); Connection con = daoFactory.getConnection(); ResultSet rs;
	 * String sql = "SELECT * FROM Aula"; try { PreparedStatement stm =
	 * con.prepareStatement(sql); rs = stm.executeQuery(); while (rs.next()) { Aula
	 * aula = new Aula(); aula.setId(rs.getInt("id"));
	 * aula.setDescricao(rs.getString("titulo"));
	 * aula.setTitulo(rs.getString("descricao"));
	 * aula.setLinkVideo(rs.getString("linkVideo"));
	 * aula.setTranscricaoVideo(rs.getString("transcricaoVideo"));
	 * aula.setTempoVideo(rs.getInt("tempoVideo"));
	 * aula.setNumAula(rs.getInt("numeroAula")); lista.add(aula); } con.close();
	 * return lista; } catch (SQLException e) { e.printStackTrace(); } return null;
	 * }
	 */
}
