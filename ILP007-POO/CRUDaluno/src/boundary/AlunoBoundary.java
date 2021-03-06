package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import controller.AlunoController;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Aluno;

public class AlunoBoundary extends BorderPane implements EventHandler<ActionEvent> {

	private AlunoController alunoController = new AlunoController();

	private VBox vboxFormulario = new VBox();

	private HBox hboxRa = new HBox();
	private Label lblRa = new Label("Ra: ");
	private TextField txtRa = new TextField();

	private HBox hboxNome = new HBox();
	private Label lblNome = new Label("Nome: ");
	private TextField txtNome = new TextField();

	private VBox vboxNascimento = new VBox();
	private Label lblNascimento = new Label("Data de Nascimento: ");
	private Label lblIdade = new Label();
	private DatePicker dateNascimento = new DatePicker();

	private HBox hboxBotoes = new HBox();
	private Button btnExcluir = new Button("Excluir");
	private Button btnSalvar = new Button("Salvar");

	private VBox vboxTabelaAlunos = new VBox();
	private Label lblTodosOsAlunos = new Label("Todos os alunos: ");
	private TableView<Aluno> tabelaAlunos;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AlunoBoundary() {

		gerarTela();
	}

	private void gerarTela() {

		txtRa.setPromptText("RA...");
		hboxRa.getChildren().addAll(lblRa, txtRa);

		txtNome.setPromptText("Nome...");
		hboxNome.getChildren().addAll(lblNome, txtNome);

		vboxNascimento.getChildren().addAll(lblNascimento, dateNascimento, lblIdade);

		btnExcluir.setOnAction(this);
		btnSalvar.setOnAction(this);
		hboxBotoes.getChildren().addAll(btnExcluir, btnSalvar);

		vboxFormulario.getChildren().addAll(hboxRa, hboxNome, vboxNascimento, hboxBotoes);

		gerarTabela();

		vboxTabelaAlunos.getChildren().addAll(lblTodosOsAlunos, tabelaAlunos);

		this.setLeft(vboxFormulario);
		this.setCenter(vboxTabelaAlunos);
	}

	private void gerarTabela() {
		tabelaAlunos = new TableView<Aluno>(alunoController.listarAlunos());

		TableColumn<Aluno, Integer> colId = new TableColumn<>("Id: ");
		colId.setCellValueFactory(new PropertyValueFactory<Aluno, Integer>("id"));

		TableColumn<Aluno, String> colRa = new TableColumn<>("RA: ");
		colRa.setCellValueFactory(new PropertyValueFactory<Aluno, String>("ra"));

		TableColumn<Aluno, String> colNome = new TableColumn<>("Nome: ");
		colNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));

		TableColumn<Aluno, Date> colNascimento = new TableColumn<>("Data de nascimento: ");
		colNascimento.setCellValueFactory(new PropertyValueFactory<Aluno, Date>("nascimento"));

		tabelaAlunos.getColumns().add(colId);
		tabelaAlunos.getColumns().add(colRa);
		tabelaAlunos.getColumns().add(colNome);
		tabelaAlunos.getColumns().add(colNascimento);

		tabelaAlunos.setOnMouseClicked(e -> {
			if (tabelaAlunos.getSelectionModel().getSelectedItem() != null) {
				entityToBoundary(tabelaAlunos.getSelectionModel().getSelectedItem().getRa());
			}
		});
	}

	private Aluno boundaryToEntity() {
		Aluno novoAluno = new Aluno(null, txtRa.getText(), txtNome.getText(), dateNascimento.getValue());
		return novoAluno;
	}

	private void entityToBoundary(String ra) {
		Aluno aluno = alunoController.exibirAluno(ra);
		if (aluno != null) {
			txtRa.setText(aluno.getRa());
			txtNome.setText(aluno.getNome());
			if (aluno.getNascimento() != null) {
				dateNascimento.setValue(aluno.getNascimento());
			}
		}
	}
	
	private void limparTabela() {
		tabelaAlunos.getItems().clear();
		tabelaAlunos.setItems(alunoController.listarAlunos());
		limparCampos();
	}
	
	private void limparCampos() {
		txtRa.clear();
		txtNome.clear();
		dateNascimento.setValue(null);
	}

	@Override
	public void handle(ActionEvent event) {

		if (event.getTarget().equals(btnSalvar)) {
			Aluno aluno2 = alunoController.exibirAluno(boundaryToEntity().getRa());

			if (aluno2 == null) {
				Integer novoId = alunoController.cadastrarAluno(boundaryToEntity());
				if (novoId != null) {
					Alert alertCadastroSucesso = new Alert(AlertType.INFORMATION,
							"Aluno de RA " + novoId + " cadastrado com sucesso!");
					alertCadastroSucesso.show();
					limparTabela();
				} else {
					Alert alertCadastroErro = new Alert(AlertType.ERROR, "Erro ao cadastrar aluno.");
					alertCadastroErro.show();
				}
			} else {
				if (alunoController.atualizarAluno(boundaryToEntity())) {
					Alert alertAtualizadoSucesso = new Alert(AlertType.INFORMATION,
							"Aluno de RA " + aluno2.getRa() + " atualizado com sucesso!");
					alertAtualizadoSucesso.show();
					limparTabela();
				} else {
					Alert alertAtualizaErro = new Alert(AlertType.ERROR, "Erro ao editar aluno.");
					alertAtualizaErro.show();
				}
			}
		}
		
		if (event.getTarget().equals(btnExcluir)) {
			alunoController.excluirAluno(boundaryToEntity().getRa());
			limparTabela();
		}
	}
}
