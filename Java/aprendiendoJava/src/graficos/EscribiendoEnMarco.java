package graficos;
import javax.swing.*;
import java.awt.*;


public class EscribiendoEnMarco 
{

	public static void main(String[] args) 
	{
		Frame myFrame=new Frame();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

class Frame extends JFrame
{	
	public Frame()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		
		Dimension screenSize=myScreen.getScreenSize();
		
		int height=screenSize.height;
		int width=screenSize.width;
		
		setVisible(true);
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Frame");
		
		//Instancio la Lamina a agregar
		Lamina miLamina=new Lamina();
		
		//Agrego la lamina encima de mi Marco
		
		add(miLamina);
		
		//POR ALGUNA RAZON QUE DESCONOZCO, si hago esto antes de instanciar la Lamina, no muestra el texto
		Image icon=myScreen.getImage("src/graficos/icono.png");
		setIconImage(icon);
		
	}
	
}

class Lamina extends JPanel
{
	//Como no creo constructores de JPanel, usa el constructor por defecto
	
	//Sobreescribo el metodo paintComponent para que escriba lo que yo quiero
	
	public void paintComponent(Graphics g)//SOBREESCRITURA DEL METODO de JPanel
	{
		super.paintComponent(g);//INVOCO A UN METODO DE LA CLASE PADRE para que haga lo suyo
		
		//Con el objeto g, accedo a todos los METODOS que DIBUJAN en la LAMINA
		g.drawString("Mi texto en Swing", 10,20);//("Texto",x,y), x e y son la posicion relativa del texto desde el marco
		
		
	}
}
