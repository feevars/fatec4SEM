package calendario;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ConversaoDatas {

	public static void main(String[] args) {
		Integer dia = Integer.parseInt(JOptionPane.showInputDialog("INFORME O DIA: "));
		Integer mes = Integer.parseInt(JOptionPane.showInputDialog("INFORME O MES: "));
		Integer ano = Integer.parseInt(JOptionPane.showInputDialog("INFORME O ANO: "));
		
		converteData(dia, mes, ano);
	}
	
	public static void converteData(Integer dia, Integer mes, Integer ano) {
		Integer data;
		Integer base;
		Integer a;
		Integer b;
		Integer c;
		Integer d;
		Integer e;
		Double dataju;
		DecimalFormat decimalFormatter = new DecimalFormat("0.00");
		
		data = dia + mes + ano;
		
		base = 15 + 10 + 1582;
				
		if(mes < 3){
			ano -= 1;
			mes += 12;
		}
				
		if(data >= base) {
			a = ano / 100;
			b = a / 4;
			c = 2 - a + b;
			d = (int) (365.25 * (ano + 4716));
			e = (int) (30.6001 * mes + 1);
			
			dataju = (Double) ((d + e + dia + 0.5 + c - 1524.5) + 30);
			String parteInteira = decimalFormatter.format(dataju).substring(0, decimalFormatter.format(dataju).indexOf(","));

			if(dataju % 2 == 0 || dataju % 2 == 1) {
				dataju -= 1;
				
				System.out.println("------------------------------");
				System.out.println("DATA JULIANA: " +parteInteira);
				System.out.println("------------------------------");
			}
		}
	}

}
