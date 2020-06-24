package entities;

import java.util.Date;
import java.util.Set;

import entities.enums.Porte;
import entities.enums.Tipo;

public class Consulta {

	private Date dataConsulta;

	private double horaConsulta;

	private Pet pet;

	private Cliente cliente;

	private Veterinario vet;

	private boolean pago;

	private Tipo tipoConsulta;

	private Porte statusConsulta;

	private Set<Exame> exames;

	private Set<Exame> listaExames;

	public boolean atualizarStatus() {
		return false;
	}

}
