package FXMenuDemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class JavaFXMenuDemo extends Application {
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Menu Sample");

		GridPane gp = new GridPane();
		
		BorderPane bp = new BorderPane();
		
		MenuBar menuBar = setUpMenuBar(stage);
		
		Scene scene = new Scene(bp, 300, 300);
		
		scene.getStylesheets().add("styles/application.css");
		
		gp.getStyleClass().add("grid");
		
		gp.add(new Label("Hello"), 1, 1);

		//gp.getChildren().add(menuBar);
		
		bp.setTop(menuBar);
		
		bp.setCenter(gp);
		
		stage.setScene(scene);
		
		stage.show();
	}

	private MenuBar setUpMenuBar(Stage stage) {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = setUpFileMenu();
		Menu helpMenu = setUpHelpMenu(stage);
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(helpMenu);
		return menuBar;
	}
	
	private Menu setUpFileMenu() {
		Menu fileMenu = new Menu("File");
		MenuItem quitItem = new MenuItem("Quit");
		quitItem.setOnAction(e -> {
			System.exit(0);
		});

		quitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q,
				KeyCombination.CONTROL_DOWN));

		fileMenu.getItems().add(quitItem);

		return fileMenu;
	}

	private Menu setUpHelpMenu(Stage stage) {
		Menu helpMenu = new Menu("Help");
		MenuItem aboutItem = new MenuItem("About");
		aboutItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Popup popup = new Popup();
				// popup.setX(100);
				VBox v = new VBox();
				v.getStyleClass().add("about");
				Text t = new Text("Copyright 2014 by John Hurley");
				t.getStyleClass().add("text");
				Button okButton = new Button("OK");
				v.getChildren().addAll(t, okButton);
				okButton.setOnAction(e -> {
					popup.hide();
				});

				popup.getContent().addAll(v);
				popup.show(stage);
			}

		});

		aboutItem.setAccelerator(new KeyCodeCombination(KeyCode.A,
				KeyCombination.CONTROL_DOWN));
		helpMenu.getItems().add(aboutItem);
		return helpMenu;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

	
