import boundary.CursoBoundary;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CRUDcursos extends Application {

	public static void main(String[] args) {
		Application.launch(CRUDcursos.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CursoBoundary alunoBoundary = new CursoBoundary();
		
		Scene cena = new Scene(alunoBoundary, 800, 600);
		
		primaryStage.setScene(cena);
		primaryStage.setTitle("CRUD Alunos");
		primaryStage.show();
	}
}
