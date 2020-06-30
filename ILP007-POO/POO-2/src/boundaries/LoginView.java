package boundaries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import boundaries.admin.AdminCadastroView;
import boundaries.admin.AdminDashboardView;
import controllers.AdministradorController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends BorderPane implements EventHandler<ActionEvent> {

	private Image logotipo;
	private ImageView logotipoView;

	private VBox vboxLogin = new VBox();

	private Label lblUsername = new Label("Nome de usuário:");
	private TextField txtUsername = new TextField();

	private Label lblPassword = new Label("Senha:");
	private PasswordField txtPassword = new PasswordField();

	private HBox hboxRadioLogin = new HBox();

	private ToggleGroup opcoesLogin = new ToggleGroup();

	private RadioButton radioUser = new RadioButton("Estudante/Instrutor");
	private RadioButton radioAdmin = new RadioButton("Administrador");

	private HBox hboxBotoesAcoes = new HBox();

	private Button btnLogin = new Button("Login");
	private Button btnCadastrar = new Button("Cadastrar");
	
	private AdministradorController adminController = new AdministradorController(); 

	public LoginView() {

		try {
			this.logotipo = new Image(new FileInputStream("src/assets/images/logotipo-freetech-vertical.png"));
			logotipoView = new ImageView(logotipo);
			this.setTop(logotipoView);
			BorderPane.setAlignment(logotipoView, Pos.CENTER);
		} catch (FileNotFoundException e) {
			System.out.println("A imagem de logotipo não foi encontrada.");
			e.printStackTrace();
		}

		this.radioUser.setToggleGroup(opcoesLogin);
		this.radioUser.setMinWidth(200);
		this.radioAdmin.setToggleGroup(opcoesLogin);
		this.radioAdmin.setMinWidth(200);
		this.opcoesLogin.selectToggle(radioUser);

		this.hboxRadioLogin.getChildren().addAll(radioUser, radioAdmin);

		this.txtUsername.setPromptText("Digite o nome de usuário ou e-mail...");
		this.txtPassword.setPromptText("Digite a senha...");

		this.btnLogin.setOnAction(this);
		this.btnCadastrar.setOnAction(this);

		this.hboxBotoesAcoes.setAlignment(Pos.CENTER_RIGHT);
		this.hboxBotoesAcoes.getChildren().addAll(btnLogin, btnCadastrar);

		this.vboxLogin.setMaxWidth(400);
		this.vboxLogin.setSpacing(10);
		this.vboxLogin.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword, hboxRadioLogin,
				hboxBotoesAcoes);

		this.setCenter(vboxLogin);

	}
	
	private void alert(AlertType tipo, String title, String header, String content) {
		Alert alert = new Alert(tipo);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	@Override
	public void handle(ActionEvent event) {

		Scene cena = this.getScene();

		if (opcoesLogin.getSelectedToggle().equals(radioUser)) {
			if (event.getTarget() == btnCadastrar) {
				cena.setRoot(new EstudanteCadastroView(txtUsername.getText(), txtPassword.getText()));
				
			} else if (event.getTarget() == btnLogin) {
				System.out.println("Login");
			}
		} else {
			if (event.getTarget() == btnCadastrar) {
				cena.setRoot(new AdminCadastroView(txtUsername.getText(), txtPassword.getText()));

			} else if (event.getTarget() == btnLogin) {
				if(adminController.logarAdmin(txtUsername.getText(), txtPassword.getText())){
					cena.setRoot(new AdminDashboardView(adminController.idAdmin(txtUsername.getText())));
				}else{
					Alert alertaErro = new Alert(AlertType.ERROR, "Usuário ou senha inválidos.");
					alertaErro.show();
				}
			}
		}
	}
}
