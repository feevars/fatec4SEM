package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import model.Convidado;
import model.Evento;

public class BuffersArquivo {

	public void escreveArquivo(Evento evento, String caminho) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
		bw.write("arquivodosge");
		bw.newLine();
		bw.write(evento.getNome());
		bw.newLine();
		bw.write(evento.getDataEvento().toString());
		bw.newLine();
		bw.write(String.valueOf(evento.getQtdConvites()));
		bw.newLine();
		bw.write(String.valueOf(evento.getDescontoAniversariante()));
		bw.newLine();
		bw.write(String.format("%.2f", evento.getValorPortaria()));
		bw.newLine();
		bw.write(String.format("%.2f", evento.getValorLote1()));
		bw.newLine();
		bw.write(String.valueOf(evento.getQtdLote1()));
		bw.newLine();
		bw.write(evento.getDataLote1().toString());
		bw.newLine();
		bw.write(String.format("%.2f", evento.getValorLote2()));
		bw.newLine();
		bw.write(String.valueOf(evento.getQtdLote2()));
		bw.newLine();
		bw.write(evento.getDataLote2().toString());
		bw.newLine();
		bw.write(String.format("%.2f", evento.getValorLote3()));
		bw.newLine();
		bw.write(String.valueOf(evento.getQtdLote3()));
		bw.newLine();
		bw.write(evento.getDataLote3().toString());
		bw.newLine();
		bw.write(evento.getListaConvidados().listaString());
		bw.newLine();
		bw.close();
		JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
	}

	public Evento abreArquivo(String caminho) throws IOException, ParseException {

		String verificacao;

		BufferedReader br = new BufferedReader(new FileReader(caminho));

		verificacao = br.readLine();
		if (!verificacao.contains("arquivodosge")) {
			JOptionPane.showMessageDialog(null, "Arquivo incompatível com o programa.");
			br.close();
			return null;
		} else {
			// Variáveis do evento
			String nome;
			Date dataEvento;
			int qtdConvites;
			int descontoAniversariante;
			double valorPortaria;
			// Variáveis do Lote 1
			Date dataLote1;
			int qtdLote1;
			double valorLote1;
			// Variáveis do Lote 2
			Date dataLote2;
			int qtdLote2;
			double valorLote2;
			// Variáveis do Lote 3
			Date dataLote3;
			int qtdLote3;
			double valorLote3;

			// Lista Dupla deve ser iniciada em um evento, mesmo que esteja vazia
			ListaConvidados listaConvidados = new ListaConvidados();

			// Formatador de número com vírgula para double
			Number numero;
			NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);

			// Formatador de datas de adição
			SimpleDateFormat adcFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

			// Evento
			nome = br.readLine();
			dataEvento = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ROOT).parse(br.readLine());
			qtdConvites = Integer.parseInt(br.readLine());
			descontoAniversariante = Integer.parseInt(br.readLine());
			numero = nf.parse(br.readLine());
			valorPortaria = numero.doubleValue();
			numero = nf.parse(br.readLine());
			valorLote1 = numero.doubleValue();
			qtdLote1 = Integer.parseInt(br.readLine());
			dataLote1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ROOT).parse(br.readLine());
			numero = nf.parse(br.readLine());
			valorLote2 = numero.doubleValue();
			qtdLote2 = Integer.parseInt(br.readLine());
			dataLote2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ROOT).parse(br.readLine());
			numero = nf.parse(br.readLine());
			valorLote3 = numero.doubleValue();
			qtdLote3 = Integer.parseInt(br.readLine());
			dataLote3 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ROOT).parse(br.readLine());

			Evento novoEvento = new Evento(nome, dataEvento, qtdConvites, dataLote1, qtdLote1, valorLote1, dataLote2,
					qtdLote2, valorLote2, dataLote3, qtdLote3, valorLote3, valorPortaria, descontoAniversariante,
					listaConvidados, caminho);
			// Começa a leitura da lista
			String primeiraLinha = br.readLine();
			if (primeiraLinha.contains("lista")) {
				JOptionPane.showMessageDialog(null, "Foi carregado um evento com lista vazia.");
				
			}
			while (primeiraLinha.contains("convidado")) {
				int id = Integer.parseInt(br.readLine());
				String nomeConvidado = br.readLine();
				String sobrenomeConvidado = br.readLine();
				String email = br.readLine();
				String telefone = br.readLine();
				Date nascimento = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ROOT)
						.parse(br.readLine());
				String tipoDocumento = br.readLine();
				String numDocumento = br.readLine();
				boolean acessibilidade = Boolean.parseBoolean(br.readLine());
				boolean vip = Boolean.parseBoolean(br.readLine());
				int lote = Integer.parseInt(br.readLine());

				Date dataAdicao = adcFormat.parse(br.readLine());
				Timestamp adicao = new Timestamp(dataAdicao.getTime());

				if (id > novoEvento.getListaConvidados().getContaId())
					novoEvento.getListaConvidados().setContaId((id));

				Convidado novoConvidado = new Convidado(id, nomeConvidado, sobrenomeConvidado, email, telefone,
						nascimento, tipoDocumento, numDocumento, acessibilidade, vip, lote);
				novoConvidado.setAdicao(adicao);
				novoEvento.getListaConvidados().inserePrimeiro(novoConvidado);
				primeiraLinha = br.readLine();
			}

			br.close();
			return novoEvento;
		}
	}
}