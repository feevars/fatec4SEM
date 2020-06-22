package classeParametrizada;

/* 36- Apresente a estrutura básica de código em JAVA, C# ou C++ para implementar as classes parametrizadas
com a estrutura <List> e <Set>.
*/ 

public class Principal <T>{
	

	public static void main(String[] args) {

		Exame e1 = new Exame(1, "Teste", "teste");
		Exame e2 = new Exame(2, "Teste", "teste");
		
		
		System.out.println("-------------------------------------------------");
		System.out.println("Lista LIST");
		System.out.println("-------------------------------------------------");
		ClasseListExames<Exame> exameList = new ClasseListExames<Exame>();
		
		//Adicionando itens
		exameList.add(e1);
		exameList.add(e2);
		
		System.out.println(exameList.size());
		
		//Esvaziar lista
		exameList.clear();
		System.out.println(exameList.size());		
		//-------------------------------------------------
		System.out.println("-------------------------------------------------");
		System.out.println("Lista SET");
		System.out.println("-------------------------------------------------");
		
		ClasseSetExame<Exame> exameSet = new ClasseSetExame<Exame>();
		
		//Adicionando itens
		exameSet.add(e1);
		exameSet.add(e2);
	
		System.out.println(exameSet.size());

		//Esvaziar lista
		exameSet.clear();
		
		System.out.println(exameSet.size());
	}

}
