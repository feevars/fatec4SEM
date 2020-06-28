package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;

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
		String sql = "INSERT INTO exercicio (titulo, questao, alternativaCorreta, alternativaIncorreta1, "
				+ "alternativaIncorreta2, alternativaIncorreta3, alternativaIncorreta4, "
				+ "explicacao, tempoResposta, pontos, aulaId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement stm;
			try {
				stm = con.prepareStatement(sql);
				stm.setString(1, exercicio.getTituloExercicio());
				stm.setString(2, exercicio.getQuestaoExercico());
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
	public void excluirExercicio(Integer id) {
		try {
			Connection con = daoFactory.getConnection();
			String sql = "DELETE FROM exercico WHERE id = ?";		
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			con.close();
			System.out.println("Exercicio de id " + id + " deletado!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar exercicio de id " + id);
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean editarExercicio(Exercicio exercicio) {
		// TODO Auto-generated method stub
		return false;
	}

}
