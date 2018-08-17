package flappyBird;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Random;
public class FlappyBird {

	private JFrame frame;
	private DisplayPanel displayPanel;
	private int frameHeight=500;
	private int frameWidth=500;
	public static void main(String[]args) {
		FlappyBird fb=new FlappyBird();
		fb.start();
		
		
	}
	public void start() {
		frame =new JFrame("Flappy Bird");
		frame.setSize(frameWidth,frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayPanel=new DisplayPanel();
		
		frame.getContentPane().add(displayPanel, BorderLayout.CENTER);
		displayPanel.setFocusable(true);
		displayPanel.requestFocusInWindow();
		frame.setVisible(true);
		
	}
	class DisplayPanel extends JPanel implements Runnable, KeyListener{
		Random rnd=new Random();
		boolean running;
		boolean px2R;
		boolean pxR;
		double x=100,y=50;
		double gravity=-0.15;
		double jumpHeight=4;
		double bx=0;
		double px=400, px2=400;
		double py=280,py2=-170;
		double sub=px2-px;
		boolean lose=false;
		double vspeed=0;
		double hspeed=0;
		boolean flapping;
		int DIAMETER=20;
		//private JButton btn;
		private BufferedImage flappyImage;
		private BufferedImage backImage;
		private BufferedImage pipeTop;
		private BufferedImage pipeBottom;
				public DisplayPanel() {
			this.addKeyListener(this);
			try {
				flappyImage=ImageIO.read(getClass().getResource("images/FlappyBird.png"));
				backImage=ImageIO.read(getClass().getResource("images/back.png"));
				pipeTop=ImageIO.read(getClass().getResource("images/PipeTop.png"));
				pipeBottom=ImageIO.read(getClass().getResource("images/PipeBottom.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			startThread();
			
		}
		
		void startThread() {
			Thread runner=new Thread(this);
			running=true;
			flapping=false;
			lose=false;
			runner.start();
			
		}
		
		void stopThread() {
			running=false;
			
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawImage(backImage, (int)bx, 0, 828, 512, (ImageObserver)this);
			g.drawImage(pipeBottom, (int)px, (int)py, 52, 242, (ImageObserver)this);			
			g.drawImage(flappyImage, (int)x, (int)y, 34, 24, (ImageObserver)this);
			g.drawImage(pipeTop, (int)px2, (int)py2, 52, 342, (ImageObserver)this);
			if(lose==true) {
				g.setFont(new Font("Arial", Font.BOLD, 50));
				g.drawString("You lose", 120, 220);
				
			}
			
					}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Game started...............");
		while(running) {
			if(flapping) {
			vspeed-=gravity;
			if(vspeed>10) {
				vspeed=10;
				
				
			}
			
			if(y>=500) {
				lose=true;
				stopThread();
				
			}
			if(y<0) {
				y=0;
				vspeed=0;
				
			}
			
			
			y+=vspeed;
			
			px-=2;
			px2-=2;
			if(px2<-52) {
				
				
				px2=600;
				
				
			}
			if(px<-52) {
				px=600;
				
				
			}
			}
			bx-=1;
			
			if(bx==-276) {
				bx=0;
			}
			
			
				
				
			
			
			
			
			repaint();
			try {
				Thread.sleep(17);
			}
			catch(InterruptedException e) {
				
			}
		}	
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==87) {
				
				if(!flapping) {
				flapping=true;
				}
				vspeed=-jumpHeight;   
				
			}
			System.out.println(e.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
}
