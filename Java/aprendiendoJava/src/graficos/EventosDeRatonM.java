package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventosDeRatonM 
{

	public static void main(String[] args) 
	{
		MarcoRaton miMarco=new MarcoRaton();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoRaton extends JFrame
{
	public MarcoRaton()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Eventos de Mouse");
		
		EventosDeRaton mouse=new EventosDeRaton();
//		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
}

//LOS EVENTOS SON OBJETOS, LOS OBJETOS CAMBIAN DE TIPO SEGUN EL EVENTO QUE NECESITE REGISTRAR

//class EventosDeRaton implements MouseListener
//{
//
//	//AL HACER CLICK, NO DISTINGUE SI ES CLICK IZQUIERDO o DERECHO
//	public void mouseClicked(MouseEvent e) //Pressed+Released
//	{
//		//System.out.println("SE COMPLETO 1 CLICK");
//		
//		System.out.println("Coordenada X: "+e.getX()+" Coordenada Y: "+e.getY());
//		//TIENEN QUE SER CLICKS SEGUIDOS->ej: si necesita doble click para abrir un MENU
//		System.out.println("CANTIDAD DE CLICKS DEL METODO mouseClicked: "+e.getClickCount());
//		
//	}
//
//	public void mousePressed(MouseEvent e) //Presionado
//	{
//		//System.out.println("HAZ PRESIONADO CLICK");
//		
//		final int accion=e.getModifiersEx();
//		
//		if(e.BUTTON1_DOWN_MASK==accion)
//		{
//			System.out.println("CLICK IZQUIERDO");
//		}
//			
//		if(e.BUTTON2_DOWN_MASK==accion)
//		{
//			System.out.println("RUEDA");
//		}
//		if(e.BUTTON3_DOWN_MASK==accion)
//		{
//			System.out.println("CLICK DERECHO");
//		}
//	}
//
//	public void mouseReleased(MouseEvent e)//Liberado
//	{
//		//System.out.println("HAZ LIBERADO EL CLICK");
//	}
//	
//	//EN VENTANA
//
//	public void mouseEntered(MouseEvent e) 
//	{
//		//System.out.println("ENTRÉ A LA VENTANA CON EL CURSOR");
//	}
//
//	public void mouseExited(MouseEvent e) 
//	{
//		//System.out.println("SALI DE LA VENTANA CON EL CURSOR");
//	}
//	
//}

class EventosDeRaton implements MouseMotionListener
{

	public void mouseDragged(MouseEvent e) 
	{
		//Mantengo el CURSOR presionado
		System.out.println("Estoy arrastrando el CURSOR(Seleccionando)");
	}
	
	public void mouseMoved(MouseEvent e) 
	{
		//Muevo el mouse normalmente
		System.out.println("Estoy moviendo el CURSOR");
	}

	
}
