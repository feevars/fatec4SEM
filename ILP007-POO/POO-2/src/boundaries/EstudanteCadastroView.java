package boundaries;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import controllers.EstudanteController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Estudante;
import model.entities.Instrutor;

public class EstudanteCadastroView extends Group implements EventHandler<ActionEvent> {

	Integer estudanteId;

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
	private Button btnVoltar = new Button("Voltar");
	private Button btnExcluir = new Button("Excluir o meu perfil");
	private Button btnCadastrar = new Button("Cadastrar");
	private Button btnSalvar = new Button("Salvar edições");

	// Construtor para cadastrar um novo usuário
	public EstudanteCadastroView(String username, String password) {

		txtUsername.setText(username);
		txtPassword.setText(password);

		btnCadastrar.setOnAction(this);
		btnCancelar.setOnAction(this);

		hboxBotoesAcoes.getChildren().addAll(btnCancelar, btnCadastrar);

		this.vboxCadastroUsuario.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword,
				lblPasswordCheck, txtPasswordCheck, lblNome, txtNome, lblSobrenome, txtSobrenome, lblEmail, txtEmail,
				lblTelefone, txtTelefone, lblDataNascimento, dtNascimento, hboxBotoesAcoes);
		this.getChildren().add(vboxCadastroUsuario);

	}

	// Construtor para editar o perfil
	public EstudanteCadastroView(Integer estudanteId) {

		this.estudanteId = estudanteId;

		Estudante usuario = estudanteController.getEstudantePorId(estudanteId);

		entityToBoundary(usuario);

		this.txtUsername.setDisable(true);
		this.txtEmail.setDisable(true);

		this.btnSalvar.setOnAction(this);
		this.btnExcluir.setOnAction(this);
		this.btnVoltar.setOnAction(this);

		hboxBotoesAcoes.getChildren().addAll(btnVoltar, btnExcluir, btnSalvar);

		this.vboxCadastroUsuario.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword,
				lblPasswordCheck, txtPasswordCheck, lblNome, txtNome, lblSobrenome, txtSobrenome, lblEmail, txtEmail,
				lblTelefone, txtTelefone, lblDataNascimento, dtNascimento, hboxBotoesAcoes);
		this.getChildren().add(vboxCadastroUsuario);

	}

	public Estudante boundaryToEntity() {
		Estudante estudante = new Estudante();
		try {
			estudante.setUsername(txtUsername.getText());
			estudante.setPassword(txtPassword.getText());
			estudante.setNome(txtNome.getText());
			estudante.setSobrenome(txtSobrenome.getText());
			estudante.setEmail(txtEmail.getText());
			estudante.setTelefone(txtTelefone.getText());
			LocalDate dataLocal = dtNascimento.getValue();
			java.util.Date dataUtil = Date.from(dataLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			estudante.setDataNascimento(dataSql);
		} catch (Exception e) {
			System.out.println("Erro ao receber dados.");
		}
		return estudante;
	}

	public void entityToBoundary(Estudante usuario) {

		if (usuario != null) {
			txtUsername.setText(usuario.getUsername());
			txtPassword.setText(usuario.getPassword());
			txtPasswordCheck.setText(usuario.getPassword());
			txtNome.setText(usuario.getNome());
			txtSobrenome.setText(usuario.getSobrenome());
			txtEmail.setText(usuario.getEmail());
			txtTelefone.setText(usuario.getTelefone());
			dtNascimento.setValue(usuario.getDataNascimento().toLocalDate());
		}
	}

	@Override
	public void handle(ActionEvent event) {

		Scene cena = this.getScene();

		if (event.getTarget().equals(btnCadastrar)) {
			if (!txtPassword.getText().equals(txtPasswordCheck.getText())) {
				Alert alertSenhasDiferentes = new Alert(AlertType.ERROR, "As senhas informadas são diferentes.");
				alertSenhasDiferentes.show();
			}
			Integer cadastro = estudanteController.cadastrarEstudante(boundaryToEntity());
			if (cadastro == 0) {
				Alert alertCadastradoComSucesso = new Alert(AlertType.INFORMATION, "Cadastrado com sucesso!");
				alertCadastradoComSucesso.show();
				cena.setRoot(new LoginView());
			} else if (cadastro == 1) {
				Alert alertusuarioJaExiste = new Alert(AlertType.ERROR,
						"O nome de usuario " + txtUsername.getText() + " já existe!");
				alertusuarioJaExiste.show();
			} else if (cadastro == 2) {
				Alert alertEmailJaExiste = new Alert(AlertType.ERROR,
						"O email " + txtEmail.getText() + " já cadastrado!");
				alertEmailJaExiste.show();
			} else if (cadastro == 3) {
				Alert alertErroBanco = new Alert(AlertType.ERROR, "Ocorreu um erro de banco de dados.");
				alertErroBanco.show();
			} else if (cadastro == 4) {
				Alert alertErroValidacaoFormulario = new Alert(AlertType.ERROR,
						"Ocorreu um erro de validação no formulário.");
				alertErroValidacaoFormulario.show();
			}
		} else if (event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new LoginView());
		} else if (event.getTarget().equals(btnVoltar)) {
			cena.setRoot(new EstudanteDashboardView(estudanteId));
		} else if (event.getTarget().equals(btnSalvar)) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Salvar alterações de perfil");
			alert.setHeaderText(txtUsername.getText() + ", caso confirme, seu perfil será editado.");
			alert.setContentText("Você confirma esta operação?");
			
			Boolean instrutorBool = estudanteController.getEstudantePorId(estudanteId) instanceof Instrutor;
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				if (estudanteController.estudanteEditarPerfil(boundaryToEntity(), instrutorBool)) {
					Alert alertEditou = new Alert(AlertType.INFORMATION, "Perfil editado com sucesso!");
					alertEditou.show();
					cena.setRoot(new EstudanteDashboardView(estudanteId));
				}
			}
		} else if (event.getTarget().equals(btnExcluir)) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Excluir Perfil");
			alert.setHeaderText(txtUsername.getText() + ", você está prestes a excluir seu perfil.");
			alert.setContentText("Você confirma esta operação?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				if (estudanteController.estudanteExcluirPerfil(estudanteId)) {
					Alert alertAdeus = new Alert(AlertType.INFORMATION, "Adeus.");
					alertAdeus.show();
					cena.setRoot(new LoginView());
				} else {
					Alert alertAdeus = new Alert(AlertType.INFORMATION, "Erro ao excluir.");
					alertAdeus.show();
					cena.setRoot(new LoginView());
				}
			}
		}
	}
}
