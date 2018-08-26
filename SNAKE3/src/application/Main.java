package application;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class Main extends Application
{
	private static final int SNAKE_SIZE = 40;
	private static final int WIDTH = SNAKE_SIZE*20;
	private static final int HEIGHT = SNAKE_SIZE*15;
	public static int score;
	public static int highscore;
	public static int snakeDeltaX = 1;
	HighScore hs=new HighScore();
	public static KeyCode keyCode;
	
	private GraphicsContext gc;
	
	@Override
	public void start(Stage primaryStage)
	{
		highscore=hs.readFileByLine("highscore.txt");
		Canvas canvas = new Canvas(WIDTH,HEIGHT);
		Group root = new Group();
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		
		Pear pear = new Pear(SNAKE_SIZE,WIDTH,HEIGHT);
		root.getChildren().add(pear);
		
		Image snakeImage = new Image("images/snake_head.png", SNAKE_SIZE, SNAKE_SIZE, false, true);
		SnakeHead snake = new SnakeHead(snakeImage);
		root.getChildren().add(snake);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Snake Game");
		primaryStage.show();
		
		drawBackground();
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, event ->
		{
			keyCode = event.getCode();
		});
		
		KeyFrame kf = new KeyFrame(Duration.millis(8), event ->
		{
			if(snake.eatPear(pear)) {
				
				pear.chooseRandom();
			score++;
			
			highscore=hs.readFileByLine("highscore.txt");
			if(score>highscore) {
				highscore=score;
				hs.writeFile(highscore);
				
			}
			drawBackground();
			}
			snake.move(keyCode);
			
			
		});
		
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	private void drawBackground()
	{
		gc.clearRect(0, 0, WIDTH, HEIGHT);
		Paint dkGray = Color.rgb(37, 37, 38);
		Paint ltGray = Color.rgb(63, 63, 70);
		gc.setFill(dkGray);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		gc.setStroke(ltGray);
		gc.setFill(Color.WHITE);
		String h="";
		String s="";
		s+=score;
		h+=highscore;
		gc.fillText(h, 0, 15);
		gc.fillText(s, 30, 15);
		
		for(int i = 0; i < WIDTH; i += SNAKE_SIZE)
		{
			gc.strokeLine(i, 0, i, HEIGHT);
		}
		for(int i = 0; i < HEIGHT; i += SNAKE_SIZE)
		{
			gc.strokeLine(0, i, WIDTH, i);
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
