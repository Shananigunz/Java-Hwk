package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
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
		Image chromeImage=new Image("images/Cicon.jpg", 90, 90, false, true);
		ImageView chrome=new ImageView(chromeImage);
		
		
		root.getChildren().add(chrome);
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test");
		primaryStage.show();
		chrome.setX((400/2)-(chromeImage.getWidth()/2));
		chrome.setY((400/2)-(chromeImage.getHeight()/2));
		KeyFrame kf=new KeyFrame(Duration.millis(10), event  -> {
			chrome.setRotate(chrome.getRotate()+10);		
		
		});
		
		Timeline timeline=new Timeline(kf);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
