package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;//Clase abstracta Rectangle2D,Ellipse2D pero tienen clases internas->Elipse2D.Double y Elipse2D.Float->Se hicieron para trabajar con argumentos de tipo double y float


public class EscribiendoMarcoJava2D
{

	public static void main(String[] args) 
	{
		MyFrame frame=new MyFrame();
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MyFrame extends JFrame
{
	public MyFrame()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		
		Dimension screenSize=myScreen.getScreenSize();
		
		int height=screenSize.height;
		int width=screenSize.width;
		 
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Practicando Java 2D");
		
		Lamina1 lamina=new Lamina1();
		
		add(lamina);
		
		lamina.setBackground(SystemColor.window);//Le da a mi lamina color de fondo por defecto SEGUN EL SISTEMA OPERATIVO DONDE SE EJECUTA EL PROGRAMA
	}
}

//JAVA2D Permite modificar el trazo, tambien se puede rotar y muchas mas cosas
//EL ORDEN IMPORTA A LA HORA DE EJECUTAR LOS METODOS

class Lamina1 extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//CASTEO DE Objeto Graphics a objeto Graphics2D
		//Intanciar clase Rectangle2D->CLASE ABSTRACTA->No puedo instanciarla directamente->Uso Class Rectangle2D.Double
		Graphics2D g2=(Graphics2D) g;
		
		//Por principio de sustitucion "es un"
		//Como Rectangle2D.Double hereda de Rectangle2D con el principio "es un", puedo instanciarla
		Rectangle2D rectangle=new Rectangle2D.Double(10,10,200,200);//(width,height,x,y)
		
		
		
		//CAMBIO COLOR
		g2.setColor(new Color(255,255,0));
		g2.fill(rectangle);
		
		//CAMBIO COLOR
		g2.setColor(Color.RED.darker().darker());
		g2.draw(rectangle);//rectangle es un objeto que implementa la interfaz Shape
		
		//CAMBIO COLOR
		g2.setColor(Color.BLACK.brighter().brighter().brighter());
		//Para dibujar una Elipse
		//Le indico el rectangulo imaginario(Con ancho y largo) donde va a estar contenida la Elipse
		
		Ellipse2D elipse=new Ellipse2D.Double();
		
		Rectangle2D rectAux=new Rectangle2D.Double(10,220,200,200);//Uso el rectangulo auxiliar pero no lo dibujo
		
		elipse.setFrame(rectAux);
		
		//CAMBIO COLOR
		g2.setPaint(Color.CYAN);//CAMBIO COLOR DE TODOS LOS TRAZOS CON LOS QUE DIBUJO
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(10,450,800,450));//punto inicial,punto final
		
		//Dibujar un circulo que englobe al rectangulo
		
		double centroX=rectangle.getCenterX();
		double centroY=rectangle.getCenterY();
		
		double radio=200;
		
		Ellipse2D circulo=new Ellipse2D.Double();
		
		//CAMBIO COLOR
		g2.setPaint(new Color(0,140,255));
		
		circulo.setFrameFromCenter(centroX, centroY, centroX+radio, centroY+radio);
		
		g2.draw(circulo);
		
		Color miColor=new Color(255,0,255);
		
		Rectangle2D miRectanguloColor=new Rectangle2D.Double(500,10,200,200);
		
		g2.setPaint(miColor.brighter().brighter());
		
		g2.fill(miRectanguloColor);
		
		g2.setPaint(Color.BLUE);
		
		g2.draw(miRectanguloColor);
		
		
		
	}
}