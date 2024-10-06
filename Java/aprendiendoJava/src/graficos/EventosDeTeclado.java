package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventosDeTeclado 
{

	public static void main(String[] args) 
	{
		NuevoMarco miMarco=new NuevoMarco();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class NuevoMarco extends JFrame
{
	public NuevoMarco()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		
		int height=screenSize.height;
		int width=screenSize.width;
		
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Eventos de teclado");
		//Instancio cual es el objeto oyente y la pongo a la escucha
		EventoDeTeclado tecla=new EventoDeTeclado();
		addKeyListener(tecla);
	}
}

class EventoDeTeclado implements KeyListener
{

	public void keyTyped(KeyEvent e) //Cuando pulso y levanto la tecla(COMBINACION DE LOS 2)
	{
		//System.out.println(e.getKeyChar());
	}

	public void keyPressed(KeyEvent e) //Cuando pulso la tecla
	{
//		int codigoTecla=e.getKeyCode();
//		System.out.println(codigoTecla);
	}

	public void keyReleased(KeyEvent e)//Cuando la tecla es Liberada y va hacia arriba
	{
		//Devuelve la letra que fue presionada
		//System.out.println(e.getKeyChar());
	}
	
}