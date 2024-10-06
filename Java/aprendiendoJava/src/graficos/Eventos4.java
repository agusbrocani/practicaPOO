package graficos;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos4 
{

	public static void main(String[] args) 
	{
		MarcoEventoWindow2 myFrame=new MarcoEventoWindow2();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEventoWindow2 extends JFrame
{
	public MarcoEventoWindow2()
	{	
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		 
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Eventos de ventana");
		
		//No informa si lo cierro con la X
		//Maximizo o Minimizo si
		addWindowStateListener(new InformoEstado());
	}
	
}

class InformoEstado implements WindowStateListener
{
	public void windowStateChanged(WindowEvent e)
	{
		//System.out.println("La ventana ha cambiado de estado.");
		
		//Me imprime el valor entero de la constante de la clase Frame, si hago un switch, puedo imprimir concretamente la accion
		//System.out.println(e.getNewState());
		
		//Si quiero algo cuando cambia el estado, ej, si es maximizada
		if(e.getNewState()==Frame.MAXIMIZED_BOTH)//estado==6
		{
			System.out.println("PANTALLA COMPLETA");
		}
		
	}
}
