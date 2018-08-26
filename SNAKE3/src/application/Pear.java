package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pear extends ImageView
{
	private int blockSize;
	private int roomW;
	private int roomH;
	
	public Pear(int blockSize, int width, int height)
	{
		super(new Image("images/pear.png", blockSize, blockSize, false, true));
		this.blockSize = blockSize;
		roomW = width;
		roomH = height;
		chooseRandom();
	}
	
	public void chooseRandom()
	{
		Random rnd = new Random();
		setX(rnd.nextInt(roomW/blockSize)*blockSize);
		setY(rnd.nextInt(roomH/blockSize)*blockSize);
	}
}
