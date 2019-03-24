/*
 *************************
 ******MODULARIZAÇÃO******
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

public class Lt01_ModSeq21{
    
    public static void main(String args[]){
        
        double nota1, nota2, nota3, nota4;
        
        nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota: "));
        nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota: "));
        nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota: "));
        nota4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a quarta nota: "));
        
        Resultado(Media(nota1, nota2, nota3, nota4));
    }
    
    public static double Media(double n1, double n2, double n3, double n4){
        
        double media = (n1 + n2 + n3 + n4) / 4;
        
        return media;
        
    }
    
    public static void Resultado(double media){
        
        if(media >= 6.0){
            
            JOptionPane.showMessageDialog(null, "Media " + media + "\nAprovado.");
            
        }else if(media >= 3.0){
            
            JOptionPane.showMessageDialog(null, "Media " + media + "\nExame. ");
            
        }else if(media < 3.0){
            
            JOptionPane.showMessageDialog(null, "Media " + media + "\nRetido. ");
        }
        
    }
    
}
