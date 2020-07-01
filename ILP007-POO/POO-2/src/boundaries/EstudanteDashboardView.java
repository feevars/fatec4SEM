package boundaries;

import java.sql.Date;

import controllers.EstudanteController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class EstudanteDashboardView extends BorderPane implements EventHandler<ActionEvent> {

	private EstudanteController estudanteController = new EstudanteController();
	private Integer estudanteId;

	private HBox hboxHeader = new HBox();
	private Label lblUsuario = new Label();
	private Button btnSair = new Button("Sair");

	private VBox vboxCursos = new VBox();
	private Label lblCursos = new Label("Cursos");
	private TableView<Curso> tableCursos; // = new TableView<>(control.getLista());

	private VBox vboxPerfil = new VBox();
	private Label lblNome = new Label();
	private Label lblPontos = new Label();
	private Button btnEditarPerfil = new Button("Editar perfil");

	public EstudanteDashboardView(Integer estudanteId) {

		this.estudanteId = estudanteId;
		Estudante usuario = estudanteController.getEstudantePorId(estudanteId);
		entityToBoundary(usuario);
		gerarTabelaCursos();

		btnSair.setOnAction(this);
		btnEditarPerfil.setOnAction(this);

		hboxHeader.getChildren().addAll(lblUsuario, btnSair);
		hboxHeader.setAlignment(Pos.TOP_RIGHT);

		vboxCursos.getChildren().addAll(lblCursos, tableCursos);
		vboxCursos.setAlignment(Pos.CENTER);

		vboxPerfil.setMinWidth(200);
		vboxPerfil.setAlignment(Pos.CENTER);
		vboxPerfil.getChildren().addAll(lblNome, lblPontos, btnEditarPerfil);

		this.setPadding(new Insets(40));
		this.setTop(hboxHeader);

		this.setCenter(vboxCursos);
		this.setRight(vboxPerfil);
	}

	private void gerarTabelaCursos() {
		tableCursos = new TableView<Curso>(estudanteController.listarTodosCursos(estudanteId));

		TableColumn<Curso, String> colTituloCurso = new TableColumn<>("Título do Curso");
		colTituloCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("titulo"));

		TableColumn<Curso, String> colDescricaoCurso = new TableColumn<>("Descrição do Curso");
		colDescricaoCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("descricao"));

		TableColumn<Curso, Date> colAtualizacaoCurso = new TableColumn<>("Última atualização");
		colAtualizacaoCurso.setCellValueFactory(new PropertyValueFactory<Curso, Date>("dataAtualizacao"));

		TableColumn<Curso, Integer> colPontos = new TableColumn<>("Seus pontos");
		colPontos.setCellValueFactory(new PropertyValueFactory<Curso, Integer>("pontos"));

		TableColumn<Curso, Boolean> colConcluido = new TableColumn<>("Concluido");
		colConcluido.setCellValueFactory(new PropertyValueFactory<Curso, Boolean>("concluido"));

		tableCursos.getColumns().add(colTituloCurso);
		tableCursos.getColumns().add(colDescricaoCurso);
		tableCursos.getColumns().add(colAtualizacaoCurso);
		tableCursos.getColumns().add(colPontos);
		tableCursos.getColumns().add(colConcluido);
		tableCursos.setMinWidth(600);

		tableCursos.setOnMouseClicked(event -> {
			if (tableCursos.getSelectionModel().getSelectedItem() != null) {
				Curso curso = tableCursos.getSelectionModel().getSelectedItem();
				Scene cena = this.getScene();
				if (curso.getPontosEstudante() == null)
					cena.setRoot(new EstudanteCursoView(estudanteId, curso.getId(), curso.getPontosEstudante(), false,
							curso.getConcluidoPeloEstudante()));
				else
					cena.setRoot(new EstudanteCursoView(estudanteId, curso.getId(), curso.getPontosEstudante(), true,
							curso.getConcluidoPeloEstudante()));

			}
		});
	}

	public void entityToBoundary(Estudante usuario) {

		if (usuario != null) {
			String nomeDoUsuario = usuario.getUsername();

			if ((!usuario.getNome().isEmpty() || usuario.getNome() == null)
					&& (!usuario.getSobrenome().isEmpty() || usuario.getSobrenome() == null))
				nomeDoUsuario = usuario.getNome() + " " + usuario.getSobrenome();

			if (usuario instanceof Instrutor) {
				this.lblUsuario.setText("Olá, queridx intrutor(x) " + nomeDoUsuario + ".");
			} else {
				this.lblUsuario.setText("Olá, " + nomeDoUsuario + ". Você é o melhor estudante desta plataforma!");

			}
			lblNome.setText(nomeDoUsuario);
			lblPontos.setText("Pontos: " + usuario.getPontos().toString());
		}
	}

	@Override
	public void handle(ActionEvent event) {

		Scene cena = this.getScene();

		if (event.getTarget().equals(btnSair)) {
			cena.setRoot(new LoginView());
		} else if (event.getTarget().equals(btnEditarPerfil)) {
			cena.setRoot(new EstudanteCadastroView(estudanteId));
		}
	}
}
