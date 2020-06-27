import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CriaTela extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane gridPane = new GridPane();
		gridPane.setPrefSize(4, 8);
		gridPane.setPadding(new Insets(25));
		gridPane.setVgap(10);
		gridPane.setHgap(5);
		
		
		Label labelPhone = new Label("Enter your phone number: ");
		labelPhone.setMinWidth(180);
		Label labelName =  new Label("Enter your name: ");
		labelName.setMinWidth(120);
		
		TextField textPhone = new TextField();
		textPhone.setPromptText("phone number here");
		
		TextArea textName = new TextArea();
		textName.setPromptText("put your name in this extremely huge text area");
		
		FlowPane flowPane = new FlowPane();
		flowPane.setHgap(10);
		
		Button buttonSalvar = new Button();
		buttonSalvar.setText("Ok");
		
		Button buttonPesquisar = new Button();
		buttonPesquisar.setText("Cancel");
		
		
		gridPane.add(labelPhone, 0, 0);
		gridPane.add(textPhone, 2, 0);
		
		gridPane.add(labelName, 0, 1);
		gridPane.add(textName, 2, 1);
		
		flowPane.getChildren().add(buttonSalvar);
		flowPane.getChildren().add(buttonPesquisar);
		
		gridPane.add(flowPane, 2, 3);
		
		Scene scene = new Scene(gridPane, 600, 200);
		
		primaryStage.setTitle("Graphic User Interface Test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(CriaTela.class, args);

	}
}