package lab8;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Runner {

	protected int row = 1;
	protected int col = 1;
	protected Button btn;
	protected Label[][] arr;
	protected StreetMap st;
	
	
	public Runner(Button button, StreetMap st, Label[][] arr) {
				
		this.btn = button;
		this.st  = st;
		this.arr = arr;
		resetHandler();
		keyEvents();
	}
	
	public void keyEvents() {
		
		btn.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {

				if (event.getCode() == KeyCode.DOWN && st.map[row + 1][col].getValue() != 'W') {

					arr[row][col].setStyle("-fx-background-color: tan;");
					st.map[row][col].setValue(' ');
					row++;
					arr[row][col].setStyle("-fx-background-color: blue;");
					st.map[row][col].setValue('R');
					
				}	else if (event.getCode() == KeyCode.UP && st.map[row - 1][col].getValue() != 'W') {
					
					arr[row][col].setStyle("-fx-background-color: tan;");
					st.map[row][col].setValue(' ');
					row--;
					arr[row][col].setStyle("-fx-background-color: blue;");
					st.map[row][col].setValue('R');
					
				}	else if (event.getCode() == KeyCode.LEFT && st.map[row][col - 1].getValue() != 'W') {
					
					arr[row][col].setStyle("-fx-background-color: tan;");
					st.map[row][col].setValue(' ');
					col--;
					arr[row][col].setStyle("-fx-background-color: blue;");
					st.map[row][col].setValue('R');
					
				}	else if (event.getCode() == KeyCode.RIGHT && st.map[row][col + 1].getValue() != 'W') {
					
					arr[row][col].setStyle("-fx-background-color: tan;");
					st.map[row][col].setValue(' ');
					col++;
					arr[row][col].setStyle("-fx-background-color: blue;");
					st.map[row][col].setValue('R');
				}
			}

		});		
		
	}
	
	public void resetHandler() {
		
		btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			boolean clicked = false;
			@Override
			public void handle(Event event) {
				
				if (clicked) {
					
					arr[row][col].setStyle("-fx-background-color: blue;");
					st.map[row][col].setValue('R');
					clicked = false;
					
				} else {

				arr[row][col].setStyle("-fx-background-color: tan;");
				st.map[row][col].setValue(' ');
				row = 1;
				col = 1;
				arr[row][col].setStyle("-fx-background-color: blue;");
				st.map[row][col].setValue('R');
				clicked = true;
				}
			}
			
		});
	}
}
