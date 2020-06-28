package boundaries;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminAula {

	private Label labelNomeAula;
	private TextField txtNomeAula;
	
	private Label labelDescricaoAula;
	private TextArea txtDescricaoAula;
	
	private Label labelLinkAula;
	private TextField txtLinkAula;
	
	private Button buttonAdicionarExercicio;
	private Button buttonAdicionarACurso;
	private Button buttonConcluir;
	
	private VBox vboxLabels;
	private VBox vboxFields;
	private HBox hboxButtons;
	
	public AdminAula() {
		
		labelNomeAula = new Label("Nome da aula: ");
		labelDescricaoAula = new Label("Descrição: ");
		labelLinkAula = new Label("Link: ");
		
		txtNomeAula = new TextField("Nome da Aula: ");
		
		vboxLabels = new VBox(10, labelNomeAula, labelDescricaoAula, labelLinkAula);

		buttonAdicionarExercicio = new Button("Adicionar Exercicio");
		buttonAdicionarExercicio.setMinSize(120, 40);
		
	}
}
