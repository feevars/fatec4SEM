package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.EstudanteDao;
import model.entities.Estudante;

public class EstudanteDaoImpl implements EstudanteDao {
	
	private DaoFactory daoFactory;

	@Override
	public void estudanteCadastro(Estudante estudante) {
		try{
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
			System.out.println("Usuario " + estudante.getNome() + " cadastrado!");
			}catch(SQLException se) {
				se.printStackTrace();
				System.out.println("Erro ao cadastrar usuário");
			}
	}

	@Override
	public void estudanteEditarPerfil(Estudante estudante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estudanteVerCurso(Integer idCurso) {
		// TODO Auto-generated method stub
		
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
	public void estudanteIniciarCurso(Integer idEstudante, Integer idCurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estudanteConcluirCurso(Integer idEstudante, Integer idCurso) {
		// TODO Auto-generated method stub
		
	}

}
