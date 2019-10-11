import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio
 */
public class ListaLigada {
	private NO inicio;

	public ListaLigada(){
		inicio=null;
	}

	public void AdicionaFinal(int e){
		if (inicio==null){
			NO n=new NO(e);
			inicio=n;
		}
		else{
			NO aux=inicio;
			while(aux.prox!=null){
				aux=aux.prox;
			}
			NO n=new NO(e);
			aux.prox=n;
		}
	}

	public void AdicionaInicio(int e){
		NO n=new NO(e);
		n.prox=inicio;
		inicio=n;
	}

	public int RemoveFinal(){
		int r=-1;
		if (inicio==null){
			System.out.println("Lista Vázia");
		}
		else{
			if (inicio.prox==null){
				r=inicio.dado;
				inicio=null;
			}
			else{
				NO aux1=inicio;
				NO aux2=inicio;

				while(aux1.prox!=null){
					aux2=aux1;
					aux1=aux1.prox;
				}

				r=aux1.dado;
				aux2.prox=null;
			}
		}
		return r;
	}
	
	public int RemoveInicio(){
		int r=-1;
		if (inicio==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}
		else{
			r=inicio.dado;
			inicio=inicio.prox;
		}
		return r;
	}
	
	   public int RemoveQualquerPosicao(int pos){
	        int e=-1;
	        int i=1;
	        NO aux=inicio;
	        
	        
	        if(inicio==null){
	            System.out.println("Lista Vazia!");
	            return e;
	        }    
	        if(pos==1){// NOVA CONDIÇÃO. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SERÁ O PRIMEIRO
	            e=RemoveInicio();
	            return e;
	        }else{           
	            while(aux.prox!=null){
	                aux=aux.prox;
	                i++;
	            }
	            if(pos>i){
	                System.out.println("Posição Invalida!");
	                return e;
	            }else if(pos==i){
	                e=RemoveFinal();
	                return e;
	            }else{
	                aux=inicio;
	                NO aux2=aux;
	                
	                while(pos>1){
	                    aux2=aux;
	                    aux=aux.prox;
	                    pos--;
	                }
	                e=aux.dado;
	                aux2.prox=aux.prox;
	                return e;
	            }
	        }        
	    }
	   
	   
	    public void AdicionaQualquerPosicao(int e, int pos){
	        NO novo= new NO(e);

	        if(pos==1){  /*CONDIÇÃO DO COMEÇO DO MÉTODO MUDOU, TENDO EM VISTA QUE
	             SEMPRE QUE A POSIÇÃO FOR 1, O ITEM SERÁ ADICIONADO NO INICIO DA LISTA,
	             NÃO IMPORTANDO SE A MESMA SE ENCONTRA VAZIA OU NÃO*/            
	            AdicionaInicio(e);
	        }else{       
	            NO aux=inicio;
	            int count=1;
	            
	            while(aux.prox!=null && count<pos-1){
	                aux=aux.prox;
	                count++;
	            }
	            
	            if(count==pos-1){  /*A CONSIÇÃO PARA SE SABER SE É POSSIVEL ADICIONAR
	               O ITEM NA POSIÇÃO DESEJADA PASSOU A SER FORA DO LAÇO */
	                novo.prox=aux.prox;
	                aux.prox=novo;
	            }else{
	                System.out.println("Posição Inválida!");
	            }            
	        }
	    }

	 

	public String percorre(){
		NO aux=inicio;
		String r=" ";
		while(aux!=null){
			r=r+"\n"+aux.dado;
			aux=aux.prox;
		}
		return r;
	}
}
