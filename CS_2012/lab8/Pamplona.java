	package lab8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pamplona extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Pamplona");
		
		MazeGUI mp = new MazeGUI();
		
		Scene sc = new Scene(mp, 650, 600);
		
		sc.getStylesheets().add("styles/styles.css");
				
		primaryStage.setScene(sc);
	
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
