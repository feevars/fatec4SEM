package boundaries.admin;

import controllers.AdministradorController;
import controllers.CursoController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

	private Integer idAdmin;

	private GridPane gpInfoHeader = new GridPane();
	
	private Label lblTituloCurso = new Label("Título do curso:");
	private TextField txtTituloCurso = new TextField();

	private Label lblDescricaoCurso = new Label("Descrição do curso:");
	private TextArea txtDescricaoCurso = new TextArea();

	private VBox vboxInstrutores = new VBox();
	
	private Label lblInstrutores = new Label("Instrutor(es):");
	private ListView<Instrutor> listInstrutores = new ListView<>(adminController.listarTodosInstrutores()); // Precisa adicionar o GET LISTA do controller
	
	private VBox vboxAulas = new VBox();
	
	private Button btnAdicionarPrimeiraAula = new Button("Adicionar primeira aula...");

	private Label lblAulas = new Label("Aulas:");
	private Button btnAdicionarAula = new Button("Adicionar aula...");
	private TableView<Aula> tableAulas = new TableView<>(); // Precisa adicionar o GET LISTA do controller aqui...;;

	private HBox hboxBotesAcoes = new HBox();

	private Button btnExcluirCurso = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private Button btnSalvarCurso = new Button("Salvar");

	//Construtor feito para cadastrar o curso
	public AdminCursoView(Integer idAdmin) {

		this.idAdmin = idAdmin;
		
		setPromtTexts();
		gerarTabelaInstrutores();

		gpInfoHeader.add(lblTituloCurso, 0, 0);
		gpInfoHeader.add(txtTituloCurso, 1, 0);
		gpInfoHeader.add(lblDescricaoCurso, 0, 1);;
		gpInfoHeader.add(txtDescricaoCurso, 1, 1);
		
		vboxInstrutores.getChildren().addAll(lblInstrutores, listInstrutores);
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
	
	//Construtor feito para editar o curso...
	public AdminCursoView(Integer idAdmin, Integer idCurso) {
		
	}

	public void gerarTabelaInstrutores() {
//		TableColumn<Instrutor, String> colNomeInstrutor = new TableColumn<>("Instrutor(a)");
//		colNomeInstrutor.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("nomeInstrutor")); // Precisa
																											// conferir
		listInstrutores.setMaxHeight(200);

	}

	public void gerarTabelaAulas() {
		TableColumn<Aula, String> colTituloAula = new TableColumn<>("Título da Aula");
		colTituloAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("tituloAula")); // Precisa conferir

		tableAulas.setMaxHeight(200);
		tableAulas.getColumns().add(colTituloAula);
	}

	private void setPromtTexts() {
		txtTituloCurso.setPromptText("Digite o título do curso...");
		txtDescricaoCurso.setPromptText("Digite a descrição do curso...");
	}

	public Curso boundaryToEntity() {
		Curso curso = new Curso();
		curso.setTitulo(txtTituloCurso.getText());
		curso.setDescricao(txtDescricaoCurso.getText());
		return curso;
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();

		if (event.getTarget().equals(btnAdicionarAula)) {

		} else if (event.getTarget().equals(btnSalvarCurso)) {

		} else if (event.getTarget().equals(btnExcluirCurso)) {
			// cursoController.excluirCurso(idCurso);
		} else if (event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new AdminDashboardView(this.idAdmin));
		}

	}

}