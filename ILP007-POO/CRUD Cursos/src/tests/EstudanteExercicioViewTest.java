package tests;

import boundaries.EstudanteExercicioView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EstudanteExercicioViewTest extends Application {
	
	public static void main(String[] args) {
		Application.launch(EstudanteExercicioViewTest.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		EstudanteExercicioView adminCurso = new EstudanteExercicioView(1, null);

		Scene scene = new Scene(adminCurso, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Curso");
		stage.show();
	}

}
