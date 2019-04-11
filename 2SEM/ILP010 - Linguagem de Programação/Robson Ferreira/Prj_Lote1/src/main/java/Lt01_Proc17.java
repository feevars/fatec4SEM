/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 17 - procedimento
Calcule a quantidade de litros gastos em uma viagem, sabendo que o
automóvel faz 12 km/l. Receber o tempo de percurso e a velocidade média.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_Proc17 
{
    public static void main (String Args[])
    { 
        
        procedure();
        
    }
    static void procedure(){
        
        double lt, vm, t;
               
        t = Double.parseDouble (JOptionPane.showInputDialog("Digite o tempo de percurso"));
        vm = Double.parseDouble (JOptionPane.showInputDialog("Digite a velocidade média"));
               
        lt = vm * t / 12;
                   
        JOptionPane.showMessageDialog(null, "a quantidade de litros gastos foi de "+lt);
    }
    
}
