package tests;

import boundaries.admin.AdminAulaView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminAulaTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(AdminAulaTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AdminAulaView adminAula = new AdminAulaView(4, 4, "Titulo da aula");

		Scene scene = new Scene(adminAula);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setMaximized(false);
		stage.setFullScreen(false);

		stage.setScene(scene);
		stage.setTitle("FreeTech Learning");
		stage.show();
	}
}
