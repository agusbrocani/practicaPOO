package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultipleFuentesEventos 
{

	public static void main(String[] args) 
	{
		MarcoAccion miMarco=new MarcoAccion();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoAccion extends JFrame
{
	public MarcoAccion()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Multiples Fuentes de Eventos");
		
		PanelAccion lamina1=new PanelAccion();
		add(lamina1);
		setVisible(true);
	}
}

//AGREGAR 3 BOTONES, QUE FUNCIONEN CON LOS BOTONES Y CON COMBINACIONES DE TECLAS(LA ACCION)
//BOTONES->FUENTE DE EVENTO
//LAMINA->OYENTE
class PanelAccion extends JPanel	//Lamina
{
	public PanelAccion()
	{
		ImageIcon iconoAmB=new ImageIcon("src/graficos/amarillo.PNG");
		ImageIcon iconoAzB=new ImageIcon("src/graficos/azul.PNG");
		ImageIcon iconoRoB=new ImageIcon("src/graficos/rojo.PNG");
		ImageIcon iconoAm=new ImageIcon(iconoAmB.getImage().getScaledInstance(50, 20, Image.SCALE_DEFAULT));//getScaledInstance(int width,int height,int hints)
		ImageIcon iconoAz=new ImageIcon(iconoAzB.getImage().getScaledInstance(50,20, Image.SCALE_DEFAULT));
		ImageIcon iconoRo=new ImageIcon(iconoRoB.getImage().getScaledInstance(50,20, Image.SCALE_DEFAULT));
		
		
		AccionColor accionAmarillo=new AccionColor("Amarillo",iconoAm,Color.YELLOW);
		AccionColor accionAzul=new AccionColor("Azul",iconoAz,Color.BLUE);
		AccionColor accionRojo=new AccionColor("Rojo",iconoRo,Color.RED);
		
		JButton botonAmarillo=new JButton(accionAmarillo);
		JButton botonAzul=new JButton(accionAzul);
		JButton botonRojo=new JButton(accionRojo);
		
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);
		//MANERA 2
		//add(new JButton(accionAmarillo));->Agrego un BOTON de una
		
		
		//MANERA 1	
		/*
		JButton botonAmarillo=new JButton("Amarillo");
		JButton botonAzul=new JButton("Azul");
		JButton botonRojo=new JButton("Rojo");
		
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);
		*/
		
		//COMBINACIONES DE TECLADO
		
		//1
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//Devuelve un objeto InputMap,PROPORCIONA UN VINCULO ENTRE UN EVENTO Y UN OBJETO, JComponent.WHEN_IN_FOCUSED_WINDOW->CONSTANTE DE CLASE INT->Invoco la combinacion de  teclas cuando el componente que lo recibe esta en la ventana enfocada
		//2
		KeyStroke combAmarillo=KeyStroke.getKeyStroke("ctrl Y");
		KeyStroke combAzul=KeyStroke.getKeyStroke("ctrl B");
		KeyStroke combRojo=KeyStroke.getKeyStroke("ctrl R");
		//3->Uso ACCIONES que ya tenia INSTANCIADAS.
		mapaEntrada.put(combAmarillo, "fondo amarillo");//Asigno comb de teclas a un Evento y le asigno una clave.
		mapaEntrada.put(combAzul, "fondo azul");
		mapaEntrada.put(combRojo, "fondo rojo");
		//4
		ActionMap mapaAccion=getActionMap();
		mapaAccion.put("fondo amarillo", accionAmarillo);//Vinculo entre Objeto y accion
		mapaAccion.put("fondo azul", accionAzul);
		mapaAccion.put("fondo rojo", accionRojo);
	}
	
	private class AccionColor extends AbstractAction	//ENCAPSULO PARA NO PODER ACCEDER DE AFUERA
	{
		public AccionColor(String nombre,Icon icono,Color colorBoton)
		{
			//Formato Clave: valor
			putValue(Action.NAME,nombre);//Constante static perteneciente a Action(Clave,Valor)
			putValue(Action.SMALL_ICON,icono);
			putValue(Action.SHORT_DESCRIPTION,"Poner la lamina de color "+nombre);//Descripcion del boton
			putValue("Color de fondo",colorBoton);//LA CLAVE ME LA INVENTO YO.->DESPUES LA USO EN actionPerformed
			
		}
		
		//El objeto del EVENTO viaja y se almacena en "e"
		public void actionPerformed(ActionEvent e) 
		{
			//Casteo un Object a Color
			Color c=(Color)getValue("Color de fondo");//Metodo de interfaz action->rescatar del objeto del evento el valor correspondiente a una clave->Yo le mando la clave "Color de fondo" y me devuelve el valor
			setBackground(c);//esta en la Clase JPanel->Como necesito que la clase donde estoy haciendo herede JPanel la convierto en una CLASE INTERNA
			System.out.println("Nombre: "+getValue(Action.NAME));
			System.out.println("Descripcion: "+getValue(Action.SHORT_DESCRIPTION));
		}

	}
}


//AbstractAction implementa 6 de los 7 metodos(Interfaz Action), queda implementar actionPerformed
//Cuando toco un BOTON se genera un OBJETO de tipo ActionEvent, y este mismo ES CAPAZ DE ALMACENAR INFORMACION RELATIVA A LA FUENTE ORIGINARIA DEL EVENTO
//Almacena la info del EVENTO como:
//Objeto acción(action)
//Clave:Valor
//ej:
//Edad(Clave):24(Valor)

//Qué info necesito ALMACENAR de un BOTON que GENERO un EVENTO FUENTE->NOMBRE DEL BOTON, ACCION DEL BOTON, UN ICONO QUE ACOMPAÑE AL BOTON[TODA ESTA INFO SE ALMACENA EN EL OBJETO EVENTO GENERADO A PARTIR DE QUE TOQUÉ EL BOTON]
//Para AMACENAR LA INFO de la FUENTE DEL EVENTO->uso putValue
//si necesito rescatar INFO->uso getValue dentro del metodo actionPerformed

//------>ACA IBA LA CLASE AccionColor-> la meti adentro de la clase PanelAccion



//https://www.youtube.com/watch?v=sY1CWJlqsSU&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=80