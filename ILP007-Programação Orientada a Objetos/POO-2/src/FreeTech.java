import boundaries.HomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FreeTech extends Application{
	
	public HomeScreen homeScreen;
	
	public static void main(String[] args) {
		Application.launch(FreeTech.class);
	}

	@Override
	public void start(Stage stage) throws Exception {

		homeScreen = new HomeScreen();
		
		final Scene scene = new Scene(homeScreen, 1366, 768);
		//scene. 
		
		stage.setScene(scene);
		stage.setTitle("FreeTech Learning");
		stage.show();
		
	}
}
