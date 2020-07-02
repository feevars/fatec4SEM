package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.dao.AdminAulaDao;
import model.dao.DaoFactory;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Exercicio;

public class AdminAulaDaoImpl implements AdminAulaDao {

	private DaoFactory daoFactory;

	public AdminAulaDaoImpl() {
		daoFactory = new DaoFactory();
	}

	@Override
	public List<Exercicio> listarExercicios(Integer idAula) {
		// List<Exercicio> exerciciosList = new ArrayList<Exercicio>(exercicios);
		List<Exercicio> exerciciosDaAula = new ArrayList<Exercicio>();
		try {
			Connection conn = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Exercicio WHERE aulaId = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Exercicio exercicio = new Exercicio();
				// exercicio.setId(rs.getInt("id"));
				exercicio.setQuestaoExercicio(rs.getString("questao"));
				exercicio.setAlternativaCorreta(rs.getString("alternativaCorreta"));
				exercicio.setAlternativaIncorreta1(rs.getString("alternativaIncorreta1"));
				exercicio.setAlternativaIncorreta2(rs.getString("alternativaIncorreta2"));
				exercicio.setAlternativaIncorreta3(rs.getString("alternativaIncorreta3"));
				exercicio.setAlternativaIncorreta4(rs.getString("alternativaIncorreta4"));
				exercicio.setExplicacao(rs.getString("explicacao"));
				exercicio.setTempoResposta(rs.getInt("tempoResposta"));
				exercicio.setPontos(rs.getInt("pontos"));
				exerciciosDaAula.add(exercicio);
				// aulaId nao precisa puxar pq ja tem aula ID
			}
			conn.close();
			return exerciciosDaAula;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer cadastrarAula(Aula aula, Integer cursoId) {

		Integer id = null;
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "INSERT INTO Aula (titulo, descricao, linkVideo, transcricaoVideo, tempoVideo, numeroAula, cursoId)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, aula.getTitulo());
			stm.setString(2, aula.getDescricao());
			stm.setString(3, aula.getLinkVideo());
			stm.setString(4, aula.getTranscricaoVideo());
			stm.setInt(5, aula.getTempoVideo());
			stm.setInt(6, aula.getNumAula());
			stm.setInt(7, cursoId);
			stm.executeUpdate();
			conn.close();

			ResultSet rs = stm.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void excluirAula(Integer idAula) {
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "DELETE FROM Aula WHERE id = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, idAula);
			stm.executeUpdate();
			conn.close();
			System.out.println("Aula " + idAula + " deletada");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar aula " + idAula);
			e.printStackTrace();
		}
	}

	@Override
	public boolean editarAula(Aula aula) {
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "UPDATE Aula SET titulo = ?, descricao = ?, linkVideo = ?, transcricaoVideo = ?, "
					+ "tempoVideo = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, aula.getTitulo());
			stm.setString(2, aula.getDescricao());
			stm.setString(3, aula.getLinkVideo());
			stm.setString(4, aula.getTranscricaoVideo());
			stm.setInt(5, aula.getTempoVideo());
			stm.executeUpdate();
			conn.close();
			System.out.println("Aula " + aula.getTitulo() + " atualizada.");
			return true;
		} catch (SQLException e) {
			System.out.println("Aula " + aula.getTitulo() + " não pode ser atualizada.");
		}
		return false;
	}

	@Override
	public List<Aula> listarAulas() {
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "SELECT * FROM Aula WHERE CursoId = ?";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Aula getAulaPorId(Integer aulaId) {
		Aula aula = null;
		try {
			Connection con = daoFactory.getConnection();
			String sql1 = "SELECT * FROM Aula WHERE id = " + aulaId;
			PreparedStatement stm = con.prepareStatement(sql1);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				aula = new Aula(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"),
						rs.getString("transcricao"), rs.getString("linkVideo"), rs.getInt("tempoVideo"),
						rs.getInt("numAula"), rs.getInt("cursoId"), null);
			}

			String sql2 = "SELECT * FROM Exercicio WHERE idAula = " + aulaId;
			stm = con.prepareStatement(sql2);
			rs = stm.executeQuery();

			Set<Exercicio> exercicios = new HashSet<Exercicio>();

			while (rs.next()) {
				exercicios.add(new Exercicio(rs.getInt("id"), rs.getString("titulo"), rs.getString("questao"),
						rs.getString("alternativaCorreta"), rs.getString("alternativaIncorreta1"),
						rs.getString("alternativaIncorreta2"), rs.getString("alternativaIncorreta3"),
						rs.getString("alternativaIncorreta4"), rs.getString("explicacao"), rs.getInt("tempoResposta"),
						rs.getInt("pontos"), aulaId));
			}

			aula.setExercicios(exercicios);

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aula;
	}
}