/*
 *************************
Lote 01 - Exercício 30
Receba a data de nascimento e atual em ano, mês e dia.
Calcule e mostre a idade em anos, meses e dias, considerando os anos bissextos.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq30 {
    
    public static void main(String args[]){
        
        /*Dia Atual, Mês Atual, Ano Atual, Dia Nascimento, Mês Nascimento, Ano Nascimento, Total Dias*/
        int DA, MA, AA, DN, MN, AN, TD;
        
        /*Ano atual*/
        AA = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual: "));
        
        /*Mês atual*/
        MA = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês atual: "));
        while(MA < 1 || MA > 12){
            MA = Integer.parseInt(JOptionPane.showInputDialog("Os meses vão de 1 a 12.\nDigite o mês atual: "));
        }
        
        /*Dia atual*/
        DA = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia atual: "));
        
        /*Se o mês tem 31 dias...*/
        if(MA == 1 || MA == 3 || MA == 5 || MA == 7 || MA == 8 || MA == 10 || MA == 12){
            
            while(DA < 1 || DA > 31){
                
                DA = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês atual vão de 1 a 31.\nDigite o dia atual: "));
                
            }
        
        /*Se o ano atual é bissexto e é fevereiro...*/
        }else if(MA == 2 && ((AA % 400 == 0) || ((AA % 4 == 0) && (AA % 100 != 0)))){
            
            while(DA < 1 || DA > 29){
                
                DA = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês atual vão de 1 a 29.\nDigite o dia atual: "));
                
            }
        
        /*Fevereiro de um ano normal...*/
        }else if(MA == 2){
            
            while(DA < 1 || DA > 28){
                
                DA = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês atual vão de 1 a 28.\nDigite o dia atual: "));
                
            }
        
        /*Mês de 30 dias...*/
        }else{
            
            while(DA < 1 || DA > 30){
                
                DA = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês atual vão de 1 a 30.\nDigite o dia atual: "));
                
            }
            
        }
        
        /*Ano nascimento*/
        AN = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));
        
        /*Ano de nascimento não pode ser maior...*/
        while(AN > AA){
            
            AN = Integer.parseInt(JOptionPane.showInputDialog("O ano de nascimento não pode ser maior que o ano atual.\nDigite o ano de nascimento: "));
            
        }
        
        /*Mês nascimento*/
        MN = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês de nascimento: "));
        if(AN == AA){
            while(MN > MA || MN < 1){
                MN = Integer.parseInt(JOptionPane.showInputDialog("O mês de nascimento não pode vir depois do mês atual do mesmo ano nem ser menor que 1.\nDigite o mês de nascimento: "));
            }
        }else{
            while(MN < 1 || MN > 12){
                MN = Integer.parseInt(JOptionPane.showInputDialog("Os meses vão de 1 a 12.\nDigite o mês de nascimento: "));
            }
        }
        
        /*Dia nascimento*/
        DN = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia de nascimento: "));
        
        /*Se o ano atual e o mes atual são os mesmos que os de nascimento...*/
        if(AN == AA && MN == MA){
            
            while(DN > DA || DN < 1){
                
                DN = Integer.parseInt(JOptionPane.showInputDialog("O dia de nascimento não pode ser maior que o dia atual nos mesmos mês e ano nem menor que 1. Digite o dia de nascimento: "));
            
            }
            
            
        }else{
            
            /*Se o mês tem 31 dias...*/
            if(MN == 1 || MN == 3 || MN == 5 || MN == 7 || MN == 8 || MN == 10 || MN == 12){

                while(DN < 1 || DN > 31){

                    DN = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês de nascimento vão de 1 a 31.\nDigite o dia de nascimento: "));

                }

            /*Se o ano de nascimento é bissexto e é fevereiro...*/
            }else if(MN == 2 && ((AN % 400 == 0) || ((AN % 4 == 0) && (AN % 100 != 0)))){

                while(DN < 1 || DN > 29){

                    DN = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês de nascimento vão de 1 a 29.\nDigite o dia de nascimento: "));

                }

            /*Fevereiro de um ano normal...*/
            }else if(MN == 2){

                while(DN < 1 || DN > 28){

                    DN = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês de nascimento vão de 1 a 28.\nDigite o dia de nascimento: "));

                }

            /*Mês de 30 dias...*/
            }else{

                while(DN < 1 || DN > 30){

                    DN = Integer.parseInt(JOptionPane.showInputDialog("Os dias do mês de nascimento vão de 1 a 30.\nDigite o dia de nascimento: "));

                }

            }
        }
        
        /*Mesmo ano, mesmo mês...*/
        if(AA == AN && MA == MN){
            
            TD = DA - DN;
            JOptionPane.showMessageDialog(null, "Idade: " + TD + " dia(s).");
        
        /*Mesmo ano, mês menor...*/
        }else if(AA == AN && MN < MA){
            
            /*Se o mês tem 31 dias...*/
            if(MN == 1 || MN == 3 || MN == 5 || MN == 7 || MN == 8 || MN == 10 || MN == 12){
                
                TD = 31 - DN;
                
            /*Se o ano de nascimento é bissexto e é fevereiro...*/
            }else if(MN == 2 && ((AN % 400 == 0) || ((AN % 4 == 0) && (AN % 100 != 0)))){
                
                TD = 29 - DN;
                                
            /*Fevereiro de um ano normal...*/
            }else if(MN == 2){
                
                TD = 28 - DN;
                
            /*Mês de 30 dias...*/
            }else{
                
                TD = 30 - DN;
                
            }
            
            /*Adiciono 1 ao mês de nascimento e inicio um enquanto...*/
            MN++;
            while (MN < MA){
                
                /*Se o mês tem 31 dias...*/
                if(MN == 1 || MN == 3 || MN == 5 || MN == 7 || MN == 8 || MN == 10 || MN == 12){

                    TD = 31 + TD;

                /*Se o ano de nascimento é bissexto e é fevereiro...*/
                }else if(MN == 2 && ((AN % 400 == 0) || ((AN % 4 == 0) && (AN % 100 != 0)))){

                    TD = 29 + TD;

                /*Fevereiro de um ano normal...*/
                }else if(MN == 2){

                    TD = 28 + TD;

                /*Mês de 30 dias...*/
                }else{

                    TD = 30 + TD;

                }
                
                MN++;
                
            }
            
            TD = TD + DA;
            
            JOptionPane.showMessageDialog(null, "Idade: " + TD + " dia(s).\nOu " + TD / 30 + " mes(es) e " + TD % 30 + " dia(s),\nconsiderando que o mês tem 30 dias.");
        
        /*O ano atual é maior que o ano de nascimento*/
        }else{
            
            /*Se o mês tem 31 dias...*/
            if(MN == 1 || MN == 3 || MN == 5 || MN == 7 || MN == 8 || MN == 10 || MN == 12){
                
                TD = 31 - DN;
                
            /*Se o ano de nascimento é bissexto e é fevereiro...*/
            }else if(MN == 2 && ((AN % 400 == 0) || ((AN % 4 == 0) && (AN % 100 != 0)))){
                
                TD = 29 - DN;
                
             
            /*Fevereiro de um ano normal...*/
            }else if(MN == 2){
                
                TD = 28 - DN;
                
            /*Mês de 30 dias...*/
            }else{
                
                TD = 30 - DN;
                
            }
            
            /*Adiciono 1 ao mês de nascimento e inicio um enquanto...*/
            MN++;
            while (MN <= 12){
                
                /*Se o mês tem 31 dias...*/
                if(MN == 1 || MN == 3 || MN == 5 || MN == 7 || MN == 8 || MN == 10 || MN == 12){

                    TD = 31 + TD;

                /*Se o ano de nascimento é bissexto e é fevereiro...*/
                }else if(MN == 2 && ((AN % 400 == 0) || ((AN % 4 == 0) && (AN % 100 != 0)))){

                    TD = 29 + TD;

                /*Fevereiro de um ano normal...*/
                }else if(MN == 2){

                    TD = 28 + TD;

                /*Mês de 30 dias...*/
                }else{

                    TD = 30 + TD;

                }
                
                MN++;
                
            }
            
            /*Adiciono 1 ao ano de nascimento*/
            AN++;
            
            /*
            Enquanto o ano de nascimento for menor que o ano atual,
            basta adicionar a quantidade de dias daquele ano ao total de dias...
            */
            while(AN < AA){
                
                /*Se for bissexto soma 366 dias.*/
                if((AN % 400 == 0) || ((AN % 4 == 0) && (AN % 100 != 0))){
                    
                    TD = TD + 366;
                
                /*Se não soma 365 dias.*/
                }else{
                    
                    TD = TD + 365;
                    
                }
                
                AN++;

            }
            
            /*
            A partir daqui o ano de nascimento já é o mesmo do atual,
            então começamos a adicionar os dias do ano em questão.
            Inicio utilizando a variável do mês de nascimento, digo que ela é 1.
            */
            
            MN = 1;
            
            while(MN < MA){
                
                /*Se o mês tem 31 dias...*/
                if(MN == 1 || MN == 3 || MN == 5 || MN == 7 || MN == 8 || MN == 10 || MN == 12){

                    TD = 31 + TD;

                /*Se o ano de nascimento é bissexto e é fevereiro...*/
                }else if(MN == 2 && ((AA % 400 == 0) || ((AA % 4 == 0) && (AA % 100 != 0)))){

                    TD = 29 + TD;

                /*Fevereiro de um ano normal...*/
                }else if(MN == 2){

                    TD = 28 + TD;

                /*Mês de 30 dias...*/
                }else{

                    TD = 30 + TD;

                }
                
                MN++;
                
            }
            
            /*Adiciono os dias do mês atual*/
            TD = TD + DA;
            
            JOptionPane.showMessageDialog(null, "Idade: " + TD + " dia(s).\nOu " + TD / 365 + " ano(s), " + (TD % 365) / 30 + " mes(es) e " + ((TD % 365) % 30) + " dia(s),\nconsiderando que o ano tem 365 e o mês tem 30 dias.");
            
        }
    
    }
   
}