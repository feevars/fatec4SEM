package boundaries;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * 
 **/
import javafx.scene.web.WebView;
public class EstudanteAula extends Group{

	private Button buttonVoltarAoCurso;
	private Button buttonProximaAula;
	private Button buttonAulaAnterior;
	private Button buttonFazerExercicio;
	private Label labelNomeAula;
	
	private VBox videoETitulo;
	private HBox botoes;
	
	public EstudanteAula(String URL) {
		
	WebView video = new WebView();
	video.getEngine().load(URL);
	video.autosize();
	video.setPrefSize(640, 390);
	
	labelNomeAula = new Label("Aula.getNome");
	labelNomeAula.alignmentProperty().setValue(Pos.BASELINE_CENTER);
	labelNomeAula.setPadding(new Insets(20));
	
	Pane boxVideo = new Pane(video);
	
	
	buttonVoltarAoCurso = new Button("Voltar ao curso");
	buttonAulaAnterior = new Button("<<< Aula anterior");
	buttonProximaAula = new Button("Próxima aula >>>");
//	buttonAulaAnterior.setMinSize(120, 40);
//	buttonProximaAula.setMinSize(120, 40);
//	botoes.setSpacing(10);
	botoes = new HBox(buttonVoltarAoCurso, buttonAulaAnterior, buttonProximaAula);
	botoes.setSpacing(30);
//	botoesAnteriorProximo.borderProperty().
	
	buttonFazerExercicio = new Button("Fazer Exercícios");
	buttonFazerExercicio.setAlignment(Pos.BOTTOM_RIGHT);
	//if (Aula.hasAnterior) { setVisible(true) e setDisable(false) no botão de Aula anterior 
	
	
	//if aula not contain exercicio, setVisible(false) e setDisable(true) no botão de fazerExrcicio
//	videoETitulo.setMinSize(600, 600);
	videoETitulo = new VBox(botoes, boxVideo, labelNomeAula, buttonFazerExercicio);
	
	this.getChildren().add(videoETitulo);
	}
}
