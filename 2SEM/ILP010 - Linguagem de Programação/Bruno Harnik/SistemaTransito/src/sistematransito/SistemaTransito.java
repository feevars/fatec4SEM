/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematransito;

/**
 *
 * @author bruno
 */
import javax.swing.*;
import java.io.*;

public class SistemaTransito {

    public static void main(String[] args) throws IOException {
        int opc = 0;
        
        JOptionPane.showMessageDialog(null, "Bem vindo(a) ao sistema de cadastro de acidentes de trânsito.");
        
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1: Registrar acidente.\n"
                                                           + "2: Verificar lista de alunos e pontos.\n\n"
                                                           + "9: Encerrar programa.\n\n"
                                                           + "Digite a opção desejada:"));
            
        }
        
     
    }
    
}
