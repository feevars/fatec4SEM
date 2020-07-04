package tests;

import java.util.HashSet;
import java.util.Set;

import controllers.CursoController;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public class CrudCursoTeste {

	public static void main(String[] args) {
		/*
		 * CursoController cursoController = new CursoController(); Integer[]
		 * arrayInstrutores = new Integer[2]; Curso curso = new Curso();
		 * //curso.setId(1); curso.setTitulo("Python");
		 * curso.setDescricao("Curso de Python"); arrayInstrutores[0] = 2;
		 * arrayInstrutores[1] = 3;
		 * 
		 * 
		 * Boolean gravado = cursoController.cadastrarCurso(curso, arrayInstrutores);
		 * 
		 * if(gravado) {System.out.println("Dados gravados com sucesso! :) ");} else {
		 * System.out.println("Erro na gravação :( ");}
		 */
		
		//pegar instrutores do curso OK
		CursoController cursoController = new CursoController();
		Set<Instrutor> listaInstrutores = new HashSet<Instrutor>();
		listaInstrutores = cursoController.carregaInstrutoresCurso(8);

		for (Instrutor instrutor : listaInstrutores) {
			System.out.println("NOME: "+ instrutor.getNome() + " | USUÁRIO: "+ instrutor.getUsername());
		}
		
		//pegar aulas do curso
		Set<Aula> listaAulas = new HashSet<Aula>();
		listaAulas = cursoController.carregaAulasCurso(8);
		for (Aula aulas : listaAulas) {
			System.out.println("Titulo: "+ aulas.getTitulo() + " | USUÁRIO: "+ aulas.getDescricao());
		}
		
		//Editando curso OK
		Curso c1 = new Curso(25, "COBOL", "Curso avançado de cobol", listaInstrutores, null);
		cursoController.editarCurso(c1);
		
		
	}

}
