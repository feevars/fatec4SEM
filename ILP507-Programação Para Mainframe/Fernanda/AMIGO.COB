******************************************************************
      * Author: FERNANDA PINHEIRO REIS
      * Date: 06/03/2020
      * Purpose: ACADEMICS
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. AMIGO.
       DATA DIVISION.
       FILE SECTION.
       FD REGAMIGO
               LABEL RECORD IS STANDARD
               VALUE OF FILE-ID IS "REGAMIGO.DAT".
       01 REGAMIGO.
                03 APELIDO         PIC X(12).
                03 NOME            PIC X(30).
                03 EMAIL           PIC X(30).
       WORKING-STORAGE SECTION.
       77 WS-MENUOPCAO     PIC 9

       01 TABAMIGO.
          03 FILLER PIC X(30) VALUE "NOME".
          03 FILLER PIC X(30) VALUE "APELIDO".
          03 FILLER PIC X(30) VALUE "EMAIL".

       SCREEN SECTION.
       01 TELAAMIGO.
           DISPLAY "PROGRAMA DO AMIGO"
            DISPLAY "ESCOLHA: "
            DISPLAY "1 - EXIBIR LISTA"
            DISPLAY "2 - CADASTRAR AMIGO"
            DISPLAY "0 - FINALIZAR PROGRAMA"
            DISPLAY ""
       
       PROCEDURE DIVISION.
       000-MAIN.
            DISPLAY 0101 VALUE TELAAMIGO.
            ACCEPT WS-MENUOPCAO.
            EVALUATE WS-MENUOPCAO
                WHEN 1
                   PERFORM 100-LER.
                WHEN 2
                   PERFORM 200-GRAVAR.
                WHEN 0 
                   DISPLAY "ENCERRANDO..."
                WHEN OTHER
                   DISPLAY "OPCAO INVALIDA"
                   PERFORM 000-MAIN.
            END-EVALUATE
            
           
       100-LER.
           DISPLAY "LENDO ESSA PORRA"
           PERFORM 000-MAIN.
       200-GRAVAR.
           DISPLAY "GRAVANDO NESTE CARALHO"
           PERFORM 000-MAIN.
       STOP RUN.
       END PROGRAM AMIGO.

