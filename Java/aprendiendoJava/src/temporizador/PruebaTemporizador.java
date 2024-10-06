package temporizador;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;//CON ESTA LINEA SOLUCIONO EL PROBLEMA DE AMBIGUEDAD A PESAR DE HABER IMPORTADO TODO
//Estoy importando 2 clases Timer que tienen un proposito diferente-> por eso solo importo la clase.

public class PruebaTemporizador 
{

	public static void main(String[] args) 
	{
		//COMO JAVA ES 100% ORIENTADO A OBJETOS-> TENGO QUE CREAR UNA CLASE QUE IMPLEMENTE LA INTERFAZ ActionListener para despues CREAR una INSTANCIA perteneciente a esa CLASE
		
		//CLASE A CREAR: DameLaHora
		//IMPLENTS: ActionListener
		//DESARROLLO TODOS LOS METODOS DE LA INTERFAZ EN ESA NUEVA CLASE
		
		//DameLaHora oyente=new DameLaHora();//constructor por defecto instancia la clase.
		
		ActionListener oyente=new DameLaHora(); //CREO UNA INSTANCIA DE TIPO ActionListener pero llama al constructor por defecto de la clase DameLaHora, LAS INTERFACES NO SE PUEDEN INSTANCIAR DIRECTAMENTE
		Timer temporizador=new Timer(5000,oyente);//CADA 5 SEGUNDOS EJECUTO "LA FUNCION", en java no es asi
		
		temporizador.start();//COMIENZA LA EJECUCION DEL TEMPORIZADOR
		
		//Tengo que hacer que el programa este en ejecucion el tiempo que quiera, porque sino el programa ejecuta el main y sale en menos de 1 segundo
	
		JOptionPane.showMessageDialog(null, "PULSAR ACEPTAR PARA DETENER");//MIENTRAS ESTE EL CARTEL EN PRIMER PLANO, SIGUE EJECUTANDOSE
		
		System.exit(0);//Detiene la ejecucion del programa
	}

}
