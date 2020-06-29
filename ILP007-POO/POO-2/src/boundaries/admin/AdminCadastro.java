package boundaries.admin;

import boundaries.Login;
import controllers.AdministradorController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Administrador;

public class AdminCadastro extends Group implements EventHandler<ActionEvent> {
	
	private AdministradorController adminController;
	
	private VBox vbox = new VBox();
	
	private Label lblUsername = new Label("Nome de usuário do administrador");
	private TextField txtUsername = new TextField();;
	
	private Label lblPassword = new Label("Digite a senha");
	private PasswordField txtPassword = new PasswordField();
	
	private HBox hbox = new HBox();;
	
	private Button btnCancelar = new Button("Cadastrar");;
	private Button btnCadastro = new Button("Cadastrar");;
	private Button btnLogin = new Button("Login");;
	
	
	public AdminCadastro (String username, String password) {
		
		adminController = new AdministradorController();
	
		txtUsername.setPromptText("Digite o nome do usuário admin");
		txtPassword.setPromptText("Digite a senha");
		
		btnCancelar.setOnAction(this);
		btnCadastro.setOnAction(this);
		btnLogin.setOnAction(this);
		
		hbox.getChildren().addAll(btnCancelar, btnCadastro, btnLogin);
		
		vbox.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword, hbox);
		
		this.getChildren().add(vbox);
	}

	@Override
	public void handle(ActionEvent event) {
		boolean logado;
		Scene cena = this.getScene();

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
		else if(event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new Login());
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
