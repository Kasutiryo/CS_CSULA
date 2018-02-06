package lab8;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Bull {

	private int ticks;
	private int[] lastWallX = new int[2];
	private int[] lastWallY = new int[2];
	private int[] lastRunner = new int[2];
	private int[] bullCoords = new int[2];
	protected Button btn;
	protected StreetMap st;
	protected Label[][] arr;

	public Bull(Button btn, StreetMap st, Label[][] arr) {

		this.btn = btn;
		this.st = st;
		this.arr = arr;
		reset();
		move();
	}

	public void reset() {


		btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				ticks = 0;
				bullCoords[0] = 1;
				bullCoords[1] = 1;

			}

		});
	}

	public void move() {	


		btn.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (ticks < 5) {

					if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {

						ticks++;
					}
				} else if (ticks >= 5) {

					arr[bullCoords[0]][bullCoords[1]].setStyle("-fx-background-color: red;");

					scanRunnerX();
					scanRunnerY();

					if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {

						if (lastRunner[0] == 0 && lastRunner[1] == 0) {

							int random = 0 + (int)(Math.random() * (1 - 0 + 1));

							if (random == 0) {

								arr[bullCoords[0]][bullCoords[1]].setStyle("-fx-background-color: tan;");
								st.map[bullCoords[0]][bullCoords[1]].setValue(' ');
								bullCoords[0] += 2;
								arr[bullCoords[0]][bullCoords[1]].setStyle("-fx-background-color: red;");
								st.map[bullCoords[0]][bullCoords[1]].setValue('B');
	
							} else {
	
								arr[bullCoords[0]][bullCoords[1]].setStyle("-fx-background-color: tan;");
								st.map[bullCoords[0]][bullCoords[1]].setValue(' ');
								bullCoords[1] += 2;
								arr[bullCoords[0]][bullCoords[1]].setStyle("-fx-background-color: red;");
								st.map[bullCoords[0]][bullCoords[1]].setValue('B');
							}
						} else if (false) {
							
						}
						
					}
				}
			}
		});
	}

		public void scanRunnerY() {

			boolean stop = false;

			for (int i = bullCoords[0]; i < st.map.length - 1 && stop == false; i++) {

				if (st.map[i][bullCoords[1]].getValue() == 'R') {

					lastRunner[0] = i;
					lastRunner[1] = bullCoords[1];

				} else if (st.map[i][bullCoords[1]].getValue() == 'W') {

					lastWallY[0] = i;
					lastWallY[1] = bullCoords[1];
					stop = true;
				}
			}
		}

		public void scanRunnerX() {

			boolean stop = false;

			for (int j = bullCoords[1]; j < st.map.length - 1 && stop == false; j++) {

				if (st.map[bullCoords[0]][j].getValue() == 'R') {

					lastRunner[0] = bullCoords[0];
					lastRunner[1] = j;

				} else if (st.map[bullCoords[0]][j].getValue() == 'W') {

					lastWallX[0] = bullCoords[0];
					lastWallY[1] = j;
					stop = true;
				}
			}
		}


	}
