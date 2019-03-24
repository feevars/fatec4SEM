/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 16
Receba a quantidade de horas trabalhadas, o valor por hora, o percentual de desconto e o número de descendentes.
Calcule o salário que serão as horas trabalhadas x o valor por hora.
Calcule o salário líquido (= Salário Bruto % desconto).
A cada dependente será acrescido R$ 100 no Salário Líquido.
Exiba o salário a receber.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.*;

public class Lt01_ModSeq16 {
    
    public static void main (String args[]){
        
        JTextField horas_trabalhadas = new JTextField();
        JTextField valor_hora = new JTextField();
        JTextField percentual_desconto = new JTextField();
        JTextField descendentes = new JTextField();
        
        Object[] dados_trabalho = {
            "Horas trabalhadas", horas_trabalhadas,
            "Valor por hora em R$", valor_hora,
            "% de desconto", percentual_desconto,
            "Quantidade de descendentes", descendentes
        };
        
        JOptionPane.showConfirmDialog(null, dados_trabalho, "Calculdadora de salário", JOptionPane.OK_CANCEL_OPTION);
        
        String texto_h = horas_trabalhadas.getText();
        double ht = Double.parseDouble(texto_h);
        String texto_v = valor_hora.getText();
        double vh = Double.parseDouble(texto_v);
        String texto_p = percentual_desconto.getText();
        double pd = Double.parseDouble(texto_p);
        String texto_d = descendentes.getText();
        double d = Double.parseDouble(texto_d);
                
        
        JOptionPane.showMessageDialog(null, "O salário líquido será:\n" + CalcularSalario(ht,vh,pd,d));
        
    }
    
    public static double CalcularSalario(double horas_trabalhadas, double valor_hora, double desconto, double descendentes){
        
        double salario_bruto, salario_liquido;
       
        salario_bruto = horas_trabalhadas * valor_hora;
        
        salario_liquido = salario_bruto - (salario_bruto * desconto / 100) + 100 * descendentes;
                
        return salario_liquido;
    }
    
    
}
