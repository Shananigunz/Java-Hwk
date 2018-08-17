package application;

import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Body extends ImageView{
	private static int bodyCount=0;
	private List<Point2D> moveHistory;
	private int moveIndex;
	public Body(Image image, List<Point2D>moveHistory) {
		super(image);
		this.moveHistory=moveHistory;
		bodyCount++;
		moveIndex=moveHistory.size()-bodyCount*80; //TODO -adjust value
	}
	public void move() {
		if(moveIndex>=0) {
			Point2D point=moveHistory.get(moveIndex);
			setX(point.getX());
			setY(point.getY());
			
		}
		moveIndex++;
		
	}
	
}
