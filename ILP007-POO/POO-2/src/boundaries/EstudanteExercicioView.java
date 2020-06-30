package boundaries;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class EstudanteExercicioView extends Group {

	private VBox vbox = new VBox();;

	private Label lblTituloExercicio = new Label();
	private Label lblQuestaoExercicio = new Label();

	private ToggleGroup alternativas;

	private RadioButton radioAlternativaA = new RadioButton();
	private RadioButton radioAlternativaB = new RadioButton();
	private RadioButton radioAlternativaC = new RadioButton();
	private RadioButton radioAlternativaD = new RadioButton();
	private RadioButton radioAlternativaE = new RadioButton();

	private Button btnResponder = new Button("Responder");;
	private Button btnProsseguir = new Button("Prosseguir");;

	private Label lblResultado = new Label();
	private Label lblExplicacao = new Label();

	public EstudanteExercicioView(Integer estudanteId, Integer exercioId) {

		this.radioAlternativaA.setToggleGroup(alternativas);
		this.radioAlternativaB.setToggleGroup(alternativas);
		this.radioAlternativaC.setToggleGroup(alternativas);
		this.radioAlternativaD.setToggleGroup(alternativas);
		this.radioAlternativaE.setToggleGroup(alternativas);
		
		
		vbox.getChildren().addAll(lblTituloExercicio, lblQuestaoExercicio, radioAlternativaA, radioAlternativaB,
				radioAlternativaC, radioAlternativaD, radioAlternativaE, lblResultado, lblExplicacao, btnResponder);
		
		this.getChildren().add(vbox);
		
	}

}
