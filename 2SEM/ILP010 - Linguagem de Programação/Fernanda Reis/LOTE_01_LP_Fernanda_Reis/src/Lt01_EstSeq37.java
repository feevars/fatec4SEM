/*
 *************************
Lote 01 - Exercício 37 - Receba um número inteiro. Calcule e mostre a série de 
Fibonacci até o seu N’nésimo termo.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq37 {
    public static void main (String args[]) {
    
    
        int A = 0, B = 1, C = 0, total = 0, numero;
    
        String resultado = A +" + " +B;

                
        numero = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos uma sequência de Fibonacci.\nInsira o termo desejado: "));
        
        if (numero ==0) {
            JOptionPane.showMessageDialog(null, "O número inserido não corresponde a nenhum termo.");
        }
        else {
            for (int i = 1; i <= (numero-1); i++){         
            
                total += B;
                C = A + B; 
                A = B; 
                B = C; 
           
                if(i < (numero-1)){
                    resultado += " + " +C ;
                } else if (i == (numero-1)) {
                    resultado += " = ";
                }
            }
        
            resultado += total;
        
            JOptionPane.showMessageDialog(null, resultado);
        }
    }
}
