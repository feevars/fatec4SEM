package classeParametrizada;

import java.util.HashSet;
import java.util.Set;

public class ClasseSetExame <E> {

	private Set<E> listaSet = new HashSet<>(); 
	
	public E add(E e) {
	if (listaSet.add(e))
		return e;
	else
		return null;
	}
				
	public int size() {
		return listaSet.size();
	}
				  
	public void clear() {
		listaSet.clear();
	}

}
		  	
