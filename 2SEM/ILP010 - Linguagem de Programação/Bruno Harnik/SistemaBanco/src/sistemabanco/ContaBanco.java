/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabanco;

/**
 *
 * @author bruno
 */
public class ContaBanco {
    
    //Atributos
    public int numConta;
    private String nomeCliente;
    private float saldoConta;
    private int tipoConta;
    
    //Métodos Personalizados
    
    public void estadoConta(){
        System.out.println("\n-------------------------\n");
        System.out.println("Cliente: " + this.getNomeCliente());
        System.out.println("Tipo da conta: " + this.getTipoConta());
        System.out.println("Saldo: R$" + this.getSaldoConta());
    }
    
    public void cadastroConta(int t){
        this.setTipoConta(t);
    }
    
    public void deposito(float v){
        this.setSaldoConta(this.getSaldoConta() + v);
        System.out.println("Depósito realizado na conta de " + this.getNomeCliente());
    }
    
    public void saque(float v){
        if(this.getSaldoConta() >= v){
            this.setSaldoConta(this.getSaldoConta() - v);
            System.out.println("Saque realizado na conta de " + this.getNomeCliente());
        } else {
            System.out.println("Saldo insuficiente para saque.");
        } 
    }
    
    //Construtor
    public ContaBanco() {
        this.saldoConta = 0;
    }
    
    //Métodos Get & Set
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    
}
