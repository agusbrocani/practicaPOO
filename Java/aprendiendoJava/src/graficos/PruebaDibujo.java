package graficos;
import java.awt.*;//Clase Graphics
import javax.swing.*;//Clase JFrame

public class PruebaDibujo 
{

	public static void main(String[] args) 
	{
		MarcoConDibujos miMarco=new MarcoConDibujos();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos extends JFrame
{
	public MarcoConDibujos()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		
		Dimension screenSize=myScreen.getScreenSize();
		
		int height=screenSize.height;
		int width=screenSize.width;
		
		setVisible(true);
		
		setSize(width/2,height/2);
		
		setLocation(width/4,height/4);
		
		setTitle("Dibujo en Lamina");
		
		LaminaConFiguras lamina1=new LaminaConFiguras();
		
		add(lamina1);//Desde la version 5.0 se puede usar add
		
	}

}

class LaminaConFiguras extends JPanel
{
	public void paintComponent(Graphics g)//No se puede modificar grosor de trazo, rotar figuras y otras cosas mas, por eso se agrego la biblioteca Java 2D, la cual permite dibujar figuras geometricas haciendo operaciones mas complejas-> Figuras son objetos, instancio clase y despues utilizar los metodos
	{
		super.paintComponent(g);
		
		g.drawRect(10, 10, 50, 50);//x,y,width,height-Rectangulos y Cuadrados
		
		g.drawLine(10, 70, 100, 70);//(X1,Y1),(X2,Y2)-> UNE 2 PUNTOS
		
		g.drawArc(10, 100, 20, 100, 120, 150);//Dibujar un arco
	}
	
}
