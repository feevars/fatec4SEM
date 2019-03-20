/*
 *************************
Lote 01 - Exercício 16
Receba a quantidade de horas trabalhadas, o valor por hora, o percentual de desconto e o número de descendentes.
Calcule o salário que serão as horas trabalhadas x o valor por hora.
Calcule o salário líquido (= Salário Bruto – desconto).
A cada dependente será acrescido R$ 100 no Salário Líquido.
Exiba o salário a receber.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq16 {
    
    public static void main (String args[]){
        
        double horas, valor_hora, desconto, descendentes, salario_bruto, salario_liquido;
        
        horas = Double.parseDouble(JOptionPane.showInputDialog("Quantidade de horas trabalhadas: "));
        
        valor_hora = Double.parseDouble(JOptionPane.showInputDialog("Valor pago por hora trabalhada: "));
        
        desconto = Double.parseDouble(JOptionPane.showInputDialog("Percentual de desconto: "));
        
        descendentes = Double.parseDouble(JOptionPane.showInputDialog("Quantidade de descendentes: "));
        
        salario_bruto = horas * valor_hora;
        
        salario_liquido = salario_bruto - (salario_bruto * desconto / 100) + 100 * descendentes;

        JOptionPane.showMessageDialog(null, "O valor do salário líquido será: " + salario_liquido);
    }
}
