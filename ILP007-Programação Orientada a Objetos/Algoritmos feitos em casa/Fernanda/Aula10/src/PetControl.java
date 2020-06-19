import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PetControl {
	//private List<Pet> lista = new ArrayList<>();
	
	
	private DateTime
	
	public PetControl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			alertError("database error", "erro ao carregar a classe JDBC", e.getMessage());
		}
	}
	
	public void alertError (String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
}
