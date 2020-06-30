package boundaries.admin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Aula;
import model.entities.Instrutor;

public class AdminCursoView extends Group implements EventHandler<ActionEvent> {

	private VBox vboxCurso = new VBox();

	private Label lblTituloCurso = new Label("Título do curso:");
	private TextField txtTituloCurso = new TextField();

	private Label lblDescricaoCurso = new Label("Descrição do curso:");
	private TextArea txtDescricaoCurso = new TextArea();

	private Label lblInstrutores = new Label("Instrutor(es):");
	private TableView<Instrutor> tableInstrutores = new TableView<>(); // Precisa adicionar o GET LISTA do controller
																		// aqui...;;

	private Label lblAulas = new Label("Aulas:");
	private Button btnAdicionarAula = new Button("Adicionar aula...");
	private TableView<Aula> tableAulas = new TableView<>(); // Precisa adicionar o GET LISTA do controller aqui...;;

	private HBox hboxBotesAcoes = new HBox();
	
	private Button btnExcluirCurso = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private Button btnSalvarCurso = new Button("Salvar");

	public AdminCursoView(Integer idAdmin) {

		this.setPromtTexts();
		this.gerarTabelaInstrutores();
		this.gerarTabelaAulas();

		this.hboxBotesAcoes.getChildren().addAll(btnExcluirCurso, btnCancelar, btnSalvarCurso);
		this.vboxCurso.setPadding(new Insets(20));
		
		this.vboxCurso.getChildren().addAll(lblTituloCurso, txtTituloCurso, lblDescricaoCurso, txtDescricaoCurso,
				lblInstrutores, tableInstrutores, lblAulas, btnAdicionarAula, tableAulas, hboxBotesAcoes);
		
		this.getChildren().add(vboxCurso);

	}

	public void gerarTabelaInstrutores() {
		TableColumn<Instrutor, String> colNomeInstrutor = new TableColumn<>("Instrutor(a)");
		colNomeInstrutor.setCellValueFactory(new PropertyValueFactory<Instrutor, String>("nomeInstrutor")); // Precisa
																											// conferir
		tableInstrutores.setMaxHeight(200);
		tableInstrutores.getColumns().addAll(colNomeInstrutor);
	}

	public void gerarTabelaAulas() {
		TableColumn<Aula, String> colTituloAula = new TableColumn<>("Título da Aula");
		colTituloAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("tituloAula")); // Precisa conferir
		
		tableAulas.setMaxHeight(200);
		tableAulas.getColumns().addAll(colTituloAula);
	}

	private void setPromtTexts() {
		txtTituloCurso.setPromptText("Digite o título do curso...");
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
