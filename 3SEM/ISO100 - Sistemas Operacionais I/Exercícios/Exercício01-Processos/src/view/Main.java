package view;

import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		
		RedesController rd = new RedesController();

		String os = rd.os();
		System.out.println(os);
	}
	

}
