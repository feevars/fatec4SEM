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
public class ContasCorrentes {
    
    
    //Atributos
    private int codConta;
    private String nomeCliente;
    private double saldoConta;
    private double limiteConta;
    private int tipoConta;
    
    public String arquivo = "ContasCorrentes.txt";
    
    public String [] str_tipoConta = {"Física","Conjunta","Jurídica","Especial"}; //Nomes dos tipos de conta
    
    
    
    //Construtor
    public ContasCorrentes(){
        this(0,"",0.0,0.0,0);
    }
    
    public ContasCorrentes(int codConta, String nomeCliente, double saldoConta, double limiteConta, int tipoConta) {
        this.codConta = codConta;
        this.nomeCliente = nomeCliente;
        this.saldoConta = saldoConta;
        this.limiteConta = limiteConta;
        this.tipoConta = tipoConta;
    }
    
    
    
    //Métodos Get & Set
    public int getCodConta() {
        return codConta;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
    
    public double getLimiteConta(){
        return limiteConta;
    }
    
    public void setLimiteConta(double limiteConta){
        this.limiteConta = limiteConta;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    
    
    //Métodos Personalizados
    
    //Cadastrar Conta
    public void cadastrarConta(ContasCorrentes conta) throws IOException{
        
        BufferedWriter writer = new BufferedWriter(new FileWriter (arquivo, true));
        BufferedReader reader = new BufferedReader(new FileReader (arquivo));
        
        int linhas = 1;
        
        int opc = 0;
        
        while(reader.readLine() != null){
            linhas++;
        }
        
        if(reader.readLine() == null){
            
            //Código da conta
            conta.setCodConta(linhas / 5);
            writer.write(String.valueOf(getCodConta()));
            writer.newLine();
            
            //Nome do cliente
            conta.setNomeCliente(JOptionPane.showInputDialog("Digite o nome do cliente"));
            writer.write(getNomeCliente());
            writer.newLine();
            
            //Saldo Conta
            conta.setSaldoConta(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial da conta.")));
            writer.write(String.valueOf(getSaldoConta()));
            writer.newLine();
            
            //Limite - Acredito que seja para negativar?
            conta.setLimiteConta(Double.parseDouble(JOptionPane.showInputDialog("Digite o limite desta da conta.")));
            writer.write(String.valueOf(getLimiteConta()));
            writer.newLine();
            
            
            //Tipo
            while(opc < 1 || opc > 4){
                
                opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção de conta:\n"
                                                                  +"1: Física\n"
                                                                  +"2: Conjunta\n"
                                                                  +"3: Jurídica\n"
                                                                  +"4: Especial"));
                
                switch(opc){
                    
                    case 1: conta.setTipoConta(1);
                            writer.write(String.valueOf(getTipoConta()));
                            writer.newLine();
                            break;
                    
                    case 2: conta.setTipoConta(2);
                            writer.write(String.valueOf(getTipoConta()));
                            writer.newLine();
                            break;
                    
                    case 3: conta.setTipoConta(3);
                            writer.write(String.valueOf(getTipoConta()));
                            writer.newLine();
                            break;
                    
                    case 4: conta.setTipoConta(4);
                            writer.write(String.valueOf(getTipoConta()));
                            writer.newLine();
                            break;
                            
                    default: JOptionPane.showMessageDialog(null, "Opção Inválida"); 
                             opc = 0;
                             break;
                    
                }
            }
        }
        
        writer.close();
        reader.close();
        
    }
    
    //Consultar Contas
    public void consultarContas() throws IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader (arquivo));
        
        String result = "Consulta de contas cadastradas:";
        
        String linha_atual;
        
        int linhas = 1;
        
        
        while((linha_atual = reader.readLine()) != null){
            
            if((linhas - 1 == 0) || ((linhas - 1) % 5 == 0)){
                
                result += "\nCódigo da conta: " + linha_atual;
                linhas++;
                result += "\nNome do cliente: " + reader.readLine();
                linhas++;
                result += "\nSaldo: " + reader.readLine();
                linhas++;
                result += "\nLimite: " + reader.readLine();
                linhas++;
                result += "\nTipo da conta: " + reader.readLine();
                linhas++;
                result += "\n----------------------------------";
            }
            
        }
        
        reader.close();
        JOptionPane.showMessageDialog(null, result);

    }
    
    //Total de Contas - Método para contar o total de contas cadastradas
    public int totalContas() throws IOException{
        
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        
        int total = 0;
        while(reader.readLine() != null) total++;
        
        if(total > 0){
            total = total / 5;
        }
        reader.close();
        return total;
    }
    
    
    //Array Contas - Monta o que está no TXT em um array para facilitar a vida
    public ContasCorrentes [] arrayContas() throws IOException{
        
        int qtd = totalContas();
        int i;
        
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        
        ContasCorrentes[] conta = new ContasCorrentes[totalContas()];
        
        for(i = 0; i < qtd; i++){
            conta[i] = new ContasCorrentes();
        }
        
        for(i = 0; i < qtd; i++){
            
            conta[i].setCodConta(Integer.parseInt(reader.readLine()));
            conta[i].setNomeCliente(reader.readLine());
            conta[i].setSaldoConta(Double.parseDouble(reader.readLine()));
            conta[i].setLimiteConta(Double.parseDouble(reader.readLine()));
            conta[i].setTipoConta(Integer.parseInt(reader.readLine()));
            
        }
        
        reader.close();
        return conta;
        
    }
    
    
    
    
    

    
    /*Métodos Personalizados
    
    public void estadoConta(){
        System.out.println("\n-------------------------\n");
        System.out.println("Cliente: " + this.getNomeCliente());
        System.out.println("Tipo da conta: " + this.getTipoConta());
        System.out.println("Saldo: R$" + this.getSaldoConta());
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
    */
    
}
