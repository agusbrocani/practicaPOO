package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Eventos1 
{

	public static void main(String[] args) 
	{
		MarcoEvento miMarco=new MarcoEvento();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEvento extends JFrame
{
	public MarcoEvento()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		
		int height=screenSize.height;
		int width=screenSize.width;
		
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Probando Marcos y Eventos");
		
		LaminaEvento lamina1=new LaminaEvento();
		
		add(lamina1);
	}
	
}

//import java.awt.event.*;
//implemento la interfaz acá porque es la misma Lamina la que recibe el evento

class LaminaEvento extends JPanel implements ActionListener
{
	JButton botonAzul=new JButton("Fondo Azul");
	JButton botonRojo=new JButton("Fondo Rojo");
	JButton botonAmarillo=new JButton("Fondo Amarillo");
	
	public LaminaEvento()
	{
		add(botonAzul);//Agrego el boton a la lamina cuando instancio la lamina en el Marco
		//botonAzul va a desencadenar un EVENTO al hacer click y que ese evento lo va a recibir el objeto a la escucha(this)
		
		add(botonRojo);
		add(botonAmarillo);
		
		botonRojo.addActionListener(this);//3 fuentes y 1 solo oyente
		botonAmarillo.addActionListener(this);
		
		
		//OBJETO EVENTO:addActionListener()->es lo mismo que decirle "AL HACER CLICK"
		//OBJETO FUENTE: botonAzul
		//OBJETO LISTENER: this ->OBJETO que recibe el EVENTO->hago referencia a la misma clase donde me encuentro
		
		botonAzul.addActionListener(this);//Uso el this porque el objeto Listener(oyente) es la propia LaminaEvento
		//		Action->raton(mouse) ->ENTONCES->actionPerformed recibe un objeto ActionEvent
		//		Window->ventana
	}
	
	//3 FACTORES:
	//1-EVENTO: al hacer click en el boton "Fondo Azul"
	//2-FUENTE: el boton(Desencadena el evento)
	//3-LISTENER(receptor del evento): como quiero que la lamina se ponga azul, el listener va a ser la Lamina 
	
	//actionPerformed->METODO que marca QUE HACER cuando se recibe un EVENTO
	
	public void actionPerformed(ActionEvent e)
	{
		//getSource-> permite capturar el origen del ActionEvent
		
		Object botonPulsado=e.getSource();//instancio un Object(SUPERCLASE DEL QUE TODOS HEREDAN)
		
		
		
		if(botonPulsado==botonAzul)
		{
			setBackground(Color.BLUE);//Metodo para elegir un color de fondo de Lamina
		}
		
		if(botonPulsado==botonRojo)
		{
			setBackground(Color.RED);
		}
		
		if(botonPulsado==botonAmarillo)
		{
			setBackground(Color.YELLOW);
		}
		
		
	}
	//EVENTOS 3
	
}

//CUANDO HAGO CLICK EN EL BOTON:
//JAVA CONSTRUYE UN OBJETO DE TIPO EVENTO Y VIAJA AL OBJETO ActionEvent del metodo actionPerformed y se ejecuta


//Construyo un OBJETO que sea el propio color de FONDO y que ese objeto pueda cambiar, OTRA FORMA DE HACERLO
//La lamina ya no va a estar a la escucha-> no necesita implementar la interfaz y separo mejor LOS 3 FACTORES.