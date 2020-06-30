import boundaries.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FreeTech extends Application{
	
	public static void main(String[] args) {
		Application.launch(FreeTech.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		LoginView telaLogin = new LoginView();
		
		Scene cena = new Scene(telaLogin);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setMaximized(true);
		stage.setFullScreen(true);
		
		stage.setScene(cena);
		stage.show();
	}
}
