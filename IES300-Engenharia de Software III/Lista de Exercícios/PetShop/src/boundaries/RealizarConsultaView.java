package boundaries;

import java.util.List;

import entities.Cliente;
import entities.Pet;

public class RealizarConsultaView {

	private Cliente cliente;

	private Pet pet;

	public boolean registrarSintomas(Pet pet, List<String> sintomas) {
		return false;
	}

	public boolean precisaNovoExame() {
		return false;
	}

	public void agendarExame() {

	}

	public void finalizarConsulta() {

	}

	public boolean atualizarHistorico(Pet pet, String diagnostico) {
		return false;
	}

}
