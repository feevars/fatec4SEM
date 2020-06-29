package tests;

import boundaries.EstudanteDashboard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EstudanteDashboardTeste extends Application {

	
	public static void main(String[] args) {
		Application.launch(EstudanteDashboardTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		EstudanteDashboard ed = new EstudanteDashboard(1);
		
		Scene cena = new Scene(ed);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setMaximized(true);
		stage.setFullScreen(true);
		
		stage.setScene(cena);
		stage.show();
	}

}
