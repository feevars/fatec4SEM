package tests;

import boundaries.CursoBoundary;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminCursoTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(AdminCursoTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		CursoBoundary adminCurso = new CursoBoundary(1, 2);

		Scene scene = new Scene(adminCurso, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Curso");
		stage.show();
	}
}
