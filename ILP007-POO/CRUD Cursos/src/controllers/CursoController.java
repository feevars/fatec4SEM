package controllers;

import java.util.HashSet;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.AdminAulaDao;
import model.dao.CursoDao;
import model.dao.EstudanteDao;
import model.dao.implementation.AdminAulaDaoImpl;
import model.dao.implementation.CursoDaoImpl;
import model.dao.implementation.EstudanteDaoImpl;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public class CursoController {

	private CursoDao adminCursoDao = new CursoDaoImpl();
	private AdminAulaDao adminAulaDao = new AdminAulaDaoImpl();
	private EstudanteDao estudanteDao = new EstudanteDaoImpl();
	private ObservableList<Instrutor> listaTodosInstrutores = FXCollections.observableArrayList();
	private ObservableList<Aula> listaAulasCursoO = FXCollections.observableArrayList();

	public ObservableList<Aula> carregarListaAulasAdmin() {
		// this.listaAulas.addAll(adminCursoDao.listarAulasCurso(id));
		// return (ObservableList<Aula>) adminCursoDao.listarAulasCurso();
		return null;
	}

	public ObservableList<Aula> carregarListaAulasEstudante(Integer idCurso) {
		Set<Aula> listaAulas = estudanteDao.listarAulasCurso(idCurso);
		listaAulasCursoO.addAll(listaAulas);
		return listaAulasCursoO;
	}

	public ObservableList<Curso> getLista() {
		return null;
	}

	// Cadastrar novo curso (passando com ids de instrutores)
	public Boolean cadastrarCurso(Curso curso, Integer[] idsInstrutores) {
		Integer idNovoCurso = adminCursoDao.cadastrarCurso(curso);
		if (idNovoCurso != 0) {
			System.out.println("Id do curso criado: " + idNovoCurso);
			for (Integer idInstrutor : idsInstrutores) {
				System.out.println("Id curso: " + idNovoCurso + " - Id Instrutor: " + idInstrutor);
				adminCursoDao.adicionarInstrutorCurso(idNovoCurso, idInstrutor);
			}
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar Curso!");
		}
		return false;
	}

	public Boolean excluirCurso(Integer idCurso) {
		if (adminCursoDao.excluirCurso(idCurso)) {
			return true;
		}
		return false;
	}

	public Boolean editarCurso(Curso curso) {
		if (adminCursoDao.editarCurso(curso)
				&& adminCursoDao.atualizarInstrutoresCurso(curso.getId(), curso.getInstrutores())) {
			return true;
		}
		return false;
	}

	public Integer cadastrarCursoEPrimeiraAula(Curso curso, Aula aula) {
		Integer cursoId = adminCursoDao.cadastrarCurso(curso);
		System.out.println("curso id :" + cursoId);
		for (Instrutor instrutor : curso.getInstrutores()) {
			System.out.println(adminCursoDao.adicionarInstrutorCurso(instrutor.getId(), cursoId));
		}
		aula.setCursoId(cursoId);
		return adminAulaDao.cadastrarAula(aula, cursoId);
	}

	// Adiciona instrutores ao curso
	public Boolean adicionarInstrutorCurso(Integer instrutorId, Integer cursoId) {
		Boolean instrutorAdicionado = adminCursoDao.adicionarInstrutorCurso(instrutorId, cursoId);
		if (instrutorAdicionado) {
			return true;
		}
		return false;
	}

	// Recebe lista com instrutores do curso
	public Set<Instrutor> carregaInstrutoresCurso(Integer id) {
		Set<Instrutor> instrutoresCurso = new HashSet<Instrutor>();
		instrutoresCurso = adminCursoDao.listarInstrutoresPorCurso(id);
		return instrutoresCurso;
	}

	public Set<Aula> carregaAulasCurso(Integer id) {
		Set<Aula> aulasCurso = new HashSet<Aula>();
		aulasCurso = adminCursoDao.listarAulasCurso(id);
		return aulasCurso;
	}

	public Curso getCursoPorId(Integer cursoId) {
		return adminCursoDao.getCursoPorId(cursoId);
	}

}
