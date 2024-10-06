package juego;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Point;

public class Snake
{

	public static void main(String[] args) throws Exception
	{
		Frame myFrame=new Frame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class Frame extends JFrame
{
	public static int widthScreen;
	public static int heightScreen;
	public static ImagenSnake imageSnake=new ImagenSnake();
	
	public Frame()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		widthScreen=screenSize.width;
		heightScreen=screenSize.height;
		setSize(widthScreen/2,heightScreen/2);
		setLocation(widthScreen/4,heightScreen/4);
		setTitle("Snake by Agustin Brocani");
		Teclas teclas=new Teclas();
		addKeyListener(teclas);
		add(imageSnake);
		Momento momento=new Momento();
		Thread trid=new Thread(momento);
		trid.start();
		setVisible(true);
		
		
	}
	
	public static void actualizar() 
	{
		imageSnake.repaint();
	}
}

class Teclas extends KeyAdapter
{
	public static int direccion=KeyEvent.VK_RIGHT;
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
				System.exit(0);
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(direccion!=KeyEvent.VK_DOWN)
			{
				direccion=KeyEvent.VK_UP;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(direccion!=KeyEvent.VK_UP)
			{
				direccion=KeyEvent.VK_DOWN;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(direccion!=KeyEvent.VK_RIGHT)
			{
				direccion=KeyEvent.VK_LEFT;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(direccion!=KeyEvent.VK_LEFT)
			{
				direccion=KeyEvent.VK_RIGHT;
			}
		}
	}
	
}

class ImagenSnake extends JPanel
{
	public static int widthPoint=10;
	public static int heightPoint=10;
	public static Point snake=new Point(Frame.widthScreen/2,Frame.heightScreen/2);
	public static long frecuencia=20;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(0,0,255));
		g.fillRect(snake.x, snake.y, widthPoint, heightPoint);//es un rectangulo de la viborita
	}
	
}


class Momento extends Thread
{
	long last=0;
	
	public void run()
	{
		while(true)//VA A CORRER SIEMPRE, actualizo el juego cada 20 ms
		{
			if((java.lang.System.currentTimeMillis()-last)>ImagenSnake.frecuencia)
			{
				if(Teclas.direccion==KeyEvent.VK_UP)
				{
					ImagenSnake.snake.y = ImagenSnake.snake.y-ImagenSnake.heightPoint;
					
					if(ImagenSnake.snake.y > Frame.heightScreen/2)
					{
						ImagenSnake.snake.y = 0;
					}
					if(ImagenSnake.snake.y<0)
					{
						ImagenSnake.snake.y = Frame.heightScreen/2-ImagenSnake.heightPoint;
					}
				}else if(Teclas.direccion==KeyEvent.VK_DOWN){
					ImagenSnake.snake.y = ImagenSnake.snake.y+ImagenSnake.heightPoint;
					if(ImagenSnake.snake.y > Frame.heightScreen/2)
					{
						ImagenSnake.snake.y = 0;
					}
					
					if(ImagenSnake.snake.y<0)
					{
						ImagenSnake.snake.y = Frame.heightScreen/2-ImagenSnake.heightPoint;
					}
				}else if(Teclas.direccion==KeyEvent.VK_LEFT){
					ImagenSnake.snake.x = ImagenSnake.snake.x-ImagenSnake.widthPoint;
					if(ImagenSnake.snake.x > Frame.widthScreen/2)
					{
						ImagenSnake.snake.x = 0;
					}
					
					if(ImagenSnake.snake.x<0)
					{
						ImagenSnake.snake.x = Frame.widthScreen/2-ImagenSnake.widthPoint;
					}
				}else if(Teclas.direccion==KeyEvent.VK_RIGHT){
					ImagenSnake.snake.x = ImagenSnake.snake.x+ImagenSnake.widthPoint;
					if(ImagenSnake.snake.x > Frame.widthScreen/2)
					{
						ImagenSnake.snake.x = 0;
					}
					
					if(ImagenSnake.snake.x<0)
					{
						ImagenSnake.snake.x = Frame.widthScreen-ImagenSnake.widthPoint;
					}
				}
				
				Frame.actualizar();
				last=java.lang.System.currentTimeMillis();
			}
		}
	}
}

//EL JUEGO TIENE UN ERROR: TENGO QUE LIMITARME A EL BORDE DEL FRAME Y NO DE LA PANTALLA COMPLETA
//https://www.youtube.com/watch?v=aP-Jcdwqrz0 25:27