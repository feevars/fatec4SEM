package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Evento;

public class BuffersArquivo {

	private JFileChooser escolhedorDeArquivos;
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Somente documentos .TXT", "txt");
	private String caminho;

	public void escreveArquivo(Evento evento) throws IOException {

		escolhedorDeArquivos = new JFileChooser();
		escolhedorDeArquivos.setCurrentDirectory(
				new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
		escolhedorDeArquivos.setDialogTitle("Titulo");
		escolhedorDeArquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
		escolhedorDeArquivos.setFileFilter(filtro);
		escolhedorDeArquivos.setAcceptAllFileFilterUsed(false);

		if (escolhedorDeArquivos.showOpenDialog(escolhedorDeArquivos) == JFileChooser.APPROVE_OPTION) {
			this.caminho = escolhedorDeArquivos.getSelectedFile().getAbsolutePath();
			if (!caminho.substring(caminho.lastIndexOf(".") + 1).equals("txt")) caminho += ".txt";
			evento.setCaminhoDoArquivo(caminho);

			BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
			bw.write("Arquivo do SGE - Sistema de Gerenciamento de Eventos");
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
			bw.write("=====================================================");
			bw.newLine();
			bw.write(evento.getListaConvidados().listaString());
			bw.newLine();
			bw.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado para a gravação.");
		}

	}

}
