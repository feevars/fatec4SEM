package boundaries;

import controllers.AdministradorController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Administrador;

public class AdminCadastro extends Group implements EventHandler<ActionEvent> {
	
	private AdministradorController adminController;
	
	private VBox vbox;
	
	private Label lblUsername;
	private TextField txtUsername;
	
	private Label lblPassword;
	private PasswordField txtPassword;
	
	private HBox hbox;
	
	private Button btnCadastro;
	private Button btnLogin;
	
	
	public AdminCadastro () {
		
		adminController = new AdministradorController();
		
		vbox = new VBox();
		
		lblUsername = new Label("Nome de usuário do administrador");
		txtUsername = new TextField();
		txtUsername.setPromptText("Digite o nome do usuário admin");
		
		lblPassword = new Label("Digite a senha");
		txtPassword = new PasswordField();
		txtPassword.setPromptText("Digite a senha");
		
		btnCadastro = new Button("Cadastrar");
		btnLogin = new Button("Login");
		
		btnCadastro.setOnAction(this);
		btnLogin.setOnAction(this);
		
		hbox = new HBox();
		hbox.getChildren().addAll(btnCadastro, btnLogin);
		
		vbox.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword, hbox);
		
		this.getChildren().add(vbox);
	}

	@Override
	public void handle(ActionEvent event) {
		boolean logado;
		
		if(event.getTarget() == btnCadastro){
			adminController.cadastrar(boundaryToEntity());

		}
		else if(event.getTarget() == btnLogin){
			logado = adminController.logar(txtUsername.getText(), txtPassword.getText());
			
			if(logado){
				System.out.println("Sucesso no login");
			}
			else{
				System.out.println("Erro no login!");
			}
		}
		
		
	}
	
	public Administrador boundaryToEntity(){
		Administrador admin = new Administrador();
		try{
			admin.setUsername(txtUsername.getText());
			admin.setPassword(txtPassword.getText());
		}catch (Exception e) {
			System.out.println("Erro ao receber dados.");
		}
		
		return admin;
	}
	
	
	
}
