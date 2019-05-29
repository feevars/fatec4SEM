/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * a) Sistema: Aluno - Classe do Objeto Aluno
 */
package sistemaaluno;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Bega Harnik
 */
public class Aluno {

    private String nome;
    private String sobrenome;
    private float pontos;
    
    

    //Métodos construtores: 1º - Recebendo em array, 2º - Declaração de cada variável	 
    Aluno() {
        this("", "", 0);
    }

    Aluno(String nomealuno, String sobrenomealuno, float pontosaluno){
          this.nome = nomealuno;
          this.sobrenome = sobrenomealuno;
          this.pontos = pontosaluno;
    }
    
    
    //Métodos especiais
    public Aluno[] gravarAluno(Aluno[] aluno, int qtd) throws IOException {

        int i;

        String nome_do_arquivo = "Registro_de_Alunos.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter( nome_do_arquivo, true ));
        
        //Inicio um objeto Aluno em cada posição de meu array aluno[]
        for (i = 0 ; i < qtd ; i++){
             aluno[i] = new Aluno();
        }
        for (i = 0 ; i < qtd ; i++){	

            //Define NOME e escreve no TXT
            aluno[i].setNome(JOptionPane.showInputDialog("Digite o primeiro nome do aluno:"));	
            writer.write("Aluno(a): " + aluno[i].getNome() + " ");

            //Define SOBRENOME e escreve no TXT
            aluno[i].setSobrenome(JOptionPane.showInputDialog("Digite o sobrenome de " + aluno[i].getNome() + ":"));	
            writer.write(aluno[i].getSobrenome());
            writer.newLine();

            //Define PONTOS e escreve no TXT
            aluno[i].setPontos(Float.parseFloat(JOptionPane.showInputDialog("Pontos de graduação de " + aluno[i].getNome() + " " + aluno[i].getSobrenome() + ":")));	
            writer.write("Pontos: " + Float.toString(aluno[i].getPontos()) + "\n-------------------------------");
            writer.newLine();
        }

        //Mensagem de sucesso e fechamento do BUFFERED WRITER
        writer.close();
        JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!");
        return aluno;
    }
    
    public void lerAluno() throws IOException {
        
        String nome_do_arquivo = "Registro_de_Alunos.txt";
        
        BufferedReader br = new BufferedReader(new FileReader( nome_do_arquivo));
        String s;
        String texto = "";
             
            //ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((s = br.readLine()) != null) {
                texto += s + "\n";
            }
            
        br.close();
        JOptionPane.showMessageDialog(null, "Registros gravados na lista de alunos:\n\n-------------------------------\n" + texto);
    }
    
    
    //Métodos get & set de encapsulamento
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public float getPontos() {
        return pontos;
    }

    public void setPontos(float pontos) {
        this.pontos = pontos;
    }
    
}
