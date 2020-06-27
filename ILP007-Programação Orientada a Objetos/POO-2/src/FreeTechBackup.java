import boundaries.Home;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FreeTechBackup extends Application{
	
	public Home homeScreen;
	
	public static void main(String[] args) {
		Application.launch(FreeTechBackup.class);
	}

	@Override
	public void start(Stage stage) throws Exception {


		
	homeScreen = new Home();

	final Scene scene = new Scene(homeScreen, 1366, 768);
	
		stage.setScene(scene);
		stage.setTitle("FreeTech Learning");
		stage.show();
//		
	}
}
