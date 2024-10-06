package graficos;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;

public class PruebaDeMarco411 
{

	public static void main(String[] args) 
	{
		Marco myFrame=new Marco();//INSTANCIO OBJETO VENTANA
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//QUE TERMINE LA EJECUCION CUANDO CIERRE LA VENTANA
		
		myFrame.setVisible(true);//true->QUE MI VENTANA SEA VISIBLE
		
	}

}

class Marco extends JFrame//JFrame es la clase hija que hereda TODOS los metodos que estoy usando para crear mi Frame, por lo tanto, la clase Marco debe heredar de esta.
{
	public Marco()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		
		//Class Dimension ->ATRIBUTOS->int height,int width-> Cuando instancio un objeto de esta clase, le doy valores a ancho y alto
		Dimension screenSize=myScreen.getScreenSize();//Metodo getScreenSize(); return= the size of this toolkit's screen, in pixels.[Objeto de tipo Dimension]
		//CRITERIO PARA DEVOLVER LA RESOLUCION DE PANTALLA:
		//En sistemas con varias pantallas, se utiliza la pantalla principal. 
		//Las dimensiones de visualización compatibles con varias pantallas están disponibles en GraphicsConfiguration y GraphicsDevice.

		//Variables donde almaceno el Alto y Ancho de mi Screen-> Estoy accediendo a los ATRIBUTOS de Class Dimension
		int height=screenSize.height;//ALTO
		
		int width=screenSize.width;//ANCHO
		
		//System.out.println("ANCHO: "+width);
		//System.out.println("ALTO: "+height);
		
		
		//Metodos heredados de JFrame
		
		setSize(width/2,height/2);//Tamaño de Frame en mi Pantalla
		//Width=1920/2=960 Height=1080/2=540
		
		setLocation(width/4,height/4);//Ubicacion del Frame en mi Pantalla-height/4
		//Width=1920/4=480 Height=1080/4=270 
		
		setTitle("App de escritorio");
		
		Image icon=myScreen.getImage("src/graficos/icono.png");//getImage(*);
		//*Le mando el nombre del jpg,png o gif->Imagen o gif guardado en mi carpeta de proyecto del Workspace, sino, envio ruta relativa al paquete desde src
		
		setIconImage(icon);
		
		
	}
	
	
	
}
