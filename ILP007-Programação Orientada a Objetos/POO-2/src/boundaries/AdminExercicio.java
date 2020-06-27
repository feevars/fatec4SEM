package boundaries;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AdminExercicio extends Group {

	private VBox vbox;

	private Label lblTitulo;
	private TextField txtTitulo;

	private Label lblQuestao;
	private TextArea txtQuestao;

	private Label lblAlternativaCorreta;
	private TextField txtAlternativaCorreta;

	private Label lblAlternativasIncorretas;
	private TextField txtAlternativaIncorreta1;
	private TextField txtAlternativaIncorreta2;
	private TextField txtAlternativaIncorreta3;
	private TextField txtAlternativaIncorreta4;

	private Label lblExplicacao;
	private TextArea txtExplicacao;

	private HBox hboxDetalhes;
	
	private Label lblTempoResposta;
	private TextField txtTempoResposta;

	private Label lblPontos;
	private TextField txtPontos;

	private HBox hboxButtons;

	private Button btnExcluir;
	private Button btnCancelar;
	private Button btnSalvar;

	public AdminExercicio() {

		vbox = new VBox();
		vbox.setSpacing(5);

		lblTitulo = new Label("Título da questão:");
		txtTitulo = new TextField();
		txtTitulo.setPromptText("Digite o título resumido do exercício...");

		lblQuestao = new Label("Texto da questão:");
		txtQuestao = new TextArea();
		txtQuestao.setPromptText("Digite a questão copleta que deverá ser respondida por meio das alternativas.");

		lblAlternativaCorreta = new Label("Alternativa correta:");
		txtAlternativaCorreta = new TextField();
		txtAlternativaCorreta.setPromptText("Digite a resposta correta para a questão forulada.");

		lblAlternativasIncorretas = new Label("Alternativas incorretas");
		txtAlternativaIncorreta1 = new TextField();
		txtAlternativaIncorreta1.setPromptText("Digite a alternativa incorreta 1");
		txtAlternativaIncorreta2 = new TextField();
		txtAlternativaIncorreta2.setPromptText("Digite a alternativa incorreta 2");
		txtAlternativaIncorreta3 = new TextField();
		txtAlternativaIncorreta3.setPromptText("Digite a alternativa incorreta 3");
		txtAlternativaIncorreta4 = new TextField();
		txtAlternativaIncorreta4.setPromptText("Digite a alternativa incorreta 4");

		lblExplicacao = new Label("Explicação:");
		txtExplicacao = new TextArea();
		txtExplicacao.setPromptText("Digite a justificativa da resposta completa, explicando a questão do exercício.");

		hboxDetalhes = new HBox();
		
		lblTempoResposta = new Label("Tempo para que o estudante responda esta questão em segundos:");
		txtTempoResposta = new TextField();

		lblPontos = new Label("Quantos pontos, de 1 a 10, vale este exercício?");
		txtPontos = new TextField();

		estilizaLabels(lblTitulo, lblQuestao, lblAlternativaCorreta, lblAlternativasIncorretas, lblExplicacao, lblTempoResposta, lblPontos);
		
		hboxDetalhes.setSpacing(10);
		hboxDetalhes.getChildren().addAll(lblTempoResposta, txtTempoResposta, lblPontos, txtPontos);

		hboxButtons = new HBox();

		btnExcluir = new Button("Excluir");
		btnCancelar = new Button("Cancelar");
		btnSalvar = new Button("Salvar");

		
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
	
	
}
