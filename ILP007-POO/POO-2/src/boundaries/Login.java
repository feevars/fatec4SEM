package boundaries;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login extends Group {

	private VBox vboxLogin = new VBox();
	
	private TextField txtUsername = new TextField();
	private PasswordField txtPassword = new PasswordField();
	
	private HBox hboxBotoesAcoes = new HBox();
	
	private Button btnLogin = new Button("Login");
	private Button btnCadastrar = new Button("Cadastrar");
	
	public Login() {
		
		this.txtUsername.setPromptText("Digite o nome de usuário ou e-mail...");
		this.txtPassword.setPromptText("Digite a senha...");
		
		this.hboxBotoesAcoes.getChildren().addAll(btnLogin, btnCadastrar);
		
		this.vboxLogin.getChildren().addAll(txtUsername, txtPassword, hboxBotoesAcoes);
	}
}
