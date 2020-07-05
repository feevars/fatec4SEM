package tests;

import boundaries.AdminExercicioView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.Exercicio;

public class AdminExercicioTeste extends Application{

	public static void main(String[] args) {
		Application.launch(AdminExercicioTeste.class, args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Exercicio exercicio = new Exercicio();

		AdminExercicioView exercico = new AdminExercicioView(3, exercicio); // tela Editar e excluir

		//AdminExercicioView exercico = new AdminExercicioView(3, 2); //tela cadastrar
		
		Scene cena = new Scene(exercico, 600, 800);
		stage.setScene(cena);
		stage.show();
		
	}

}
