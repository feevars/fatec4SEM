package controllers;

import java.util.Date;

import entities.Cliente;
import entities.Pet;
import entities.Veterinario;

public class RealizarConsultaControl {

	private Cliente cliente;

	private Pet pet;

	public boolean registrarSintomas(Pet pet) {
		return false;
	}

	public boolean precisaNovoExame() {
		return false;
	}

	public boolean agendarExame(Veterinario vet, Date data) {
		return false;
	}

	public boolean atualizarHistorico(Pet pet, String diagnostico) {
		return false;
	}

	public boolean atualizarStatus() {
		return false;
	}

}
