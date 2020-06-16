       IDENTIFICATION DIVISION.
       PROGRAM-ID. ENDERECO.
       AUTHOR. LUIZ FERNANDO GERALDO DOS SANTOS.

       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
           DECIMAL-POINT IS COMMA.

       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT ARQUIVOENDERECO ASSIGN TO DISK
           ORGANIZATION            IS INDEXED
           ACCESS MODE             IS DYNAMIC
           RECORD KEY              IS ID-ENDERECO
           FILE STATUS             IS WS-STATUS-ARQUIVO
           ALTERNATE RECORD KEY    IS CEP.

       DATA DIVISION.
       FILE SECTION.
       FD  ARQUIVOENDERECO
           LABEL RECORDS ARE STANDARD
           VALUE OF FILE-ID IS "CADEND.DAT".
       
       01 ENDERECO.
           05 ID-ENDERECO      PIC X(04).
           05 CEP              PIC X(08).
           05 LOGRA            PIC X(35).
           05 BAIRRO           PIC X(20).
           05 CIDADE           PIC X(35).
           05 UF               PIC X(02).

      *---------------------- VARIAVEIS DE TRABALHO --------------------
       WORKING-STORAGE SECTION.
       77 WS-STATUS-ARQUIVO            PIC X(02).
       77 WS-MSG                       PIC X(60).
       77 WS-OPCAO                     PIC X.

       01 TABELA-ESTADOS.
           03   FILLER PIC X(20) VALUE "SP-SAO PAULO".
           03   FILLER PIC X(20) VALUE "RJ-RIO DE JANEIRO".
           03   FILLER PIC X(20) VALUE "PR-PARANA".
           03   FILLER PIC X(20) VALUE "RS-RIO GRANDE DO SUL".
           03   FILLER PIC X(20) VALUE "SC-SANTA CATARINA".
           03   FILLER PIC X(20) VALUE "MG-MINAS GERAIS".
           03   FILLER PIC X(20) VALUE "MT-MATO GROSSO".

    
       01 FILLER REDEFINES TABELA-ESTADOS.
           03 ESTADO PIC X(20) OCCURS 07 . 

      * ---------------------  TELAS DO SISTEMA ------------------------

       SCREEN SECTION.
       01 TELA-MENU.
           05 BLANK SCREEN BACKGROUND-COLOR 02 FOREGROUND-COLOR 15.
           05 VALUE "SISTEMA DE CADASTRO DE ENDERECOS" 
               FOREGROUND-COLOR 14 LINE 01 COLUMN 30.
           05 VALUE "C - CADASTRAR ENDERECOS" FOREGROUND-COLOR 14 
               LINE 05 COLUMN 10.
           05 VALUE "L - LISTAR ENDERECOS" FOREGROUND-COLOR 14 
               LINE 06 COLUMN 10.
           05 VALUE "S - SAIR" FOREGROUND-COLOR 14 LINE 07 COLUMN 10.
           05 OPCAO PIC X USING WS-OPCAO LINE 09 COLUMN 10.
       
       01 TELA-MENSAGEM.
           05 BLANK SCREEN BACKGROUND-COLOR 02 FOREGROUND-COLOR 15.
           05 PIC X(60) FROM WS-MSG              LINE 15 COLUMN 10.
           05 PIC X(02) FROM WS-STATUS-ARQUIVO   LINE 17 COLUMN 10.
       
       01 TELA-CADASTRO.
           05 BLANK SCREEN BACKGROUND-COLOR 02 FOREGROUND-COLOR 15.
           05 VALUE "NOVO " FOREGROUND-COLOR 14 LINE 02 COLUMN 30.
            
            05 VALUE "ID:" FOREGROUND-COLOR 14 LINE 05 COLUMN 05.
            05 NOVO-ID PIC X(04) USING ID-ENDERECO LINE 05 COLUMN 09.
            
            05 VALUE "CEP:" FOREGROUND-COLOR 14 LINE 06 COLUMN 05.
            05 NOVO-CEP PIC X(08) USING CEP LINE 06 COLUMN 10.

            05 VALUE "ENDERECO:" FOREGROUND-COLOR 14 LINE 07 COLUMN 05.
            05 NOVO-ENDERECO PIC X(35) USING LOGRA LINE 07 COLUMN 17.

            05 VALUE "BAIRRO:" FOREGROUND-COLOR 14 LINE 08 COLUMN 05.
            05 NOVO-BAIRRO PIC X(20) USING BAIRRO LINE 08 COLUMN 15.

            05 VALUE "CIDADE:" FOREGROUND-COLOR 14 LINE 09 COLUMN 05.
            05 NOVA-CIDADE PIC X(35) USING CIDADE LINE 09 COLUMN 14.

            05 VALUE "UF:" FOREGROUND-COLOR 14 LINE 10 COLUMN 05.
            05 NOVA-UF PIC X(02) USING UF LINE 10 COLUMN 10.
      *--------------------- BLOCOS DE EXECUÇÃO ------------------------
       PROCEDURE DIVISION.

       P-ABERTURA-ARQUIVO.
           OPEN I-O ARQUIVOENDERECO
           IF WS-STATUS-ARQUIVO NOT = "00"
               IF WS-STATUS-ARQUIVO = "30"
                   OPEN OUTPUT ARQUIVOENDERECO
                   MOVE "CRIANDO ARQUIVO DE MARGEM..." TO WS-MSG
                   CLOSE ARQUIVOENDERECO
                   PERFORM P-MSG-FINAL THRU P-FIM   
                   GO TO P-ABERTURA-ARQUIVO
               ELSE
                   GO TO P-MSG-FINAL.

       P-INICIAL.

           MOVE ZEROS TO ID-ENDERECO CEP
           MOVE SPACES TO ENDERECO BAIRRO CIDADE UF WS-OPCAO WS-MSG

           DISPLAY TELA-MENU
           ACCEPT WS-OPCAO.

           IF WS-OPCAO = "C"
              GO TO P-NOVO-ID
           ELSE IF WS-OPCAO = "L"
              GO TO P-LISTAR
           ELSE IF WS-OPCAO = "S"
               GO TO P-FIM
           ELSE 
               MOVE "OPCAO INVALIDA" TO WS-MSG 
               DISPLAY TELA-MENSAGEM.

      *------ CADASTRO DOS CAMPOS --------------------------------------
       P-NOVO-ID.
           DISPLAY TELA-CADASTRO
           ACCEPT NOVO-ID
           GO TO P-NOVO-CEP.
              
       P-NOVO-CEP.
           DISPLAY TELA-CADASTRO
           ACCEPT NOVO-CEP
           GO TO P-NOVO-ENDERECO.

       P-NOVO-ENDERECO.
           DISPLAY TELA-CADASTRO
           ACCEPT NOVO-ENDERECO
           GO TO P-NOVO-BAIRRO.

       P-NOVO-BAIRRO.
           DISPLAY TELA-CADASTRO
           ACCEPT NOVO-BAIRRO
           GO TO P-NOVA-CIDADE.

       P-NOVA-CIDADE.
           DISPLAY TELA-CADASTRO
           ACCEPT NOVA-CIDADE
           GO TO P-NOVA-UF.

       P-NOVA-UF.
           DISPLAY TELA-CADASTRO
           ACCEPT NOVA-UF
           MOVE "CADASTRO REALIZADO" TO WS-MSG
           GO TO P-GRAVA-ARQUIVO.

      * ----- GRAVACAO EM ARQUIVO --------------------------------------
       
       P-GRAVA-ARQUIVO.

           WRITE ENDERECO
               IF WS-STATUS-ARQUIVO = "00" OR "02"
                   MOVE "DADOS GRAVADOS" TO WS-MSG
                   DISPLAY TELA-MENSAGEM
                   DISPLAY TELA-MENU
               IF WS-STATUS-ARQUIVO = "22"
                   MOVE "ENDERECO JA EXISTE!" TO WS-MSG
                   PERFORM P-MSG-FINAL THRU P-FIM
               ELSE
                   MOVE "ERRO NA GRAVACAO DO ARQUIVO " TO WS-MSG
                   DISPLAY TELA-MENSAGEM
                   GO TO P-FIM.          


       P-LISTAR.

           READ ARQUIVOENDERECO
                IF WS-STATUS-ARQUIVO NOT = "23"
                   IF WS-STATUS-ARQUIVO = "00"

                   MOVE SPACES TO ID-ENDERECO CEP LOGRA BAIRRO
                       CIDADE UF
                   DISPLAY (01, 01) ERASE
                   DISPLAY (12, 01) "ID    : "
                   DISPLAY (14, 01) "CEP   : "
                   DISPLAY (16, 01) "LOGRA : "
                   DISPLAY (18, 01) "BAIRRO: "
                   DISPLAY (20, 01) "CIDADE: "
                   DISPLAY (22, 01) "ESTADO: "
                ELSE
                   MOVE "ERRO AO LER ARQUIVO" TO WS-MSG
                   GO TO P-MSG-FINAL.
      
      * ----- ENCERRAMENTO DO PROGRAMA ---------------------------------
       
       P-MSG-FINAL.
           DISPLAY TELA-MENSAGEM.
       
       P-FIM.
           CLOSE ARQUIVOENDERECO
           EXIT PROGRAM.