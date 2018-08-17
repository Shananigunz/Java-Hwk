package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	private static final int WIDTH=800;
	private List<Point2D> moveHistory;
	public static final int HEIGHT=600;
	public static KeyCode keyCode;
	private GraphicsContext gc;
	private int score;
	private List<Body>snakeBodies=new ArrayList<Body>();
	
	@Override
	public void start(Stage primaryStage) {
		Canvas canvas=new Canvas(WIDTH, HEIGHT);
		Group root=new Group();
		root.getChildren().add(canvas);
		gc=canvas.getGraphicsContext2D();		
		Image snakeImage=new Image("images/snake head.PNG", 50, 50, false, true);
		SnakeHead snake=new SnakeHead(snakeImage);
		Image appleImage=new Image("images/TotallyAGrape.....png", 50, 50, false, true);
		
		
		Grape grape=new Grape(appleImage, WIDTH, HEIGHT);
		root.getChildren().add(snake);
		root.getChildren().add(grape);
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Play Snake");
		primaryStage.show();
		
		resetGame(snake, grape);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
			keyCode=event.getCode();
		});
		KeyFrame kf=new KeyFrame(Duration.millis(10), event  -> {
			snake.move(WIDTH, HEIGHT, (int)snakeImage.getWidth(), (int)snakeImage.getHeight(), keyCode);
			moveHistory=snake.move(WIDTH, HEIGHT, (int)snakeImage.getWidth(), (int)snakeImage.getHeight(), keyCode);
			for(Body snakeBody:snakeBodies) {
				snakeBody.move();
				
			}
			if(snake.eatApple(grape)) {
			grape.moveRandom();
			scoreIncrease();
			Image bodyImage=new Image("images/Untitled.png", 50, 50, false, true);
			Main main=new Main();
			Body body=new Body(bodyImage, main.getMoveHistory());
			root.getChildren().add(body);
			}
		});
		Timeline timeline=new Timeline(kf);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		resetGame(snake, grape);
		
	}
	public void resetGame(SnakeHead snake, Grape apple) {
		apple.moveRandom();
		setInitialPosition(snake);
		score=0;
		displayScore();
	}
	public void setInitialPosition(SnakeHead snake) {
		snake.setX(WIDTH/2);
		snake.setY(HEIGHT/2);
		moveHistory=new ArrayList<Point2D>();
	}
	public List<Point2D> getMoveHistory(){
		return moveHistory;
		
	}
	public void scoreIncrease() {
		score++;
		displayScore();
	}
	public void displayScore() {
		gc.clearRect(0,0,WIDTH,30);
		gc.setFont(new Font("Arial", 36));
		gc.fillText("Score: "+score, 10, 30);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
