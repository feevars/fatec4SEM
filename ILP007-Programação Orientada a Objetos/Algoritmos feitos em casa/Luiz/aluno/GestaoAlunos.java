package aluno;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.swing.JOptionPane;

public class GestaoAlunos {

	private Integer indice;
	private Aluno[] aluno;
	
	
	public void criar() {
		
		Long id = Long.parseLong(JOptionPane.showInputDialog("QUAL O ID DO ALUNO? "));
		String nome = JOptionPane.showInputDialog("QUAL O NOME DO ALUNO? ");
		String ra = JOptionPane.showInputDialog("QUAL O RA DO ALUNO: ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strNasc = JOptionPane.showInputDialog("Qual a data de nascimento? ");
		
		Aluno al = new Aluno();
		al.setId(id);
		al.setNome(nome);
		al.setRa(ra);
		try {
			al.setNascimento(sdf.parse(strNasc));
		} catch (ParseException e) {
			e.printStackTrace();
			al.setNascimento(null);
			System.out.println("Erro no formato da DATA");
		}
		this.aluno[indice] = al;
		this.indice ++;
		
		System.out.println("ALUNO:  " +
				"ID: " + al.getId() + "\n" +
				"NOME: " + al.getNome() + "\n" +
				"RA: " + al.getRa() + "\n" +
				"NASCIMENTO: " + al.getNascimento() + "\n" );		
	}
	

	public void exibir() {
		String ra = JOptionPane.showInputDialog("QUAL O RA PARA PESQUISA? ");
			for (int i = 0 ; i <=this.indice ; i ++ ) {
				if (this.aluno[i].getRa() == ra) {
					this.aluno[i].exibir();
				}
			}
		System.out.println("---------------------------------");
	}
	
	public void excluir() {
		int resposta = JOptionPane.YES_NO_OPTION;
		String ra = JOptionPane.showInputDialog("Qual o RA para exclusão? ");
		for (int i = 0 ; i <=this.indice ; i ++ ) {
			if (this.aluno[i].getRa() == ra) {
				resposta = JOptionPane.showConfirmDialog (null, "TEM CERTEZA QUE DESEJA EXLUIR? ","WARNING", resposta);
				if(resposta ==JOptionPane.YES_OPTION) {
					this.aluno[i] = null;
					if(i <= this.indice) {
						for(int  cont = i; cont <= indice; cont ++) {
							this.aluno[cont] = this.aluno[cont+1];
						}
					}
				}
			}
		}
	}
	
	public void atualizar() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		String strData;
		String ra = JOptionPane.showInputDialog("Qual o RA para atualização? ");
		for(int i = 0; i <= this.indice; i++) {
			if(this.aluno[i].getRa() == ra) {
				this.aluno[i].setId(Long.parseLong(JOptionPane.showInputDialog("INFORME O NOVO ID: ")));
				this.aluno[i].setNome(JOptionPane.showInputDialog("INFORME O NOVO NOME: "));	
				try {
					strData = JOptionPane.showInputDialog("INFORME A DATA DE NASCIMENTO");
					this.aluno[i].setNascimento(sdf.parse(strData));
				}catch (ParseException pe) {
					pe.printStackTrace();
					System.out.println("ERRO DE CONVERSAO. NAO FOI POSSIVEL ALTERAR DATA");
				}
			}
		}
	}
	
	public void menu(){
		boolean loop = true;
		String op = "" ;
		
		JOptionPane.showMessageDialog(null,
		"\n--------------------------------------------------------" +
		"\nSISTEMA DE GESTAO DE ALUNOS" +
		"\n(C)riar" +
		"\n(E)xibir" +
		"\n(A)tualizar" +
		"\n(R)emover" +
		"\n(S)air" +
		"\n--------------------------------------------------------");
		
		while(loop == true) {
			op = JOptionPane.showInputDialog("INFORME A OPCAO: ");			
	
			switch (op.toUpperCase()) {
					
				case "C":
					criar();
					break;
					
				case "E":
					exibir();
					break;
					
				case "A":
				try {
					atualizar();
				} catch (ParseException e) {
					e.printStackTrace();
				}
					break;
					
				case "R":
					excluir();
					break;
					
				case "S":
					loop = false;
					break;
			}
		}

	}
	
}
