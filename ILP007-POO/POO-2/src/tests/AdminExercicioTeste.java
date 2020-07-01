package tests;

import boundaries.admin.AdminExercicioView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminExercicioTeste extends Application{

	public static void main(String[] args) {
		Application.launch(AdminExercicioTeste.class, args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		AdminExercicioView exercico = new AdminExercicioView(3, 2);
		
		Scene cena = new Scene(exercico, 600, 800);
		stage.setScene(cena);
		stage.show();
		
	}

}
