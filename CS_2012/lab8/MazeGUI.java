package lab8;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class MazeGUI extends BorderPane {

	protected Label[][] labelArray;
	protected GridPane gp;
	protected StreetMap st;
	protected Button btn;
	
	public MazeGUI() {
		
		st = new StreetMap();
		labelArray = new Label[st.map.length][st.map[0].length];
		gp = new GridPane();
		btn = new Button("RUN");
		btn.getStyleClass().add("runButton");
		
		gp.getStyleClass().add("gridpane");
		
		createGrid();
		startLabel();
		endLabel();
		labelEvents();
		game();
		
		super.setCenter(gp);
		super.setBottom(btn);
	}
	
	public void createGrid() {
		
		//ALL GRAPHICAL IMPLEMENTAL CODE
		
		for (int i = 0; i < st.map.length; i++) {
			
			for (int j = 0; j < st.map[i].length; j++) {
				
				//creates first and last row of permanent walls
				if (i == 0 || i == st.map.length - 1) {
					
					labelArray[i][j] = new Label();
					labelArray[i][j].getStyleClass().add("label");
					labelArray[i][j].getStyleClass().add("wallLabel");
					gp.add(labelArray[i][j], j, i);
					st.map[i][j] = new Coordinate(i, j, 'W');
				
				//creates first and last column of permanent walls
				}	else if (j == 0 || j == st.map[0].length - 1) {
					
					labelArray[i][j] = new Label();
					labelArray[i][j].getStyleClass().add("label");
					labelArray[i][j].getStyleClass().add("wallLabel");
					gp.add(labelArray[i][j], j, i);
					st.map[i][j] = new Coordinate(i, j, 'W');
				
				//creates 30% of walls inside the grid and 80% spaces
				}	else {
					
					labelArray[i][j] = new Label();
					labelArray[i][j].getStyleClass().add("label");
					int twentyPercent =  0 + (int)(Math.random() * (100 - 0 + 1));
					
					if (twentyPercent <= 30) {
						
						labelArray[i][j].getStyleClass().add("wallLabel");
						st.map[i][j] = new Coordinate(i, j, 'W');
						gp.add(labelArray[i][j], j, i);
						
					} 	else {
						
						labelArray[i][j].getStyleClass().add("spaceLabel");
						st.map[i][j] = new Coordinate(i, j, ' ');
						gp.add(labelArray[i][j], j, i);

					}
				}
			}
		}
	}

	public void labelEvents() {
		
		//ALL LOGIAL CODE FOR LABELS
		
		for (int i = 1; i < st.map.length - 1; i++) {
			
			for (int j = 1; j < st.map[i].length - 1; j++) {
				
				
				final int row = i;
				final int col = j;
				
				labelArray[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

					Boolean clicked = false;
					
					@Override
					public void handle(Event event) {
						
						if (!clicked) {
							
							clicked = true;

							labelArray[row][col].setStyle("-fx-background-color: grey;");
							
							st.map[row][col].setValue('W');
							
							//FOR DEBUGGING USE ONLY:
							//System.out.println("" + st.map[row][col].getRow() + st.map[row][col].getCol() + st.map[row][col].getValue());
							
						} else {
							
							clicked = false;
							
							labelArray[row][col].setStyle("-fx-background-color: tan;");
							
							st.map[row][col].setValue(' ');

							//FOR DEBUGGING USE ONLY:
							//System.out.println("" + st.map[row][col].getRow() + st.map[row][col].getCol() + st.map[row][col].getValue());
						}
					}
					
				});
			}
		}
	}

	public void startLabel() {
		
		labelArray[0][1] = new Label("S");
		
		labelArray[0][1].getStyleClass().add("label");
		labelArray[0][1].getStyleClass().add("startLabel");
		
		gp.add(labelArray[0][1], 1, 0);
		st.map[0][1] = new Coordinate(0, 1, 'S');
	}
	
	public void endLabel() {
		
		labelArray[st.map.length - 1][st.map[0].length - 2] = new Label("E");
		
		labelArray[st.map.length - 1][st.map[0].length - 2].getStyleClass().add("label");
		labelArray[st.map.length - 1][st.map[0].length - 2].getStyleClass().add("endLabel");
		
		gp.add(labelArray[st.map.length - 1][st.map[0].length - 2], st.map[0].length - 2, st.map.length - 1);
		st.map[st.map.length - 1][st.map[0].length - 2] = new Coordinate(st.map.length - 1, st.map[0].length - 2, 'E');
	}

	public void game() {
	
		
		Runner run = new Runner(btn, st, labelArray);
		
		Bull bull = new Bull(btn, st, labelArray);
		

	}

}
