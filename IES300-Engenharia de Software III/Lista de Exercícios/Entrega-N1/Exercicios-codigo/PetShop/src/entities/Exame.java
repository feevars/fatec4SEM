package entities;

import java.util.Date;

public class Exame extends Consulta{

	private Date data;

	private Pet pet;

	private Veterinario quemSolicitou;

	public boolean foiRealizado() {
		return false;
	}

	private String resultado;

	private Veterinario quemRealizou;

	public void criar() {

	}

}
