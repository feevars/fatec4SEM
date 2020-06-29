package tests;

import java.util.Date;

import boundaries.admin.AdminUsuario;
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
		
		AdminUsuario uc = new AdminUsuario(1, "Felizberto", "Fonseca", "2345678", new Date(), true);
		
		Scene cena = new Scene(uc, 600, 800);
		stage.setScene(cena);
		stage.show();
	}

}
