package controller;

public class ThreadSec extends Thread {
	private int n;
	public double res;
	public String show;
	public int num;

	public ThreadSec(int n) {
		this.n = n;
	}

	@Override
	public void run() { // como se fosse o main da classe
		seq();// só roda o que tiver aqui dentro
		super.run(); // acionar a superclasse (thread)
	}

	public void seq() {
		double num;
		int aux = 0;
		// de 1 a n. os ímpares soma e os pares, subtrai
		for (num = 1; num <= n; num += 2) {
			if (aux == 0 || aux % 2 == 0 && aux != 1) {
				res += (1 / num);
				show += " + " + "1/" + num;
			} else if (aux % 2 != 0){
				res -= (1 / num);
				show += " - " + "1/" + num;
			}
			aux++;
		}
		System.out.println(n + "\n " + show + "\n" + (4*res) + "\n");
	}
}
