package tests;

import boundaries.admin.AdminCurso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminAulaTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(AdminAulaTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AdminCurso adminCurso = new AdminCurso(1);

		Scene scene = new Scene(adminCurso, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Curso");
		stage.show();
	}
}
