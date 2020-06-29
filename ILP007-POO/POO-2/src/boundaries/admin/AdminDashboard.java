package boundaries.admin;

import boundaries.EstudanteCadastro;
import boundaries.Login;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entities.Administrador;
import model.entities.Curso;
import model.entities.Estudante;

public class AdminDashboard extends BorderPane implements EventHandler<ActionEvent>{

	private Label lblAdmin = new Label(); 
	private GridPane dashboardAdmin = new GridPane();
	private VBox vboxCursos = new VBox();
	private VBox vboxUsuarios = new VBox();
	private HBox hboxHeader = new HBox();
	private Button btnSair = new Button("Sair");
	
	private Label lblCursos = new Label("Cursos");
	private TableView<Curso> tableCursos = new TableView<>();//(control.getLista

	private Label lblUsuarios = new Label("Usuários");
	private TableView<Estudante> tableUsuarios = new TableView<>();//control.getLista
	
	public AdminDashboard (Integer id) {
		this.lblAdmin.setText("Logado como: "); // Colocar a chamada de getUsername by ID
		
		btnSair.setOnAction(this);
		
		gerarTabelaCursos();
		gerarTabelaUsuarios();
		
		hboxHeader.getChildren().addAll(lblAdmin, btnSair);
		this.hboxHeader.setAlignment(Pos.TOP_RIGHT);
		
		vboxCursos.getChildren().addAll(lblCursos, tableCursos);
		this.setPadding(new Insets(40));
		
		vboxUsuarios.getChildren().addAll(lblUsuarios, tableUsuarios);
		this.setPadding(new Insets(40));
		
		this.lblAdmin.setAlignment(Pos.CENTER_RIGHT);
		this.dashboardAdmin.add(vboxCursos, 0, 0);
		this.dashboardAdmin.add(vboxUsuarios, 1, 0);
		this.dashboardAdmin.setAlignment(Pos.CENTER);
		this.setCenter(dashboardAdmin);
		this.setTop(hboxHeader);
	}
	
	
	private void gerarTabelaCursos() {
		TableColumn<Curso, String> colTituloCurso = new TableColumn<>("Título do curso");
		colTituloCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("titulo"));
		
		tableCursos.getColumns().addAll(colTituloCurso);
	}
	
	private void gerarTabelaUsuarios() {
		TableColumn<Estudante, String> colUserEstudante = new TableColumn<>("Username");
		colUserEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("username"));
		
		TableColumn<Estudante, String> colNomeEstudante = new TableColumn<>("Nome");
		colUserEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("nome"));
		
		TableColumn<Estudante, String> colSobrenomeEstudante = new TableColumn<>("Sobrenome");
		colUserEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("sobrenome"));
		
		TableColumn<Estudante, String> colEmailEstudante = new TableColumn<>("Email");
		colUserEstudante.setCellValueFactory(new PropertyValueFactory<Estudante, String>("email"));
	
		tableUsuarios.getColumns().addAll(colUserEstudante, colNomeEstudante, colSobrenomeEstudante, colEmailEstudante);
		
		
	}
	
	public void EntityToBoundary(Administrador administrador) {
		if (administrador != null) {
			this.lblAdmin.setText(administrador.getUsername());
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		Scene cena = this.getScene();

			if (event.getTarget().equals(btnSair)) {
				cena.setRoot(new Login());
			}
	}
}
