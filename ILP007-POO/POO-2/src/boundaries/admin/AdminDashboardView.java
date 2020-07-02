package boundaries.admin;

import boundaries.LoginView;
import controllers.AdministradorController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Administrador;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class AdminDashboardView extends BorderPane implements EventHandler<ActionEvent> {

	private Integer idAdmin;
	AdministradorController adminController = new AdministradorController();

	private Label lblAdmin = new Label();
	private VBox vboxCursos = new VBox();
	private VBox vboxUsuarios = new VBox();
	private HBox hboxHeader = new HBox();
	private Button btnSair = new Button("Sair");

	private Label lblCursos = new Label("Cursos");
	private Button btnNovoCurso = new Button("Novo curso...");
	private TableView<Curso> tableCursos = new TableView<>(adminController.listarTodosCursos());// (control.getLista

	private Label lblUsuarios = new Label("Usuários");
	private TableView<Estudante> tableUsuarios = new TableView<>(adminController.listarTodosEstudantes());

	public AdminDashboardView(Integer idAdmin) {
		this.idAdmin = idAdmin;
		this.lblAdmin.setText("Logado como: "); // Colocar a chamada de getUsername by ID

		btnSair.setOnAction(this);
		btnNovoCurso.setOnAction(this);

		gerarTabelaCursos();
		gerarTabelaUsuarios();

		hboxHeader.getChildren().addAll(lblAdmin, btnSair);
		this.hboxHeader.setAlignment(Pos.TOP_RIGHT);

		vboxCursos.getChildren().addAll(lblCursos, tableCursos, btnNovoCurso);
		this.setPadding(new Insets(40));

		vboxUsuarios.getChildren().addAll(lblUsuarios, tableUsuarios);
		this.setPadding(new Insets(40));

		this.lblAdmin.setAlignment(Pos.CENTER_RIGHT);
		this.setLeft(vboxCursos);
		this.setCenter(vboxUsuarios);
		this.setTop(hboxHeader);
	}

	private void gerarTabelaCursos() {
		TableColumn<Curso, String> colTitulo = new TableColumn<>("Título");
		colTitulo.setCellValueFactory(new PropertyValueFactory<Curso, String>("titulo"));

		TableColumn<Curso, String> colDescricao = new TableColumn<>("Descrição");
		colDescricao.setCellValueFactory(new PropertyValueFactory<Curso, String>("descricao"));

		TableColumn<Curso, String> colCriacao = new TableColumn<>("Criação");
		colCriacao.setCellValueFactory(new PropertyValueFactory<Curso, String>("dataCriacao"));

		TableColumn<Curso, String> colAtualizacao = new TableColumn<>("Ultima atualização");
		colAtualizacao.setCellValueFactory(new PropertyValueFactory<Curso, String>("dataAtualizacao"));

		tableCursos.getColumns().add(colTitulo);
		tableCursos.getColumns().add(colDescricao);
		tableCursos.getColumns().add(colCriacao);
		tableCursos.getColumns().add(colAtualizacao);

		tableCursos.setOnMouseClicked(event -> {
			if (tableCursos.getSelectionModel().getSelectedItem() != null) {
				Curso curso = tableCursos.getSelectionModel().getSelectedItem();
				Scene cena = this.getScene();
				cena.setRoot(new AdminCursoView(this.idAdmin, curso.getId(), curso.getTitulo(), curso.getDescricao()));
			}
		});

	}

	private void gerarTabelaUsuarios() {

		TableColumn<Estudante, String> colUserEstudante = new TableColumn<>("Username");
		colUserEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("username"));

		TableColumn<Estudante, String> colNomeEstudante = new TableColumn<>("Nome");
		colNomeEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("nome"));

		TableColumn<Estudante, String> colSobrenomeEstudante = new TableColumn<>("Sobrenome");
		colSobrenomeEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("sobrenome"));

		TableColumn<Estudante, String> colEmailEstudante = new TableColumn<>("Email");
		colEmailEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("email"));

		TableColumn<Estudante, String> colInstrutor = new TableColumn<>("Instrutor");
		colInstrutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomeDoObjeto()));

		tableUsuarios.getColumns().add(colUserEstudante);
		tableUsuarios.getColumns().add(colNomeEstudante);
		tableUsuarios.getColumns().add(colSobrenomeEstudante);
		tableUsuarios.getColumns().add(colEmailEstudante);
		tableUsuarios.getColumns().add(colInstrutor);

		tableUsuarios.setOnMouseClicked(event -> {
			if (tableUsuarios.getSelectionModel().getSelectedItem() != null) {
				Estudante user = tableUsuarios.getSelectionModel().getSelectedItem();
				Scene cena = this.getScene();
				cena.setRoot(new AdminUsuarioView(idAdmin, user.getId(), user.getNome(), user.getSobrenome(),
						user.getTelefone(), user.getDataNascimento(), (user instanceof Instrutor)));
			}
		});

	}

	public void entityToBoundary(Administrador administrador) {
		if (administrador != null) {
			this.lblAdmin.setText(administrador.getUsername());
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Scene cena = this.getScene();
		if (event.getTarget().equals(btnSair)) {
			cena.setRoot(new LoginView());
		} else if (event.getTarget().equals(btnNovoCurso)) {
			this.getChildren().clear();
			cena.setRoot(new AdminCursoView(this.idAdmin));
		}
	}

}