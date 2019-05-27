/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estatisticatransito;

/**
 * CLASSE ABSTRATA
 * @author Fernanda
 */
public class absEstatistica {
    private int codigo_cidade;
    private String nome_cidade;
    private int num_acidentes;
    private int tipo_veiculo;
    
    //construtor 
    public absEstatistica () {
        int cod, 
                tring nome;
    }
    
    
    //métodos principais
    public cadaastrarEstatistica() {
        
    }
    
    
    
    
    
    
    //métodos getters and setters

    public int getCodigo_cidade() {
        return codigo_cidade;
    }

    public void setCodigo_cidade(int codigo_cidade) {
        this.codigo_cidade = codigo_cidade;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public int getNum_acidentes() {
        return num_acidentes;
    }

    public void setNum_acidentes(int num_acidentes) {
        this.num_acidentes = num_acidentes;
    }

    public int getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(int tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }
    
    
    
}
