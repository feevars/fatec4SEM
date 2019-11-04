package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Buffers {
	 
	Path path = Paths.get("ListasGeradas/Lista.txt");
	//Métodos especiais
    public Evento[] gravarAluno(Convidado[] convidado) throws IOException {

        int i;

        String nomeArquivo = "Registro_de_Alunos.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true ));
        
        "Lista de Convidados " +;
        ListaConvidados 
        //Inicio um objeto Convidado em cada posição de meu array aluno[]
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
    
}
