package controller;

import java.io.IOException;
		
public interface IContArquivos {
	
	public void leDir(String path) throws IOException;
	public void leArquivo(String path, String nome) throws IOException;
	public void criaArq(String path, String nome) throws IOException;
	public void abreArq(String path, String nome) throws IOException;

}
