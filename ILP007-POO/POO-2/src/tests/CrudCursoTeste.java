package tests;

import model.dao.implementation.AdminCursoDaoImpl;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class CrudCursoTeste {

	public static void main(String[] args) {
		AdminCursoDaoImpl adminCursoDao = new AdminCursoDaoImpl();
		Curso curso = new Curso();
		curso.setId(1);
		curso.setTitulo("Python");
		curso.setDescricao("Curso de Python");
		
		Instrutor instrutor1 = new Instrutor(2, "Luiz", "", "Luiz", "Geraldo", "",
				"", null, null, null);
		
		Estudante instrutor2 = new Instrutor(3, "Fernando", "", "Fernando", "Santos",
				"", "", null, null, null);
	
		
		Boolean gravou = adminCursoDao.cadastrarCurso(curso, instrutor1.getId(),instrutor2.getId());
		
		if(gravou){
			System.out.println(curso.getTitulo() + " de ID: " + curso.getId() + " foi gravado!");
		}else{
			System.out.println(curso.getTitulo() + " de ID: " + curso.getId() + " não foi gravado!");
		}
	}

}
