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
		
		Scene cena = new Scene(telaLogin, 800, 600);
		
		
		stage.setScene(cena);
		stage.show();
	}

}
