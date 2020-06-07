import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DesenhaFormas extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane gridPane= new GridPane();
		
		Canvas canvas1 = new Canvas(300, 300);
		GraphicsContext graphicCasa = canvas1.getGraphicsContext2D();
		desenhaCasa(graphicCasa);
		
		Canvas canvas2 = new Canvas(300, 300);
		GraphicsContext graphicEsfera = canvas2.getGraphicsContext2D();
		desenhaEsfera(graphicEsfera, 300);
		
		gridPane.add(canvas1, 0, 0);
		gridPane.add(canvas2, 1, 0);
		
		Scene cena = new Scene(gridPane, 700, 300, Color.ALICEBLUE);
		primaryStage.setTitle("Desenha Formas");
		primaryStage.setResizable(false);
		primaryStage.setScene(cena);
		primaryStage.show();	
	}
	
	private void desenhaCasa(GraphicsContext gc) {
		gc.setStroke(Color.AQUAMARINE);
		gc.setLineWidth(3);
		gc.strokeRect(100, 100, 100, 100);
		gc.strokeLine(150, 50, 200, 100);
		gc.strokeLine(100, 100, 150, 50);

	}
	
	private void desenhaEsfera(GraphicsContext gc, int tamanho) {

		if (tamanho <= 1) {
			return;
		}
		
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeOval(0, (gc.getCanvas().getHeight() - tamanho * 0.8) / 2, 300, tamanho * 0.8);
		gc.strokeOval((gc.getCanvas().getWidth() - tamanho) / 2, (gc.getCanvas().getHeight() - 300 * 0.8) / 2, tamanho, 300 * 0.8);
		desenhaEsfera(gc, tamanho - 15);
	}

	public static void main(String[] args) {
		Application.launch(DesenhaFormas.class, args);
	}	
}