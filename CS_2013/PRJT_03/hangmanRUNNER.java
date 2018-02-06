package PRJT_03;
/*
 * Upon running the program, it will seem like nothing was rendered.
 * However, you may begin playing right away. Any key pressed will count towards
 * a valid try. This includes ENTER, ESC, CTRL, and so on. 
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class hangmanRUNNER extends Application {

	protected BorderPane bp = new BorderPane();
	protected HangmanPane pane = new HangmanPane();
	protected GridPane bottomPane = new GridPane();
	protected TextField text = new TextField();
	protected Label wDynamicLabel = new Label("");
	protected Label pDynamicLabel = new Label("");
	protected int lives = 6;
	protected String playWord; 
	protected Label system = new Label();

	@Override
	public void start(Stage primaryStage) throws Exception {

		text.setPrefColumnCount(10);
		text.setOnKeyPressed(this::draw);

		bottomGUI();

		bp.setBottom(bottomPane);
		bp.setCenter(pane);

		Scene scene = new Scene(bp, 700, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("HangMan Game");
		primaryStage.show();

	}

	public static void main(String[] args) {

		Application.launch(args);
	}

	public void draw(KeyEvent e) {
		if (e.getCode().isLetterKey()) {
			if(playWord.contains("" + e.getCode()) && lives > 0) {
				system.setText("CORRECT! LIVES REMAINING: " + lives);
				pane.draw(lives);
				discoverLetters(e.getCode() + "");
				text.clear();
				if (playWord.equals(pDynamicLabel.getText())) {
					system.setText("CONGRADULATIONS! YOU GUESSED THE WORD!");
					Button reset = new Button("RESET");
					reset.setOnMouseClicked(this::resetGame);
					bottomPane.add(reset, 1, 2);
					text.clear();
				}
			} else if (lives > 0) {
				lives--;
				pane.draw(lives);
				system.setText("WRONG! LIVES REMAINING: " + lives);
				wDynamicLabel.setText(wDynamicLabel.getText() + e.getCode());
				text.clear();
			} else if (lives <= 0) {
				system.setText("GAME OVER!");
				Button reset = new Button("RESET");
				reset.setOnMouseClicked(this::resetGame);
				bottomPane.add(reset, 1, 3);
				text.clear();
			}
		}
	}

	private void resetGame(MouseEvent e) {
		lives = 6;
		pane.getChildren().clear();
		bottomPane.getChildren().clear();
		pane.draw(lives);
		pDynamicLabel.setText("");
		wDynamicLabel.setText("");
		system.setText("Game as been reset");
		bottomGUI();
	}

	private void discoverLetters(String letters) {

		char[] discovered = playWord.toCharArray();
		char[] entered = letters.toCharArray();
		String before = pDynamicLabel.getText();
		String after = "";
		for (char item: discovered) {
			if (item == entered[0])
				after += letters;
			else
				after += "*";
		}
		pDynamicLabel.setText(combine(before, after));
	}

	private String combine(String before, String after) {

		String toReturn = "";
		for (int i = 0; i < before.length(); i++) {
			if (before.charAt(i) == after.charAt(i)) 
				toReturn += before.charAt(i);
			else if (before.charAt(i) != '*')
				toReturn += before.charAt(i);
			else if (after.charAt(i) != '*')
				toReturn += after.charAt(i);
		}
		return toReturn;
	}

	private void bottomGUI() {

		Label label = new Label("Type a letter to guess: ");
		Label wLabel = new Label("Wrong letters: ");
		Label pLabel = new Label("     Word to guess: ");

		HBox hbox = new HBox();
		hbox.getChildren().addAll(label, text);
		hbox.setAlignment(Pos.CENTER);

		HBox GUI = new HBox();
		GUI.getChildren().addAll(wLabel, wDynamicLabel, pLabel, pDynamicLabel);
		GUI.setAlignment(Pos.CENTER);

		HBox systemBox = new HBox();
		systemBox.getChildren().add(system);
		systemBox.setAlignment(Pos.CENTER);

		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.add(systemBox, 0, 1);
		bottomPane.add(GUI, 0, 2);
		bottomPane.add(hbox, 0, 3);

		String[] words = {"BOTTLE", "POWER", "COMPUTER", "NOTEBOOK", "PHONE", "CARD"};
		int ran = (int) (Math.random() * 6);
		playWord = words[ran];
		for (int i = 0; i < playWord.length(); i++) {
			pDynamicLabel.setText(pDynamicLabel.getText() + "*");
		}

	}
}

class HangmanPane extends Pane {

	public void draw(int lives) {
		this.getChildren().clear();
		switch (lives) {

		case 0:
			drawStand();
			this.getChildren().addAll(drawHead(),
					drawRightHand(),
					drawLeftHand(),
					drawBody(),
					drawRightLeg(),
					drawLeftLeg());
			break;
		case 1:
			drawStand();
			this.getChildren().addAll(drawHead(),
					drawRightHand(),
					drawLeftHand(),
					drawBody(),
					drawRightLeg());
			break;
		case 2:
			drawStand();
			this.getChildren().addAll(drawHead(),
					drawRightHand(),
					drawLeftHand(),
					drawBody());
			break;
		case 3:
			drawStand();
			this.getChildren().addAll(drawHead(),
					drawRightHand(),
					drawLeftHand());
			break;
		case 4:
			drawStand();
			this.getChildren().addAll(drawHead(),
					drawRightHand());
			break;
		case 5:
			drawStand();
			this.getChildren().addAll(drawHead());
			break;
		default: drawStand();
		}

	}

	public void drawStand() {
		Line rope = new Line(this.getWidth()/2, 30, this.getWidth()/2, 15);
		rope.setStrokeWidth(10);
		rope.setStroke(Color.BROWN);
		Line standHead = new Line(this.getWidth()/2, 15, this.getWidth()*0.25, 15);
		standHead.setStrokeWidth(10);
		standHead.setStroke(Color.SILVER);
		Line standPole = new Line(this.getWidth()*0.25, 15, this.getWidth()*0.25, 525.0);
		standPole.setStrokeWidth(10);
		standPole.setStroke(Color.SILVER);
		Line standCross = new Line(this.getWidth()*0.25, 75, this.getWidth()*0.35, 15);
		standCross.setStrokeWidth(10);
		standCross.setStroke(Color.SILVER);
		this.getChildren().addAll(rope, standHead, standCross, standPole);
	}

	private Circle drawHead() {
		Circle circle = new Circle();
		circle.setFill(Color.CYAN);
		circle.setRadius(50.0);
		circle.setCenterX(getWidth()/2);
		circle.setCenterY(80.0);
		return circle;
	}

	private Line drawBody() {
		Line line = new Line(getWidth()/2.0, 130.0, getWidth()/2.0, 300.0);
		return line;
	}

	private Line drawLeftHand() {
		Line line = new Line(getWidth()/2.0, 145.0, getWidth()*0.65, 200.0);
		return line;
	}
	private Line drawRightHand() {
		Line line = new Line(getWidth()/2.0, 145.0, getWidth()*0.35, 200.0);
		return line;
	}

	private Line drawLeftLeg() {
		Line line = new Line(getWidth()/2.0, 300.0, getWidth()*0.65, 500.0);
		return line;
	}

	private Line drawRightLeg() {
		Line line = new Line(getWidth()/2.0, 300.0, getWidth()*0.35, 500.0);
		return line;
	}
}
