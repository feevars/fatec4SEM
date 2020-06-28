package boundaries;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UsuarioCadastro extends Group {

	private VBox vboxCadastroUsuario = new VBox();

	private Label lblUsername = new Label("Nome de usuário");
	private TextField txtUsername = new TextField();

	private Label lblPassword = new Label("Senha");
	private PasswordField txtPassword = new PasswordField();

	private Label lblNome = new Label("Primeiro nome:");
	private TextField txtNome = new TextField();
	private Label lblSobrenome = new Label("Sobrenome:");
	private TextField txtSobrenome = new TextField();

	private Label lblEmail = new Label("Email:");
	private TextField txtEmail = new TextField();

	private Label lblTelefone = new Label("Telefone:");
	private TextField txtTelefone = new TextField();

	private Label lblDataNascimento = new Label("Data de nascimento:");
	private TextField txtDataNascimento = new TextField();

	private HBox hboxBotoesAcoes = new HBox();
	
	private Button btnCancelar = new Button("Cancelar");
	private Button btnCadastrar = new Button("Cadastrar");

	public UsuarioCadastro() {
		
		hboxBotoesAcoes.getChildren().addAll(btnCancelar, btnCadastrar);

		this.vboxCadastroUsuario.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword, lblNome, txtNome,
				lblSobrenome, txtSobrenome, lblEmail, txtEmail, lblTelefone, txtTelefone, lblDataNascimento,
				txtDataNascimento, hboxBotoesAcoes);
		
		this.getChildren().add(vboxCadastroUsuario);
	}
}
