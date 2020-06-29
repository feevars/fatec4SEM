package boundaries;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.entities.Aula;

public class EstudanteCurso extends BorderPane implements EventHandler<ActionEvent> {

	private Integer estudanteId, cursoId;
	
	private VBox vboxInfoCurso = new VBox();
	
	private Label lblTituloCurso = new Label("Título do curso");
	private Label lblDescricaoCurso = new Label("Descrição do curso");
	private Label lblInstrutores = new Label("Instrutores");
	
	private Label lblAulas = new Label("Aulas");
	private TableView<Aula> tableAulas = new TableView<>();
	
	private Button btnAdicionarAula = new Button("Adicionar aula...");
	
	private VBox vboxInfoEstudante = new VBox();
	
	private Label lblStatus = new Label("Status");
	private Label lblPontosEstudanteCurso = new Label("Seus pontos neste curso: ");
	
	private Button btnVoltar = new Button("Voltar");
	
	public EstudanteCurso(Integer estudanteId, Integer cursoId, Integer pontosEstudanteCurso, Boolean iniciado, Boolean concluido) {
		
		this.estudanteId = estudanteId;
		this.cursoId = cursoId;
		
		this.setPadding(new Insets(40));
		
		this.lblPontosEstudanteCurso.setText(lblPontosEstudanteCurso.getText() + pontosEstudanteCurso);
		
		this.btnVoltar.setOnAction(this);
		
		gerarTabelaAullas();
		
		this.vboxInfoCurso.getChildren().addAll(lblTituloCurso, lblDescricaoCurso, lblInstrutores, lblAulas, tableAulas, btnAdicionarAula);
		this.vboxInfoEstudante.getChildren().addAll(lblStatus, lblPontosEstudanteCurso);
		
		this.setCenter(vboxInfoCurso);
		this.setRight(vboxInfoEstudante);
		this.setTop(btnVoltar);
	}
	
	
	private void gerarTabelaAullas() {
		
		TableColumn<Aula, String> colTituloAula = new TableColumn<>("Título da aula");
		colTituloAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("titulo"));
		
		tableAulas.getColumns().add(colTituloAula);
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();
		
		if (event.getTarget().equals(btnVoltar)) {
			cena.setRoot(new EstudanteDashboard(estudanteId));
		} 
	}
	
}
