package classeParametrizada;

import java.util.ArrayList;
import java.util.List;

public class ClasseListExames <E> {
		
	  private List<E> listaList;
	  
	  
	  public ClasseListExames() {
		  listaList = new ArrayList<E>();
	  }
	
	  
	  public E add(E e) {
		  if (listaList.add(e))
		    return e;
		  else
		    return null;
	  }
		
	  public int size() {
		return listaList.size();
	  }
		  
	  public void clear() {
		  listaList.clear();
	  }
	  
}
