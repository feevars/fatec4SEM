package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.dao.CursoDao;
import model.dao.DaoFactory;
import model.entities.Curso;

public class CursoDaoImpl implements CursoDao {
	
	DaoFactory dbFactory = new DaoFactory();
	Connection con = dbFactory.getConnection();
	
	@Override
	public void adicionarCurso(Curso c) {
		try {
			String sql = "INSERT INTO Curso (id, nome, descricao, totalHoras, dataCriacao) "
					+ "VALUES  (0, ?, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, c.getId());
			stm.setString(2, c.getNome());
			stm.executeUpdate();
			con.close();
		}catch ( SQLException e ){
			e.printStackTrace();
		}
	}

	@Override
	public void excluirCurso(Curso c) {
		
		
	}

	@Override
	public void editarCurso(Curso c) {
		
		
	}

	@Override
	public List<Curso> pesquisarPorNome(String nome) {
		
		return null;
	}

}
