package graficos;
import java.awt.Toolkit;
import java.awt.*;

import javax.swing.*;

public class CrearMarcoCentrado 
{

	public static void main(String[] args) 
	{
		MarcoCentrado miMarco=new MarcoCentrado();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);

	}
}

class MarcoCentrado extends JFrame
{
	
	//VENTANA COMO DEBE SER, SEGUN EL MONITOR DONDE SE ABRA EL PROGRAMA
	public MarcoCentrado()
	{
		//Capto el retorno de mi pantalla
		Toolkit miPantalla=Toolkit.getDefaultToolkit();//Devuelve el medio por donde ejecuto el programa(the default toolkit)-> si lo ejecuto en la pantalla, la pantalla
	
		//getScreenSize->TAMAÑO DE MI VENTANA->RETURN:Objeto de tipo Dimension
		
		Dimension tamPantalla=miPantalla.getScreenSize();//Tamaño de mi pantalla donde corro el programa
		
		//Atributos de la clase Dimension
		//width->ancho
		//height->alto
		
		int alturaPantalla=tamPantalla.height;
		int anchoPantalla=tamPantalla.width;
		
		//Creo un Frame donde el ancho y el largo van a quedar a la mitad de MI pantalla
		
		setSize(anchoPantalla/2,alturaPantalla/2);//TOMO LA DIMENSION DE MI MONITOR Y USO LA MITAD
		
		setLocation(anchoPantalla/4,alturaPantalla/4);//POSICION DE LA VENTANA
		
		setTitle("Mi MarcoCentrado");
		
		Image icono=miPantalla.getImage("src/graficos/icono.png");//ADMITE .gif.jpg.png- "icono.png" SI ESTA EN LA CARPETA DEL Eclipse Workspace, SINO, si esta en el paquete del proyecto, PONGO RUTA RELATIVA.
		
		setIconImage(icono);
		//https://www.youtube.com/watch?v=zWUMgcFbOlg&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=60
		//VIDEO 58
		
		
	}
	
}