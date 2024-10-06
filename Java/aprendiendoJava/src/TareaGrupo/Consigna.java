package TareaGrupo;//Cree un package con ese nombre para realizar la tarea.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consigna 
{
	//LI=Limite Inferior	-	LS=Limite Superior
	public static int LI_EDAD=0;
	public static int LS_EDAD=200;
	public static int LI_DNI=999999;//CONTEMPLA EL CASO EN QUE HAY PERSONAS CON DNI DE 7 DIGITOS. EJ: 4.123.567
	public static int LS_DNI=100000000;
	
	public static void main(String[] args) 
	{
		String nombre;
		int edad;
		int dni;
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("DATOS DE LA PERSONA 1:\n");
		
		System.out.println("NOMBRE");
		nombre=ingresoNombre(entrada);
		System.out.println("EDAD");
		edad=ingresoEntero(entrada,LI_EDAD,LS_EDAD);
		System.out.println("DNI");
		dni=ingresoEntero(entrada,LI_DNI,LS_DNI);
		
		Persona persona1=new Persona(nombre,edad,dni);
		
		entrada.nextLine();//LIMPIO EL BUFFER DE ENTRADA
		
		System.out.println("DATOS DE LA PERSONA 2:\n");
	
		System.out.println("NOMBRE");
		nombre=ingresoNombre(entrada);
		System.out.println("EDAD");
		edad=ingresoEntero(entrada,LI_EDAD,LS_EDAD);
		System.out.println("DNI");
		dni=ingresoEntero(entrada,LI_DNI,LS_DNI);
		
		Persona persona2=new Persona(nombre,edad,dni);
		
		persona1.mostrarPersona();
		persona2.mostrarPersona();
		
		if(persona1.esMayorDeEdad())
		{
			System.out.println("La persona 1 es MAYOR DE EDAD");
		}
		else
		{
			System.out.println("La persona 1 NO es MAYOR DE EDAD");
		}
		
		if(persona2.esMayorDeEdad())
		{
			System.out.println("La persona 2 es MAYOR DE EDAD");
		}
		else
		{
			System.out.println("La persona 2 NO es MAYOR DE EDAD");
		}
		
		entrada.close();
		
	}
	
	public static final boolean validaNombre(char dato)
	{
		return ( dato>='A'&&   dato<='Z')||( dato>='a'&&  dato<='z') || dato==' ';
	}
	
	public static final String ingresoNombre(Scanner entrada)//INGRESA Y VALIDA
	{
		String nombre;
		boolean datoValido;
		int i;
		
		do
		{
			System.out.println("Ingrese el dato:");
			nombre=entrada.nextLine();
			i=nombre.length();
			datoValido=true;
			
			while(0!=i && datoValido)
			{
				datoValido=validaNombre(nombre.charAt(i-1));
				i--;
			}
		}while(!datoValido);
		
		return nombre;
	}
	
	public static final int ingresoEntero(Scanner entrada,int li,int ls)//INGRESA Y VALIDA
	{
		int valor;
		
		try 
		{
			do
			{
				System.out.println("Ingrese el dato:");
				valor=entrada.nextInt();
				
			}while(valor<=li||valor>=ls);
		}catch(InputMismatchException ex)
		{
			valor=li-1;//SIEMPRE VA A SER UN VALOR PROHIBIDO, POR LO QUE VA A VOLVER A INGRESAR AL Do-While
		}
		
		return valor;
		
	}
}

class Persona
{
	private String nombre;
	private int edad;
	private int dni;
	
	public Persona()
	{
		nombre="";
		edad=0;
		dni=0;
	}
	
	public Persona(String nombre,int edad,int dni)
	{
		this.nombre=nombre;
		this.edad=edad;
		this.dni=dni;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getEdad()
	{
		return edad;
	}
	public int getDni()
	{
		return dni;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	
	public void setEdad(int edad)
	{
		this.edad=edad;
	}
	
	public void setDni(int dni)
	{
		this.dni=dni;
	}
	
	public boolean esMayorDeEdad()
	{
		return edad>=18;
	}
	
	public void mostrarPersona()
	{
		System.out.println("\nNOMBRE: "+nombre);
		System.out.println("EDAD: "+edad);
		System.out.println("DNI: "+ dni+"\n");
	}
}