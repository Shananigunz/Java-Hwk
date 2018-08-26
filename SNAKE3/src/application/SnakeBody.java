package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SnakeBody extends ImageView
{
	public SnakeBody(int snake_size)
	{
		super(new Image("images/snake_body.png", snake_size, snake_size, false, true));
	}
}
