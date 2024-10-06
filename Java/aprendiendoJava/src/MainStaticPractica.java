
import java.util.*;
//StaticString clase creada

public class MainStaticPractica 
{

	public static void main(String[] args) 
	{
		
		Scanner entrada=new Scanner(System.in);
		System.out.print("INGRESE MENSAJE A SER DADO VUELTA:\t");
		String mensaje=entrada.nextLine();//next(); me capta hasta el primer espacio
		
		System.out.println("Mensaje: "+mensaje);
		System.out.println("Mensaje Reverse: "+StaticString.Reverse(mensaje));
		
		entrada.close();
	}

}
