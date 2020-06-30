package boundaries;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class EstudanteAulaView extends BorderPane implements EventHandler<ActionEvent> {

	private Integer idEstudante, idAula;

	private Button btnVoltarAoCurso = new Button("Voltar ao curso");

	private VBox vboxInfo = new VBox();

	private Label lblTituloCurso = new Label("Títilo do curso");
	private Label lblTituloAula = new Label("Título da aula");
	private Label lblDescricaoAula = new Label("Descricao da aula");

	private String urlVideo;

	private Label lblTempoVideo = new Label("Tempo desta vídeo aula: ");

	private Label lblQtdExercicios = new Label("Quantidade de exercícios: ");
	private Button btnRealizzarExercicios = new Button("Realizar exercícios desta aula");

	private VBox vboxVideo = new VBox();

	private WebView video = new WebView();
	private Label lblTranscricaoVideo = new Label("Transcrição do vídeo");

	public EstudanteAulaView(Integer idEstudante, Integer idAula) {

		this.idEstudante = idEstudante;
		this.idAula = idAula;

		video.getEngine().load(urlVideo);
		video.autosize();
		video.setPrefSize(560, 315);

		this.vboxInfo.getChildren().addAll(lblTituloCurso, lblTituloAula, lblDescricaoAula, lblTempoVideo,
				lblQtdExercicios, btnRealizzarExercicios);

		this.vboxVideo.getChildren().addAll(video, lblTranscricaoVideo);

		this.setTop(btnVoltarAoCurso);
		this.setCenter(vboxInfo);
		this.setLeft(vboxVideo);

	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}
