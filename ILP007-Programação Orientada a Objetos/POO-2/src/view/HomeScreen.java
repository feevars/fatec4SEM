package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

public class HomeScreen extends Group{

	private static String MEDIA_URL = "https://www.youtube.com/watch?v=-qPTNiHqy6o&t=669s";
	private FlowPane fpMenu;
	private HBox hbMenu;
	private FlowPane fpCorpo;
	private Image logo;
	
//	private Label lblResultadoPalavra;
//	private Label lblResultadoDefinicao;
	private Button buttonHome;
	private Button buttonCursos;
	private TextField textPesquisar;
	
	private VBox vbox;
	
	
	public HomeScreen() {
		
		try {
			logo = new Image(new FileInputStream("src/images/logo.png"));
		} catch (FileNotFoundException e) {
			System.out.println("imagem nao encontrada");
		}
		WebView video = new WebView();
		video.getEngine().load("https://www.youtube.com/watch?v=-qPTNiHqy6o&t=669s");
		video.autosize();
		video.setPrefSize(640, 390);
		
		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(false);
		
		MediaView mediaView = new MediaView(mediaPlayer);
		mediaView.autosize();
		
		ImageView logoView = new ImageView(logo);
		logoView.setFitHeight(50);
		logoView.setFitWidth(50);
		
		buttonHome = new Button("Home");
		buttonHome.setMinSize(100, 40);
		
		buttonCursos = new Button("Cursos");
		buttonCursos.setMinSize(100, 40);
		
		textPesquisar = new TextField();
		textPesquisar.setPromptText("pesquisar...");
		textPesquisar.setMinSize(200, 40);
		
		fpMenu = new FlowPane();
		fpMenu.setMinWidth(500);
		fpMenu.setHgap(10);
		fpMenu.setPadding(new Insets(5));
		
		
		fpMenu.getChildren().addAll(buttonHome, buttonCursos, textPesquisar);
		
//		painelResultado = new FlowPane();
//		painelResultado.setMinSize(400, 400);
//		painelResultado.setHgap(10);
//		painelResultado.setPadding(new Insets(0, 20, 20, 20));
		
		fpCorpo = new FlowPane();
		
//		lblResultadoDefinicao = new Label();
		
//		lblResultadoDefinicao.setWrapText(true);
//		lblResultadoDefinicao.setPrefWidth(painelResultado.getMinWidth());

//		painelBusca.getChildren().addAll(txtBusca, btnBusca);
//		painelResultado.getChildren().addAll(lblResultadoPalavra, lblResultadoDefinicao);
		
		hbMenu = new HBox(logoView, fpMenu);
		fpCorpo = new FlowPane(mediaView);
		
		vbox = new VBox(hbMenu, fpCorpo);
		this.getChildren().addAll(vbox);
		
	}
}
