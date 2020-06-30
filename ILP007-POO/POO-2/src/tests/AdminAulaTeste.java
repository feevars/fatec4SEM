package tests;

<<<<<<< HEAD
import boundaries.admin.AdminAulaView;
=======
import boundaries.admin.AdminCursoView;
>>>>>>> 3443427baa2ffba3fea3017491f17defedaec7e5
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminAulaTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(AdminAulaTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
<<<<<<< HEAD
		AdminAulaView adminAula = new AdminAulaView();
=======
		AdminCursoView adminCurso = new AdminCursoView(1);
>>>>>>> 3443427baa2ffba3fea3017491f17defedaec7e5

		Scene scene = new Scene(adminAula);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setMaximized(true);
		stage.setFullScreen(false);

		stage.setScene(scene);
		stage.setTitle("Cadastrar Aula");
		stage.show();
	}
}
