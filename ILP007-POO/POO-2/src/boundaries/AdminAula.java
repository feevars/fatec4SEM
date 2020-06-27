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

	private AulaController aulaController;
	
	private VBox vboxAula;
	
	private Label lblTituloAula;
	private TextField txtTituloAula;
	
	private Label lblDescricaoAula;
	private TextArea txtDescricaoAula;
	
	private Label lblLinkVideo;
	private TextField txtLinkVideo;
	
	private Label lblTranscricaroVideo;
	private TextArea txtTranscricaoVideo;
	
	private Button btnAdicionarExercicio;
	private Label lblExercicios;
	private TableView<Exercicio> tableExercicios;
	
	private Button btnCancelar;
	private Button btnExcluir;
	private Button btnSalvarAula;
	
	public AdminAula() {
		
		super();
		
		this.aulaController = new AulaController();
		
		this.vboxAula = new VBox();
		
		this.lblTituloAula = new Label("Título da aula:");
		this.txtTituloAula = new TextField();
		this.txtTituloAula.setPromptText("Digite o título da aula...");
		
		this.lblDescricaoAula = new Label("Descrição da aula:");
		this.txtDescricaoAula = new TextArea();
		this.txtDescricaoAula.setPromptText("Digite a descrição do conteúdo desta aula");
		
		this.lblLinkVideo = new Label("Link do vídeo");
		this.txtLinkVideo = new TextField();
		this.txtLinkVideo.setPromptText("Digite o link de embed do vídeo fornecido pelo YouTube...");
		
		this.lblTranscricaroVideo = new Label("Transcrição do vídeo:");
		this.txtTranscricaoVideo = new TextArea();
		
		this.btnAdicionarExercicio = new Button("Adicionar exercício...");
		this.lblExercicios = new Label("Exercícios");
		this.tableExercicios = new TableView<>(); //Precisa adicionar o GET LISTA do controller aqui...
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
}
