package graficos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora 
{

	public static void main(String[] args) 
	{
		FrameCalculadora myFrame=new FrameCalculadora();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
	}

}

class FrameCalculadora extends JFrame
{
	public FrameCalculadora()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		setSize(width/6,height/2);
		setLocation(width/3,height/4);
		setTitle("Calculadora");
		LaminaCalculadora lamina=new LaminaCalculadora();
		add(lamina);
		//pack();//Le digo que el contenedor se tiene que adaptar al tamaño por defecto de lo que contiene
	
	}
}

class LaminaCalculadora extends JPanel
{
	private JButton pantalla;
	private JPanel lamina2;
	private boolean principio;//Valor por defecto falso si no la inicializo
	private double resultado;
	private String ultimaOperacion;
	
	public LaminaCalculadora()
	{
		principio=true;//DESAPAREZCA EL 0 despues del primer ingreso
		setLayout(new BorderLayout());
		pantalla=new JButton("0");//Donde muestra resultados de las operaciones
		pantalla.setEnabled(false);//DESHABILITO EL BOTON PARA QUE SE VEA DISTINTO A LOS DEMAS, YA QUE MUESTRA RESULTADOS
		add(pantalla,BorderLayout.NORTH);
		lamina2=new JPanel();//Construi una nueva Lamina, podria haber hecho una clase
		lamina2.setLayout(new GridLayout(6,4));//FILAS,COLUMNAS
		ActionListener insertar=new InsertaNumero();
		ActionListener orden=new AccionOrden();
		
		crearBoton("%",orden);
		crearBoton("CE",orden);
		crearBoton("C",orden);
		crearBoton("DEL",orden);
		crearBoton("",null);
		crearBoton("",null);
		crearBoton("",null);
		crearBoton("*",orden);
		crearBoton("7",insertar);
		crearBoton("8",insertar);
		crearBoton("9",insertar);
		crearBoton("/",orden);
		crearBoton("4",insertar);
		crearBoton("5",insertar);
		crearBoton("6",insertar);
		crearBoton("+",orden);
		crearBoton("1",insertar);
		crearBoton("2",insertar);
		crearBoton("3",insertar);
		crearBoton("-",orden);
		crearBoton("+/-",orden);
		crearBoton("0",insertar);
		crearBoton(".",orden);
		crearBoton("=",orden);
		add(lamina2,BorderLayout.CENTER);
		ultimaOperacion="=";
	}
	
	private void crearBoton(String nombreBoton,ActionListener listener)
	{
		JButton boton=new JButton(nombreBoton);
		
		if(nombreBoton.equals(""))
		{
			boton.setEnabled(false);
		}
		boton.addActionListener(listener);
		lamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String capturoBoton=e.getActionCommand();//Devuelve el String asociado a esta acción(En este caso al BOTON)
			if(principio)
			{
				pantalla.setText("");
				principio=false;
			}
			
			//BOTON DISPLAY->pantalla
			pantalla.setText(pantalla.getText()+capturoBoton);
		}
		
	}
	
	private class AccionOrden implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			String operacion=e.getActionCommand();//Rescato texto del boton
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion=operacion;
			principio=true;
		}
		
		public void calcular(double valor)
		{
			if(ultimaOperacion.equals("+"))
			{
				resultado+=valor;
				System.out.println(resultado);
			}
			
			else if(ultimaOperacion.equals("="))
			{
				resultado=valor;
			}
			
			else if(ultimaOperacion.equals("-"))
			{
				resultado-=valor;
			}
			
			else if(ultimaOperacion.equals("*"))
			{
				resultado*=valor;
			}
			
			else if(ultimaOperacion.equals("/"))
			{
				resultado/=valor;
				
				if(Double.isNaN(resultado))//0/0
				{
				}
				if(Double.isInfinite(resultado))//5/0
				{
				}

			}
			
			pantalla.setText(""+resultado);
		}
		
	}
	
}

//https://www.youtube.com/watch?v=Q2bzRMcE2Jk&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=88
//LAYOUT 5

//getText,setText-> capturar el texto en el boton como establecer un nuevo texto en el boton