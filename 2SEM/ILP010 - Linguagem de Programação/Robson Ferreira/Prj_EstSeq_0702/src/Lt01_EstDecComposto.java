/*

*/


import javax.swing.JOptionPane;

public class Lt01_EstDecComposto
{
    public static void main (String args[])
    {
        int idade;
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade"));
        if (idade >= 18)
        {
            JOptionPane.showMessageDialog(null,"MAIOR DE IDADE");
        }
        else
        {
                    JOptionPane.showMessageDialog(null,"VOCÊ É UM PIVETE DE MENÓ");
        }
    }
    
}