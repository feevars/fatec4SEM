package boundaries.admin;

import java.util.HashSet;
import java.util.Set;

import controllers.AdministradorController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public class AdminCursoView extends BorderPane implements EventHandler<ActionEvent> {

	AdministradorController adminController = new AdministradorController();

	private Integer idAdmin;

	private GridPane gpInfoHeader = new GridPane();

	private Label lblTituloCurso = new Label("Título do curso:");
	private TextField txtTituloCurso = new TextField();

	private Label lblDescricaoCurso = new Label("Descrição do curso:");
	private TextArea txtDescricaoCurso = new TextArea();

	private VBox vboxInstrutores = new VBox();

	private Label lblInstrutores = new Label("Instrutor(es):");
	private TableView<Instrutor> tableInstrutores = new TableView<>(adminController.listarTodosInstrutores());
	private Label lblAjudaInstrutor = new Label(
			"*Segure o shift e clique na linha para selecionar mais de um instrutor.");

	private VBox vboxAulas = new VBox();

	private Button btnAdicionarPrimeiraAula = new Button("Adicionar primeira aula...");

	private Label lblAulas = new Label("Aulas:");
	private Button btnAdicionarAula = new Button("Adicionar aula...");
	private TableView<Aula> tableAulas = new TableView<>();

	private HBox hboxBotesAcoes = new HBox();

	private Button btnExcluirCurso = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private Button btnSalvarCurso = new Button("Salvar");

	private Set<Instrutor> autores = new HashSet<Instrutor>();

	// Construtor feito para cadastrar o curso
	public AdminCursoView(Integer idAdmin) {

		this.idAdmin = idAdmin;

		setPromtTexts();
		gerarTabelaInstrutores();

		gpInfoHeader.add(lblTituloCurso, 0, 0);
		gpInfoHeader.add(txtTituloCurso, 1, 0);
		gpInfoHeader.add(lblDescricaoCurso, 0, 1);
		;
		gpInfoHeader.add(txtDescricaoCurso, 1, 1);

		vboxInstrutores.getChildren().addAll(lblInstrutores, tableInstrutores, lblAjudaInstrutor);
		vboxAulas.getChildren().add(btnAdicionarPrimeiraAula);
		vboxAulas.setAlignment(Pos.CENTER);

		hboxBotesAcoes.getChildren().addAll(btnCancelar);

		btnCancelar.setOnAction(this);
		btnAdicionarPrimeiraAula.setOnAction(this);

		this.setTop(gpInfoHeader);
		this.setLeft(vboxInstrutores);
		this.setCenter(vboxAulas);
		this.setBottom(hboxBotesAcoes);
	}

	// Construtor feito para editar o curso...
	public AdminCursoView(Integer idAdmin, Integer idCurso) {

	}

	public void gerarTabelaInstrutores() {
		TableColumn<Instrutor, String> colUsername = new TableColumn<>("Username");
		colUsername.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("username"));

		TableColumn<Instrutor, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("nome"));

		TableColumn<Instrutor, String> colSobrenome = new TableColumn<>("Sobrenome");
		colSobrenome.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("sobrenome"));

		tableInstrutores.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableInstrutores.setMaxHeight(200);
		tableInstrutores.setMinWidth(400);
		tableInstrutores.getColumns().add(colUsername);
		tableInstrutores.getColumns().add(colNome);
		tableInstrutores.getColumns().add(colSobrenome);
	}

	public void gerarTabelaAulas() {
		TableColumn<Aula, String> colTituloAula = new TableColumn<>("Título da Aula");
		colTituloAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("tituloAula"));

		tableAulas.setMaxHeight(200);
		tableAulas.getColumns().add(colTituloAula);
	}

	private void setPromtTexts() {
		txtTituloCurso.setPromptText("Digite o título do curso...");
		txtDescricaoCurso.setPromptText("Digite a descrição do curso...");
	}

	public Curso boundaryToEntityCadastro() {
		Curso curso = new Curso();
		curso.setTitulo(txtTituloCurso.getText());
		curso.setDescricao(txtDescricaoCurso.getText());
		ObservableList<Instrutor> oListAutores = tableInstrutores.getSelectionModel().getSelectedItems();
		autores.addAll(oListAutores);
		curso.setInstrutores(autores);
		return curso;
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();

		if (event.getTarget().equals(btnAdicionarPrimeiraAula)) {
			Curso curso = boundaryToEntityCadastro();
			if (!curso.getInstrutores().isEmpty()) {
				cena.setRoot(new AdminAulaView(curso));
			} else {
				Alert alertaInstrutor = new Alert(AlertType.ERROR, "Você precisa escoher pelo menos um instrutor...");
				alertaInstrutor.show();
			}
		} else if (event.getTarget().equals(btnSalvarCurso)) {

		} else if (event.getTarget().equals(btnExcluirCurso)) {
			// cursoController.excluirCurso(idCurso);
		} else if (event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new AdminDashboardView(this.idAdmin));
		}

	}

}