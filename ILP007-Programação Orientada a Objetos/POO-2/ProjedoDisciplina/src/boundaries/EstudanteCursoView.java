package boundaries;

import controllers.CursoController;
import controllers.EstudanteController;
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
import model.entities.Curso;
import model.entities.Instrutor;

public class EstudanteCursoView extends BorderPane implements EventHandler<ActionEvent> {
	
	private EstudanteController estudanteController = new EstudanteController();
	private CursoController cursoController = new CursoController();
	private Integer estudanteId, cursoId;

	private VBox vboxInfoCurso = new VBox();

	private Label lblTituloCurso = new Label("Título do curso");
	private Label lblDescricaoCurso = new Label("Descrição do curso");
	private Label lblInstrutores = new Label("Instrutores");

	private Label lblAulas = new Label("Aulas");
	private TableView<Aula> tableAulas;
	private VBox vboxInfoEstudante = new VBox();

	private Label lblStatus = new Label("Status: Não iniciado");
	private Label lblPontosEstudanteCurso = new Label("Seus pontos neste curso: ");

	private Button btnVoltar = new Button("Voltar");

	public EstudanteCursoView(Integer estudanteId, Integer cursoId, Integer pontosEstudanteCurso, Boolean iniciado,
			Boolean concluido) {

		this.estudanteId = estudanteId;
		this.cursoId = cursoId;
		
		
		this.setPadding(new Insets(40));

		gerarLabels(pontosEstudanteCurso, iniciado, concluido);
		gerarTabelaAulas();

		this.vboxInfoCurso.getChildren().addAll(lblTituloCurso, lblDescricaoCurso, lblInstrutores, lblAulas,
				tableAulas);
		this.vboxInfoEstudante.getChildren().addAll(lblStatus, lblPontosEstudanteCurso);

		this.btnVoltar.setOnAction(this);

		this.setCenter(vboxInfoCurso);
		this.setRight(vboxInfoEstudante);
		this.setTop(btnVoltar);
	}

	private void gerarTabelaAulas() {

		tableAulas = new TableView<Aula>(cursoController.carregarListaAulasEstudante(cursoId));
		
		TableColumn<Aula, String> colTituloAula = new TableColumn<>("Título da aula");
		colTituloAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("titulo"));
		
		TableColumn<Aula, String> colDescricaoAula = new TableColumn<>("Descrição da aula");
		colDescricaoAula.setCellValueFactory(new PropertyValueFactory<Aula, String>("descricao"));

		tableAulas.getColumns().add(colTituloAula);
		tableAulas.getColumns().add(colDescricaoAula);
		
		tableAulas.setOnMouseClicked(event -> {
			if (tableAulas.getSelectionModel().getSelectedItem() != null) {
				Aula aula = tableAulas.getSelectionModel().getSelectedItem();
				Scene cena = this.getScene();
				cena.setRoot(new EstudanteAulaView(estudanteId, aula.getId()));
			}
		});
	}

	private void gerarLabels(Integer pontosEstudanteCurso, Boolean iniciado, Boolean concluido) {
		if (iniciado != null) {
			if (iniciado)
				lblStatus.setText("Status: Em andamento");
		}
		if (concluido != null) {
			if (concluido)
				lblStatus.setText("Status: Concluído");
		}
		if (pontosEstudanteCurso != null) {
			lblPontosEstudanteCurso.setText(lblPontosEstudanteCurso.getText() + pontosEstudanteCurso);
		} else {
			lblPontosEstudanteCurso.setText(lblPontosEstudanteCurso.getText() + "Você ainda nem começou...");
		}
		
		Curso curso = estudanteController.getCursoPorId(cursoId);
		lblTituloCurso.setText(curso.getTitulo());
		lblDescricaoCurso.setText(curso.getDescricao());
		
		for (Instrutor i : curso.getInstrutores()) {			
			lblInstrutores.setText(lblInstrutores.getText() + i.getNome() + " " + i.getSobrenome() + "\n");
		}
		
		lblInstrutores.setWrapText(true);
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();

		if (event.getTarget().equals(btnVoltar)) {
			cena.setRoot(new EstudanteDashboardView(estudanteId));
		}
	}

}
