package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Canvas canvas=new Canvas(400,400);	
		Group root=new Group();
		root.getChildren().add(canvas);
		Image grapeImage=new Image("images/TotallyAGrape.....png", 90, 90, false, true);
		ImageView grape=new ImageView(grapeImage);
		
		grape.setX((400/2)-(grapeImage.getWidth()/2));
		root.getChildren().add(grape);
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
