package attacks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MonsterGUI extends Application {
	
	private BorderPane bp = new BorderPane();
	private MenuBar mb = new MenuBar();
	private GridPane gp = new GridPane();
	private Menu fileMenu;
	private MenuItem[] fileMenuItems = new MenuItem[5];
	private Label[] columnTitle = new Label[5];
	private Label[] toDisplay = new Label[5];
	private int lastRow = 1;
	private int id = 0;
	private static List<MonsterAttack> monAtks;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		monAtks = new ArrayList<MonsterAttack>();
		
		primaryStage.setTitle("Monster Recorder");
		
		createMenu();
		
		createGrid();
		
		Scene sc = new Scene(bp, 650, 600);
		
		sc.getStylesheets().add("styles/monster.css");
		
		bp.setTop(mb);
		bp.setCenter(gp);
		
		primaryStage.setScene(sc);
		
		primaryStage.show();
	}
	
	private void createMenu() {
		
		mb.getStyleClass().add("menu");
		
		fileMenu = new Menu("File");
		
		fileMenu.getStyleClass().add("menu");
		
		fileMenuItems[0] = new MenuItem("Add");
		fileMenuItems[0].getStyleClass().add("file");
		fileMenuItems[0].setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					int ID = id;
					
					String date = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY): ");
					
					String monster = JOptionPane.showInputDialog("Enter the monster's name: ");
					
					String location = JOptionPane.showInputDialog("Enter the location: ");
					
					String reporter = JOptionPane.showInputDialog("Enter the reporter's name: ");
					
					monAtks.add(new MonsterAttack(ID, date, monster, location, reporter));
					
					JOptionPane.showMessageDialog(null, "Successfully created a new Monster Attack");
					
					int temp = monAtks.size();
					lastRow = 1;
					gp = new GridPane();
					createGrid();
					bp.setCenter(gp);
					
					for (int i = 0; i < temp; i++) {
						
						updateList(i);
					}
					id++;
				}
			});
			
		fileMenuItems[1] = new MenuItem("Delete");
		fileMenuItems[1].getStyleClass().add("file");
		fileMenuItems[1].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				int x = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the monster attack: "));
				
				for (int i = 0; i < monAtks.size(); i++) {
					
					if(monAtks.get(i).getID() == x) {
						
						monAtks.remove(i);
						
						i = monAtks.size();
					}
					
				}
				
				lastRow--;
				int temp = monAtks.size();
				lastRow = 1;
				gp = new GridPane();
				createGrid();
				bp.setCenter(gp);
				
				for (int i = 0; i < temp; i++) {
					
					updateList(i);
				}
			}
		});
		
		fileMenuItems[2] = new MenuItem("Save");
		fileMenuItems[2].getStyleClass().add("file");
		fileMenuItems[2].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				MonsterPersister monPre = new BinaryMonsterPersister();
				
				JFileChooser jfc = new JFileChooser();

				int retVal = jfc.showOpenDialog(null);
				
				if (retVal == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = jfc.getSelectedFile();
					
					monPre.save(selectedFile, monAtks);
				}
			}
		});
		
		fileMenuItems[3] = new MenuItem("Load");
		fileMenuItems[3].getStyleClass().add("file");
		fileMenuItems[3].setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
				MonsterPersister monPre_ = new BinaryMonsterPersister();
				
				JFileChooser jfc_ = new JFileChooser();

				int retVal_ = jfc_.showOpenDialog(null);
				
				if (retVal_ == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = jfc_.getSelectedFile();
					
					monAtks = monPre_.load(selectedFile);
				}
				
				int temp = monAtks.size();
				lastRow = 1;
				gp = new GridPane();
				createGrid();
				bp.setCenter(gp);
				id = monAtks.size();
				
				for (int i = 0; i < temp; i++) {
					
					updateList(i);
				}
			}
			
		});
		
		fileMenuItems[4] = new MenuItem("Quit");
		fileMenuItems[4].getStyleClass().add("file");
		fileMenuItems[4].setOnAction(e -> {
			System.exit(0);
		});
		
		for (int i = 0; i < 5; i++) {
			
			fileMenu.getItems().add(fileMenuItems[i]);
		}

		mb.getMenus().add(fileMenu);
		
		
	}
	
	private void createGrid() {
		
		gp.getStyleClass().add("grid");
						
		columnTitle[0] = new Label(" ");
		columnTitle[1] = new Label("Date");
		columnTitle[2] = new Label("Monster");
		columnTitle[3] = new Label("Location");
		columnTitle[4] = new Label("Reporter");
				
		for (int i = 0; i < 5; i++) {
			
			columnTitle[i].getStyleClass().add("label");
			gp.add(columnTitle[i], i, 0);
		}
	}
	
	private void updateList(int num) {
		
		toDisplay[0] = new Label("" + monAtks.get(num).getID());
		toDisplay[1] = new Label(monAtks.get(num).getDate());
		toDisplay[2] = new Label(monAtks.get(num).getMonsterName());
		toDisplay[3] = new Label(monAtks.get(num).getLocation());
		toDisplay[4] = new Label(monAtks.get(num).getReporterName());
		
		for (int i = 0; i < 5; i++) {
			
			toDisplay[i].getStyleClass().add("label");
			gp.add(toDisplay[i], i, lastRow);
		}
		lastRow++;
	}

	public static void main(String[] args) {
		
		Application.launch(args);
	}
}
