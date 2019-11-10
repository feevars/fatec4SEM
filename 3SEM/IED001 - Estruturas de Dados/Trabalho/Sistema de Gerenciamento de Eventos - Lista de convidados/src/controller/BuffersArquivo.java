package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Evento;

public class BuffersArquivo {

	private JFileChooser escolhedorDeArquivos;
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Somente documentos de texto (.txt)", "txt");
	private String caminho;

	public void escreveArquivo(Evento evento) throws IOException {

		escolhedorDeArquivos = new JFileChooser();
		escolhedorDeArquivos.setCurrentDirectory(
				new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
		escolhedorDeArquivos.setDialogTitle("Salvar evento...");
		escolhedorDeArquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
		escolhedorDeArquivos.setFileFilter(filtro);
		escolhedorDeArquivos.setApproveButtonText("Salvar");
		escolhedorDeArquivos.setAcceptAllFileFilterUsed(false);

		if (escolhedorDeArquivos.showOpenDialog(escolhedorDeArquivos) == JFileChooser.APPROVE_OPTION) {
			this.caminho = escolhedorDeArquivos.getSelectedFile().getAbsolutePath();
			if (!caminho.substring(caminho.lastIndexOf(".") + 1).equals("txt"))
				caminho += ".txt";
			evento.setCaminhoDoArquivo(caminho);

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
			bw.write(evento.getCaminhoDoArquivo());
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
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado para a gravação.");
		}
	}

	public Evento abreArquivo(String caminho) throws IOException, ParseException {

		String verificacao;
		
		String nome;
		Date dataEvento;
		int qtdConvites;
		Date dataLote1;
		int qtdLote1;
		double valorLote1;
		Date dataLote2;
		int qtdLote2;
		double valorLote2;
		Date dataLote3;
		int qtdLote3;
		double valorLote3;
		double valorPortaria;
		int descontoAniversariante;
		ListaConvidados listaConvidados;
		String caminhoDoArquivo;
		
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		
		verificacao = br.readLine();
		nome = br.readLine();
		dataEvento = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ROOT).parse(br.readLine());
		qtdConvites = Integer.parseInt(br.readLine());
		descontoAniversariante = Integer.parseInt(br.readLine());
		caminhoDoArquivo = br.readLine();
		//valorPortaria = Double.valueOf(br.readLine());
		//System.out.println(valorPortaria);
		
		
		
		br.close();

		return null;
	}
}