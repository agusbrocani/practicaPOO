package graficos;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.imageio.*;//Image
import java.io.*;//FILE

public class FuentesDeTexto 
{

	public static void main(String[] args) 
	{
		FrameWithFont myFrame=new FrameWithFont();
		
		myFrame.setVisible(true);
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameWithFont extends JFrame
{
	public FrameWithFont()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
	
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Prueba de Fuentes");
		
		LFont lamina=new LFont();
		
		add(lamina);
		
		//ESTABLECER EL COLOR DE TODA LA LAMINA
		//lamina.setForeground(Color.BLUE);//Esto sirve si no utilice el metodo setColor dentro de mi Lamina
		
		LaminaConImagen laminaImagen=new LaminaConImagen();
		
		add(laminaImagen);
		
	}	
}

class LFont extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		 Font myFont=new Font("Courier",Font.BOLD,150);
		 //Puedo instanciar otra clase fuente para tener mas de 1
		 //Puedo instanciar un objeto de la clase Font dentro de un metodo
		 
		 g2.setFont(myFont);//Establezco mi tipo de fuente
		 
		 g2.setColor(Color.black.darker().darker());
		 
		 //g2.drawString("F O N O H A", 50, 200);//EN LAS COORDENADAS ME INSERTA EL RENGLON DONDE HACE LA LETRA
	
		 //g2.drawString("M A N C O",100, 400);
		 
		 //Usando TODO
		 
		 //g2.setFont(new Font("Arial",Font.ITALIC,14));
		 //g2.setColor(new Color(255,0,255).brighter());
		 //g2.drawString("Curso de Java",10,20);
		 
		 
	}
}

class LaminaConImagen extends JPanel
{
	private Image imagen;//Como declare esto como atributo, puedo utilizarlo en toda la clase
	
	//*MODIFICACION
	
	public LaminaConImagen()
	{
		
		//Cada vez que instancio la lamina, la agrego y le doy un estado inicial a la lamina, cargando la imagen en memoria
		try 
		{
			imagen=ImageIO.read(new File("src/graficos/pinguino.png"));
		}catch(IOException e)
		{
			System.out.println("No se encontro la imagen");
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Cuando redimensiono la pantalla, vuelvo a llamar a este metodo para pintar el frame nuevamente
		
		File myImage=new File("src/graficos/coche.png");
		
		//exception que puede pasar en tiempo de ejecucion
		//El codigo entra en el try e ignora el catch porque encuentra la imagen
		//SI NO LA ENCUENTRA-> read lanza una exception -> la capta el catch y en consola lanza el mensaje que puse para el tratamiento de la exeption
		
		
		//////*CAMBIADO POR MODIFICACION
		
//		try //Intenta esto, si no se puede
//		{
//			imagen=ImageIO.read(myImage);//puedo instanciar myImage dentro del metodo
//		}catch(IOException e)//HAGO ESTO
//		{
//			System.out.println("No se encontro la imagen");
//		}
		//*//////////////////////
		
		//HAY METODOS DRAWIMAGE QUE PUEDEN REDIMENSIONAR LA IMAGEN 
		
		//Objeto ImageObserver->objeto que debe ser notificado cuando la imagen se esta convirtiendo
		//Puede ser que se dibuje instantaneamente o pixel por pixel(fractal), necesito un observador para notificar como va la carga
		
		//g.drawImage(imagen, 5, 5, null);//null porque no notifico a nadie de la carga
		
	
		File image=new File("src/graficos/pinguino.png");
		
		try
		{
			imagen=ImageIO.read(image);
		}catch(IOException e)
		{
			System.out.println("No se encontro imagen2");
		}
		
		g.drawImage(imagen, 0, 0, 16, 16, null);
		
		
		g.copyArea(0, 0, 16, 16, 16, 0);
		//punto x,y de la imagen que quiero copiar(cualquiera de toda la imagen), ancho y alto que quiero copiar(TODA LA IMAGEN O UNA PARTE),DESDE EL BORDE SUPERIOR IZQUIERDO, QUE DISTANCIA HAY EN PIXELES HASTA DONDE QUIERO COPIAR?(dx,dy) por distancia x y distancia y
		//(x,y,width,height,dx,dy)
		
		for(int i=0;i<=943;i=i+16)
		{
			for(int j=0;j<=500;j=j+16)//llena 1 columna y despues pasa a la siguiente
			{
				
				g.copyArea(0, 0, 16, 16, i, j);//Como ya cree 1 en (0,0), me hace una copia arriba de la que ya esta creada
				
			}
		}
		
//		int altura=imagen.getHeight(this);
//		int ancho=imagen.getWidth(this);
//		
//	
//		
//		for(int i=0;i<960;i++)
//		{
//			for(int j=0;j<540;j++)//llena 1 columna y despues pasa a la siguiente
//			{
//				g.copyArea(0, 0, ancho, altura, ancho*i, altura*j);
//				//this->hace referencia al objeto en que me encuentro->por lo tanto, hace referencia al objeto imagen
//			}
//		}
		
		
		
	}
	
	
}
