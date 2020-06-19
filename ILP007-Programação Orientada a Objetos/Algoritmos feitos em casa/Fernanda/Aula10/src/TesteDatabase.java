import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDatabase {

	public static void main(String[] args) {
		private static final String URL = "jdbc:mariadb://localhost:3306/petshop";
		private static final String USER = "root";
		private static final String PASS = "";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada com sucesso.");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conexão criada com sucesso.");
		
			Statement stm = con.createStatement();
			String sql = "INSERT INTO aluno (id, nome, raca, peso, nascimento) "
					+ "VALUES (0, 'Totó', 'ViraLata' 14.5, '2014-05-07')";
			int i = stm.executeUpdate(sql);
			System.out.println(i + " rows updated");
			
			
			PreparedStatement stm2 = con.prepareStatement("SELECT * FROM aluno");
			String sql2 = "SELECT * FROM aluno WHERE nome = ?";
			con.close(); //nao esquecer de fechar a conexão
		
		
		} catch (ClassNotFoundException e) {
			System.out.println("Problema para carregar a classe.");
		} catch (SQLException e) {
			System.out.println("banco refused");
		}

	}

}

/*
 * create database escola;
 * use database escola;
 * 
 * create table aluno (
 * id int auto_increment,
 * nome char(50),
 * raca char (20),
 * peso decimal (4,1),
 * nascimento date,
 * primary key(id)
 * );
 * */
