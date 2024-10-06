package temporizador;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;


public class DameLaHora implements ActionListener
{
	public void actionPerformed(ActionEvent e)//e es un objeto de tipo Evento
	{
		Date ahora=new Date();//import java.util, HORA ACTUAL CUANDO IMPORTO EL OBJETO
		//CADA 5 SEGUNDOS ALMACENA LA HORA ACTUAL Y LA MUESTRA POR PANTALLA
		
		System.out.println("Hora cada 5 segundos: "+ahora);
		
		//Para que suene cada vez que imprima la hora Toolkit
		//Puente entre el SO y los programas en Java. Resolucion del monitor, recursos de sonidos del sistema.
		
		Toolkit.getDefaultToolkit().beep();//Hace que suene un sonido
		
	}
}


//IMPLEMENTO la INTERFAZ ActionListener PARA ASEGURAR que implemento el METODO actionPerformed-> por eso pide el parametro oyente en el main