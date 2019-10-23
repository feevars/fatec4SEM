package controller;

public class ThreadCalc extends Thread{
		
		private int a;
		private int b;
		private int op;
		
		//construtor
		public ThreadCalc(int a, int b, int op) { // desde o começo da thread, vai até o fim
		
			this.a = a;
			this.b = b;
			this.op = op;
		}
		@Override
		public void run() { // como se fosse o main da classe
			calc();//só roda o que tiver aqui dentro
		super.run(); //acionar a superclasse (thread) 
		}
		
		public void calc () {
			try {
				Thread.sleep(op * 1000); // isso faz com que eu influencie no escalonador. 
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //cada thread vai ficar 1 seg a mais pelo tempo q eu defini
			
			int res = 0;
			String opera = "";
			switch (op) {
			case 0:
				res = a + b;
				opera = "+";
				break;
			case 1:
				res = a - b;
				opera = "-";
				break;
			case 2:
				res = a * b;
				opera = "*";
				break;
			case 3:
				res = a / b;
				opera = "/";
				break;
			}
			System.out.println(a + " " + opera + " " + b + " = " + res);
		}
}