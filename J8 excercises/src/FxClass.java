import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class FxClass extends Application {
	Canvas canvas = new Canvas();

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * Blue = 0 Yellow = 1 Red= 2 Green = 3
	 * 
	 */
	Tile YRBB = new Tile(new int[] { 1, 2, 0, 0 });
	Tile RYGG = new Tile(new int[] { 2, 1, 3, 3 });
	Tile GBRR = new Tile(new int[] { 3, 0, 2, 2 });
	Tile BGYY = new Tile(new int[] { 0, 3, 1, 1 });
	Tile[] tiles = new Tile[] { YRBB, RYGG, GBRR, BGYY };
	Set<Tile> tileSet = new HashSet<Tile>(Arrays.asList(tiles));

	void draw4(GraphicsContext gc, Tile[][] plane) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(5);
		double xPointer = 5;
		double yPointer = 5;
		double size = 30;
		double offset = 5;
		// while ((xPointer + size) < canvas.getWidth() && (yPointer + size) <
		// canvas.getHeight()) {
		int count = 0;
		for (Tile[] tLine : plane) {
			System.out.println(count++);
			for (Tile t : tLine) {
				if (t == null) {
					throw new Error("bitch");
				}
				myRec(gc, new double[] { xPointer, yPointer, xPointer + size, yPointer + size }, t);
				xPointer += size + offset;
				System.out.println(t.toString());
				
			}
			xPointer = 5;
			yPointer += size + offset;
			System.out.println(yPointer);
		}
		/*for (Tile t : tiles) {
			myRec(gc, new double[] { xPointer, yPointer, xPointer + size, yPointer + size }, t);
			xPointer += size + offset;
			yPointer += size + offset;
		}
		System.out.println(xPointer);*/
	}

	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		TileMatcher match = new TileMatcher(8, 8);
		Tile[][] plane = match.fillPlane(tileSet);
		primaryStage.setTitle("Drawing Operations Test");
		Group root = new Group();
		canvas.setHeight(320);
		canvas.setWidth(320);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		draw4(gc, plane);
	}

	void myRec(GraphicsContext gc, double[] coo, Tile t) {

		setTop(gc, coo, t.getTop());
		setBot(gc, coo, t.getBot());
		setLeft(gc, coo, t.getLeft());
		setRight(gc, coo, t.getRight());
	}

	void setTop(GraphicsContext gc, double[] coo, Color col) {
		gc.setStroke(col);
		gc.strokeLine(coo[0], coo[1], coo[2], coo[1]);// top
	}

	void setLeft(GraphicsContext gc, double[] coo, Color col) {
		gc.setStroke(col);
		gc.strokeLine(coo[0], coo[1], coo[0], coo[3]);// left
	}

	void setBot(GraphicsContext gc, double[] coo, Color col) {
		gc.setStroke(col);
		gc.strokeLine(coo[0], coo[3], coo[2], coo[3]);// bot
	}

	void setRight(GraphicsContext gc, double[] coo, Color col) {
		gc.setStroke(col);
		gc.strokeLine(coo[2], coo[1], coo[2], coo[3]);// right
	}

}