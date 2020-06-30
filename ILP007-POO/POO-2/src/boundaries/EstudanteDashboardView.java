package boundaries;

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

public class EstudanteDashboardView extends BorderPane implements EventHandler<ActionEvent> {
	
	private Integer estudanteId;

	private HBox hboxHeader = new HBox();
	private Label lblUsuario = new Label();
	private Button btnSair = new Button("Sair");
		
	private VBox vboxCursos = new VBox();
	private Label lblCursos = new Label("Cursos");
	private TableView<Curso> tableCursos = new TableView<Curso>(); //= new TableView<>(control.getLista());
	
	private VBox vboxPerfil = new VBox();
	private Label lblNome = new Label("Nome");
	private Label lblPontos = new Label("Pontos");
	private Button btnEditarPerfil = new Button("Editar perfil");
	
	
	public EstudanteDashboardView(Integer estudanteId) {
		
		this.estudanteId = estudanteId;
		
		this.lblUsuario.setText("Logado como: "); //Aqui precisa colocar uma chamada de get nome por id
		
		//entityToBoundary(usuario); Tem que pegar o usuário pelo e montar um estudante
		gerarTabelaCursos();
		
		btnSair.setOnAction(this);
		btnEditarPerfil.setOnAction(this);
		
		hboxHeader.getChildren().addAll(lblUsuario, btnSair);
		hboxHeader.setAlignment(Pos.TOP_RIGHT);
		
		vboxCursos.getChildren().addAll(lblCursos, tableCursos);
		vboxCursos.setAlignment(Pos.CENTER);
		
		vboxPerfil.setMinWidth(300);
		vboxPerfil.setAlignment(Pos.CENTER);
		vboxPerfil.getChildren().addAll(lblNome, lblPontos, btnEditarPerfil);
		
		
		this.setPadding(new Insets(40));
		this.setTop(hboxHeader);

		this.setCenter(vboxCursos);
		this.setRight(vboxPerfil);
	}
	
	private void gerarTabelaCursos() {
		TableColumn<Curso, String> colTituloCurso = new TableColumn<>("Título do Curso");
		colTituloCurso.setCellValueFactory(new PropertyValueFactory<Curso, String>("titulo"));
		
		tableCursos.getColumns().add(colTituloCurso);
		tableCursos.setMaxWidth(600);
	}
	
	public void entityToBoundary(Estudante estudante) {
		
		if (estudante != null) {
			if (!estudante.getNome().isEmpty() && !estudante.getSobrenome().isEmpty())
			this.lblUsuario.setText(estudante.getNome() + " " + estudante.getSobrenome());
			else this.lblUsuario.setText(estudante.getUsername());
		}
	}

	@Override
	public void handle(ActionEvent event) {

		Scene cena = this.getScene();

		if (event.getTarget().equals(btnSair)) {
			cena.setRoot(new LoginView());
		} 
		else if (event.getTarget().equals(btnEditarPerfil)) {
			cena.setRoot(new EstudanteCadastroView(estudanteId));
		} 
	}
}
