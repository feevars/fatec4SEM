package view;



import java.net.SocketException;

import controller.RedesController;

public class Main {
	
	public static void main(String[] args) throws SocketException {
		
		RedesController rd = new RedesController();

		String os = rd.os();
		System.out.println(os);
		
		
		
		rd.redes();
		
		
		
		
	}
	

}
