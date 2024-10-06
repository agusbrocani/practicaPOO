package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiplesOyentes 
{

	public static void main(String[] args) 
	{
		FrameMultiplesOyentes myFrame=new FrameMultiplesOyentes();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}

class FrameMultiplesOyentes extends JFrame
{
	public static int width;
	public static int height;
	
	public FrameMultiplesOyentes()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		this.width=width;
		this.height=height;
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("EVENTOS - Multiples oyentes");
		LaminaPrincipal lamina1=new LaminaPrincipal();
		add(lamina1);
		
	}
}
//BOTON NUEVO->GENERO NUEVAS VENTANAS
//BOTON CERRAR TODO->CIERRO TODAS LAS VENTANAS
//CUANDO PULSO CERRAR->DESENCADENO UN EVENTO ->VA A SER ESCUCHADO POR TODAS LAS VENTANAS ABIERTAS y REACCIONARAN EN BASE AL EVENTO

class LaminaPrincipal extends JPanel
{
	public LaminaPrincipal()
	{
		JButton nuevaVentana=new JButton("Abrir nueva Ventana");
		add(nuevaVentana);
		add(cerrarVentana);
		
		OyenteNuevo miOyente=new OyenteNuevo();
		nuevaVentana.addActionListener(miOyente);
	}
	//Instancio aca porque lo uso en otros metodos.
	JButton cerrarVentana=new JButton("Cerrar Ventanas Emergentes");
	private class OyenteNuevo implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			MarcoEmergente marco=new MarcoEmergente(cerrarVentana);
			marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}

class MarcoEmergente extends JFrame
{
	private static int contador=1;
	
	public MarcoEmergente(JButton referenciaBotonCerrarVentana)
	{
		setTitle("Ventana Emergente: "+contador);
		contador++;//Incremento el contador cada vez que instancio
		setBounds(40*contador,40*contador,FrameMultiplesOyentes.width/2,FrameMultiplesOyentes.height/2);
		setVisible(true);
		
		CierraTodo oyenteCerrar=new CierraTodo();
		referenciaBotonCerrarVentana.addActionListener(oyenteCerrar);
		
	}
	private class CierraTodo implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //CERRAR EL OBJETO
		{
			dispose();//Pertenece a JFrame->Libera todos los recursos de las ventanas y sus componentes marcandolos como invisibles->CERRARLOS
		}
		
	}
}

//PROBLEMA
//QUIEN ES LA FUENTE->BOTON CERRAR TODO
//EL BOTON NO ESTA EN LA CLASE MarcoEmergente
//SOLUCION->¿COMO HAGO REFERENCIA AL BOTON CERRAR TODO?-> LO PASO POR PARAMETRO(Es una referencia al OBJETO)