import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class fxTest extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		
		stage.setResizable(true);
		stage.setScene(new Scene(createContent()));
		stage.show();
	}
	public Parent createContent() {
		Box red = new Box(200,200,200);
		red.setMaterial(new PhongMaterial(Color.AQUA));
		red.setDrawMode(DrawMode.FILL);
		PerspectiveCamera cam = new PerspectiveCamera(false);
		cam.getTransforms().addAll(new Rotate(-20,Rotate.Y_AXIS),new Rotate(-20,Rotate.X_AXIS),new Translate(0,0,-15));
		
		Group root = new Group();
		root.getChildren().add(cam);
		root.getChildren().add(red);
		
		SubScene sub = new SubScene(root, 300, 300);
		sub.setFill(Color.ALICEBLUE);
		sub.setCamera(cam);
		
		Group group = new Group();
		group.getChildren().add(sub);
		return group;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
