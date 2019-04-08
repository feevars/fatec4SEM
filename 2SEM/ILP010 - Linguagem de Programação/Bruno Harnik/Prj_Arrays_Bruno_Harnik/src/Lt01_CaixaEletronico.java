/*
 * Caixa Eletrônico
 * 
 * 1.   Criar um menu de opções:
 *
 *      Menu Principal
 *      1 - Carregar Notas
 *      2 - Retirar Notas
 *      3 - Estatística
 *      9 - Fim
 *
 *
 * 2.   Carregar a quantidade de notas em uma
 *      área da memória com 6 ocorrências.
 *
 *
 * 3.   Solicitar que o cliente faça a retirada de valores
 *      obedecendo ao critério do maior pelo menor.
 *
 *
 * 4.   Dar a opção para o cliente escolher o valor e a quantidade de notas.
 *      P. ex.: 1 x 20, 2 x 10...
 *
 *
 * 5.   Caso não tenha o valor da maior cédula,
 *      disponibilizar a próxima.
 *
 *
 * 6.   Se o valor a ser solicitado for maior que o saldo total do caixa,
 *      enviar a mensagem "EXCEDEU O LIMITE DO CAIXA".
 *
 *
 * 7.   Solicitar até 100 retiradas ou até não haver mais notas.
 *
 *
 * 8.   No momento da solicitação do valor, coletar também o código
 *      do banco que o cliente tem conta, segundo:
 *
 *      Código: [       1       ][      2      ][      3     ][      4      ] -> mudei para 0, 1, 2, 3
 *      Banco:  [Banco do Brasil][  Santander  ][    Itaú    ][    Caixa    ]
 *
 *
 * 9.   No final, exibir a estatística, separada por bancos, com:
 *
 *      9.1 O maior e o menor valor sacado;
 *      
 *      9.2 A média dos saques;
 *
 *      9.3 Valor total dos saques;
 *
 *      9.4 Valor das sobras dos caixas.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Lt01_CaixaEletronico {
    
    //Variáveis globais
    
    //Notas
    //Vetor com nome das notas tem texto
    static String [] nomes_notas = {"R$2", "R$5", "R$10", "R$20", "R$50", "R$100"};
    
    //Vetor com valor das notas
    static int [] valor_notas = {2, 5, 10, 20, 50, 100};
    
    //Vetor com a quantidade de cada nota
    static int [] qtd_notas = new int [6];
    
    //Vetor com o saldo de cada nota
    static int [] saldo_notas = new int [4];
    
    //Saldo em caixa
    static int saldo_caixa;
    
    //Bancos
    //Nome dos Bancos
    static String [] nomes_bancos = {"Banco do Brasil", "Santander", "Itaú", "Caixa"};
    
    //Variável para manipular o banco em questão.
    static int banco;
    
    //Quantidades de saques
    static int [] qtd_saques = new int [4];
    
    static int [] saldo_saques = new int [4];
    
    //Ícone
    static ImageIcon icone = new ImageIcon("src/images/favicon.png");
    
    
    //Função Main só carrega a função de menu.
    public static void main(String[] args){
        
        JOptionPane.showMessageDialog(null, "Bem vindo ao BankHarnik.\n\n"
                                          + "Você será direcionado para o Carregamento de Notas,\n"
                                          + "pois o caixa está vazio por enquanto...", "Caixa Eletrônico", 0, icone);
        MenuPrincipal();
        
    }
    
    
    //Função que exibe o Menu Principal
    public static void MenuPrincipal(){
        
        int opcao;
        String[] opcoes = {"Carregar notas", "Retirar notas", "Estatística", "Fim"};
        
        //Calculo o saldo total do caixa sempre que entro no menu
        saldo_caixa = 0;
        
        for (int i = 0; i < 6; i++){
            
            saldo_caixa += qtd_notas[i] * valor_notas[i];
            saldo_notas[i] = qtd_notas[i] * valor_notas[i];
            
        }
        
        if(saldo_caixa == 0){
            
            opcao = 1;
        }else{
            opcao = JOptionPane.showOptionDialog(null, //Frame pai (não usamos)
                                                "Saldo em caixa\nR$" + saldo_caixa + "\n\nSelecione a opção desejada:", //Texto na caixa
                                                "Caixa eletrônico", //Título da caixa
                                                JOptionPane.DEFAULT_OPTION, //Comportamento das opções
                                                JOptionPane.INFORMATION_MESSAGE, //Tipo de mensagem da caixa
                                                icone, //ícone
                                                opcoes, //Carrega as opções dos botões, a seleção devolve um inteiro com a posição no array
                                                opcoes[2]) //Posição que é destacada na caixa (destaquei Estatística)
                                                + 1;
                                                //Somei 1 para que as opções sejam 1, 2 e 3
                                                //se a opção for 4, vira 9 para seguir o enunciado
                                                if(opcao == 4){
                                                
                                                    opcao = 9;

                                                }
        }

        switch(opcao){
            
            case 1:     CarregarNotas();
                        break;
            
            case 2:     RetirarNotas();
                        break;
            
            case 3:     Estatistica();
                        break;
            
            case 9:     Fim();
                        break;
                        
            default:    Erro(1);
                        break;
            
        }
        
    }
    
    
    //Função que carrega notas
    public static void CarregarNotas(){
        
        SpinnerNumberModel model_2 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel model_5 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel model_10 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel model_20 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel model_50 = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel model_100 = new SpinnerNumberModel(0, 0, 100, 1);
        
        JSpinner N2 = new JSpinner(model_2);
        JSpinner N5 = new JSpinner(model_5);
        JSpinner N10 = new JSpinner(model_10);
        JSpinner N20 = new JSpinner(model_20);
        JSpinner N50 = new JSpinner(model_50);
        JSpinner N100 = new JSpinner(model_100);
        
        Object[] dados_carregar = {
            
            "Insira a\nquantidade desejada\nde cada nota:\n\n",
            nomes_notas[0], N2,
            nomes_notas[1], N5,
            nomes_notas[2], N10,
            nomes_notas[3], N20,
            nomes_notas[4], N50,
            nomes_notas[5], N100
        };
        
        JOptionPane.showConfirmDialog(null, dados_carregar, "Carregar notas", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, icone);

        qtd_notas[0] += Integer.parseInt(N2.getValue().toString());
        qtd_notas[1] += Integer.parseInt(N5.getValue().toString());
        qtd_notas[2] += Integer.parseInt(N10.getValue().toString());
        qtd_notas[3] += Integer.parseInt(N20.getValue().toString());
        qtd_notas[4] += Integer.parseInt(N50.getValue().toString());
        qtd_notas[5] += Integer.parseInt(N100.getValue().toString());
        
        MenuPrincipal();
    }
    
    
    //Função para retirar notas
    public static void RetirarNotas(){
        
        banco = JOptionPane.showOptionDialog(null,
                                                "\nSelecione seu banco:",
                                                "Saque",
                                                JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.INFORMATION_MESSAGE,
                                                icone, //ícone
                                                nomes_bancos,
                                                null);

        switch(banco){
            
            case 0:     Saque(banco);
                        break;
            
            case 1:     Saque(banco);
                        break;
            
            case 2:     Saque(banco);
                        break;
            
            case 3:     Saque(banco);
                        break;
                        
            default:    Erro(2);
                        break;
            
        }

    }
        
        //Funcão de Saque
        public static void Saque(int banco){
            
            SpinnerNumberModel model_saque = new SpinnerNumberModel(0, 0, saldo_caixa, 1);

            JSpinner valor_saque = new JSpinner(model_saque);

            Object[] dados_saque = {"Digite o valor\ndo saque:\n", valor_saque};

            JOptionPane.showConfirmDialog(null, dados_saque, "Saque", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, icone);

            int saque = Integer.parseInt(valor_saque.getValue().toString());
            
            //Este erro não deve acontecer, pois o Spinner sempre aceitará, no máximo, o saldo que há em caixa.
            if(saque > saldo_caixa){
                
                Erro(3);
            
            //Saque valor ímpar e não há nota de 5
            }else if(saque % 2 != 0 && qtd_notas[1] == 0){
                
                Erro(4);
            
            //Saque que depende de nota de 2 e não tem
            }else if((saque % 10 > saldo_notas[0] && saque % 2 == 0) || (saque % 5 > saldo_notas[0] && saque % 2 != 0)){
                
                Erro(5);
                
            }
            
            
            qtd_saques[banco]++;
            
            MenuPrincipal();
        }
    
    //Função que retorna as estatísticas do Caixa
    public static void Estatistica(){
        
        MenuPrincipal();
        
    }
    
    
    //Função que retorna mensagens de erro, cada casa uma mensagem.
    public static void Erro(int x){
        
        switch(x){
            
            //Erro 1: opção inválida no menu principal, caso o usuário clique no "X".
            case 1: JOptionPane.showMessageDialog(null, "Opção inválida.\n"
                                                      + "Por favor, selecione uma das opções exibidas nos botões.",
                                                      "Erro", 0, icone);
                    MenuPrincipal();
                    
            //Erro 2: opção inválida na seleção de banco, caso o usuário clique no "X".
            case 2: JOptionPane.showMessageDialog(null, "Opção inválida.\n"
                                                      + "Por favor, selecione um dos bancos para prosseguir com o saque.",
                                                      "Erro", 0, icone);
                    RetirarNotas();
            
            //Erro 3: saque maior que o saldo em caixa
            case 3: JOptionPane.showMessageDialog(null, "Não é poséivel sacar este valor.\n"
                                                      + "O saque é maior que o saldo em caixa.\n Refaça a operação.",
                                                      "Erro", 0, icone);
                    Saque(banco);
                    
            //Erro 4: sem notas de 5, não é possível sacar valor ímpar.
            case 4: JOptionPane.showMessageDialog(null, "Não é poséivel sacar este valor.\n"
                                                      + "Não há notas de R$5 no caixa,\nportando não é possível sacar valor ímpar.",
                                                      "Erro", 0, icone);
                    Saque(banco);
                    
            //Erro 5: sem notas de 2 para realizar o saque desejado.
            case 5: JOptionPane.showMessageDialog(null, "Não é poséivel sacar este valor.\n"
                                                      + "Não há notas de R$2 no caixa suficientes para sacar o valor desejado.",
                                                      "Erro", 0, icone);
                    Saque(banco);
        }
        
    }
    
    
    public static void Fim(){
        
        
        
    }
    
}
