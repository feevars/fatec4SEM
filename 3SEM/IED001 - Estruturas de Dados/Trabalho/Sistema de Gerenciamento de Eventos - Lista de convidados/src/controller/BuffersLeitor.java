package controller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Convidado;
import model.Evento;

import java.io.BufferedReader;

public class BuffersLeitor {

	public Evento leitor(File arquivo) {

		ListaConvidados lista = new ListaConvidados();

		try {
			FileReader leitor = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(leitor);
			String linha = lerArq.readLine();

			while(linha != null) {
				//Pula o cabeçalho do arquivo
				if(linha.contains("SGE")) {
					linha=lerArq.readLine();
				}

				//Obtem dados do evento
				String nomeEvento = null;
				Date dataEvento = null;
				int qtdConvites = 0; 
				Date dataLote1 = null;
				int qtdLote1 = 0;
				double valorLote1 = 0;
				Date dataLote2 = null;
				int qtdLote2 = 0;
				double valorLote2 = 0;
				Date dataLote3 = null;
				int qtdLote3 = 0;
				double valorLote3 = 0;
				double valorPortaria = 0;
				int descontoAniversariante= 0;
				ListaConvidados listaConvidados = null;
				String caminhoDoArquivo = null;

				while(!linha.contains("===")) {

					linha = lerArq.readLine();
					nomeEvento = linha;

					linha = lerArq.readLine();
					SimpleDateFormat fDataEvento = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
					dataEvento = fDataEvento.parse(linha);

					linha = lerArq.readLine();
					qtdConvites = Integer.parseInt(linha);

					linha = lerArq.readLine();
					SimpleDateFormat fDataLoteI = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
					dataLote1 = fDataLoteI.parse(linha);

					linha = lerArq.readLine();
					qtdLote1 = Integer.parseInt(linha);

					linha = lerArq.readLine();
					valorLote1 = Double.parseDouble(linha);

					linha = lerArq.readLine();
					SimpleDateFormat fDataLote2 = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
					dataLote2 = fDataLote2.parse(linha);

					linha = lerArq.readLine();
					qtdLote2 = Integer.parseInt(linha);

					linha = lerArq.readLine();
					valorLote2 = Double.parseDouble(linha);

					linha = lerArq.readLine();
					SimpleDateFormat fDataLote3 = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
					dataLote3 = fDataLote3.parse(linha);

					linha = lerArq.readLine();
					qtdLote3 = Integer.parseInt(linha);

					linha = lerArq.readLine();
					valorLote3 = Double.parseDouble(linha); 

					linha = lerArq.readLine();
					valorPortaria = Double.parseDouble(linha);

					linha = lerArq.readLine();
					descontoAniversariante = Integer.parseInt(linha);

					linha = lerArq.readLine();
					listaConvidados = null;

					linha = lerArq.readLine();
					caminhoDoArquivo = linha;
				}
				Evento evento = new Evento(nomeEvento, dataEvento, qtdConvites, dataLote1, 
						qtdLote1, valorLote1, dataLote2, qtdLote2, valorLote2, dataLote3, 
						qtdLote3, valorLote3, valorPortaria, descontoAniversariante, 
						listaConvidados, caminhoDoArquivo);

				//Obtém dados do participante
				while(linha != null){

					linha = lerArq.readLine();
					int id = Integer.parseInt(linha);

					linha = lerArq.readLine();
					String nomeConv = linha;

					linha = lerArq.readLine();
					String sobreNome = linha;

					linha = lerArq.readLine();
					String email = linha;

					linha = lerArq.readLine();
					String telefone = linha;

					linha = lerArq.readLine();
					SimpleDateFormat formato = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
					Date nascimento = formato.parse(linha);

					linha = lerArq.readLine();
					String tipoDocumento = linha;

					linha = lerArq.readLine();
					String numDocumento = linha;

					linha = lerArq.readLine();
					boolean acessibilidade = false;
					if(linha.contains("true")) {
						acessibilidade = true;
					}
					if(linha.contains("false")) {
						acessibilidade = false;
					}

					linha = lerArq.readLine();
					boolean vip = false;
					if(linha.contains("true")) {
						vip = true;
					}
					if(linha.contains("false")) {
						vip = false;
					}

					linha = lerArq.readLine();
					int lote = Integer.parseInt(linha);	

					Convidado convidado = new Convidado(id, nomeConv, sobreNome, email, 
							telefone, nascimento, tipoDocumento, numDocumento, 
							acessibilidade, vip, lote);

					//Inserindo convidado na lista
					lista.insereUltimo(convidado);
				}

				//Inserindo a lista no evento
				evento.setListaConvidados(lista);
				return evento;
			}

			lerArq.close(); //Fechando BufferederReader
			leitor.close(); //Fechando FileReader

		}
		catch(IOException ex) {
			//Tratamento de Excessões
			System.out.println("Erro na leitura!");
			ex.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Erro de conversão de data");
			e.printStackTrace();
		}

		return null;

	}

}
