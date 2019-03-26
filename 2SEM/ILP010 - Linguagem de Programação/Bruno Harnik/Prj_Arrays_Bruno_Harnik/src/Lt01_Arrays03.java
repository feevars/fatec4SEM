/*
 * 3.   Criar e coletar valores inteiros nos vetores VT1[3] e VT2[3].
 *      Concatenar esses valores em um 3º vetor (VT3_txt[6]) e mostrar os seus dados. 
 *      P. ex:
 *          VT1[1,2,3]  +   VT2[4,5,6]  =>  VT3_txt[1,4,2,5,3,6]
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Lt01_Arrays03 {
    
    public static void main(String[] args){
        
        int []  VT1 = new int [3], VT2 = new int [3];
        
        String VT1_txt = "Vetor 1: ", VT2_txt = "Vetor 2: ";
        
        for(int i = 0; i < 3; i++){
            
            VT1[i] = Integer.parseInt(JOptionPane.showInputDialog("1º vetor.\n" + (i+1) + "ª posição:" ));
            VT2[i] = Integer.parseInt(JOptionPane.showInputDialog("2º vetor.\n" + (i+1) + "ª posição:" ));
            
            if(i < 2){
                
                VT1_txt += VT1[i] + ",  ";
                VT2_txt += VT2[i] + ",  ";
                
            }else{
                
                VT1_txt += VT1[i] + ".";
                VT2_txt += VT2[i] + ".";
                
            }
            
        }
        
        String resultado = VT1_txt + "\n" + VT2_txt + "\n\nVetor 3: " + VT3(VT1,VT2);
        
        
        JOptionPane.showMessageDialog(null, resultado);
        
        
        
    }
    public static String VT3(int VT1[], int VT2[]){
        
        String VT3_txt = "";
        
        for(int i = 0; i < 6; i++){
            
            if(i % 2 == 0){
                
                VT3_txt += VT1[i / 2];
                
            }else{
                
                VT3_txt += VT2[i / 2];
                
            }
            if(i < 5){
                
                VT3_txt += ",   ";
                
            }else{
                
                VT3_txt += ".";
                
            }
            
        }
        
        return VT3_txt;
    }
    
}