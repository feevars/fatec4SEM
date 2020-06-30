package tests;

import controllers.CursoController;
import model.entities.Curso;

public class CrudCursoTeste {

	public static void main(String[] args) {
		CursoController cursoController = new CursoController();
		Integer[] arrayInstrutores = new Integer[2];
		Curso curso = new Curso();
		//curso.setId(1);
		curso.setTitulo("Python");
		curso.setDescricao("Curso de Python");
		arrayInstrutores[0] = 2;
		arrayInstrutores[1] = 3;
		
		
		Boolean gravado = cursoController.cadastrarCurso(curso, arrayInstrutores);
		
		if(gravado) {System.out.println("Dados gravados com sucesso! :) ");}
		else { System.out.println("Erro na gravação :( ");}

	}

}
