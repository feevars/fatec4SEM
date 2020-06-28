package boundaries;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import controllers.EstudanteController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Estudante;

public class EstudanteCadastro extends Group implements EventHandler<ActionEvent>{

	EstudanteController estudanteController = new EstudanteController();
	
	private VBox vboxCadastroUsuario = new VBox();

	private Label lblUsername = new Label("Nome de usuário: ");
	private TextField txtUsername = new TextField();

	private Label lblPassword = new Label("Senha: ");
	private PasswordField txtPassword = new PasswordField();
	private Label lblPasswordCheck = new Label("Repita a sua senha:");
	private PasswordField txtPasswordCheck = new PasswordField();

	private Label lblNome = new Label("Primeiro nome:");
	private TextField txtNome = new TextField();
	private Label lblSobrenome = new Label("Sobrenome:");
	private TextField txtSobrenome = new TextField();

	private Label lblEmail = new Label("Email:");
	private TextField txtEmail = new TextField();

	private Label lblTelefone = new Label("Telefone:");
	private TextField txtTelefone = new TextField();

	private Label lblDataNascimento = new Label("Data de nascimento:");
	private DatePicker dtNascimento = new DatePicker();
	
	private HBox hboxBotoesAcoes = new HBox();
	
	private Button btnCancelar = new Button("Cancelar");
	private Button btnCadastrar = new Button("Cadastrar");

	public EstudanteCadastro(String username, String password) {
		
		txtUsername.setText(username);
		txtPassword.setText(password);
		
		btnCadastrar.setOnAction(this);
		btnCancelar.setOnAction(this);
		
		hboxBotoesAcoes.getChildren().addAll(btnCancelar, btnCadastrar);
		
		this.vboxCadastroUsuario.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword, lblPasswordCheck, txtPasswordCheck, lblNome, txtNome,
				lblSobrenome, txtSobrenome, lblEmail, txtEmail, lblTelefone, txtTelefone, lblDataNascimento,
				dtNascimento, hboxBotoesAcoes);
		this.getChildren().add(vboxCadastroUsuario);
	}
	
	
	
	public Estudante boundaryToEntity(){
		Estudante usuario = new Estudante();
		try{
			usuario.setUsername(txtUsername.getText());
			usuario.setPassword(txtPassword.getText());
			usuario.setNome(txtNome.getText());
			usuario.setSobrenome(txtSobrenome.getText());
			usuario.setEmail(txtEmail.getText());
			usuario.setTelefone(txtTelefone.getText());
			LocalDate dataLocal = dtNascimento.getValue();
			java.util.Date dataUtil = Date.from(dataLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			usuario.setDataNascimento(dataSql);
		}catch (Exception e) {
			System.out.println("Erro ao receber dados.");
		}
		return usuario;
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget() == btnCadastrar){
//			estudanteController.cadastrar(boundaryToEntity());
			if (!txtPassword.getText().equals(txtPasswordCheck.getText())) {
				Alert alertSenhasDiferentes = new Alert(AlertType.ERROR, "As senhas informadas são diferentes.");
				alertSenhasDiferentes.show();
			}
			
		}
		else if(event.getTarget() == btnCancelar){			
		}
		
	}

}
