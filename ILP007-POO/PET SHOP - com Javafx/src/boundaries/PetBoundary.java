package boundaries;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import control.PetController;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.entities.Pet;

public class PetBoundary extends BorderPane {
	private PetController control = new PetController();
	
	Label lblId = new Label("Id: ");
	TextField txtId = new TextField();
	
	Label lblNome = new Label("Nome: ");
	TextField txtNome = new TextField("Digite o nome...");
	
	private TextField txtPeso = new TextField();
	private TextField txtNascimento = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private TableView<Pet> tableView = new TableView<>(control.getLista());
	
	public void gerarTabelaPets() { 
		TableColumn<Pet, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Pet, String>("nome"));
		
		TableColumn<Pet, Double> colPeso = new TableColumn<>("Peso");
		colPeso.setCellValueFactory(new PropertyValueFactory<Pet, Double>("peso"));
		
		TableColumn<Pet, String> colNascimento = new TableColumn<>("Nascimento");
		colNascimento.setCellValueFactory(item -> 
			new ReadOnlyStringWrapper(dtf.format(item.getValue().getNascimento()))
		);			
		tableView.getColumns().addAll(colNome, colPeso, colNascimento);
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pet>() {
			@Override
			public void changed(ObservableValue<? extends Pet> p, Pet antigo, Pet novo) {
				entityToBoundary(novo);
			}
		});
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panPrincipal = new BorderPane();
		Scene scn = new Scene(panPrincipal, 400, 300);
		
		GridPane panCampos = new GridPane();
		generateTable();
		
		panCampos.add(new Label("Id: "), 0, 0);
		panCampos.add(txtId, 1, 0);
		panCampos.add(new Label("Nome: "), 0, 1);
		panCampos.add(txtNome, 1, 1);
		panCampos.add(new Label("Raça: "), 0, 2);
		panCampos.add(txtRaca, 1, 2);
		panCampos.add(new Label("Peso: "), 0, 3);
		panCampos.add(txtPeso, 1, 3);
		panCampos.add(new Label("Nascimento: "), 0, 4);
		panCampos.add(txtNascimento, 1, 4);
		panCampos.add(btnAdicionar, 0, 5);
		panCampos.add(btnPesquisar,  1,  5);
		
		btnAdicionar.setOnAction(this);
		btnPesquisar.setOnAction(this);
		
		panPrincipal.setTop(panCampos);
		panPrincipal.setCenter(tableView);
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Pets");
		stage.show();
	}
	
	public void handle(ActionEvent e) { 
		if (e.getTarget() == btnAdicionar) { 
			Pet p = boundaryToEntity();
			control.adicionar(p);
			entityToBoundary(new Pet());
		} else if (e.getTarget() == btnPesquisar){ 
			String nome = txtNome.getText();
			Pet p = control.pesquisarPorNome(nome);
			entityToBoundary(p);
		}
	}
	
	public Pet boundaryToEntity() { 
		Pet p = new Pet();
		try { 
			p.setId( Long.parseLong(txtId.getText()) );
			p.setNome( txtNome.getText() );
			p.setRaca( txtRaca.getSelectionModel().getSelectedItem() );
			p.setPeso( Double.parseDouble(txtPeso.getText()) );
			LocalDate dt = LocalDate.parse(txtNascimento.getText(), dtf);
			p.setNascimento( dt );
		} catch (Exception ex) { 
			System.out.println("Erro ao computar os dados");
		}
		return p;
	}
	
	public void entityToBoundary(Pet p) { 
		if (p != null) {
			txtId.setText( String.valueOf(p.getId()) );
			txtNome.setText( p.getNome() );
			txtRaca.getSelectionModel().select( p.getRaca() );
			txtPeso.setText( String.valueOf(p.getPeso()) );
			txtNascimento.setText( dtf.format(p.getNascimento()) );
		}
	}
	
	
}
