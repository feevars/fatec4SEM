package tests;
import boundaries.EstudanteAula;
import boundaries.Home;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTesteAulaAluno extends Application {
	
	public EstudanteAula estudanteAula;
	
	public static void main(String[] args) {
		Application.launch(MainTesteAulaAluno.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
				estudanteAula = new EstudanteAula("https://www.youtube.com/embed/videoseries?list=PLnvgG3onSbK8ADiJotrqYgZadFtHxwDGs");
		
		final Scene scene = new Scene(estudanteAula, 800, 800);
//		//scene. 
//		
		stage.setScene(scene);
		stage.setTitle("FreeTech Learning");
		stage.show();	
}
}
