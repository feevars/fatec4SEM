package boundaries.admin;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import controllers.AdministradorController;
import controllers.AulaController;
import controllers.CursoController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	CursoController cursoController = new CursoController();
	AulaController aulaController = new AulaController();

	private Integer idAdmin;
	private Integer idCurso;
	private Integer numeroNovaAula;

	private GridPane gpInfoHeader = new GridPane();

	private Label lblTituloCurso = new Label("Título do curso:");
	private TextField txtTituloCurso = new TextField();

	private Label lblDescricaoCurso = new Label("Descrição do curso:");
	private TextArea txtDescricaoCurso = new TextArea();

	private VBox vboxInstrutores = new VBox();

	private Label lblInstrutores = new Label("Instrutor(es):");
	private TableView<Instrutor> tableInstrutores;
	private Label lblAjudaInstrutor = new Label(
			"*Segure o shift e clique na linha para selecionar mais de um instrutor.");

	private VBox vboxAulas = new VBox();
	private HBox hboxTabelas = new HBox();

	private Button btnAdicionarPrimeiraAula = new Button("Adicionar primeira aula...");

	private Label lblAulas = new Label("Aulas:");
	private Button btnAdicionarAula = new Button("Adicionar aula...");
	private TableView<Aula> tableAulas;

	private HBox hboxBotesAcoes = new HBox();

	private Button btnExcluirCurso = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private Button btnSalvarCurso = new Button("Salvar");

	private Set<Instrutor> autoresCurso = new HashSet<Instrutor>();
	private Set<Aula> aulasCurso = new HashSet<Aula>();

	// Construtor feito para cadastrar o curso
	public AdminCursoView(Integer adminId) {

		this.idAdmin = adminId;
		setPromtTexts();
		gerarTabelaInstrutores();

		gpInfoHeader.add(lblTituloCurso, 0, 0);
		gpInfoHeader.add(txtTituloCurso, 1, 0);
		gpInfoHeader.add(lblDescricaoCurso, 0, 1);
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
	public AdminCursoView(Integer adminId, Integer idCurso) {
		this.idAdmin = adminId;
		this.idCurso = idCurso;
		this.autoresCurso = cursoController.carregaInstrutoresCurso(idCurso);
		this.aulasCurso = cursoController.carregaAulasCurso(idCurso);
		System.out.println(this.idCurso);

		
		entityToBoundary();
		gerarTabelaInstrutores();
		gerarTabelaAulas();

		gpInfoHeader.add(lblTituloCurso, 0, 0);
		gpInfoHeader.add(txtTituloCurso, 1, 0);
		gpInfoHeader.add(lblDescricaoCurso, 0, 1);
		;
		gpInfoHeader.add(txtDescricaoCurso, 1, 1);

		vboxInstrutores.getChildren().addAll(lblInstrutores, tableInstrutores, lblAjudaInstrutor);
		vboxAulas.getChildren().addAll(lblAulas, tableAulas, btnAdicionarAula);
		hboxTabelas.getChildren().addAll(vboxInstrutores, vboxAulas);
		hboxTabelas.setAlignment(Pos.CENTER);

		hboxBotesAcoes.getChildren().addAll(btnCancelar, btnExcluirCurso, btnSalvarCurso);

		btnAdicionarAula.setOnAction(this);
		btnCancelar.setOnAction(this);
		btnExcluirCurso.setOnAction(this);
		btnSalvarCurso.setOnAction(this);

		this.setTop(gpInfoHeader);
		this.setLeft(vboxInstrutores);
		this.setCenter(vboxAulas);
		this.setBottom(hboxBotesAcoes);
	}

	public void gerarTabelaInstrutores() {

		tableInstrutores = new TableView<>(adminController.listarTodosInstrutores());

		TableColumn<Instrutor, String> colUsername = new TableColumn<>("Username");
		colUsername.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("username"));

		TableColumn<Instrutor, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("nome"));

		TableColumn<Instrutor, String> colSobrenome = new TableColumn<>("Sobrenome");
		colSobrenome.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("sobrenome"));

		tableInstrutores.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		if (idCurso != null)
			for (Instrutor i : tableInstrutores.getItems()) {
				for (Instrutor j : adminController.getListInstrutorCurso(idCurso)) {
					if (i.getId() == j.getId())
						tableInstrutores.getSelectionModel().select(i);
				}
			}

		tableInstrutores.setMaxHeight(200);
		tableInstrutores.setMinWidth(400);
		tableInstrutores.getColumns().add(colUsername);
		tableInstrutores.getColumns().add(colNome);
		tableInstrutores.getColumns().add(colSobrenome);
	}

	public void gerarTabelaAulas() {

		tableAulas = new TableView<>(adminController.listarAulasCurso(idCurso));

		TableColumn<Aula, String> colTituloAula = new TableColumn<>("Título");
		colTituloAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("titulo"));

		TableColumn<Aula, String> colDescricaoAula = new TableColumn<>("Descrição");
		colDescricaoAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("descricao"));

		tableAulas.setMaxHeight(200);
		tableAulas.getColumns().add(colTituloAula);
		tableAulas.getColumns().add(colDescricaoAula);

		tableAulas.setOnMouseClicked(event -> {
			if (tableAulas.getSelectionModel().getSelectedItem() != null) {
				Scene cena = this.getScene();
				cena.setRoot(new AdminAulaView(idAdmin, aulaController.getAulaPorId(tableAulas.getSelectionModel().getSelectedItem().getId())));
			}
		});

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
		autoresCurso.addAll(oListAutores);
		curso.setInstrutores(autoresCurso);
		return curso;
	}

	public Curso entityToBoundary() {
		Curso curso = cursoController.getCursoPorId(idCurso);
		txtTituloCurso.setText(curso.getTitulo());
		txtDescricaoCurso.setText(curso.getDescricao());
		numeroNovaAula = curso.getAulas().size() + 1;
		return curso;
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();

		if (event.getTarget().equals(btnAdicionarPrimeiraAula)) {

			Curso curso = boundaryToEntityCadastro();
			if (!curso.getInstrutores().isEmpty()) {
				cena.setRoot(new AdminAulaView(idAdmin, curso));
			} else {
				Alert alertaInstrutor = new Alert(AlertType.ERROR, "Você precisa escoher pelo menos um instrutor...");
				alertaInstrutor.show();
			}

		} else if (event.getTarget().equals(btnSalvarCurso)) {

			Curso c = entityToBoundary();
			if (cursoController.editarCurso(c)) {
				Alert alertaEdicaoCursoOk = new Alert(AlertType.INFORMATION, "Curso Editado com sucesso!");
				alertaEdicaoCursoOk.show();
			} else {
				Alert alertaEdicaoCursoErro = new Alert(AlertType.ERROR, "Erro ao editar Curso");
				alertaEdicaoCursoErro.show();
			}

		} else if (event.getTarget().equals(btnExcluirCurso)) {

			Alert alertExcluir = new Alert(AlertType.CONFIRMATION);
			alertExcluir.setTitle("Excluir curso");
			alertExcluir.setHeaderText("Você está prestes a excluir o Curso " + txtTituloCurso.getText());
			alertExcluir.setContentText(
					"Serão deletados o registro da tabela Curso, os registros da tabela InstrutorCurso, os registros deste curso na tabela de Aulas e os exercícios das aulas deste curso. Você confirma esta operação?");

			Optional<ButtonType> result = alertExcluir.showAndWait();
			if (result.get() == ButtonType.OK) {

				if (cursoController.excluirCurso(idCurso)) {
					Alert alertaExclusaoCursoOk = new Alert(AlertType.INFORMATION, "Curso Excluido!");
					alertaExclusaoCursoOk.show();
					cena.setRoot(new AdminDashboardView(this.idAdmin));
				} else {
					Alert alertaEdicaoCrusoErro = new Alert(AlertType.ERROR, "Erro ao Excluir Curso");
					alertaEdicaoCrusoErro.show();
				}

			}

		} else if (event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new AdminDashboardView(idAdmin));

		} else if (event.getTarget().equals(btnAdicionarAula)) {
			Curso curso = entityToBoundary();
			cena.setRoot(new AdminAulaView(idAdmin, curso.getId(), numeroNovaAula));
		}

	}

}