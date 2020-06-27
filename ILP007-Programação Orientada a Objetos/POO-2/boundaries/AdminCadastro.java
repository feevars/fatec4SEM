package boundaries;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AdminCadastro extends Group {
	
	private VBox vbox;
	
	private Label lblUsername;
	private TextField txtUsername;
	
	private Label lblPassword;
	private PasswordField txtPassword;
	
	public AdminCadastro () {
		vbox = new VBox();
		
		lblUsername = new Label("Nome de usuário do administrador");
		txtUsername = new TextField();
		txtUsername.setPromptText("Digite o nome do usuário admin");
		
		lblPassword = new Label("Digite a senha");
		txtPassword = new PasswordField();
		txtPassword.setPromptText("Digite a senha");
		
		vbox.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword);
		
		this.getChildren().add(vbox);
	}
	
	
	
}
