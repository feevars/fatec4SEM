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

public class AdminAulaDaoImpl implements AdminAulaDao {

	private DaoFactory daoFactory;
	
	public AdminAulaDaoImpl() {
		daoFactory = new DaoFactory();
	}
	
	@Override
	public List<Aula> listarAula(Aula aula) {
		List<Aula> listaAulas = new ArrayList<Aula>();
		try {
			Connection conn = daoFactory.getConnection();
			ResultSet rs;
			String sql = "SELECT * FROM Aula";
			PreparedStatement stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				Aula aula1 = new Aula();
				aula1.setId(rs.getInt("id"));
				aula1.setTitulo(rs.getString("titulo"));
				aula1.setDescricao(rs.getString("descricao"));
				aula1.setLinkVideo(rs.getString("linkVideo"));
				aula1.setTranscricaoVideo(rs.getString("transcricaoVideo"));
				aula1.setTempoVideo(rs.getInt("tempoVideo"));
			}
			return listaAulas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void cadastrarAula(Aula aula) {
		
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "INSERT INTO Aula (titulo, descricao, linkVideo, transcricaoVideo, tempoVideo)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, aula.getTitulo());
			stm.setString(2, aula.getDescricao());
			stm.setString(3, aula.getLinkVideo());
			stm.setString(4, aula.getTranscricaoVideo());
			stm.setInt(5, aula.getTempoVideo());
			stm.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluirAula(Integer id) {
		try {
			Connection conn = daoFactory.getConnection();
			String sql = "DELETE FROM Aula WHERE id = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			conn.close();
			System.out.println("Aula " + id + " deletada");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar aula " + id);
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



}
