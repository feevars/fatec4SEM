import boundaries.EstudanteExercicio;
import boundaries.admin.AdminCadastro;
import boundaries.admin.AdminExercicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TesteExercicio extends Application {

	public static void main(String[] args) {
		Application.launch(TesteExercicio.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AdminCadastro exercicio = new AdminCadastro();

//		EstudanteExercicio exercicio = new EstudanteExercicio("Titulo do exercício",
//				"sadfygff igfg asuidfdgs aiugfgiuf dsaiu syadfuagy fdsuagisu gfiasdgsy asdfugsu ", "Alternativa A",
//				"Alternativa B", "Alternativa C", "Alternativa D", "Alternativa E", "Explicação");

		Scene scene = new Scene(exercicio, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Exercicio");
		stage.show();
	}
}
