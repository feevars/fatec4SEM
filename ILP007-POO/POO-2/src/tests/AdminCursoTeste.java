package tests;

<<<<<<< HEAD
=======
import boundaries.admin.AdminAulaView;
>>>>>>> 3443427baa2ffba3fea3017491f17defedaec7e5
import boundaries.admin.AdminCursoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminCursoTeste extends Application {
	
	public static void main(String[] args) {
		Application.launch(AdminCursoTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
<<<<<<< HEAD
		AdminCursoView adminCurso = new AdminCursoView(1);
=======
		AdminAulaView adminAula = new AdminAulaView();
>>>>>>> 3443427baa2ffba3fea3017491f17defedaec7e5

		Scene scene = new Scene(adminCurso, 640, 800);

		stage.setScene(scene);
		stage.setTitle("Curso");
		stage.show();
	}
}
