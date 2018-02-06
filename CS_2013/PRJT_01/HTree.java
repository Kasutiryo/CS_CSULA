package PRJT_01;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class HTree extends Application {
	
	private BorderPane bp = new BorderPane();
	private HTreePane pane = new HTreePane();
	private TextField text = new TextField();
	@Override
	public void start(Stage primaryStage) throws Exception {

		HBox hbox = new HBox();
		Label order = new Label("Order: ");
		Button enter = new Button("Enter");
		enter.setOnMouseClicked(this::setOrder);
		hbox.getChildren().addAll(order, text, enter);
		hbox.setAlignment(Pos.CENTER);
		bp.setCenter(pane);
		bp.setBottom(hbox);
		Scene sc = new Scene(bp, 500, 500);
		primaryStage.setScene(sc);
		primaryStage.setTitle("HTree");
		primaryStage.show();
		
		sc.widthProperty().addListener(ov -> pane.paint());
	    sc.heightProperty().addListener(ov -> pane.paint());
	}
	
	public void setOrder(MouseEvent e) {
		try {
			pane.setOrder(Integer.parseInt(text.getText()));
		} catch (Exception E) {
			System.out.println("Please enter a valid integer!");
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);	
	}
}

class HTreePane extends Pane {
	
	private int order = 0;
	
	public HTreePane() {}
	
	public void setOrder(int order) {
		
		this.order = order;
		paint();
	}
	
	protected void paint() {
		
		Point2D center = new Point2D(getWidth()/2, getHeight()/2);
		double size = 250;
		this.getChildren().clear();
		drawHTrees(order, center, size);
	}
	
	protected void draw(Point2D center, double size) {
		
		double leftX = center.getX() - size/2;
		double rightX = center.getX() + size/2;
		double topY = center.getY() - size/2;
		double bottomY = center.getY() + size/2;
		
		Line left = new Line(leftX, topY, leftX, bottomY);
		Line right = new Line(rightX, topY, rightX, bottomY);
		Line horizonal = new Line(leftX, center.getY(), rightX, center.getY());
	
		this.getChildren().addAll(left, right, horizonal);
	}
	
	protected void drawHTrees(int order, Point2D center, double size) {
		
		if(order == 0) {
			draw(center, size);		
		} else {
			draw(center, size);
			Point2D bottomLeft = new Point2D(center.getX() - size/2, center.getY() - size/2);
			Point2D upperLeft = new Point2D(center.getX() - size/2, center.getY() + size/2);
			Point2D bottomRight = new Point2D(center.getX() + size/2, center.getY() - size/2);
			Point2D upperRight = new Point2D(center.getX() + size/2, center.getY() + size/2);
			
			drawHTrees(order-1, bottomLeft, size/2);
			drawHTrees(order-1, upperLeft, size/2);
			drawHTrees(order-1, bottomRight, size/2);
			drawHTrees(order-1, upperRight, size/2);
		}
	}
}
