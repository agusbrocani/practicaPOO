package graficos;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

//Clase que GENERA el Frame se convierte en Listener(oyente)
public class FocoVentana extends JFrame implements WindowFocusListener
{
	public void windowGainedFocus(WindowEvent e)
	{
		
		//getSource=> RETORNA EL OBJETO DEL EVENTO OCURRIDO
		if(e.getSource()==marco1)
		{
			marco1.setTitle("Tengo el FOCO");
		}
		else
		{
			marco2.setTitle("Tengo el FOCO");
		}
		
	}
	//Si no le digo que hacer cuando pierde el foco, el titulo me queda en las 2 ventanas por mas que perdio
	public void windowLostFocus(WindowEvent e) 
	{
		if(e.getSource()==marco1)
		{
			marco1.setTitle("");
		}
		else
		{
			marco2.setTitle("");
		}
	}
	
	public void iniciar()
	{
		marco1=new FocoVentana();
		marco2=new FocoVentana();
		
		marco1.setVisible(true);
		marco2.setVisible(true);
		
		marco1.setBounds(300,100,600,350);
		marco2.setBounds(1200, 100, 600, 350);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco1.addWindowFocusListener(this);//porque el oyente es la misma clase
		marco2.addWindowFocusListener(this);
	}
	
	FocoVentana marco1;
	FocoVentana marco2;
	
	public static void main(String[] args) 
	{
		FocoVentana miMarco=new FocoVentana();
		miMarco.iniciar();
	}

}
