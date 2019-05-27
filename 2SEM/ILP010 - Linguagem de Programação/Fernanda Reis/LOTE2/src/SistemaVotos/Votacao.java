/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVotos;

/**
 *
 * @author Fernanda
 */
class Votacao {
    int num_secao; 
    int num_candidato;

    Votacao () { //construtor
            this(0, 0);
    }
    Votacao (int numero_secao, int numero_candidato) { //cria variáveis locais para executar
            num_secao = numero_secao;
            num_candidato = numero_candidato;
    }
}

