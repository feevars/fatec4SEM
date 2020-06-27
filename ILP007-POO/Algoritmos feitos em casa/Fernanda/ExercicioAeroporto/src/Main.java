import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Piloto p1 = new Piloto("Marta", "14A23", "São Paulo", "São Paulo", "Brasil");
		Piloto p2 = new Piloto("Fabiana", "18C79", "Uberlândia", "Minas Gerais", "Brasil");
		
		Passageiro pass1 = new Passageiro("Roberta", "656845675867", true , true, false);
		Passageiro pass2 = new Passageiro("Carla", "656845675867", true , true, false);
		
		Aeronave a1 = new Aeronave("Boeing 747", p1, "LATAM", pass1, false);
		Aeronave a2 = new Aeronave("Boeing 838", p2, "GOL", pass2, false);
		
		Aeroporto ap1 = new Aeroporto("Internacional", "GRU", "Guarulhos", true);
		ap1.setAeronavesParadas(Arrays.asList(a1, a2));
		
		Aeroporto ap2 = new Aeroporto("Viracopos", "VCP", "São Paulo", true);
		ap1.setAeronavesParadas(Arrays.asList(a1, a2));
		
	}
}
