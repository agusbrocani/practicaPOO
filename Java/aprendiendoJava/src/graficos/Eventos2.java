package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Eventos2 
{

	public static void main(String[] args) 
	{
		MarcoEvento2 miMarco=new MarcoEvento2();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEvento2 extends JFrame
{
	public MarcoEvento2()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		
		int height=screenSize.height;
		int width=screenSize.width;
		
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Probando Marcos y Eventos");
		
		LaminaEvento2 lamina1=new LaminaEvento2();
		
		add(lamina1);
	}
	
}


class LaminaEvento2 extends JPanel
{
	JButton botonAzul=new JButton("Fondo Azul");
	JButton botonRojo=new JButton("Fondo Rojo");
	JButton botonAmarillo=new JButton("Fondo Amarillo");
	
	public LaminaEvento2()
	{
		add(botonAzul);
		add(botonRojo);
		add(botonAmarillo);
		
		ColorFondo Rojo=new ColorFondo(Color.RED);
		ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
		ColorFondo Azul=new ColorFondo(Color.BLUE);
		
		botonRojo.addActionListener(Rojo);
		botonAmarillo.addActionListener(Amarillo);
		botonAzul.addActionListener(Azul);
	}
	
	//Clase interna de LaminaEvento2-> la declaro private para que solo la clase contenedora pueda acceder.
	//Clase Oyente
	private class ColorFondo implements ActionListener
	{
		private Color colorDeFondo;
		
		public ColorFondo(Color c)
		{
			colorDeFondo=c;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			setBackground(colorDeFondo);
		}
	}
	
}
