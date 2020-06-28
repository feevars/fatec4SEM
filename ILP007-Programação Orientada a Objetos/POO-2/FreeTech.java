import boundaries.Home;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FreeTech extends Application{
	
	public Home homeScreen;
	
	public static void main(String[] args) {
		Application.launch(FreeTech.class);
	}

	@Override
	public void start(Stage stage) throws Exception {


		
//<<<<<<< Updated upstream
	homeScreen = new Home();

	final Scene scene = new Scene(homeScreen, 1366, 768);
	
		stage.setScene(scene);
		stage.setTitle("FreeTech Learning");
		stage.show();
//		
//=======
				//homeScreen = new Home();
		
		//final Scene scene = new Scene(homeScreen, 1366, 768);
//		//scene. 
//		
		//stage.setScene(scene);
		//stage.setTitle("FreeTech Learning");
		//stage.show();
		
//>>>>>>> Stashed changes
	}
}
