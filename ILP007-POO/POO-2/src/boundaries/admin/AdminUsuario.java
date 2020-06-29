package boundaries.admin;

import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

import controllers.AdministradorController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Estudante;

public class AdminUsuario extends Group implements EventHandler<ActionEvent> {

	AdministradorController adminController = new AdministradorController();

	private Integer idAdmin;
	
	private VBox vboxCadastroUsuario = new VBox();

	private Label lblNome = new Label("Primeiro nome:");
	private TextField txtNome = new TextField();
	private Label lblSobrenome = new Label("Sobrenome:");
	private TextField txtSobrenome = new TextField();

	private Label lblTelefone = new Label("Telefone:");
	private TextField txtTelefone = new TextField();

	private Label lblDataNascimento = new Label("Data de nascimento:");
	private DatePicker dtNascimento = new DatePicker();

	private HBox hboxBotoesAcoes = new HBox();

	private CheckBox checkInstrutor = new CheckBox("É instrutor?");

	private Button btnCancelar = new Button("Cancelar");
	private Button btnExcluir = new Button("Excluir usuário");
	private Button btnSalvar = new Button("Salvar edições");


	public AdminUsuario(Integer idAdmin, String nomeUsuario, String sobrenomeUsuario, String telefoneUsuario,
			Date dataNascimentoUsuario, Boolean eInstrutor) {

		this.idAdmin = idAdmin;
		
		btnSalvar.setOnAction(this);
		btnExcluir.setOnAction(this);
		btnCancelar.setOnAction(this);

		txtNome.setText(nomeUsuario);
		txtSobrenome.setText(sobrenomeUsuario);
		txtTelefone.setText(telefoneUsuario);

		dtNascimento.setValue(dataNascimentoUsuario.toLocalDate());
		
		checkInstrutor.setSelected(eInstrutor);

		hboxBotoesAcoes.getChildren().addAll(btnCancelar, btnExcluir, btnSalvar);

		this.vboxCadastroUsuario.getChildren().addAll(lblNome, txtNome, lblSobrenome, txtSobrenome, lblTelefone,
				txtTelefone, lblDataNascimento, dtNascimento, checkInstrutor, hboxBotoesAcoes);
		this.getChildren().add(vboxCadastroUsuario);
	}

	public Estudante boundaryToEntity() {
		Estudante usuario = new Estudante();
		try {
			usuario.setNome(txtNome.getText());
			usuario.setSobrenome(txtSobrenome.getText());
			usuario.setTelefone(txtTelefone.getText());
			LocalDate dataLocal = dtNascimento.getValue();
			java.util.Date dataUtil = Date.from(dataLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			usuario.setDataNascimento(dataSql);
		} catch (Exception e) {
			System.out.println("Erro ao receber dados.");
		}
		return usuario;
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();
		if (event.getTarget() == btnSalvar) {
			adminController.editarEstudante(boundaryToEntity());
		} else if (event.getTarget() == btnCancelar) {
			cena.setRoot(new AdminCurso(this.idAdmin));
		}

	}

}
