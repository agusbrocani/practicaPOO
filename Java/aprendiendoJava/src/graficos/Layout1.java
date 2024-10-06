package graficos;
import java.awt.*;
import javax.swing.*;

public class Layout1 
{

	public static void main(String[] args) 
	{
		FrameLayout myFrame=new FrameLayout();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//class FrameLayout extends JFrame
//{
//	public FrameLayout()
//	{
//		Toolkit myScreen=Toolkit.getDefaultToolkit();
//		Dimension screenSize=myScreen.getScreenSize();
//		int width=screenSize.width;
//		int height=screenSize.height;
//		setSize(width/2,height/2);
//		setLocation(width/4,height/4);
//		setTitle("Layout");
//		LaminaLayout lamina=new LaminaLayout();
//		//Le digo que disposicion tienen los elementos de la lamina
//		//FlowLayout disposicion=new FlowLayout(FlowLayout.CENTER,10,10);
//		//lamina.setLayout(disposicion);
//		add(lamina);
//	}
//}
//
//class LaminaLayout extends JPanel
//{
//	public LaminaLayout()
//	{
//		//setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//		//setLayout(new BorderLayout());//No deja espacios entre los botones con el const. por defecto
//		setLayout(new BorderLayout(10,10));//CREO UNA NUEVA DISPOCION
//		add(new Button("Amarillo"),BorderLayout.NORTH);//add(COMPONENTE A AGREGAR, POSICION DONDE SE AGREGA);
//		add(new Button("Azul"),BorderLayout.SOUTH);
//		add(new Button("Rojo"),BorderLayout.WEST);
//		add(new Button("Verde"),BorderLayout.EAST);
//		//add(new Button("Negro"));Si no especifico me lo ubica en el espacio que queda
//		add(new Button("Negro"),BorderLayout.CENTER);
//	}
//}

//-------------------------------
class FrameLayout extends JFrame
{
	public FrameLayout()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Layout");
		LaminaLayout lamina=new LaminaLayout();
		LaminaLayout2 lamina2=new LaminaLayout2();
		//Para que aparezcan las 2, le tengo que decir a mi contenedor que es el marco que disposicion va a tener
		add(lamina,BorderLayout.NORTH);//COLOCO 1 LAMINA EN LA PARTE SUPERIOR DEL MARCO
		add(lamina2,BorderLayout.SOUTH);//COLOCO 1 LAMINA EN LA PARTE INFERIOR DEL MARCO
	}
}

class LaminaLayout extends JPanel
{
	public LaminaLayout()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new Button("Amarillo"));
		add(new Button("Rojo"));

	}
}

class LaminaLayout2 extends JPanel
{
	public LaminaLayout2()
	{
		setLayout(new BorderLayout());
		add(new Button("Azul"),BorderLayout.WEST);
		add(new Button("Verde"),BorderLayout.EAST);
		add(new Button("Negro"),BorderLayout.CENTER);
	}
	
}

