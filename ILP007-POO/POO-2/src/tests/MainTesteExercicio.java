package tests;

import boundaries.admin.AdminExercicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTesteExercicio extends Application{

	public static void main(String[] args) {
		Application.launch(MainTesteExercicio.class, args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		AdminExercicio exercico = new AdminExercicio();
		
		Scene cena = new Scene(exercico, 600, 800);
		stage.setScene(cena);
		stage.show();
		
	}

}
