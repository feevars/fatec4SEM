/*
 *************************
Lote 01 - Exercício 21
Receba 4 notas bimestrais de um aluno. Calcule e mostre a média aritmética.

Mostre a mensagem de acordo com a média:
a. Se a média for >= 6,0 exibir "Aprovado";
b. Se a média for >= 3,0 ou < 6,0 exibir "Exame";
c. Se a média for < 3,0 exibir "Retido".

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq21{
    
    public static void main(String args[]){
        
        double nota1, nota2, nota3, nota4, media;
        
        nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota: "));
        nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota: "));
        nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota: "));
        nota4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a quarta nota: "));
        
        media = (nota1 + nota2 + nota3 + nota4) / 4;
        
        if(media >= 6.0){
            
            JOptionPane.showMessageDialog(null, "Media " + media + "\nAprovado.");
            
        }else if(media >= 3.0){
            
            JOptionPane.showMessageDialog(null, "Media " + media + "\nExame. ");
            
        }else if(media < 3.0){
            
            JOptionPane.showMessageDialog(null, "Media " + media + "\nRetido. ");
        }

    }
    
}
