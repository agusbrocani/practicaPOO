package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Eventos3 
{

	public static void main(String[] args) 
	{
		//Tengo 2 ventanas, con JFrame.EXIT_ON_CLOSE, cuando apreto X, me cierra las 2 y quiero que se quede la otra.
		//SOLUCION: uso JFrame.DISPOSE_ON_CLOSE
		//SI CIERRO EL PRIMER MARCO, EL PROGRAMA TERMINA, SI CIERRO EL SEGUNDO, ESA VENTANA DESAPARECE PERO SIGUE EN EJECUCION
		
		MarcoEventoWindow myFrame=new MarcoEventoWindow();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MarcoEventoWindow myFrame2=new MarcoEventoWindow();
		myFrame2.setVisible(true);
		myFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//SI QUIERO DALE SIZE, LOCATION Y TITLE DISTINTO, INVOCO A LOS sets EN EL MAIN
		
		
	}

}

class MarcoEventoWindow extends JFrame
{
	public MarcoEventoWindow()
	{	
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		 
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Eventos de ventana");
		
//		MVentana listenerVentana=new MVentana();
//		
//		addWindowListener(listenerVentana);
		
		//Para simplificar el codigo
		addWindowListener(new MVentana());//Instancio la clase oyente directamente
	}
	
}

class MVentana extends WindowAdapter implements WindowListener
{
	//Implemento TODOS los metodos o HEREDO WindowAdapter y hacer los metodos que yo quiera
	
//	public void windowActivated(WindowEvent e) 
//	{
//		System.out.println("VENTANA ACTIVADA");//Cuando maximizo o se abre la ventana-> Esta en primer plano la ventana
//	}
//	public void windowClosed(WindowEvent e)
//	{
//		//NO PUEDO VER CUANDO DESENCADENA LA ACCION POR EL COMANDO myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);, porque le indico que finalice
//		//se ejecuta cuando la ventana esta cerrada, como sigue en ejecucion el programa por la instruccion JFrame.DISPOSE_ON_CLOSE, lo puedo ver
//		
//		System.out.println("LA VENTANA HA SIDO CERRADA");
//	}
//	public void windowClosing(WindowEvent e)//Apreto la X y se cierra la ventana
//	{
//		System.out.println("CERRANDO VENTANA");
//	}
//	public void windowDeactivated(WindowEvent e)
//	{
//		System.out.println("VENTANA DESACTIVADA");//La ventana esta en segundo plano(minimizada), cuando la cierro no cuenta(con la cruz)
//	}
//	public void windowDeiconified(WindowEvent e)
//	{
//		System.out.println("VENTANA RESTAURADA");//Solo cuando maximizo la ventana
//	}
	public void windowIconified(WindowEvent e)
	{
		System.out.println("LA VENTANA HA SIDO MINIMIZADA.");
	}
//	public void windowOpened(WindowEvent e)
//	{
//		System.out.println("VENTANA ABIERTA");//Cuando abro la ventana
//	}
}
