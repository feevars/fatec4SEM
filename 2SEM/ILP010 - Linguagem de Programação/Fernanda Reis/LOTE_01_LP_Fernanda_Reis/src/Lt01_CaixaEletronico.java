/*
 *************************
Caixa Eletrônico
 
1.   Criar um menu de opções:

      Menu Principal
        1 - Carregar Notas
        2 - Retirar Notas
        3 - Estatística
        9 - Fim

2.   Carregar a quantidade de notas em uma área da memória com 6 ocorrências.

3.   Solicitar que o cliente faça a retirada de valores obedecendo ao critério 
do maior pelo menor.

4.   Dar a opção para o cliente escolher o valor e a quantidade de notas.
     P. ex.: 1 x 20, 2 x 10...

5.   Caso não tenha o valor da maior cédula, disponibilizar a próxima.

6.   Se o valor a ser solicitado for maior que o saldo total do caixa, enviar 
a mensagem "EXCEDEU O LIMITE DO CAIXA".

7.   Solicitar até 100 retiradas ou até não haver mais notas.

8.   No momento da solicitação do valor, coletar também o código do banco que 
o cliente tem conta, segundo:

      Código: [       1       ][      2      ][      3     ][      4      ]
      Banco:  [Banco do Brasil][  Santander  ][    Itaú    ][    Caixa    ]

9.   No final, exibir a estatística, separada por bancos, com:
      9.1 O maior e o menor valor sacado;      
      9.2 A média dos saques;
      9.3 Valor total dos saques;
      9.4 Valor das sobras dos caixas.

 
 Programador: Fernanda Pinheiro Reis
 Professor: Ricardo Satoshi
 ************************* 
 */

import javax.swing.JOptionPane;

public class Lt01_CaixaEletronico {
    
    public static void main(String[] args){
        
        String start = "Selecione a opção desejada:";
        String [] menu_principal = {"Carregar notas", "Retirar notas", "Estatísticas", "Fim"};
        
        int opcaoEscolhida = JOptionPane.showOptionDialog(null, start,
                "             ---CAIXA ELETRÔNICO---",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu_principal, menu_principal[0]);
        
        //de acordo com a resposta do usuário...
        switch (opcaoEscolhida) {
            case 0: //CarregarNotas
                carregaNotas();
                break;
            case 1: //retirarNotas
                retirarNotas();
                break;
            case 2: //estatisticas
                estatisticaBancos ();
                break;
            case 3: //fim
                break;
        }
        //carregaNotas
        
    }
}

static int [] carregaNotas (int nota) {
    String exibir = "NOTAS CARREGADAS: \n";
        int j = 0, i = 0;
        int carrega_notas[][] = new int [6][2]; //primeira coluna só com os valores das notas
        carrega_notas[0][j] = 2;
        carrega_notas[1][j] = 5;
        carrega_notas[2][j] = 10;
        carrega_notas[3][j] = 20;
        carrega_notas[4][j] = 50;
        carrega_notas[5][j] = 100;
        
        //qtddNotas
            for (i = 0; i < 6; i++) {
               carrega_notas[i][1] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de notas de R$ " + carrega_notas[i][j] +",00 que deseja carregar: "));
               exibir += "Notas " +carrega_notas[i][0] +": " +carrega_notas[i][1];
            }
}
