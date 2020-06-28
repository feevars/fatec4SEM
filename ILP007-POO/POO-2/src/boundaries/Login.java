package boundaries;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login extends Group implements EventHandler<ActionEvent>{
	

	
	private VBox vboxLogin = new VBox();
	
	private TextField txtUsername = new TextField();
	private PasswordField txtPassword = new PasswordField();
	
	private HBox hboxBotoesAcoes = new HBox();
	
	private Button btnLogin = new Button("Login");
	private Button btnCadastrar = new Button("Cadastrar");
	
	public Login() {
		
		
		
		this.txtUsername.setPromptText("Digite o nome de usuário ou e-mail...");
		this.txtPassword.setPromptText("Digite a senha...");
		
		this.btnLogin.setOnAction(this);
		this.btnCadastrar.setOnAction(this);
		
		this.hboxBotoesAcoes.getChildren().addAll(btnLogin, btnCadastrar);
		this.vboxLogin.getChildren().addAll(txtUsername, txtPassword, hboxBotoesAcoes);
		
		this.getChildren().add(vboxLogin);
		
	}

	@Override
	public void handle(ActionEvent event) {
		
		Scene cena = this.getScene();
		
		if(event.getTarget() == btnCadastrar){
			System.out.println("Cadastrar");
		    cena.setRoot(new EstudanteCadastro(txtUsername.getText(), txtPassword.getText()));
		    
		}
		else if(event.getTarget() == btnLogin){
			System.out.println("Login");
		}
	}
}
