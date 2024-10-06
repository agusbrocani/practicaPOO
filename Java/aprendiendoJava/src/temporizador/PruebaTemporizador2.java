package temporizador;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;//Para evitar conflicto de tipo
import java.awt.Toolkit;


public class PruebaTemporizador2 
{

	public static void main(String[] args) 
	{
		//Reloj miReloj=new Reloj(3000,true);
		//miReloj.enMarcha();
		
		Reloj miReloj=new Reloj();//INVOCO AL CONSTRUCTOR POR DEFECTO
		miReloj.enMarcha(3000,true);
		
		JOptionPane.showMessageDialog(null, "PULSA ACEPTAR PARA TERMINAR");
		
		System.exit(0);

	}

}

class Reloj
{
	//Como recibi enMarcha los atributos como parametros, no necesito esto
//	private int intervalo;
//	private boolean sonido;
//	
//	public Reloj(int intervalo,boolean sonido)//PARA ACCEDER A CLASE INTERNA, TENGO QUE USAR EL METODO enMarcha
//	{
//		this.intervalo=intervalo;
//		this.sonido=sonido;
//	}
	
	//public void enMarcha()
	public void enMarcha(int intervalo, final boolean sonido)//PARA PODER ACCEDER A VARIABLES LOCALES DEL METODO DONDE FUERON DECLARADAS TENGO QUE USAR final
	{
		
		//CLASE INTERNA LOCAL: puedo acceder a campos de la clase externa y a las variables que declaremos en el metodo enMarcha
		//Como la clase INTERNA no accede a intervalo, NO HACE FALTA que lo declare final
		class DameLaHora2 implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Date ahora=new Date();
				
				System.out.println("HORA CADA 3 SEGUNDOS: "+ahora);
				
				if(sonido)//Puedo acceder a los atributos privados sin metodos de acceso porque pertenece a la clase Reloj
				{
					Toolkit.getDefaultToolkit().beep();
				}
			}
			
		}
		
		ActionListener oyente=new DameLaHora2();//COMO USO LA CLASE INTERNA UNA UNICA VEZ, PUEDO HACER UNA CLASE INTERNA
		
		Timer temporizador=new Timer(intervalo,oyente);
		
		temporizador.start();
		
	}

//SI NO TENGO LA CLASE INTERNA, LO PUEDO HACER ASI
	
	
//	//CLASE DameLaHora2 INTERNA dentro de la CLASE Reloj
//	//PUEDO ACCEDER A LOS ATRIBUTOS DE LA CLASE QUE ENGLOBA A LA CLASE DameLaHora2
//	
//	private class DameLaHora2 implements ActionListener
//	{
//		public void actionPerformed(ActionEvent e)
//		{
//			Date ahora=new Date();
//			
//			System.out.println("HORA CADA 3 SEGUNDOS: "+ahora);
//			
//			if(sonido)//Puedo acceder a los atributos privados sin metodos de acceso porque pertenece a la clase Reloj
//			{
//				Toolkit.getDefaultToolkit().beep();
//			}
//		}
//		
//	}
	
}