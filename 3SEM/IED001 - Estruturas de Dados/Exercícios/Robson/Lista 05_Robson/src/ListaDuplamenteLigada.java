import javax.swing.JOptionPane;

public class ListaDuplamenteLigada<T> {
	
	//---Variáveis que existem na ListaDupla
	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;
	
	//---Construtor
	public ListaDuplamenteLigada() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
	}
	
	//--Métodos
	public boolean estaVazia() {
		return qtdNo == 0;
	}
	
	public void inserirPrimeiro(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.ultimo = novoNo;
		}
		novoNo.setProximo(this.primeiro);
		this.primeiro = novoNo;
		this.qtdNo++;
	}
	
	public void inserirNaPosicao(T conteudo, int posicao) {
		
		if(posicao > qtdNo) {
			JOptionPane.showMessageDialog(null, "A posição desejada é maior que o tamanho da lista."
					+ "\nO item será inserido no final.");
			this.inserirUltimo(conteudo);
		}
		
		
	}
	
	public void inserirUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProximo(novoNo);
		}
		novoNo.setAnterior(this.ultimo);
		this.ultimo = novoNo;
		this.qtdNo++;
	}
	
	public String imprimirLista() {
		
		String listaImpressa = "Lista:\n";
		
		if (this.estaVazia()) {
			listaImpressa += "A lista está vazia.";
		}else {
			No atual = this.primeiro;
			while(atual != null) {
				listaImpressa += atual.getConteudo().toString() + "\n";
				atual = atual.getProximo();
			}
		}
		
		return listaImpressa;
	}

	
	
}
