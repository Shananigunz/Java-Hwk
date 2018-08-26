package application;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class SnakeHead extends ImageView
{
	private int speed = 2;
	private int deltaX = 0;
	private int deltaY = 0;
	
	private int blockSize;

	public SnakeHead(Image image)
	{
		super(image);
		Init(image);
	}
	
	public SnakeHead(Image image, int speed)
	{
		super(image);
		Init(image);
		this.speed = speed;
	}
	
	private void Init(Image image)
	{
		blockSize = (int)image.getWidth();
		setX(0);
		setY(0);
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void move(KeyCode keyCode)
	{
		updateDeltas(keyCode);
		
		setX(getX() + deltaX);
		setY(getY() + deltaY);
	}
	
	private void updateDeltas(KeyCode keyCode)
	{
		if(!(getX() % blockSize == 0 && getY() % blockSize == 0))
			return;
		
		if(keyCode == KeyCode.RIGHT && getRotate()!=180)
		{
			deltaX = speed;
			deltaY = 0;
			setRotate(0);
		}
		else if(keyCode == KeyCode.LEFT && getRotate()!=0)
		{
			deltaX = -speed;
			deltaY = 0;
			setRotate(180);
		}
		else if(keyCode == KeyCode.UP && getRotate()!=90)
		{
			deltaX = 0;
			deltaY = -speed;
			setRotate(-90);
		}
		else if(keyCode == KeyCode.DOWN && getRotate()!=-90)
		{
			deltaX = 0;
			deltaY = speed;
			setRotate(90);
		}
	}
	
	public boolean eatPear(ImageView pear)
	{
		double offsetX = Math.abs(getX()-pear.getX());
		double offsetY = Math.abs(getY()-pear.getY());
		
		if(offsetX < 1 && offsetY < 1)
			return true;
		
		return false;
	}
}
