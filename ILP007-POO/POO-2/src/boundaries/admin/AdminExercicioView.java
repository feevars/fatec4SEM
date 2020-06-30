package boundaries.admin;

import controllers.ExercicioController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.entities.Exercicio;

public class AdminExercicioView extends Group implements EventHandler<ActionEvent>{
	
	ExercicioController exercicioController = new ExercicioController();

	private VBox vbox = new VBox();

	private Label lblTitulo = new Label("Título da questão:");
	private TextField txtTitulo = new TextField();

	private Label lblQuestao = new Label("Texto da questão:");
	private TextArea txtQuestao = new TextArea();

	private Label lblAlternativaCorreta = new Label("Alternativa correta:");
	private TextField txtAlternativaCorreta = new TextField();

	private Label lblAlternativasIncorretas = new Label("Alternativas incorretas");
	private TextField txtAlternativaIncorreta1 = new TextField();
	private TextField txtAlternativaIncorreta2 = new TextField();
	private TextField txtAlternativaIncorreta3 = new TextField();
	private TextField txtAlternativaIncorreta4 = new TextField();

	private Label lblExplicacao = new Label("Explicação:");
	private TextArea txtExplicacao = new TextArea();

	private HBox hboxDetalhes = new HBox();
	
	private Label lblTempoResposta = new Label("Tempo para que o estudante responda esta questão em segundos:");
	private TextField txtTempoResposta = new TextField();

	private Label lblPontos = new Label("Quantos pontos, de 1 a 10, vale este exercício?");
	private TextField txtPontos = new TextField();

	//
	private Label lblAula = new Label("A qual aula esse exercicio pertence");
	private TextField txtAula = new TextField();
	//
	
	private HBox hboxButtons = new HBox();

	private Button btnExcluir = new Button("Excluir");
	private Button btnCancelar = new Button("Cancelar");
	private Button btnSalvar = new Button("Salvar");

	public AdminExercicioView() {

		vbox.setSpacing(5);

		txtTitulo.setPromptText("Digite o título resumido do exercício...");
  
		txtQuestao.setMaxHeight(30);
		txtQuestao.setPromptText("Digite a questão copleta que deverá ser respondida por meio das alternativas.");

		txtAlternativaCorreta.setPromptText("Digite a resposta correta para a questão forulada.");
	
		txtAlternativaIncorreta1.setPromptText("Digite a alternativa incorreta 1");
		txtAlternativaIncorreta2.setPromptText("Digite a alternativa incorreta 2");
		txtAlternativaIncorreta3.setPromptText("Digite a alternativa incorreta 3");
		txtAlternativaIncorreta4.setPromptText("Digite a alternativa incorreta 4");

		txtExplicacao.setMaxHeight(30);
		txtExplicacao.setPromptText("Digite a justificativa da resposta completa, explicando a questão do exercício.");

		estilizaLabels(lblTitulo, lblQuestao, lblAlternativaCorreta, lblAlternativasIncorretas, lblExplicacao, lblTempoResposta, lblPontos, lblAula);
		
		hboxDetalhes.setSpacing(10);
		hboxDetalhes.getChildren().addAll(lblTempoResposta, txtTempoResposta, lblPontos, txtPontos, lblAula, txtAula);

		btnSalvar.setOnAction(this);
		btnCancelar.setOnAction(this);
		
		hboxButtons.setSpacing(10);
		hboxButtons.getChildren().addAll(btnExcluir, btnCancelar, btnSalvar);

		vbox.getChildren().addAll(lblTitulo, txtTitulo, lblQuestao, txtQuestao, lblAlternativaCorreta,
				txtAlternativaCorreta, lblAlternativasIncorretas, txtAlternativaIncorreta1, txtAlternativaIncorreta2,
				txtAlternativaIncorreta3, txtAlternativaIncorreta4, lblExplicacao, txtExplicacao, hboxDetalhes, hboxButtons);
		
		vbox.setMaxWidth(600);
		vbox.setPadding(new Insets(20));
		this.getChildren().add(vbox);

	}
	

	private void estilizaLabels(Label ... labels) {
		
		for (Label label : labels) {
			
			label.setPadding(new Insets(10, 0, 0, 0));
			label.setWrapText(true);
			label.setFont(new Font(16));

		}
		
	}
	
	public Exercicio boundaryToEntity(){
		Exercicio exercicio = new Exercicio();
		try{
			exercicio.setTituloExercicio(txtTitulo.getText());
			exercicio.setQuestaoExercicio(txtQuestao.getText());
			exercicio.setAlternativaCorreta(txtAlternativaCorreta.getText());
			exercicio.setAlternativaIncorreta1(txtAlternativaIncorreta1.getText());
			exercicio.setAlternativaIncorreta2(txtAlternativaIncorreta2.getText());
			exercicio.setAlternativaIncorreta3(txtAlternativaIncorreta3.getText());
			exercicio.setAlternativaIncorreta4(txtAlternativaIncorreta4.getText());
			exercicio.setExplicacao(txtExplicacao.getText());
			exercicio.setTempoResposta(Integer.parseInt(txtTempoResposta.getText()));
			exercicio.setPontos(Integer.parseInt(txtPontos.getText()));
			exercicio.setAulaId((Integer.parseInt(txtAula.getText())));
			
			
		}catch (Exception e) {
			System.out.println("Erro ao receber dados.");
		}
		return exercicio;
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getTarget() == btnSalvar){
			exercicioController.cadastrarExercicio(boundaryToEntity());
		}
		else if(event.getTarget() == btnCancelar){			
		}
		
	}
	
	
}
