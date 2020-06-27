package boundaries;

import controllers.AulaController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.entities.Exercicio;

public class AdminAula extends Group {

	private AulaController aulaController = new AulaController();
	
	private VBox vboxAula = new VBox();
	
	private Label lblTituloAula = new Label("Título da aula:");
	private TextField txtTituloAula = new TextField();
	
	private Label lblDescricaoAula = new Label("Descrição da aula:");
	private TextArea txtDescricaoAula = new TextArea();
	
	private Label lblLinkVideo = new Label("Link do vídeo");
	private TextField txtLinkVideo = new TextField();
	
	private Label lblTranscricaroVideo = new Label("Transcrição do vídeo:");
	private TextArea txtTranscricaoVideo = new TextArea();
	
	private Button btnAdicionarExercicio = new Button("Adicionar exercício...");
	private Label lblExercicios = new Label("Exercícios");;
	private TableView<Exercicio> tableExercicios = new TableView<>(); //Precisa adicionar o GET LISTA do controller aqui...;
	
	private Button btnCancelar = new Button("Cancelar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnSalvarAula = new Button("Salvar");
	
	public AdminAula() {
		
		super();

		this.setPromtTexts();
		this.gerarTabela();
		
		this.vboxAula.setPadding(new Insets(20));
		this.vboxAula.getChildren().addAll(lblTituloAula, txtTituloAula, lblDescricaoAula, txtDescricaoAula, lblLinkVideo, txtLinkVideo, lblTranscricaroVideo, txtTranscricaoVideo, lblExercicios, btnAdicionarExercicio, tableExercicios);
		
		
		this.getChildren().add(vboxAula);
		
	}
	
	private void gerarTabela() {
		
		TableColumn<Exercicio, String> colTituloExercicio = new TableColumn<>("Título do Exercício");
		colTituloExercicio.setCellValueFactory(new PropertyValueFactory<Exercicio, String>("tituloExercicio"));
		
		tableExercicios.getColumns().addAll(colTituloExercicio);
		
	}
	
	private void setPromtTexts() {
		this.txtTituloAula.setPromptText("Digite o título da aula...");
		this.txtDescricaoAula.setPromptText("Digite a descrição do conteúdo desta aula");
		this.txtLinkVideo.setPromptText("Digite o link de embed do vídeo fornecido pelo YouTube...");
	}
}
