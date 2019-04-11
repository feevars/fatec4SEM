/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 27 - procedimento
Receba o número de voltas, a extensão do circuito (em metros) e o tempo de
duração (minutos). Calcule e mostre a velocidade média em km/h.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_Proc27 
{
    public static void main (String Args[])
    { 
        procedure();
    }
     static void procedure(){
        int voltas;
        double metros, minutos, velocidade;
               
        voltas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de voltas."));
        metros = Double.parseDouble(JOptionPane.showInputDialog("Digite a extensão do circuito em metros."));
        minutos = Double.parseDouble(JOptionPane.showInputDialog("Digite a duração do circuito em minutos."));
        
        velocidade = (voltas*(metros/1000))/(minutos/60);
        JOptionPane.showMessageDialog(null,"A velocidade média em km/h é de: "+velocidade);
    }
}

        
    