package boundaries;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class EstudanteExercicio extends Group {

	private VBox vbox;

	private ToggleGroup alternativas;

	private Label lblTituloExercicio;
	private Label lblQuestaoExercicio;

	private RadioButton radioAlternativaA;
	private RadioButton radioAlternativaB;
	private RadioButton radioAlternativaC;
	private RadioButton radioAlternativaD;
	private RadioButton radioAlternativaE;

	private Button btnResponder;

	private Label lblResultado;
	private Label lblExplicacao;

	public EstudanteExercicio(String titulo, String questao, String alternativaA, String alternativaB,
			String alternativaC, String alternativaD, String alternativaE, String Explicacao) {

		vbox = new VBox();

		this.lblTituloExercicio = new Label(titulo);
		this.lblQuestaoExercicio = new Label(questao);

		this.alternativas = new ToggleGroup();
		this.radioAlternativaA = new RadioButton(alternativaA);
		this.radioAlternativaB = new RadioButton(alternativaB);
		this.radioAlternativaC = new RadioButton(alternativaC);
		this.radioAlternativaD = new RadioButton(alternativaD);
		this.radioAlternativaE = new RadioButton(alternativaE);
		
		this.radioAlternativaA.setToggleGroup(alternativas);
		this.radioAlternativaB.setToggleGroup(alternativas);
		this.radioAlternativaC.setToggleGroup(alternativas);
		this.radioAlternativaD.setToggleGroup(alternativas);
		this.radioAlternativaE.setToggleGroup(alternativas);

		this.lblResultado = new Label();
		this.lblExplicacao = new Label();
		
		this.btnResponder = new Button("Responder");

		vbox.getChildren().addAll(lblTituloExercicio, lblQuestaoExercicio, radioAlternativaA, radioAlternativaB,
				radioAlternativaC, radioAlternativaD, radioAlternativaE, lblResultado, lblExplicacao, btnResponder);
		
		this.getChildren().add(vbox);
		
	}

}
