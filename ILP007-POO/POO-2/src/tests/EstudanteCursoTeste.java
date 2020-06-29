package tests;


import boundaries.EstudanteAula;
import boundaries.EstudanteCurso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EstudanteCursoTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(EstudanteCursoTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		EstudanteAula tela = new EstudanteAula(1, 1);
		
		Scene cena = new Scene(tela);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
//		stage.setMaximized(true);
//		stage.setFullScreen(true);
		
		stage.setScene(cena);
		stage.show();
	}

}
