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

public class Lt01_ModSeq30 {
    
    public static void main(String args[]){
        
        //Variáveis para data Atual e data Final
        int AN, MN = 0, DN = 0, AA, MA = 0, DA = 0;
        
        //Entrada de dados com validação
        //Ano Nascimento
        AN = Integer.parseInt(JOptionPane.showInputDialog("Ano de nascimento: "));
        
        while(MN < 1 || MN > 12){
            
            //Mês Nascimento
            MN = Integer.parseInt(JOptionPane.showInputDialog("Mês de nascimento: "));
            
        }
        while(DN < 1 || DN > DiasNoMes(MN,AN)){
            
            //Dia Nascimento
            DN = Integer.parseInt(JOptionPane.showInputDialog(NomeMes(MN) + " de " + AN + " tem " + DiasNoMes(MN,AN) + " dias.\nDia de nascimento: "));
            
        }
        
        //Atribuo um valor para que o Ano Atual sirva para a condição de validação
        AA = AN - 1;
        while(AA < AN){
            
            AA = Integer.parseInt(JOptionPane.showInputDialog("Ano atual: "));

        }
        while(MA < 1 || MA > 12){
            
            MA = Integer.parseInt(JOptionPane.showInputDialog("Mês atual: "));

        }
        while(DA < 1 || DA > DiasNoMes(MA,AA)){
            
            DA = Integer.parseInt(JOptionPane.showInputDialog(NomeMes(MA) + " de " + AA + " tem " + DiasNoMes(MA,AA) + " dias.\nDia atual: "));
            
        }
        
        JOptionPane.showMessageDialog(null, "Total de dias: " + TotalDias(AN,MN,DN,AA,MA,DA) + "\n" + TotalDataInfo(AN,MN,DN,AA,MA,DA));
        
    }
    //FIM DO MAIN ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    //Função que verifica se o ano é bissexto
    public static boolean VerificaBissexto(int ano){
        
        //Se o ano é divisível por 400, ou se o ano é divisível por 4 mas não é divisível por 100, retorna TRUE.
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
        
    }
    
    //Função que verifica quantos dias há no mês recebendo o ano e o mês como parâmetros
    public static int DiasNoMes(int mes, int ano){
        
        if(mes == 1 || mes ==  3 || mes ==  5 || mes ==  7 || mes ==  8 || mes ==  10 || mes ==  12){
            
            return 31;
            
        }else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
            
            return 30;
            
        }else if(mes == 2 && VerificaBissexto(ano) == true){
            
            return 29;
            
        }else{
            
            return 28;
            
        }
        
    }
    
    //Funçãozinha para dar nome ao mês
    public static String NomeMes(int mes){
        
        String mes_nome[] = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        
        
        return mes_nome[mes - 1];
        
    }
    
    //**************************************
    //Função que calcula o total de dias
    //no intervalo das informações inseridas  
    //**************************************
    public static int TotalDias(int AN, int MN, int DN, int AA, int MA, int DA){
        
        int total_dias;
        
        //Ano e mês de nascimento são iguais aos atuais - subtração dos dias
        if(AN == AA && MN == MA){
            
            total_dias = DA - DN;
                    
        //Anos iguais, mês atual maior que mês de nascimento
        }else if(AN == AA && MN < MA){           
            
            total_dias = DiasNoMes(MN,AN) - DN + DA;
            
            for(int i = MN + 1; i < MA; i++ ){
                
                total_dias = total_dias + DiasNoMes(i,AN);
                
            }
        //Anos diferentes
        }else {
            
            //Subtraio o total de dias no mês pelo dia de nascimento
            //e somo os dias da data atual
            total_dias = DiasNoMes(MN,AN) - DN + DA;

            //Somo todos os dias que sobram no ano inicial
            for(int i = MN + 1; i <= 12; i++ ){

                total_dias = total_dias + DiasNoMes(i,AN);

            }
            
            //Somo os dias dos anos que estão no intervalo
            for (int i = AN + 1; i < AA; i++){

                if(VerificaBissexto(i) == true){

                    total_dias = total_dias + 366;

                }else{

                    total_dias = total_dias + 365;

                }

            }
            
            //Somo os dias dos meses do ano atual
            for(int i = 1; i < MA; i++ ){

                total_dias = total_dias + DiasNoMes(i,AA);

            }
                
        }
        
        return total_dias;
        
    }
    //**************************************
    //Função que calcula o total do período contando cada mês e
    //considerando 30 dias para adicionar 1 mês caso a soma dos
    //dias restantes do mês de nascimento com os dias da data atual
    //ultrapasse 30 dias.
    //**************************************
    public static String TotalDataInfo(int AN, int MN, int DN, int AA, int MA, int DA){
        
        
        
        
        int total_dias, total_meses = 0, total_anos = 0;
        
        total_dias = DiasNoMes(MN,AN) - DN + DA;
            
        if(total_dias >= 30){

            total_meses++;

            total_dias -= 30;

        }
        if(AN == AA){
            
            for(int i = MN + 1; i < MA; i++){

                total_meses++;

            }
        }else{
            
            for(int i = MN + 1; i <= 12; i++){

                total_meses++;

            }
            for(int i = 1; i < MA; i++){

                total_meses++;

            }
            if(total_meses >= 12){
                
                total_anos++;
                
                total_meses -= 12;
                
            }

        }
        
        for(int i = AN + 1; i < AA; i++){
            
                total_anos++;
                
        }
        
        String resultado = total_anos + " anos, " + total_meses + " meses e " + total_dias + " dias.";
        
        return resultado;
        
    }
            
}