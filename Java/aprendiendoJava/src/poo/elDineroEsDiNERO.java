package poo;
import java.util.*;

public class elDineroEsDiNERO 
{

	/*
	public static void main(String[] args) 
	{
		String fonoRico="no";
		
		if((tienePlata(fonoRico)))
		{
			System.out.println("FONOHA TIENE PLATA REY!!!");
		}
		else
		{
			System.out.println("AGARRA LA PALA!!!");
		}

	}
	
	public static boolean tienePlata(String condicion) 
	{
		boolean condicion2=false;
		
		if(condicion.equalsIgnoreCase("si"))
		{
			condicion2=true;
		}
		
		return (condicion2)?true:false;
	}
	
	
	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);//OBJETO->ATRIBUTOS(nombre,dni,direccion) Y METODOS(sumarle 10,actualizar dni)->funciones de la CLASE
		
		boolean valida1=false;
		boolean valida2=false;
		String mensaje;
		
		System.out.println("INGRESE SI FONOHA ES RICO O POBRE: SI/NO");
		
		do
		{
			System.out.print("RESPUESTA:\t");
			mensaje=entrada.nextLine();
			valida1=mensaje.equalsIgnoreCase("SI");
			valida2=mensaje.equalsIgnoreCase("NO");
			
		}while(!valida1&&!valida2);
		
		if(mensaje.equalsIgnoreCase("SI"))
		{
			System.out.println("FONOHA ES UN PUTO MILLONARIO");
		}
		else
		{
			System.out.println("FONOHA, TENES QUE AGARRAR LA PALA!!!");
		}
		
		entrada.close();
	}*/

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		String mensaje;
		
		System.out.println("¿FonohA es una persona con plata?: SI/NO");
		
		do
		{
			System.out.print("RESPUESTA:\t");
			mensaje=entrada.nextLine();
			
		}while((!mensaje.equalsIgnoreCase("SI")&&!mensaje.equalsIgnoreCase("NO")));

		entrada.close();
		
		fonohAEsRico(mensaje);
	
	}
	
	public static void fonohAEsRico(String mensaje)
	{
		
		if(mensaje.equalsIgnoreCase("SI"))
		{
			System.out.println("FonohA ES RICO WACHO!!!");
		}
		else
		{
			System.out.println("AGARRA LA PALA FonohA!!!");
		}
	}
}
