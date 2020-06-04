package Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class GestaoFuncionarios {

	Funcionario funcionarios[] = new Funcionario[50];
	private int indice = 0;
	
	
	//ADICIONANDO NOVO USUARIO
	public void criar() throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataRecebida;
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
		String nome = JOptionPane.showInputDialog("NOME: "); 
		String matricula = JOptionPane.showInputDialog("NOME: "); 
		
		dataRecebida = JOptionPane.showInputDialog("ADMISSAO");
		Date admissao = formato.parse(dataRecebida);
		
		dataRecebida = JOptionPane.showInputDialog("DEMISSAO");
		Date demissao = formato.parse(dataRecebida);
		
		float salario = Float.parseFloat(JOptionPane.showInputDialog("SALARIO: "));
		String horario  = JOptionPane.showInputDialog("HORARIO: ");
		
		if(this.indice <= 49) {
			Funcionario f = new Funcionario(id, nome, matricula, admissao, demissao, salario, horario);
			funcionarios[indice] = f;
			this.indice += 1;
		}
		else {
			System.out.println("Nao foi possivel cadastrar funcionario - Lista cheia !");
		}
	}
	
	
	public void atualizar() throws ParseException{
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataRecebida;
		
		String matricula = JOptionPane.showInputDialog("Qual a matricula? ");
		for(int i =0; i<=funcionarios.length; i++) {
			if(funcionarios[i].getMatricula() == matricula) {
				funcionarios[i].setNome(JOptionPane.showInputDialog("NOVO NOME: "));
				funcionarios[i].setMatricula(JOptionPane.showInputDialog("NOVA MATRICULA: "));
				
				dataRecebida = JOptionPane.showInputDialog("ADMISSAO: ");
				funcionarios[i].setAdmissao(formato.parse(dataRecebida));
				
				dataRecebida = JOptionPane.showInputDialog("DEMISSAO: ");
				funcionarios[i].setDemissao(formato.parse(dataRecebida));
				
				funcionarios[i].setSalario(Float.parseFloat(JOptionPane.showInputDialog("SALARIO: ")));
				funcionarios[i].setHorario(JOptionPane.showInputDialog("HORARIO: "));
			}
		}
	}
	
	
	public void remover(){
		String matricula = JOptionPane.showInputDialog("MATRICULA: ");
		for (int cont = 0; cont <=49; cont ++) {
			if(funcionarios[cont].getMatricula() == matricula) {
				funcionarios[cont] = null;
					if(cont > 0) {
						for(int i = cont; i <= 45; i ++) {
							funcionarios[i] = funcionarios[i+1];
						}
					}
			}
		}
	}
	
	
	public void exibir() {
		String matricula = JOptionPane.showInputDialog("MATRICULA: ");
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula() == matricula) {
				System.out.println("NOME: " + funcionario.getNome() +
						"NOME: " + funcionario.getMatricula() +
						"NOME: " + funcionario.getAdmissao() +
						"NOME: " + funcionario.getDemissao() +
						"NOME: " + funcionario.getSalario() +
						"NOME: " + funcionario.getHorario());	
			}
		}
	}
	
	public void menu() throws ParseException{
		boolean loop = true;
		String op = "" ;
		
		JOptionPane.showMessageDialog(null,
		"\n--------------------------------------------------------" +
		"\nSISTEMA DE GESTAO DE FUNCIONARIOS" +
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
					atualizar();
					break;
					
				case "R":
					remover();
					break;
					
				case "S":
					loop = false;
					break;
			}
		}

	}

	
}
