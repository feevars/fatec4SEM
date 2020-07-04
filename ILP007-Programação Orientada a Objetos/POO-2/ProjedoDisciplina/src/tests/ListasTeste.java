package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.dao.AdministradorDao;
import model.dao.implementation.AdminstradorDaoImpl;
import model.entities.Curso;

public class ListasTeste {

	public static void main(String[] args) {
		AdministradorDao adminDao = new AdminstradorDaoImpl();

		List<Curso> lista = new ArrayList<Curso>(adminDao.listarCursos());
		
		System.out.println("------------ LISTAGEM DE CURSO ------------ ");
		for(Curso c : lista){
			System.out.println("TITULO: " + c.getTitulo());
			System.out.println("DESCRICAO: " + c.getDescricao());
			System.out.println("DATA CRIAÇÃO: " + c.getDataCriacao());
			System.out.println("DATA ATUALIZAÇÃO: " + c.getDataAtualizacao());
		}
	}

}
