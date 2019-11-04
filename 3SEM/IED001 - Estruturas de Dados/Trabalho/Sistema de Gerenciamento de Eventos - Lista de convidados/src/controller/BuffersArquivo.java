package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

import model.Evento;

public class BuffersArquivo {
	
	private JFileChooser escolhedorDeArquivos;
	private String caminho = "/Users/bruno/Desktop/escrevedorDaLista.txt";

	public void escreveArquivo(Evento evento) throws IOException {
		
		escolhedorDeArquivos = new JFileChooser();
		escolhedorDeArquivos.setCurrentDirectory(new File("."));
		escolhedorDeArquivos.setDialogTitle("Titulo");
		escolhedorDeArquivos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		escolhedorDeArquivos.setAcceptAllFileFilterUsed(false);
   
	    if (escolhedorDeArquivos.showOpenDialog(escolhedorDeArquivos) == JFileChooser.APPROVE_OPTION) { 
	      System.out.println("getCurrentDirectory(): " 
	         +  escolhedorDeArquivos.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " 
	         +  escolhedorDeArquivos.getSelectedFile());
	      }
	    else {
	      System.out.println("No Selection ");
	      }
	     
	    caminho = escolhedorDeArquivos.getSelectedFile().toString();
		
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
		bw.close();
	}

}
