package tests;

import controllers.CursoController;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

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
		
//		Boolean gravou = adminCursoDao.cadastrarCurso(curso, instrutor1.getId(),instrutor2.getId());
//		if(gravou){
//			System.out.println(curso.getTitulo() + " de ID: " + curso.getId() + " foi gravado!");
//		}else{
//			System.out.println(curso.getTitulo() + " de ID: " + curso.getId() + " não foi gravado!");
//		}
	}

}
