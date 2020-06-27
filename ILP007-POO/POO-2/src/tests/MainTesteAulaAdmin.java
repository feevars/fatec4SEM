package tests;

import boundaries.AdminCurso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTesteAulaAdmin extends Application {
	
	public static void main(String[] args) {
		Application.launch(MainTesteAulaAdmin.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AdminCurso adminCurso = new AdminCurso();

		Scene scene = new Scene(adminCurso, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Curso");
		stage.show();
	}
}
