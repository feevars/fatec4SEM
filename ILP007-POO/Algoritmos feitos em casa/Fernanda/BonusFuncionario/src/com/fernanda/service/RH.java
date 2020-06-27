package com.fernanda.service;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import com.fernanda.entities.Empresa;
import com.fernanda.entities.Funcionario;

public class RH {
	private Empresa emp = new Empresa(this);
	private Set<Funcionario> funcionarios = new HashSet<>();
	private double bonus;
	
	public Double valorBonus(Funcionario func) {
		if (func.getFaltasNoAno() < 2) {
			bonus = (func.getSalario()*0.3);
		}
		if (func.getFaltasNoAno() >=2 && func.getFaltasNoAno() <= 4) {
			bonus = (func.getSalario()*0.3);
		}
		if (func.getFaltasNoAno() > 4) {
			bonus = (func.getSalario()*0.3);
		}
		
		if (func.getUltimaNotaAvaliacao() > 7) {
			bonus += (func.getSalario()*0.3);
		}
		if (func.getUltimaNotaAvaliacao() > 5 && func.getUltimaNotaAvaliacao() <= 7) {
			bonus += (func.getSalario()*0.15);
		}
		if (func.getUltimaNotaAvaliacao() <= 5) {
			bonus += (func.getSalario()*0.05);
		}
		return bonus;
	}
	
	public void mostrarBonusTodosFuncionarios() {
		for (Funcionario f : funcionarios) {
			if (f.getSalario() != null) f.setBonus(valorBonus(f));
			System.out.println(f.toString());
		}
	}
	
	public void adicionarFuncionario (Funcionario func) {
		funcionarios.add(func);
		System.out.println("Funcionário cadastrado no sistema.");
	}
	
	public void removerFuncionario (Funcionario func) {
		//int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário que deseja remover"));
		funcionarios.remove(func); 
		System.out.println("funcionário removido com sucesso.");
			
		}
	}