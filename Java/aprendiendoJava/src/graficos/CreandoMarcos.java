package graficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos //CLASE PRINCIPAL
{

	public static void main(String[] args) 
	{
		miMarco miMarco1=new miMarco();
		
		//2-HACER VISIBLE LA VENTANA
		
		miMarco1.setVisible(true);//true->HACERLO VISIBLE
		
		//3-QUE HACER CUANDO SE CIERRE-> SI NO HAGO ESTA LINEA, EL PROGRAMA SIGUE EN EJECUCION
		
		miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//miMarco1.setDefaultCloseOperation(VALOR ENTERO)->JFrame.EXIT_ON_CLOSE ->CUANDO SE CIERRE LA VENTANA, EL PROGRAMA TIENE QUE ACABAR
		
		//miMarco1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//OCULTO LA VENTANA, PERO SIGUE EN EJECUCION HASTA QUE CIERRO LA VENTANA CON LA INSTRUCCION EXIT_ON_CLOSE
	
		
	}

}

//en 2 clases diferentes
//Heredo JFrame para poder utilizar TODOS sus metodos

class miMarco extends JFrame
{
	public miMarco()
	{
		//1-TAMAÑO DE VENTANA
		//public void setSize(int width,int height)
		
		//setSize(500,300);//CLASE Toolkit-> puedo detectar la resolucion donde se esta ejecutando mi aplicacion y se adapta el tamaño de la ventana AUTOMATICAMENTE
		
		//setLocation(500,300);//X(DESPLAZAMIENTO HORIZONTAL)=500 Y(DESPLAZAMIENTO VERTICAL)=300 - CENTRO ES (0,0)->MARGEN SUPERIOR IZQUIERDO
		
		setBounds(500,300,550,250);//(X,Y)DONDE ABRO,(ANCHO,ALTO)DIMENSION DE VENTANA
		
		//setResizable(false);//false->NO DEJO QUE EL USUARIO REDIMENSIONE LA VENTANA, true->PUEDE REDIMENSIONAR LA VENTANA
	
		//setExtendedState(Frame.MAXIMIZED_BOTH);//LA VENTANA SE ABRE PANTALLA COMPLETA-> CONSTANTE= 6
	
		setTitle("Ventana que cree.");
		
		
		
	}
}