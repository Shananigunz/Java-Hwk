package application;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Grape extends ImageView{
	int width, height;
	
	static Random rnd=new Random();
	public Grape(Image image, int Width, int Height) {
		super(image);
		width=Width;
		height=Height;
		
		moveRandom();
		//setX(rnd.nextInt());
		//setY(rnd.nextInt());
	}
	
	
	
	
	public void moveRandom() {
				
				setX(rnd.nextInt(width-50));
				setY(rnd.nextInt(height-50));
				
				
				
			}
			
			
		
		
		
	}
	
	

