package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import controller.CursoController;
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
import model.entities.Curso;

public class CursoBoundary extends BorderPane implements EventHandler<ActionEvent> {

	private CursoController CursoController = new CursoController();

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

	private VBox vboxTabelaCursos = new VBox();
	private Label lblTodosOsCursos = new Label("Todos os Cursos: ");
	private TableView<Curso> tabelaCursos;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public CursoBoundary() {

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

		vboxTabelaCursos.getChildren().addAll(lblTodosOsCursos, tabelaCursos);

		this.setLeft(vboxFormulario);
		this.setCenter(vboxTabelaCursos);
	}

	private void gerarTabela() {
		tabelaCursos = new TableView<Curso>(CursoController.listarCursos());

		TableColumn<Curso, Integer> colId = new TableColumn<>("Id: ");
		colId.setCellValueFactory(new PropertyValueFactory<Curso, Integer>("id"));

		TableColumn<Curso, String> colRa = new TableColumn<>("RA: ");
		colRa.setCellValueFactory(new PropertyValueFactory<Curso, String>("ra"));

		TableColumn<Curso, String> colNome = new TableColumn<>("Nome: ");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("nome"));

		TableColumn<Curso, Date> colNascimento = new TableColumn<>("Data de nascimento: ");
		colNascimento.setCellValueFactory(new PropertyValueFactory<Curso, Date>("nascimento"));

		tabelaCursos.getColumns().add(colId);
		tabelaCursos.getColumns().add(colRa);
		tabelaCursos.getColumns().add(colNome);
		tabelaCursos.getColumns().add(colNascimento);

		tabelaCursos.setOnMouseClicked(e -> {
			if (tabelaCursos.getSelectionModel().getSelectedItem() != null) {
				entityToBoundary(tabelaCursos.getSelectionModel().getSelectedItem().getRa());
			}
		});
	}

	private Curso boundaryToEntity() {
		Curso novoCurso = new Curso(null, txtRa.getText(), txtNome.getText(), dateNascimento.getValue());
		return novoCurso;
	}

	private void entityToBoundary(String ra) {
		Curso Curso = CursoController.exibirCurso(ra);
		if (Curso != null) {
			txtRa.setText(Curso.getRa());
			txtNome.setText(Curso.getNome());
			if (Curso.getNascimento() != null) {
				dateNascimento.setValue(Curso.getNascimento());
			}
		}
	}
	
	private void limparTabela() {
		tabelaCursos.getItems().clear();
		tabelaCursos.setItems(CursoController.listarCursos());
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
			Curso Curso2 = CursoController.exibirCurso(boundaryToEntity().getRa());

			if (Curso2 == null) {
				Integer novoId = CursoController.cadastrarCurso(boundaryToEntity());
				if (novoId != null) {
					Alert alertCadastroSucesso = new Alert(AlertType.INFORMATION,
							"Curso de RA " + novoId + " cadastrado com sucesso!");
					alertCadastroSucesso.show();
					limparTabela();
				} else {
					Alert alertCadastroErro = new Alert(AlertType.ERROR, "Erro ao cadastrar Curso.");
					alertCadastroErro.show();
				}
			} else {
				if (CursoController.atualizarCurso(boundaryToEntity())) {
					Alert alertAtualizadoSucesso = new Alert(AlertType.INFORMATION,
							"Curso de RA " + Curso2.getRa() + " atualizado com sucesso!");
					alertAtualizadoSucesso.show();
					limparTabela();
				} else {
					Alert alertAtualizaErro = new Alert(AlertType.ERROR, "Erro ao editar Curso.");
					alertAtualizaErro.show();
				}
			}
		}
		
		if (event.getTarget().equals(btnExcluir)) {
			cursoController.excluirCurso(boundaryToEntity().getRa());
			limparTabela();
		}
	}
}
