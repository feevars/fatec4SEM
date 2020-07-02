package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.AdminExercicioDao;
import model.dao.DaoFactory;
import model.entities.Exercicio;

public class AdminExercicioDaoImpl implements AdminExercicioDao{
	
	private DaoFactory daoFactory;
	
	public AdminExercicioDaoImpl() {
		daoFactory = new DaoFactory();
	}

	@Override
	public void cadastrarExercicio(Exercicio exercicio) {
		
		Connection con = daoFactory.getConnection();
		String sql = "INSERT INTO Exercicio (titulo, questao, alternativaCorreta, alternativaIncorreta1, "
				+ "alternativaIncorreta2, alternativaIncorreta3, alternativaIncorreta4, "
				+ "explicacao, tempoResposta, pontos, aulaId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement stm;
			try {
				stm = con.prepareStatement(sql);
				stm.setString(1, exercicio.getTituloExercicio());
				stm.setString(2, exercicio.getQuestaoExercicio());
				stm.setString(3, exercicio.getAlternativaCorreta());
				stm.setString(4, exercicio.getAlternativaIncorreta1());
				stm.setString(5, exercicio.getAlternativaIncorreta2());
				stm.setString(6, exercicio.getAlternativaIncorreta3());
				stm.setString(7, exercicio.getAlternativaIncorreta4());
				stm.setString(8, exercicio.getExplicacao());
				stm.setInt(9, exercicio.getTempoResposta());
				stm.setInt(10, exercicio.getPontos());
				stm.setInt(11, exercicio.getAulaId());
				stm.executeUpdate();
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro ao conectar");
				e.printStackTrace();
			}
	
	}
	@Override
	public boolean excluirExercicio(Integer id) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "DELETE FROM Exercicio WHERE id = ?";		
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			con.close();
			System.out.println("Exercicio de id " + id + " deletado!");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao deletar exercicio de id " + id);
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean editarExercicio(Exercicio exercicio) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "UPDATE Aula SET titulo = ?, questao = ?, alternativaCorreta = ?, alternativaIncorreta1 = ?, "
					+ "alternativaIncorreta2 = ?, alternativaIncorreta3 = ?, alternativaIncorreta4 = ?,"
					+ "explicacao = ?, tempoResposta = ?, pontos = ?, aulaId = ? WHERE id = ?";
			PreparedStatement stm;
			stm = con.prepareStatement(sql);
			stm.setString(1, exercicio.getTituloExercicio());
			stm.setString(2, exercicio.getQuestaoExercicio());
			stm.setString(3, exercicio.getAlternativaCorreta());
			stm.setString(4, exercicio.getAlternativaIncorreta1());
			stm.setString(5, exercicio.getAlternativaIncorreta2());
			stm.setString(6, exercicio.getAlternativaIncorreta3());
			stm.setString(7, exercicio.getAlternativaIncorreta4());
			stm.setString(8, exercicio.getExplicacao());
			stm.setInt(9, exercicio.getTempoResposta());
			stm.setInt(10, exercicio.getPontos());
			stm.setInt(11, exercicio.getAulaId());
			stm.setInt(12, exercicio.getId());
			stm.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println(" Exercico não pode ser atualizada.");
		}
		return false;
	}

	@Override
	public List<Exercicio> getListaExercicios(Integer idAula) {
		List<Exercicio> lista = new ArrayList<Exercicio>();
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "SELECT * FROM Exercicio WHERE aulaId = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, idAula);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Exercicio exec = new Exercicio(rs.getInt("id"), rs.getString("titulo"),
						rs.getString("questao"), rs.getString("alternativaCorreta"), rs.getString("alternativaIncorreta1"),
						rs.getString("alternativaIncorreta2"), rs.getString("alternativaIncorreta3"), rs.getString("alternativaIncorreta4"),
						rs.getString("explicacao"), rs.getInt("tempoResposta"), rs.getInt("pontos"),
						rs.getInt("aulaId"));
				lista.add(exec);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
