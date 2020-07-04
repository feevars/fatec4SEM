package model.entities;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Pet implements Comparable<Pet> {
	private long id;
	private String nome = "";
	private String raca = "";
	private double peso;
	private LocalDate nascimento = LocalDate.now();
	
	public Pet() { 
	}
	
	public Pet(String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@NotBlank(message = "O campo nome não pode ser nulo.")
	@Size(min=2, max=50)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank(message = "O campo raça não pode ser nulo.")
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Past(message = "A data de nascimento deve ser anterior à data atual.")
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public int compareTo(Pet p) {
		return getNome().compareTo(p.getNome());
	}
	
	@Override
	public String toString() { 
		return nome;
	}
}
