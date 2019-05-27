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
public class SistemaBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContaBanco c1 = new ContaBanco();
        c1.setNumConta(1);
        c1.setNomeCliente("Fernandinha");
        c1.cadastroConta(3);
        
        
        ContaBanco c2 = new ContaBanco();
        c2.setNumConta(2);
        c2.setNomeCliente("Bruno");
        c2.cadastroConta(2);
        
        c1.estadoConta();
        c2.estadoConta();
    }
    
}
