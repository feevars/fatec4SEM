package heap;

public class Heap {

	public static void main(String[] args) {
        
       try{
            String[] lista = new String[1000000000];

            for (int cont = 0; cont < 1000000000; cont++) {
                lista[cont] = new String("NOVO");
                System.out.println("ADICIONANDO ... POSICAO: " + cont);
            }
            
      }catch(Throwable e) {
    	  
    	  e.printStackTrace();
    	  }
        
        }

}
