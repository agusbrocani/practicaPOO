package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventosDeFocoComponenteM 
{

	public static void main(String[] args) 
	{
		MarcoFoco miMarco=new MarcoFoco();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoFoco extends JFrame
{
	public MarcoFoco()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		
		//Si pongo el setVisible acá, solo me muestra el Frame y no los cuadros de texto
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Eventos de Foco");
		
		LaminaFoco lamina1=new LaminaFoco();
		add(lamina1);
		setVisible(true);//LA POSICION IMPORTA PORQUE HAY ERROR SINO
	}
}


class LaminaFoco extends JPanel
{
	public JTextField cuadro1;
	public JTextField cuadro2;
	
	public LaminaFoco()
	{
		//AGREGO 2 CUADROS DE TEXTO, CUANDO 1 PIERDE EL FOCO, SE DESENCADENA LA ACCION
		//LAYOUT: disposicion que tienen los ELEMENTOS dentro de una VENTANA.
			
		setLayout(null);//Ya no hay colocacion por defecto de los CUADROS DE TEXTO(Antes los ponia en el medio de la ventana)
				
		cuadro1=new JTextField(); 
		cuadro2=new JTextField(); 
				
		//Puedo usar setLocation y setSize
		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(120, 50, 150, 20);
		add(cuadro1);
		add(cuadro2);
				
		//PONGO A LA ESCUCHA A MI OBJETO
		LanzaFocos focoDelCuadro=new LanzaFocos();
				
		cuadro1.addFocusListener(focoDelCuadro);
	}
	
/*	La causa de que getText no funcione, es que el 
	método public void paintComponent(Graphics g) 
	cada vez que la ventana recibe una acción se vuelve a pintar la lamina, 
	y esto hace que el texto de cuadro de texto vuela a queda vacío, 
	la solución seria crear un constructor para la clase PanelFoco, 
	e incluir todo el código que tiene el metodo paintComponent(Graphics g) 
	excepto super.paintComponent(g);
*/
//-------------------------------------------------------------------------
	//ESTE METODO ESTA COMENTADO PORQUE NO SE USA Y CAUSA PROBLEMAS
//-------------------------------------------------------------------------
//	public void paintComponent(Graphics g)
//	{
//		super.paintComponent(g);
//	}
	
	//CLASE INTERNA-> para poder acceder a los OBJETOS cuadros.(LA ENCAPSULO PARA QUE NADIE MAS PUEDA ACCEDER)
	private class LanzaFocos implements FocusListener
	{
		//PROGRAMO QUE TIENE QUE HACER MI COMPONENTE cuadro1 CUANDO GANA Y CUANDO PIERDE EL FOCO.
		public void focusGained(FocusEvent e) 
		{
			//System.out.println("Gane el foco");
		}

		public void focusLost(FocusEvent e) 
		{
			//System.out.println("Perdi el foco");
			String email=cuadro1.getText();//Capturo el texto del cuadro1
			boolean comprobacion=false;
			int cantidadArroba=0;
			
			System.out.println(email);
			
			for(int i=0;i<email.length();i++)
			{
				if('@'==email.charAt(i))
				{
					comprobacion=true;
					cantidadArroba++;
				}
			}
			
			if(comprobacion&&cantidadArroba==1)
			{
				System.out.println("EMAIL CORRECTO");
			}
			else
			{
				System.out.println("EMAIL INCORRECTO");
			}
		}
		
	}
}

//EJ DE USO:
//TENGO LOS 2 CUADROS DE TEXTO, EN EL PRIMERO PONGO UN DNI Y QUIERO VALIDAR QUE SEA CORRECTO CUANDO ESA CASILLA PIERDE EL FOCO Y PASO A LA SIGUIENTE, SI ES INVALIDO EL DNI, TENGO QUE SEGUIR EN LA ANTERIOR HASTA QUE SEA CORRECTO
