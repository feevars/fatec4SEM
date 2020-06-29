package tests;

import boundaries.admin.AdminDashboard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminDashboardTeste extends Application {

	
	public static void main(String[] args) {
		Application.launch(AdminDashboardTeste.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		AdminDashboard telaAdminDashboard = new AdminDashboard(1);
		
		Scene cena = new Scene(telaAdminDashboard);
		
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setMaximized(true);
		stage.setFullScreen(true);
		
		stage.setScene(cena);
		stage.show();
	}
}
