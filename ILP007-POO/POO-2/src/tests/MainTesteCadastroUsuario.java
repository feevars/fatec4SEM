package tests;

import boundaries.UsuarioCadastro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTesteCadastroUsuario extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(MainTesteCadastroUsuario.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		UsuarioCadastro uc = new UsuarioCadastro();
		
		Scene cena = new Scene(uc, 600, 800);
		stage.setScene(cena);
		stage.show();
	}

}
