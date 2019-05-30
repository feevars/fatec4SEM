/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * c) Sistema: Eleicao - Estatísticas
 */
package sistemavotos;

import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Bega Harnik
 */
public class Estatisticas {
    
    Eleicao e = new Eleicao();
    int [] votos_secao = new int [e.num_secoes];
    int [] votos_candidato = new int [e.num_candidatos];
    
    
    //4.1 Eleitores por seção
    public void eleitoresSecao(Eleicao[] voto, int qtd){
        
        String result = "Votos por Seção\n"
                      + "---------------\n\n";
        
        for(int i = 1; i <= e.num_secoes; i++){
            
            for(int j = 0; j < qtd; j++){
                
                if(i == voto[j].getSecao()){
                    
                    votos_secao[i - 1]++;
                    
                }
                
            }
            
            result += "Seção\t" + i + ":\t" + votos_secao[i - 1] + "\teleitores\n";
            
        }
        
        JOptionPane.showMessageDialog(null, result);
        
    }
    
    //4.2 Seções com maior e menor número de eleitores
    public void secaoMaiorMenor(){
        
        int maior = votos_secao[0];
        int menor = votos_secao[0];
        
        String txt_maior = "1";
        String txt_menor = "1";
        
        for(int i = 1; i < e.num_secoes; i++){
            
            if(votos_secao[i] > maior){
                
                maior = votos_secao[i];
                txt_maior = "" + (i + 1);
                
            }else if(votos_secao[i] < menor){
                
                menor = votos_secao[i];
                txt_menor = "" + (i + 1);
                
            }else if(votos_secao[i] == maior){
                
                txt_maior += ", " + (i + 1);
                
            }else if(votos_secao[i] == menor){
                
                txt_menor += ", " + (i + 1);
                
            }
        }
        
        JOptionPane.showMessageDialog(null, "Seções com maior número de votos (" + maior + " votos) : " + txt_maior
                                        + "\nSeções com menor número de votos (" + menor + " votos) : " + txt_menor);
        
    }
    
    public void votosCandidatos(Eleicao [] voto, int qtd){
        
        String result = "Votos por Candidato\n"
                      + "---------------\n\n";
        
        for(int i = 1; i <= e.num_candidatos; i++){
            
            for(int j = 0; j < qtd; j++){
                
                if(i == voto[j].getSecao()){
                    
                    votos_candidato[i - 1]++;
                    
                }
                
            }
            
            result += "Candidato\t" + i + ":\t" + votos_candidato[i - 1] + "\tvotos\n";
            
        }
        
        JOptionPane.showMessageDialog(null, result);
        
        
    }
    
}
