package boundaries;

import controllers.CursoController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.entities.Curso;

public class AdminCurso extends Application implements EventHandler<ActionEvent>{

	private CursoController cursoController = new CursoController();
	private TextField txtBuscaCurso = new TextField();
	private Button btnBuscaCurso = new Button("PESQUISAR");
	private Button btnEditarCurso = new Button("EDITAR");
	private Button btnExcluirCurso = new Button("EXCLUIR");
	private Button btnNovoCurso = new Button("NOVO");
	
	
	public void generateTable() {
		
		TableColumn<Curso, String> colNome = new TableColumn<>("ID:");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("id"));
		
		TableColumn<Curso, String> colNome = new TableColumn<>("NOME:");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("nome"));
		
		TableColumn<Curso, String> colNome = new TableColumn<>("DESCRICAO:");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("descricao"));
		
		TableColumn<Curso, String> colNome = new TableColumn<>("HORAS:");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("horas"));
		
		TableColumn<Curso, String> colNome = new TableColumn<>("CRIACAO:");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("criacao"));
		
		TableColumn<Curso, String> colNome = new TableColumn<>("ATULIZAO:");
		colNome.setCellValueFactory(new PropertyValueFactory<Curso, String>("atualizacao"));
	}
	

	@Override
	public void start(Stage adminCrusoStage) throws Exception {
		BorderPane panPrincipal = new BorderPane();
		Scene cena = new Scene(panPrincipal, 1024, 768);
		
		GridPane panBusca = new GridPane();
		GridPane panGerencia = new GridPane();
		
		panBusca.add(new Label("NOME: "), 0, 0); //col - lin
		panBusca.add(txtBuscaCurso,1 , 0);
		panBusca.add(btnBuscaCurso,  2, 0);
		
		panGerencia.add(btnNovoCurso, 0, 0);
		panGerencia.add(btnEditarCurso, 1, 0);
		panGerencia.add(btnExcluirCurso, 2, 0);
		
		
		btnBuscaCurso.setOnAction(this);
		
		panPrincipal.setTop(panBusca);
		panPrincipal.setCenter(panGerencia);
		
		adminCrusoStage.setScene(cena);
		adminCrusoStage.setTitle("ADMIN CURSOS");
		adminCrusoStage.show();
	}
	
	public static void main(String args[]) {
		Application.launch(AdminCurso.class, args);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
