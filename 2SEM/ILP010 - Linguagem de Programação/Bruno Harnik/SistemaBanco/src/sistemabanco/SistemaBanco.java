/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabanco;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class SistemaBanco {

    /**
     * @param args the command line arguments
     * 
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ContasCorrentes contas = new ContasCorrentes();
        MovimentoContas movimento = new MovimentoContas();
        
        int opc = 0;
        
        int opcc = 0;
        
        while(opc != 9){
            
            opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n"
                                                              + "1: Cadastrar conta corrente\n"
                                                              + "2: Cadastrar movimento\n"
                                                              + "3: Gerar contas atualizadas\n"
                                                              + "4: Consultar cadastros\n\n"
                                                              + "9: FIM"));
            
            
            
            switch(opc){
                
                case 1: contas.cadastrarConta(contas);
                        break;
                        
                case 2: movimento.cadastrarMovimento(movimento);
                        break;
                        
                
                case 4: while(opcc != 9){
            
                            opcc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n"
                                                                            + "1: Contas Correntes\n"
                                                                            + "2: Movimentos\n"
                                                                            + "3: Atualizado\n"
                                                                            + "9: Voltar"));
                    
                            switch(opcc){
                                case 1: contas.consultarContas();
                                        break;
                                        
                                case 9: break;

                                default: JOptionPane.showMessageDialog(null, "Opção Inválida"); 
                                         opc = 0;
                                         break;
                            }
                        }
                        break;
                
                case 9: JOptionPane.showMessageDialog(null, "Fim do programa.\nReinicie para continuar."); 
                        break;
                        
                default: JOptionPane.showMessageDialog(null, "Opção Inválida"); 
                         opc = 0;
                         break;
                
            }
            
        }
        
        

    }
    
}
