package boundaries;

import java.util.List;
import java.util.Set;

import controllers.AulaController;
import controllers.CursoController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import model.entities.Aula;
import model.entities.Exercicio;

public class EstudanteAulaView extends BorderPane implements EventHandler<ActionEvent> {

	AulaController aulaController = new AulaController();
	CursoController cursoController = new CursoController();
	
	private Set<Exercicio> listaExercicios;
	private List<Aula> listAula;
	private Aula aula;

	private Integer idEstudante, idAula, idCurso;

	private Button btnVoltarAoCurso = new Button("Voltar ao curso");

	private VBox vboxInfo = new VBox();

	private Label lblTituloCurso = new Label("Títilo do curso");
	private Label lblTituloAula = new Label("Título da aula");
	private Label lblDescricaoAula = new Label("Descricao da aula");

	private String urlVideo;

	private Label lblTempoVideo = new Label("Tempo desta vídeo aula: ");

	private Label lblQtdExercicios = new Label("Quantidade de exercícios: ");
	private Button btnRealizarExercicios = new Button("Realizar exercícios desta aula");

	private VBox vboxVideo = new VBox();

	private WebView video = new WebView();
	private Label lblTranscricaoVideo = new Label("Transcrição do vídeo");

	private Button btnProximaAula = new Button("Próxima aula");

	public EstudanteAulaView(Integer idEstudante, Integer idAula) {

		this.idEstudante = idEstudante;
		this.idAula = idAula;

		btnVoltarAoCurso.setOnAction(this);
		
		aula = aulaController.getAulaPorId((idAula));
		for (Exercicio exec : aula.getExercicios()) {
			listaExercicios.add(exec);
		}
		
		entityToBoundary(aula);

		video.getEngine().load(urlVideo);
		video.autosize();
		video.setPrefSize(560, 315);

		if (listaExercicios == null) {
			btnRealizarExercicios.setVisible(false);
			btnRealizarExercicios.setDisable(true);
		}

		this.vboxInfo.getChildren().addAll(lblTituloCurso, lblTituloAula, lblDescricaoAula, lblTempoVideo,
				lblQtdExercicios, btnRealizarExercicios);

		this.vboxVideo.getChildren().addAll(video, lblTranscricaoVideo);

		this.setTop(btnVoltarAoCurso);
		this.setCenter(vboxInfo);
		this.setLeft(vboxVideo);

	}

	public void entityToBoundary(Aula aula) {
		if (aula != null) {
//			lblTituloCurso.setText(aula.getCursoId());
			lblTituloAula.setText(aula.getTitulo());
			lblDescricaoAula.setText(aula.getDescricao());
			lblTempoVideo.setText(aula.getTempoVideo().toString());
			urlVideo = aula.getLinkVideo();
			lblTranscricaoVideo.setText(aula.getTranscricaoVideo());
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();
		if (event.getTarget().equals(btnVoltarAoCurso)) {
			cena.setRoot(new EstudanteCursoView(idEstudante, cursoController.getCursoPorId(aula), null, true, false));
		} else if (event.getTarget().equals(btnRealizarExercicios)) {
			if (listaExercicios != null) {
				cena.setRoot(new EstudanteExercicioView(idEstudante, listaExercicios));
			}
		}

	}
}
