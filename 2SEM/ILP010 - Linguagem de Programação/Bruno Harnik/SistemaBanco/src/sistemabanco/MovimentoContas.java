/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabanco;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class MovimentoContas {
    
    //Atributos
    private int codConta;
    private double valorMovimento;
    private int tipoMovimento;
    private boolean status;
    
    public String arquivo = "Movimentos.txt";
    
    //Construtores
    public MovimentoContas(){
        this(0,0.0,0,false);
    }
    
    public MovimentoContas(int codConta, double valorMovimento, int tipoMovimento, boolean status){
        this.codConta = codConta;
        this.valorMovimento = valorMovimento;
        this.tipoMovimento = tipoMovimento;
        this.status = status;
    }
    
    //Método Get & Set;
    public int getCodConta(){
        return codConta;
    }
    public void setCodConta(int codConta){
        this.codConta = codConta;  
    }
    public double getValorMovimento(){
        return valorMovimento;
    }
    public void setValorMovimento(double valorMovimento){
        this.valorMovimento = valorMovimento;
    }
    public int getTipoMovimento(){
        return tipoMovimento;
    }
    public void setTipoMovimento(int tipoMovimento){
        this.tipoMovimento = tipoMovimento;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    
    //Métodos Especiais
    
    //Cadastrar Movimento
    public MovimentoContas cadastrarMovimento(MovimentoContas mov) throws IOException{
        
        ContasCorrentes cc = new ContasCorrentes();

        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true));
        BufferedReader reader_mov = new BufferedReader(new FileReader(arquivo));   //Reader para Movimento
        BufferedReader reader_cc = new BufferedReader(new FileReader(cc.arquivo)); //Reader para ContaCorrente
        
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Digite código da conta que você deseja realizar operações:"));
        
        for(int i = 0; i < cc.totalContas(); i ++){
            if( i ==)
            cc.arrayContas()[i].getCodConta();
        }
        
        

    }
}