package boundaries.admin;

import boundaries.LoginView;
import controllers.AulaController;
import controllers.CursoController;
import controllers.ExercicioController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Aula;
import model.entities.Exercicio;

public class AdminAulaView extends Group implements EventHandler<ActionEvent> {

	private CursoController cursoController = new CursoController();
	private AulaController aulaController = new AulaController();
	private ExercicioController exercicioController = new ExercicioController();
	private Integer idCurso;
	private Integer idAula;
	private Aula aula;
	
	private VBox vboxAula = new VBox();
	private HBox hboxAula = new HBox();

	private Label lblTituloAula = new Label("Título da aula:");
	private TextField txtTituloAula = new TextField();

	private Label lblDescricaoAula = new Label("Descrição da aula:");
	private TextArea txtDescricaoAula = new TextArea();

	private Label lblLinkVideo = new Label("Link do vídeo");
	private TextField txtLinkVideo = new TextField();

	private Label lblTranscricaoVideo = new Label("Transcrição do vídeo:");
	private TextArea txtTranscricaoVideo = new TextArea();

	private Label lblTempoVideo = new Label("Tempo do vídeo (em segundos):");
	private TextField txtTempoVideo = new TextField();

	private Button btnAdicionarExercicio = new Button("Adicionar exercício...");
	private Label lblExercicios = new Label("Exercícios");;
	private TableView<Exercicio> tableExercicios = new TableView<>(); // cursoController.carregarListaAulasAdmin(idCurso) Precisa adicionar o GET LISTA do controller
																		// aqui...;

	private Button btnCancelar = new Button("Cancelar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnSalvarAula = new Button("Salvar");

	public AdminAulaView(Integer idCurso) {

		this.idCurso = idCurso;
		
		btnAdicionarExercicio.setOnAction(this);
		btnCancelar.setOnAction(this);
		btnSalvarAula.setOnAction(this);
	
		this.setPromtTexts();
		this.gerarTabela();

		this.txtDescricaoAula.setMaxHeight(100);

		this.hboxAula.getChildren().addAll(btnCancelar, btnExcluir, btnSalvarAula);

		this.vboxAula.setPadding(new Insets(20));
		this.vboxAula.getChildren().addAll(lblTituloAula, txtTituloAula, lblDescricaoAula, txtDescricaoAula,
				lblLinkVideo, txtLinkVideo, lblTranscricaoVideo, txtTranscricaoVideo, lblTempoVideo, txtTempoVideo,
				lblExercicios, btnAdicionarExercicio, tableExercicios, hboxAula);

		this.getChildren().add(vboxAula);

	}

	private void gerarTabela() {

		TableColumn<Exercicio, String> colTituloExercicio = new TableColumn<>("Título do Exercício");
		colTituloExercicio.setCellValueFactory(new PropertyValueFactory<Exercicio, String>("tituloExercicio"));

		tableExercicios.getColumns().add(colTituloExercicio);
		tableExercicios.setMaxHeight(120);
		
		tableExercicios.setRowFactory(tv -> {
			TableRow<Exercicio> row = new TableRow<>();
			row.setOnMouseClicked(e -> {
				Exercicio exec = row.getItem();
				Scene cena = this.getScene();
				cena.setRoot(new AdminExercicioView(3));
			});
			return row;
		});
		

	}

	private void setPromtTexts() {
		this.txtTituloAula.setPromptText("Digite o título da aula...");
		this.txtDescricaoAula.setPromptText("Digite a descrição do conteúdo desta aula");
		this.txtLinkVideo.setPromptText("Digite o link de embed do vídeo fornecido pelo YouTube...");
	}

	@Override
	public void handle(ActionEvent event) {

		Scene cena = this.getScene();

		if (event.getTarget() == btnAdicionarExercicio) {
			cena.setRoot(new AdminExercicioView(3)); // Aqui talvez tenha que passar ID da aula	
			//aulaController.adicionarExercicio(this.boundaryToEntity().setExercicios(exercicio);)
			//exercicioController.cadastrarExercicio(exercicio);
		} else if (event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new AdminCursoView(this.idCurso));
		} else if (event.getTarget().equals(btnExcluir)) {
			aulaController.removerAula(4); // modificar idAula
		} else if (event.getTarget().equals(btnSalvarAula)) {
			aulaController.adicionarAula(this.boundaryToEntity());
		}
	}
	
	public void entityToBoundary(Aula aula) {
		if (aula != null) {
			txtTituloAula.setText(String.valueOf(aula.getTitulo()));
			txtDescricaoAula.setText(String.valueOf(aula.getDescricao()));
			txtLinkVideo.setText(String.valueOf(aula.getLinkVideo()));
			txtTranscricaoVideo.setText(String.valueOf(aula.getTranscricaoVideo()));
			//txtTempoVideo.setText(Integer.parseInt(aula.getTempoVideo()));
		}
	}

	//só pode ser chamado ao atualizar a aula
	public Aula boundaryToEntity() {
		try {
			Aula aula = new Aula();
			aula.setTitulo(txtTituloAula.getText());
			aula.setDescricao(txtDescricaoAula.getText());
			aula.setLinkVideo(txtLinkVideo.getText());
			aula.setTranscricaoVideo(txtTranscricaoVideo.getText());
			aula.setTempoVideo(Integer.parseInt(txtTempoVideo.getText()));			//aula.setExercicios(exercicios);
			//aula.setExercicios(exercicios); //recebe uma lista de exercicios já montada (ou nenhum exercício)
		} catch (Exception e) {
			System.out.println("Erro ao receber dados.");
		}

		return aula;
	}
}