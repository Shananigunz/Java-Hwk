package application;

import java.util.ArrayList;
import java.util.List;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class SnakeHead extends ImageView
{
	public int xdirection=1;
	public int ydirection=0;
	public int timeCounter=0;
	private int gridSize;
	private List<Point2D> moveHistory;
	public SnakeHead(Image image) {
		super(image);
		setX(0);
		setY(300);
		gridSize=(int)getImage().getWidth();
		
		
	}
	
	public List<Point2D> move(int WIDTH, int HEIGHT, int HeadWidth, int HeadHeight, KeyCode keyCode) {
			
			boolean a= (int)(getX()%gridSize)==0;
			
			boolean b=(int)(getY()% gridSize)==0;
			
			if(a || b) {
				if(keyCode==KeyCode.RIGHT&&getRotate()!=180) {
					xdirection=1;
					ydirection=0;
					setRotate(0);
					
				}
				if(keyCode==KeyCode.LEFT&&getRotate()!=0) {
					xdirection=-1;
					ydirection=0;
					setRotate(180);
					
				}
				if(keyCode==KeyCode.UP&&getRotate()!=90) {
					setRotate(-90);
					ydirection=-1;
					xdirection=0;
				}
				if(keyCode==KeyCode.DOWN&&getRotate()!=-90) {
					setRotate(90);
					ydirection=1;
					xdirection=0;				
				}
				
				
			}
			setY(getY()+ydirection);
			setX(getX()+xdirection);
			moveHistory.add(new Point2D(getX(), getY()));
			return moveHistory;
	}
		public boolean eatApple(ImageView pear) {
			double offsetX=Math.abs(getX()-pear.getX());
			double offsetY=Math.abs(getY()-pear.getY());
			if(offsetX<50&&offsetY<50) 
				return true;
				
		
			
				return false;
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
