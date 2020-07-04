package boundaries;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Exercicio;

public class EstudanteExercicioView extends Group implements EventHandler<ActionEvent>{

	private Set<Exercicio> listExercicio;
	
	private VBox vbox = new VBox();
	private HBox hbox = new HBox();

	private Label lblTituloExercicio = new Label();
	private Label lblQuestaoExercicio = new Label();

	private ToggleGroup alternativas;

	private RadioButton radioAlternativaA = new RadioButton();
	private RadioButton radioAlternativaB = new RadioButton();
	private RadioButton radioAlternativaC = new RadioButton();
	private RadioButton radioAlternativaD = new RadioButton();
	private RadioButton radioAlternativaE = new RadioButton();

	private Button btnResponder = new Button("Responder");
	private Button btnProsseguir = new Button("Prosseguir");
	private Button btnConcluir = new Button("Concluir");
	private Button btnCancelar = new Button("Cancelar");
	
	private Label lblResultado = new Label();
	private Label lblExplicacao = new Label();
	

	public EstudanteExercicioView(Integer estudanteId, Set<Exercicio> listaExercicios) {

		this.listExercicio = listaExercicios;
		this.radioAlternativaA.setToggleGroup(alternativas);
		this.radioAlternativaB.setToggleGroup(alternativas);
		this.radioAlternativaC.setToggleGroup(alternativas);
		this.radioAlternativaD.setToggleGroup(alternativas);
		this.radioAlternativaE.setToggleGroup(alternativas);
		
		
		btnProsseguir.setOnAction(this);
		btnResponder.setOnAction(this);
		btnConcluir.setOnAction(this);
		btnCancelar.setOnAction(this);
		
		if (listaExercicios.iterator().hasNext()) {
		hbox.getChildren().addAll(btnCancelar, btnProsseguir);
		} else {
			hbox.getChildren().addAll(btnCancelar, btnConcluir);
		
		vbox.getChildren().addAll(hbox, lblTituloExercicio, lblQuestaoExercicio, radioAlternativaA, radioAlternativaB,
				radioAlternativaC, radioAlternativaD, radioAlternativaE, lblResultado, lblExplicacao, btnResponder);
		}
		this.getChildren().add(vbox);
	}


	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget().equals(btnProsseguir)) {
			
		} else if (event.getTarget().equals(btnConcluir)) {
			
		} else if (event.getTarget().equals(btnResponder)){
			
		};
		
	}

}
