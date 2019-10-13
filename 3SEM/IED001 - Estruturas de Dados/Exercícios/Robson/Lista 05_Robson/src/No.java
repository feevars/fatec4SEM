
public class No<T> {
	
	private T conteudo;
	private No anterior;
	private No proximo;
	
	public No(T conteudo) {
		this.conteudo = conteudo;
		this.anterior = null;
		this.proximo = null;
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

}
