/*

*/


import javax.swing.JOptionPane;

public class Lt01_EstDecEncadeado
{
    public static void main (String args[])
    {
        int idade;
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade"));
        if (idade >= 18)
        {
            JOptionPane.showMessageDialog(null,"TÁ GRANDE HEIN BIXÃO");
        }
        else if(idade >= 16 && idade < 18)
                {
                    JOptionPane.showMessageDialog(null,"TÁ QUASE LÁ CAMPEÃO!");
                }
         else
                {
                    JOptionPane.showMessageDialog(null,"VOCÊ É UM PIVETE DE MENÓ");
                        }       
    }
    
}