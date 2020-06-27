package com.fernanda;

import javax.swing.JOptionPane;

import com.fernanda.entities.Empresa;
import com.fernanda.entities.Funcionario;
import com.fernanda.service.RH;

public class Application {

	public static String menu() {
		String menuText = "Menu:"
				+ "1) Cadastrar Funcionário"
				+ "2) Cadastrar Salário"
				+ "3) Exibir lista de bônus"
				+ "\n\n\n"
				+ "9) Sair ";
		return menuText;
	};
	
	
	public static void main(String[] args) {
		
		RH rh = new RH();
		Empresa emp = new Empresa(rh);
		
		for (int i = 0; i < 5; i++) {
			emp.contratarFuncionario();
		}
		
		//Funcionario func1 = new Funcionario(null, "Carlos", "3459", 1200.00, 3, 7.8F, null, null, null, null);
		//Funcionario func2 = new Funcionario(null, "Manoel", "3439", 1280.00, 4, 9.8F, null, null, null, null);
		//Funcionario func3 = new Funcionario(null, "Sara", "3453", 1800.00, 6, 2.6F, null, null, null, null);
		//Funcionario func4 = new Funcionario(null, "Maria", "3400", 1450.00, 1, 7.9F, null, null, null, null);
		//Funcionario func5 = new Funcionario(null, "Tainara", "3499", 1700.00, 2, 5.8F, null, null, null, null);
		
		//emp.contratarFuncionario(func1);
		//emp.contratarFuncionario(func2);
		//emp.contratarFuncionario(func3);
		//emp.contratarFuncionario(func4);
		//emp.contratarFuncionario(func5);
		
		rh.mostrarBonusTodosFuncionarios();
		
		//rh.removerFuncionario(func2);
		
		System.out.println("\n\n");

		rh.mostrarBonusTodosFuncionarios();
	}

}
