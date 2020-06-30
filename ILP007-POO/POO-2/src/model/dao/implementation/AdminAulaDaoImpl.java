package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		//List<Exercicio> exerciciosList = new ArrayList<Exercicio>(exercicios);
		List<Exercicio> exerciciosDaAula = new ArrayList<Exercicio>();
		try {
			Connection conn = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Exercicio WHERE aulaId = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Exercicio exercicio = new Exercicio();
				//exercicio.setId(rs.getInt("id"));
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
				//aulaId nao precisa puxar pq ja tem aula ID
			}
			conn.close();
			return exerciciosDaAula;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void cadastrarAula(Aula aula, Integer cursoId) {
		
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "INSERT INTO Aula (titulo, descricao, linkVideo, transcricaoVideo, tempoVideo, numAula, cursoId)"
					   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, aula.getTitulo());
			stm.setString(2, aula.getDescricao());
			stm.setString(3, aula.getLinkVideo());
			stm.setString(4, aula.getTranscricaoVideo());
			stm.setInt(5, aula.getTempoVideo());
			stm.setInt(6, aula.getNumAula());	// Talvez nao usaremos...
			stm.setInt(7, cursoId);
			stm.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
}