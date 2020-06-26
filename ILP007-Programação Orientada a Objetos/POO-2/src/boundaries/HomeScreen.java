package boundaries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

public class HomeScreen extends Group{

	private Button buttonAluno;
	private Button buttonAdministrador;
	
	private Image logo;
	private Button buttonHome1;
	private Button buttonCursos;
	private TextField textPesquisar;
	private Button buttonDashboard;
	private Button buttonLogin;
	private Button buttonHome2;
	private Button buttonListaAlunos;
	private Button buttonListaCursos;
	
	
	private static String MEDIA_URL = "https://www.youtube.com/embed/videoseries?list=PLnvgG3onSbK8ADiJotrqYgZadFtHxwDGs";
	private HBox hbUser;
	private HBox hbMenuAluno;
	private HBox hbMenuAdministrador;
	private HBox hbMenu;
	private GridPane gpCorpo;
	
//	private Label lblResultadoPalavra;
//	private Label lblResultadoDefinicao;
	
	private VBox vbox;
	
	
	public HomeScreen() {
		
		try {
			logo = new Image(new FileInputStream("src/images/logo.png"));
		} catch (FileNotFoundException e) {
			System.out.println("imagem nao encontrada");
		}
		WebView video = new WebView();
		video.getEngine().load("https://www.youtube.com/embed/videoseries?list=PLnvgG3onSbK8ADiJotrqYgZadFtHxwDGs");
		video.autosize();
		video.setPrefSize(640, 390);
		
		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(false);
		
		MediaView mediaView = new MediaView(mediaPlayer);
		mediaView.autosize();
		
		buttonAluno = new Button("Aluno");
		buttonAluno.setMinSize(100, 40);
		
		buttonAdministrador = new Button("Administrador");
		buttonAdministrador.setMinSize(100, 40);
		
		hbUser = new HBox();
		hbUser.getChildren().addAll(buttonAluno, buttonAdministrador);
		hbUser.setAlignment(Pos.BASELINE_CENTER);
		
		ImageView logoView = new ImageView(logo);
		logoView.setFitHeight(50);
		logoView.setFitWidth(50);
		
		buttonHome1 = new Button("Home");
		buttonHome1.setMinSize(90, 40);
		
		buttonCursos = new Button("Cursos");
		buttonCursos.setMinSize(90, 40);
		
		textPesquisar = new TextField();
		textPesquisar.setPromptText("pesquisar...");
		textPesquisar.setMinSize(150, 40);
		
		buttonDashboard = new Button("Dashboard");
		buttonDashboard.setMinSize(90, 40);
		
		buttonLogin = new Button("Login");
		buttonLogin.setMinSize(90, 40);
		
		hbMenuAluno = new HBox();
		hbMenuAluno.setMinWidth(600);
		hbMenuAluno.setPadding(new Insets(5));
		//hbMenuComponents.borderProperty().setValue(10);
		
		hbMenuAluno.getChildren().addAll(buttonHome1, buttonCursos, textPesquisar, buttonDashboard, buttonLogin);
		hbMenuAluno.alignmentProperty().set(Pos.CENTER_LEFT);
		
		buttonHome2 = new Button("Home");
		buttonHome2.setMinSize(100, 40);
		
		buttonListaAlunos = new Button("Lista de Alunos");
		buttonListaAlunos.setMinSize(100, 40);
		
		buttonListaCursos = new Button("Lista de Cursos");
		buttonListaCursos.setMinSize(100, 40);
		
		hbMenuAdministrador = new HBox();
		hbMenuAdministrador.setMinWidth(600);
		hbMenuAdministrador.setPadding(new Insets(5));
		
		hbMenuAdministrador.getChildren().addAll(buttonHome2, buttonListaAlunos, buttonListaCursos);
		hbMenuAdministrador.alignmentProperty().set(Pos.CENTER_RIGHT);
		
		
//		painelResultado = new FlowPane();
//		painelResultado.setMinSize(400, 400);
//		painelResultado.setHgap(10);
//		painelResultado.setPadding(new Insets(0, 20, 20, 20));

		
//		lblResultadoDefinicao = new Label();
		
//		lblResultadoDefinicao.setWrapText(true);
//		lblResultadoDefinicao.setPrefWidth(painelResultado.getMinWidth());

//		painelBusca.getChildren().addAll(txtBusca, btnBusca);
//		painelResultado.getChildren().addAll(lblResultadoPalavra, lblResultadoDefinicao);
		
		hbMenu = new HBox(logoView, hbMenuAluno, hbMenuAdministrador);
		hbMenu.setDisable(true);
		hbMenu.setMinWidth(1366);
		gpCorpo = new GridPane();
		gpCorpo.setStyle("-fx-background-color:blue;");
		gpCorpo.setMinSize(1366, 800);
		gpCorpo.getChildren().add(video);
		//		gpCorpo.getChildren().add(mediaView);
		
		vbox = new VBox(hbUser, hbMenu, gpCorpo);
		this.getChildren().addAll(vbox);
		
	}
}
