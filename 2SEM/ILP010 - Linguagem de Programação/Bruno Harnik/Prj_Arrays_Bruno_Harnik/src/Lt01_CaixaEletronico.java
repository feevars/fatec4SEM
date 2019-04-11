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
import java.util.Arrays;

public class Lt01_CaixaEletronico {
    
    //Variáveis globais
    
    //Notas
    //Vetor com nome das notas tem texto
    static final String [] NOMES_NOTAS = {"R$2", "R$5", "R$10", "R$20", "R$50", "R$100"};
    
    //Vetor com valor das notas
    static final int [] VALOR_NOTAS = {2, 5, 10, 20, 50, 100};
    
    //Vetor com a quantidade de cada nota
    static int [] qtd_notas = new int [6];
    
    //Vetor com o saldo de cada nota
    static int [] saldo_notas = new int [6];
    
    //Saldo em caixa
    static int saldo_caixa;
    
    static int saques_registrados = 0;
    
    static int total_sacado = 0;
    
    //Bancos
    //Nome dos Bancos
    static final String [] NOMES_BANCOS = {"Banco do Brasil", "Santander", "Itaú", "Caixa"};
    
    //Variável para manipular o banco em questão, apenas.
    static int banco;
    
    //Quantidades de saques
    static int [] qtd_saques = new int [4];
    
    //Quanto cada banco sacou
    static int [] saldo_saques = new int [4];
    
    //Quanto cada banco sacou de cada nota
    static int [][] notas_saques = new int [4][6];
    
    //Ícone
    static final ImageIcon ICONE_BH = new ImageIcon("src/images/favicon.png");
    
    
    /**********/
    /*        */
    /*  Main  */
    /*        */
    /**********/
    public static void main(String[] args){
        
        JOptionPane.showMessageDialog(null, "Bem vindo ao BankHarnik.\n\n"
                                          + "Você será direcionado para o Carregamento de Notas,\n"
                                          + "pois o caixa está vazio por enquanto...", "Caixa Eletrônico", 0, ICONE_BH);
        MenuPrincipal();
        
    }
    
    
    /*********************************/
    /*                               */
    /*  Procedimento: MenuPrincipal  */
    /*                               */
    /*********************************/
    public static void MenuPrincipal(){
        
        int opcao;
        String[] opcoes = {"Carregar notas", "Retirar notas", "Estatística", "Fim"};
        
        //Calculo o saldo total do caixa sempre que entro no menu
        saldo_caixa = 0;
        
        for (int i = 0; i < 6; i++){
            
            saldo_caixa += qtd_notas[i] * VALOR_NOTAS[i];
            saldo_notas[i] = qtd_notas[i] * VALOR_NOTAS[i];
            
        }
        
        if(saldo_caixa == 0){
            
            opcao = 1;
        }else{
            opcao = JOptionPane.showOptionDialog(null, //Frame pai (não usamos)
                                                "Saldo em caixa\nR$" + saldo_caixa + "\n\nSelecione a opção desejada:", //Texto na caixa
                                                "Caixa eletrônico", //Título da caixa
                                                JOptionPane.DEFAULT_OPTION, //Comportamento das opções
                                                JOptionPane.INFORMATION_MESSAGE, //Tipo de mensagem da caixa
                                                ICONE_BH, //ícone
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
                        
            default:    Erro(99);
                        break;
            
        }
        
    }
    
    
    /*********************************/
    /*                               */
    /*  Procedimento: CarregarNotas  */
    /*                               */
    /*********************************/
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
            NOMES_NOTAS[0], N2,
            NOMES_NOTAS[1], N5,
            NOMES_NOTAS[2], N10,
            NOMES_NOTAS[3], N20,
            NOMES_NOTAS[4], N50,
            NOMES_NOTAS[5], N100
        };
        
        JOptionPane.showConfirmDialog(null, dados_carregar, "Carregar notas", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, ICONE_BH);

        qtd_notas[0] += Integer.parseInt(N2.getValue().toString());
        qtd_notas[1] += Integer.parseInt(N5.getValue().toString());
        qtd_notas[2] += Integer.parseInt(N10.getValue().toString());
        qtd_notas[3] += Integer.parseInt(N20.getValue().toString());
        qtd_notas[4] += Integer.parseInt(N50.getValue().toString());
        qtd_notas[5] += Integer.parseInt(N100.getValue().toString());
        
        MenuPrincipal();
    }
    
    
    /********************************/
    /*                              */
    /*  Procedimento: RetirarNotas  */
    /*                              */
    /********************************/
    public static void RetirarNotas(){
        
        //Neste procedimento seleciono o banco, apenas.
        banco = JOptionPane.showOptionDialog(null,
                                                "\nSelecione seu banco:",
                                                "Saque",
                                                JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.INFORMATION_MESSAGE,
                                                ICONE_BH, //ícone
                                                NOMES_BANCOS,
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
                        
            default:    Erro(98);
                        break;
            
        }

    }
        
        /*  Procedimento: Saque */ //CONTINUA AQUI, NAS OPÇÕES DE SAQUE
        public static void Saque(int banco){
            
            /* 
            Este procedimento recebe o valor do saque que o usuário deseja e
            verifica possíveis erros para a realização de algum saque possível.
            Caso tudo ocorra bem, exibe as opções ao usuário calculadas por duas funções.
            Selecionada uma opção, o programa seguirá para a função RegistraSaque com o
            vetor retornado da função OpcaoSaque"X".
            */
            
            //Vetor que carregará o texto das opções de saque.
            String [] opcoes_saque_t = {"",""};
            
            //Modelo de números do Spinner
            SpinnerNumberModel model_saque = new SpinnerNumberModel(0, 0, saldo_caixa, 1);
            
            //Variável do JSpinner
            JSpinner valor_saque = new JSpinner(model_saque);
            
            //Objeto "array" que receber variáveis de diversos tipos
            Object[] dados_saque = {"Digite o valor\ndo saque:\n", valor_saque};
            
            //Janela com caixa de diálogo que recebe o Objeto para compor o conteúdo.
            JOptionPane.showConfirmDialog(null, dados_saque, NOMES_BANCOS[banco] + " - Saque", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, ICONE_BH);
            
            //Inicio a variável saque, que recebe o conteúdo do Spinner, convertido em inteiro.
            int saque = Integer.parseInt(valor_saque.getValue().toString());
            
            //Verificação de possíveis erros de saque
            //Erro: saque > saldo do caixa
            if(saque > saldo_caixa){
                
                Erro(0);
            
            //Erro: saque = R$1
            }else if(saque == 1){
                
                Erro(1);
                
            //Erro: saque = R$3
            }else if(saque == 0){
                
                Erro(6);
                
            //Erro: saque = R$3
            }else if(saque == 3){
                
                Erro(2);
                
            //Erro: Saque valor ímpar e não há nota de R$5 no caixa
            }else if(saque % 2 != 0 && qtd_notas[1] == 0){
                
                Erro(3);
            
            //Saque que depende de nota de 2 e não tem
            }else if((saque % 10 > saldo_notas[0] && saque % 2 == 0) || (saque % 5 > saldo_notas[0] && saque % 2 != 0)){
                
                Erro(4);
            }else if(saques_registrados >= 100){
                
                Erro(66);            
            //Se estivermos livres dos erros...
            }else{
                
                //Iniciei variáveis para receber as opções de saque
                int [] opcao_saque1;
                int [] opcao_saque2;
                
                
                if((Arrays.equals(OpcaoSaque1(saque),null) && Arrays.equals(OpcaoSaque2(saque),null))){
                    
                    Erro(5);
                    
                //Apenas uma opção de saque: segunda opção nula, ou as duas opções são iguais
                }else if((OpcaoSaque1(saque) != null && Arrays.equals(OpcaoSaque2(saque),null)) || Arrays.equals(OpcaoSaque1(saque),OpcaoSaque2(saque))){
                    
                    opcao_saque1 = OpcaoSaque1(saque);
                    
                    for(int i = 0; i < 6; i++){

                        if(opcao_saque1[i] != 0){

                            opcoes_saque_t[0] += opcao_saque1[i] + "x R$" + VALOR_NOTAS[i] + "   ";

                        }

                    }
                    
                    JOptionPane.showMessageDialog(null, "Saque: " + saque
                                                      + "\nHá apenas uma opção de saque:\n"
                                                      + opcoes_saque_t[0],
                                                      NOMES_BANCOS[banco] + " - Saque", 0, ICONE_BH);
                    
                    RegistraSaque(opcao_saque1, banco, saque);

                //Apenas uma opção de saque: primeira opção nula   
                }else if((Arrays.equals(OpcaoSaque1(saque),null) && OpcaoSaque2(saque) != null)){
                    
                    opcao_saque1 = OpcaoSaque2(saque);
                    
                    for(int i = 0; i < 6; i++){

                        if(opcao_saque1[i] != 0){

                            opcoes_saque_t[0] += opcao_saque1[i] + "x R$" + VALOR_NOTAS[i] + "   ";

                        }
                        
                        JOptionPane.showMessageDialog(null, "Saque: " + saque
                                                      + "\nHá apenas uma opção de saque:\n"
                                                      + opcoes_saque_t[0],
                                                      NOMES_BANCOS[banco] + " - Saque", 0, ICONE_BH);

                    }
                    
                    RegistraSaque(opcao_saque1, banco, saque);

                
                //Duas opções válidas e diferentes
                }else{
                    
                    opcao_saque1 = OpcaoSaque1(saque);
                    opcao_saque2 = OpcaoSaque2(saque);
                    
                    //Construo o texto dos botões
                    for(int i = 0; i < 6; i++){

                        if(opcao_saque1[i] != 0){

                            opcoes_saque_t[0] += opcao_saque1[i] + "x R$" + VALOR_NOTAS[i] + "   ";

                        }

                        if(opcao_saque2[i] != 0){

                            opcoes_saque_t[1] += opcao_saque2[i] + "x R$" + VALOR_NOTAS[i] + "   ";

                        }

                    }
                    
                    //Falo para o usuário escolher a opção
                    //Exibição das opções para o usuário confirmar o saque
                    int opcao_saque = JOptionPane.showOptionDialog(null,
                                                    "Saque: \nR$" + saque + "\n\nSelecione como deseja receber as notas:",
                                                    NOMES_BANCOS[banco] + " - Saque",
                                                    JOptionPane.DEFAULT_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE,
                                                    ICONE_BH,
                                                    opcoes_saque_t,
                                                    null);

                    switch(opcao_saque){

                        case 0:     RegistraSaque(OpcaoSaque1(saque), banco, saque);
                                    break;

                        case 1:     RegistraSaque(OpcaoSaque2(saque), banco, saque);
                                    break;

                        default:    Erro(97);
                                    break;

                    }
                }
                
            }

        }
    
        /*  Função: Opção de Saque 1 */
        public static int [] OpcaoSaque1(int s){

            int [] S = new int [6];

            /*
                Primeiro passo: Arredondamento das Unidades
            
                Caso o valor esteja quebrado na casa das unidades, precisamos
                arredondar os 2 e 5 para que passemos a trabalhar com as dezenas.
            */

            //Caso o resto da divisão por 10 dê 1, 2, 3, 4, 5, 6, 7, 8 ou 9,
            //distribuo as notas de 2 e 5.
            switch (s % 10) {
                case 2:
                    S[0]++;
                    break;
                case 4:
                    S[0] += 2;
                    break;
                case 6:
                    S[0] += 3;
                    break;
                case 8:
                    S[0] += 4;
                    break;
                case 5:
                    S[1]++;
                    break;
                case 7:
                    S[0]++;
                    S[1]++;
                    break;
                case 9:
                    S[0] += 2;
                    S[1]++;
                    break;
                case 1:
                    S[0] += 3;
                    S[1]++;
                    break;
                case 3:
                    S[0] += 4;
                    S[1]++;
                    break;
                default:
                    break;
            }
            
            //Subtraio o valor do arredondamento usado com as notas de 2 e 5.
            s -= (S[0] * VALOR_NOTAS[0]) + (S[1] * VALOR_NOTAS[1]);
            
            
            /*  
                Segundo passo: dividir o saque a partir da nota mais alta até as notas de 10
            
            */
            for(int i = 5; i >= 2; i--){
                
                //Se tiver daquela nota no caixa
                if(qtd_notas[i] > 0 && s > VALOR_NOTAS[i]){
                    
                    //Se o saldo em caixa da nota em caixa for menor que o valor do saque...
                    if(saldo_notas[i] < s){
                        
                        //...adiciono as notas que estão em caixa.
                        S[i] =+ qtd_notas[i];
                    
                    //Se for maior...
                    }else{
                        
                        //...divido o saque pelo valor da nota e obtenho a quantidade.
                        S[i] =+ s / VALOR_NOTAS[i];
                        
                    }
                    
                    //Subtraio o valor das notas incluidas no saque
                    s -= S[i] * VALOR_NOTAS[i];
                    
                }

            }
            
            
            /*  
                Terceiro passo: ainda pode haver resto no saque, aí existem algumas saídas...
            */
            
            //Se ainda houver valor no saque...
            if(s != 0){
                
                //Verifico se as notas de 5 podem zerar o saque
                if((qtd_notas[1] - S[1]) * VALOR_NOTAS[1] >= s){
                    
                    S[1] += s / VALOR_NOTAS[1];
                    
                //Se não, verifico se as notas de 2 podem zerar o saque   
                }else if((qtd_notas[0] - S[0]) * VALOR_NOTAS[0] >= s){
                    
                    S[0] += s / VALOR_NOTAS[0];
                
                //Se não, devolvo as notas de 10, 20 e 50, zero os índices no vetor de saque e...
                }else{
                
                    s += (S[2] * VALOR_NOTAS[2]) + (S[3] * VALOR_NOTAS[3]) + (S[4] * VALOR_NOTAS[4]);
                    S[2] = 0;
                    S[3] = 0;
                    S[4] = 0;

                    //...refaço o looping começando pelas notas de 10 até as de 50.
                    for(int i = 2; i < 5; i++){

                        //Se tiver daquela nota no caixa
                        if(qtd_notas[i] > 0){

                            //Se o saldo em caixa da nota em caixa for menor que o valor do saque...
                            if(saldo_notas[i] < s){

                                //...adiciono as notas que estão em caixa.
                                S[i] =+ qtd_notas[i];

                            //Se for maior...
                            }else{

                                //...divido o saque pelo valor da nota e obtenho a quantidade.
                                S[i] =+ s / VALOR_NOTAS[i];

                            }

                            //Subtraio o valor das notas incluidas no saque
                            s -= S[i] * VALOR_NOTAS[i];

                        }

                    }
                    
                    //Se ainda assim sobrar resto, tento mais uma vez dividir por 2 e 5.
                    if(s != 0){
                
                        //Verifico se as notas de 5 podem zerar o saque
                        if((qtd_notas[1] - S[1]) * VALOR_NOTAS[1] >= s){

                            S[1] += s / VALOR_NOTAS[1];

                        //Se não, verifico se as notas de 2 podem zerar o saque   
                        }else if((qtd_notas[0] - S[0]) * VALOR_NOTAS[0] >= s){

                            S[0] += s / VALOR_NOTAS[0];
                            
                        //Se não der certo, esta opção de saque retornará vazia
                        }else{
                            
                            S = null;
                            
                        }
                    
                    }
                    
                }
                
            }

            return S;
        }

        /*  Função: Opção de Saque 2 */ //CÓPIA BARATA DA OPÇÃO 1
        public static int [] OpcaoSaque2(int s){

            int [] S = new int [6];
            
            /*  
                Nesta segunda opção de saque, apenas alterei a ordem.
                Começo pelas notas mais baixas no looping.
            */

            /*
                Primeiro passo: Arredondamento das Unidades
            
            */

            //Caso o resto da divisão por 10 dê 1, 2, 3, 4, 5, 6, 7, 8 ou 9,
            //distribuo as notas de 2 e 5.
            switch (s % 10) {
                case 2:
                    S[0]++;
                    break;
                case 4:
                    S[0] += 2;
                    break;
                case 6:
                    S[0] += 3;
                    break;
                case 8:
                    S[0] += 4;
                    break;
                case 5:
                    S[1]++;
                    break;
                case 7:
                    S[0]++;
                    S[1]++;
                    break;
                case 9:
                    S[0] += 2;
                    S[1]++;
                    break;
                case 1:
                    S[0] += 3;
                    S[1]++;
                    break;
                case 3:
                    S[0] += 4;
                    S[1]++;
                    break;
                default:
                    break;
            }
            
            //Subtraio o valor do arredondamento usado com as notas de 2 e 5.
            s -= (S[0] * VALOR_NOTAS[0]) + (S[1] * VALOR_NOTAS[1]);
            
            
            /*  
                Segundo passo
            
            */
            
            
            
            while(s > 0){
                
                int n = 0;
                
                for(int i = 5; i >= 0; i--){
                    
                    //Precisa ter da nota e o saque deve ser maior que o valor da nota
                    if(qtd_notas[i] > 0 && s > VALOR_NOTAS[i]){
                        
                        //se há mais nota no caixa do que o saque pede
                        //vou utilizar n para não substituir as notas de 2 e 5 já colocadas
                        if(qtd_notas[i] > S[i]){
                            
                            n += s / VALOR_NOTAS[i];
                            
                        //se há menos nota..    
                        }else{
                            
                            
                            n += qtd_notas[i];
                            
                        }
                        
                        s -= n * VALOR_NOTAS[i];
                        S[i] += n;
                        
                        n = 0;
                    }
                    
                    //se cairmos numa situação de que a nota do looping é maior que o saque
                    if(s < VALOR_NOTAS[i] && i < 5 && S[i + 1] > 0 && s > 0){
                        
                        S[i + 1]--;
                        s += VALOR_NOTAS[i + 1];
                        
                        i++;
                        
                    }
                    
                    
                }
                
            }
            

            return S;
        }

        /*  Procedimento: Registra o Saque */
        public static void RegistraSaque(int saque[], int banco, int s){
            
            for(int i = 0; i < 6; i++){
                
                //tiro as notas do caixa
                qtd_notas[i] -= saque[i];
                //adiciono as notas à matriz de notas do banco
                notas_saques[banco][i] += saque[i];
                
            }
            
            saldo_saques[banco] += s;
            qtd_saques[banco]++;
            total_sacado += s;
            saques_registrados++;
            
            MenuPrincipal();

        }
    
    
    /*******************************/
    /*                             */
    /*  Procedimento: Estatística  */
    /*                             */
    /*******************************/
    public static void Estatistica(){
        
        String stats = "Estatísticas do caixa eletrônico\n";
        
        
        for(int i = 0; i < 4; i++){
            
            stats += NOMES_BANCOS[i]
                    + "\nQuantidade de saques: " + qtd_saques[i]
                    + "\nSacado neste banco: R$" + saldo_saques[i] + "\nQuantidade de cada nota sacada por este banco:\n";
            
                    for(int j = 0; j < 6; j++){
                        
                        stats += notas_saques[i][j] + "x " + NOMES_NOTAS[j] + "   ";
                        
                    }
                    
            stats += "\n\n";

        }
        
        stats += "\n\n\nTotal sacado: R$" + total_sacado + "\nSaques registrados: " + saques_registrados + "\n\nO saldo do caixa é R$" + saldo_caixa + " com:\n";
        
        for(int i = 0; i < 6; i++){
            
            stats += qtd_notas[i] + " notas de " + NOMES_NOTAS[i] + "\n";
            
        }
        
        JOptionPane.showMessageDialog(null, stats, "Estatística", 0, ICONE_BH);
                
        MenuPrincipal();
        
    }
    
    
    /************************/
    /*                      */
    /*  Procedimento: Erro  */
    /*                      */
    /************************/
    public static void Erro(int x){
        
        switch(x){
            
            //Erros de saque
            //Erro 0: Saque maior que o saldo em caixa
            case 0: JOptionPane.showMessageDialog(null, "Erro!\n"
                                                      + "Saldo insuficiente para o saque desejado.\n"
                                                      + "Por favor, volte e refaça a operação.",
                                                      "Saldo insuficiente", 0, ICONE_BH);
                    Saque(banco);
                    break;
            
            //Erro 1: Saque de R$1
            case 1: JOptionPane.showMessageDialog(null, "Erro!\nInfelizmente não há mais nota de R$1,00 nos bancos.\n"
                                                      + "Eu tenho na minha carteira, você tem?\n"
                                                      + "Por favor, volte e refaça a operação.",
                                                      "Erro do R$1", 0, ICONE_BH);
                    Saque(banco);
                    break;
                    
            //Erro 2: Saque de R$3
            case 2: JOptionPane.showMessageDialog(null, "Erro!\nInfelizmente não há mais nota de R$1,00 nos bancos e,\n"
                                                      + "por esse motivo, não é possível sacar R$3.\n"
                                                      + "Por favor, volte e refaça a operação.",
                                                      "Erro dos R$3", 0, ICONE_BH);
                    Saque(banco);
                    break;
                    
            //Erro 3: sem notas de R$5 no caixa, não é possível sacar valor ímpar.
            case 3: JOptionPane.showMessageDialog(null, "Não é poséivel sacar este valor.\n"
                                                      + "Não há notas de R$5 no caixa,\nportando não é possível sacar valor ímpar.",
                                                      "Erro da falta de R$5 e saque ímpar", 0, ICONE_BH);
                    Saque(banco);
                    break;
                    
            //Erro 4: sem notas de 2 para realizar o saque desejado.
            case 4: JOptionPane.showMessageDialog(null, "Não é poséivel sacar este valor.\n"
                                                      + "Não há notas de R$2 no caixa suficientes para sacar o valor desejado.",
                                                      "Erro", 0, ICONE_BH);
                    Saque(banco);
                    break;
                    
            //Erro 5: Erro do "comi bola"
            case 5: JOptionPane.showMessageDialog(null, "Vacilo do programador...\n"
                                                      + "Se algo de errado ocorreu, foi porque as duas opções de saque retornaram nulas..."
                                                      + "\nUm pouco improvável.. Voltando para o saque...",
                                                      "Comi bola", 0, ICONE_BH);
                    Saque(banco);
                    break;
                    
            //Erro 6: Saque = 0
            case 6: JOptionPane.showMessageDialog(null, "O saque não pode ser 0\n"
                                                      + "\nPor favor refaça.",
                                                      "Saque 0?", 0, ICONE_BH);
                    Saque(banco);
                    break;
                    
                    
            
            //Erro 66: Chegou ao centézimo saque
            case 66: JOptionPane.showMessageDialog(null, "Você chegou ao centézimo saque."
                                                      + "Acabou... Encerre o programa se quiser sacar mais.",
                                                      "Chega de saque!", 0, ICONE_BH);
                    MenuPrincipal();
                    break;
            
                    
            //Erros provocados pelo usuário
            //Erro 99: opção inválida no menu principal, caso o usuário clique no "X".
            case 99: JOptionPane.showMessageDialog(null, "Não clique no X.\n"
                                                       + "Por favor, selecione uma das opções exibidas nos botões.",
                                                       "Por que você clicou no X?!", 0, ICONE_BH);
                    MenuPrincipal();
                    break;
                    
            //Erro 98: opção inválida na seleção de banco, caso o usuário clique no "X".
            case 98: JOptionPane.showMessageDialog(null, "Não clique no X.\n"
                                                       + "Por favor, selecione um dos bancos para prosseguir com o saque.",
                                                       "Por que você clicou no X?!", 0, ICONE_BH);
                    RetirarNotas();
                    break;
                    
            //Erro 97: usuário clicou no X na hora de sacar...
            case 97: JOptionPane.showMessageDialog(null, "Não clique no X.\n"
                                                       + "Você deveria ter clicado em alguma opção de saque.\n"
                                                       + "Refaça a operação.",
                                                       "Por que você clicou no X?!", 0, ICONE_BH);
                    Saque(banco);
                    break;
        }
        
    }
    
    
    /***********************/
    /*                     */
    /*  Procedimento: Fim  */
    /*                     */
    /***********************/
    public static void Fim(){
        
        JOptionPane.showMessageDialog(null, "Obrigado por rodar este algoritmo...\n"
                                                       + "Deu um trabalhão!\n",
                                                       "Bruno Harnik", 0, ICONE_BH);
        
    }
    
}
