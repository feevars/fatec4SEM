import javax.swing.JOptionPane;

public class BubbleSort {
	public static int vetor[]=new int [10];        	
	public static int i;                            


	public static void main(String[] args) {
		for (i=0;i<=9;i++)
		{
			vetor[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe um número"));        
		}

		rot_ordenar();                    
		rot_exibir();                     
	}

	public static void rot_ordenar(){
		int j,aux;
		for (i=0;i<9;i++)                                
			for (j=i+1;j<10;j++)                              
			{
				if (vetor[i]>vetor[j]) {                            
					aux=vetor[i];                                      
					vetor[i]=vetor[j];                                 
					vetor[j]=aux;                                      				}
			}
	}

	public static void rot_exibir(){
		System.out.println("Os valores informados em ordem crescente são:");
		for (i=0;i<10;i++)
		{
			System.out.println(+vetor[i]);                
		}
	}

}
