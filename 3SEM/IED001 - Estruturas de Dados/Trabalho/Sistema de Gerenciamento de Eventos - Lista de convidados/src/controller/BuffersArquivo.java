package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
			// Formatador de número com vírgula para double
			Number numero;
			NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);

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

			System.out.println(verificacao + "\n" +
							   nome + "\n" +
							   dataEvento + "\n" + 
							   qtdConvites + "\n" +
							   descontoAniversariante + "\n" +
							   valorPortaria + "\n" +
							   valorLote1 + "\n" +
							   qtdLote1 + "\n");

			
			
			
			
			
			ListaConvidados listaConvidados;
			
			
			
			
			br.close();
			
			return null;
		}
	}
}