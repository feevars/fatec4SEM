package boundaries.admin;
import controllers.AulaController;
import controllers.CursoController;
import controllers.ExercicioController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Exercicio;

public class AdminAulaView extends BorderPane implements EventHandler<ActionEvent> {

	private CursoController cursoController = new CursoController();
	private AulaController aulaController = new AulaController();
	private ExercicioController exercicioController = new ExercicioController();
	private Integer idCurso;
	private Integer idAula;

	private Label lblTituloCurso = new Label("nome do curso");

	private VBox vboxInfoAula = new VBox();

	private Label lblTituloAula = new Label("Título da aula:");
	private TextField txtTituloAula = new TextField();

	private Label lblDescricaoAula = new Label("Descrição da aula:");
	private TextArea txtDescricaoAula = new TextArea();

	private VBox vboxInfoVideo = new VBox();

	private Label lblLinkVideo = new Label("Link do vídeo");
	private TextField txtLinkVideo = new TextField();

	private Label lblTranscricaoVideo = new Label("Transcrição do vídeo:");
	private TextArea txtTranscricaoVideo = new TextArea();

	private Label lblTempoVideo = new Label("Tempo do vídeo (em segundos):");
	private TextField txtTempoVideo = new TextField();

	private Button btnAdicionarExercicio = new Button("Adicionar exercício...");
	private Label lblExercicios = new Label("Exercícios");;
	private TableView<Exercicio> tableExercicios = new TableView<>(); // cursoController.carregarListaAulasAdmin(idCurso)
																		// Precisa adicionar o GET LISTA do controller
	private HBox hboxBotoesAcoes = new HBox();

	private Button btnCancelarCadastroCurso = new Button("Cancelar cadastro deste curso");
	private Button btnCadastrarCurso = new Button("Cadastrar curso");

	private Button btnCancelar = new Button("Cancelar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnSalvarAula = new Button("Salvar");

	private Curso curso;
	
	private Integer idAdmin;
	
	//Esse construtor é para cadastrar nova aula junto a um curso --- aula ainda sem id
	public AdminAulaView(Integer idAdmin, Curso curso) {
		
		this.curso = curso;
		
		setPromtTexts();
		gerarTabelaExercicios();

		lblTituloCurso.setText(curso.getTitulo() + " - " + curso.getDescricao());
		
		btnCadastrarCurso.setOnAction(this);
		btnCancelarCadastroCurso.setOnAction(this);

		txtDescricaoAula.setMaxHeight(100);

		vboxInfoVideo.getChildren().addAll(lblLinkVideo, txtLinkVideo, lblTranscricaoVideo, txtTranscricaoVideo,
				lblTempoVideo, txtTempoVideo);
		vboxInfoAula.getChildren().addAll(lblTituloAula, txtTituloAula, lblDescricaoAula, txtDescricaoAula);
		hboxBotoesAcoes.getChildren().addAll(btnCancelarCadastroCurso, btnCadastrarCurso);

		this.setTop(lblTituloCurso);
		this.setLeft(vboxInfoVideo);
		this.setCenter(vboxInfoAula);
		this.setBottom(hboxBotoesAcoes);
	}

	//Construtor de uma aula que não é a inicial
	public AdminAulaView(Integer idAdmin, Integer idCurso, String tituloAula) {
		
		btnAdicionarExercicio.setOnAction(this);
		btnCancelar.setOnAction(this);
		btnSalvarAula.setOnAction(this);
		
		this.idAdmin = idAdmin;
		txtTituloAula.setText(tituloAula);
		
		this.setPromtTexts();
		this.gerarTabelaExercicios();

		this.txtDescricaoAula.setMaxHeight(100);

		this.hboxBotoesAcoes.getChildren().addAll(btnCancelar, btnExcluir, btnSalvarAula);

		this.vboxInfoAula.setPadding(new Insets(20));
		this.vboxInfoAula.getChildren().addAll(lblTituloAula, txtTituloAula, lblDescricaoAula, txtDescricaoAula,
				lblLinkVideo, txtLinkVideo, lblTranscricaoVideo, txtTranscricaoVideo, lblTempoVideo, txtTempoVideo,
				lblExercicios, btnAdicionarExercicio, tableExercicios, hboxBotoesAcoes);
		
		this.setCenter(vboxInfoAula);
	}

	private void gerarTabelaExercicios() {

		TableColumn<Exercicio, String> colTituloExercicio = new TableColumn<>("Título do Exercício");
		colTituloExercicio.setCellValueFactory(new PropertyValueFactory<Exercicio, String>("tituloExercicio"));

		tableExercicios.getColumns().add(colTituloExercicio);
		tableExercicios.setMaxHeight(120);

		tableExercicios.setRowFactory(tv -> {
			TableRow<Exercicio> row = new TableRow<>();
			row.setOnMouseClicked(e -> {
				Exercicio exec = row.getItem();
				Scene cena = this.getScene();
				cena.setRoot(new AdminExercicioView(3, 2));
			});
			return row;
		});

	}

	private void setPromtTexts() {
		this.txtTituloAula.setPromptText("Digite o título da aula...");
		this.txtDescricaoAula.setPromptText("Digite a descrição do conteúdo desta aula");
		this.txtLinkVideo.setPromptText("Digite o link de embed do vídeo fornecido pelo YouTube...");
	}

	public void entityToBoundary(Aula aula) {
		if (aula != null) {
			txtTituloAula.setText(String.valueOf(aula.getTitulo()));
			txtDescricaoAula.setText(String.valueOf(aula.getDescricao()));
			txtLinkVideo.setText(String.valueOf(aula.getLinkVideo()));
			txtTranscricaoVideo.setText(String.valueOf(aula.getTranscricaoVideo()));
			// txtTempoVideo.setText(Integer.parseInt(aula.getTempoVideo()));
		}
	}

	// só pode ser chamado ao atualizar a aula
	public Aula boundaryToEntityPrimeiroCadastro() {
		Aula aula = new Aula();

		aula.setTitulo(txtTituloAula.getText());
		aula.setDescricao(txtDescricaoAula.getText());
		aula.setLinkVideo(txtLinkVideo.getText());
		aula.setTranscricaoVideo(txtTranscricaoVideo.getText());
		aula.setTempoVideo(Integer.parseInt(txtTempoVideo.getText()));
		aula.setNumAula(1);
		return aula;
	}
	//o numero da aula depende do número de aulas do curso
	public Aula boundaryToEntity() {
		Aula aula = new Aula();
		
		aula.setTitulo(txtTituloAula.getText());
		aula.setDescricao(txtDescricaoAula.getText());
		aula.setLinkVideo(txtLinkVideo.getText());
		aula.setTranscricaoVideo(txtTranscricaoVideo.getText());
		aula.setTempoVideo(Integer.parseInt(txtTempoVideo.getText()));
		aula.setNumAula(aula.getNumAula()+1);
		return aula;
	}

	@Override
	public void handle(ActionEvent event) {

		Scene cena = this.getScene();

		if (event.getTarget() == btnAdicionarExercicio) {
			cena.setRoot(new AdminExercicioView(idAula, idAdmin)); // Aqui talvez tenha que passar ID da aula
			// aulaController.adicionarExercicio(this.boundaryToEntity().setExercicios(exercicio);)
			// exercicioController.cadastrarExercicio(exercicio);
		
		} else if (event.getTarget().equals(btnCancelar)) {
			cena.setRoot(new AdminDashboardView(idAdmin));
		
		} else if (event.getTarget().equals(btnExcluir)) {
			aulaController.removerAula(this.idAula); // modificar idAula
		
		} else if (event.getTarget().equals(btnSalvarAula)) {
			aulaController.adicionarAula(boundaryToEntity(), curso.getId());
			
		} else if (event.getTarget().equals(btnCadastrarCurso)) {
			if (cursoController.cadastrarCursoEPrimeiraAula(curso, boundaryToEntityPrimeiroCadastro())) {
				System.out.println("Cadastrou com sucesso...");
			}
			cena.setRoot(new AdminDashboardView(idAdmin));
		
		} else if (event.getTarget().equals(btnCancelarCadastroCurso)) {
			cena.setRoot(new AdminDashboardView(idAdmin));
		}
	}
}