/*
 *************************
Lote 01 - Exercício 21 - Receba 4 notas bimestrais de um aluno. Calcule e 
         mostre a média aritmética. Mostre a mensagem de acordo com a média:
            a. Se a média for >= 6,0 exibir “APROVADO”;
            b. Se a média for >= 3,0 ou < 6,0 exibir “EXAME”;
            c. Se a média for < 3,0 exibir “RETIDO”.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_Mod21 {
    static double NOTA1, NOTA2, NOTA3, NOTA4, MEDIA; 
     private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    public static void main (String args[]) {  
    
    NOTA1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota: "));
    NOTA2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota: "));
    NOTA3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 3ª nota: "));
    NOTA4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 4ª nota: "));
    
    Media();
    
    if (MEDIA > 6) {
        JOptionPane.showMessageDialog(null,"MÉDIA FINAL: " +casas2.format(MEDIA) +"\n       APROVADO.");
    }
    else {
        if (MEDIA > 3 && MEDIA < 6){
            JOptionPane.showMessageDialog(null,"MÉDIA FINAL: " +casas2.format(MEDIA) +"\n        EXAME.");
        }
        else {
            JOptionPane.showMessageDialog(null,"MÉDIA FINAL: " +casas2.format(MEDIA) +"\n       REPROVADO.");
        }
    }
    }
    
    
    static void Media () {
        MEDIA = (NOTA1 + NOTA2 + NOTA3 + NOTA4) / 4;
    }
}
