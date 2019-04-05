/*
 * Criar e carregar uma matriz [4][3] inteiro com quantidade
 * de produtos vendidos em 4 semanas. Calcular e exibir:
 *      a. A quantidade de cada produto vendido no mês;
 *      b. A quantidade de produtos vendidos por semana;
 *      c. O total de produtos vendidos no mês.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Lt01_Arrays08 {
    
    public static void main(String[] args){
        
        int [][] Produtos = new int [4][3];
        
        for(int i = 0; i < 4; i ++){
            
            for(int j = 0; j < 3; j++){
                
                Produtos[i][j] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "ª semana\n\nVendas do\nProduto #" + (j + 1)));
                
            }
            
        }
        
        //Respostas
        
        //Quantidade de cada produto vendido no mês
        JOptionPane.showMessageDialog(null, "A quantidade de produtos vendidos no mês foi:\n"
                                          + "\nProduto 1: " + ProdutosMes(Produtos)[0]
                                          + "\nProduto 2: " + ProdutosMes(Produtos)[1]
                                          + "\nProduto 3: " + ProdutosMes(Produtos)[2]);
        
        //Total de produtos vendidos por semana
        JOptionPane.showMessageDialog(null, "A quantidade de vendas por semana foi:\n"
                                          + "\nSemana 1: " + VendasSemana(Produtos)[0]
                                          + "\nSemana 2: " + VendasSemana(Produtos)[1]
                                          + "\nSemana 3: " + VendasSemana(Produtos)[2]
                                          + "\nSemana 4: " + VendasSemana(Produtos)[3]);
        
        //Total de produtos vendidos no mês
        JOptionPane.showMessageDialog(null, "O total de produtos vendidos foi: " + TotalVendas(Produtos));
        
    }
    
    public static int [] ProdutosMes(int p[][]){
        
        int [] produtos_mes = new int [3];
        
        for(int i = 0; i < 3; i++){
            
            for(int j = 0; j < 4; j++){
                
                produtos_mes[i] += p[j][i];
                
            }
            
        }
        
        return produtos_mes;
        
    }
    
    public static int [] VendasSemana(int p[][]){
        
        int [] vendas_semana = new int [4];
        
        for(int i = 0; i < 4; i++){
            
            for(int j = 0; j < 3; j++){
                
                vendas_semana[i] += p[i][j];
                
            }
            
        }
        
        return vendas_semana;
        
    }
    
    public static int TotalVendas(int p[][]){
        
        int total_vendas = 0;
        
        for(int i = 0; i < 4; i++){
            
            for(int j = 0; j < 3; j++){
                
                total_vendas += p[i][j];
                
            }
            
        }

        return total_vendas;

    }
    
}
