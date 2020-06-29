package tests;

import boundaries.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TesteMainPrincipal extends Application {

	
	public static void main(String[] args) {
		Application.launch(TesteMainPrincipal.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Login telaLogin = new Login();
		
		Scene cena = new Scene(telaLogin);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setMaximized(true);
		stage.setFullScreen(true);
		
		stage.setScene(cena);
		stage.show();
	}

}
