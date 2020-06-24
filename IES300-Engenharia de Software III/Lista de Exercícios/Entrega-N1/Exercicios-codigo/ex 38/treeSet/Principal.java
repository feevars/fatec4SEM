package treeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		
		//Criando TreeSet
		TreeSet<String> ts = new TreeSet<String>();
		
		//Adicionando itens
		ts.add("Fernanda Reis");
		ts.add("Bruno Harnik");
		ts.add("Raquel Nascimento");
		ts.add("Luiz Fernando");
		
		//Exibindo elementos 
		Iterator<String> iter = ts.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//Exibindo em ordem reversa
		Iterator<String> rev = ts.descendingIterator();
		while(rev.hasNext()) {
			System.out.println(rev.next());
		}
		
		
	}

}
