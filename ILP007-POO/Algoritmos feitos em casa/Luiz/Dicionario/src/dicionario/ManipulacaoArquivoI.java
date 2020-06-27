package dicionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface ManipulacaoArquivoI {

	Collection<Palavra> lerArquivo() throws FileNotFoundException, IOException;
	
	void escreverNoArquivo(String palavra, String descricao) throws FileNotFoundException, IOException;
}
