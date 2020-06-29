package tests;

import boundaries.admin.AdminAula;
import boundaries.admin.AdminCurso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminCursoTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(AdminCursoTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AdminAula adminAula = new AdminAula();

		Scene scene = new Scene(adminAula, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Aula");
		stage.show();
	}
}
