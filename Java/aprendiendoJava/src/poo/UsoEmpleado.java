package poo;
import java.util.*;

public class UsoEmpleado //CLASE PRINCIPAL O PUBLICA
{

	public static void main(String[] args) 
	{
		//String nombre,double sueldo,int year,int mes,int dia
		/*
		Empleado empleado1=new Empleado("AGUSTIN BROCANI",5000,2022,12,3);
		Empleado empleado2=new Empleado("Ana Lopez",9500,1995,6,2);
		Empleado empleado3=new Empleado("Maria Martin",10500,2002,3,15);
		
		empleado1.setAumentoSueldo(10);
		empleado2.setAumentoSueldo(2);
		empleado3.setAumentoSueldo(5);
		
		System.out.println("Nombre: "+empleado1.getNombre()+"\n"+"Sueldo: "+empleado1.getSueldo()+"\n"+"Fecha de alta: "+empleado1.getAltaContrato());
		*/
		
		Empleado[] misEmpleados=new Empleado[3];//Reservo memoria para 3 objetos de tipo Empleado
		
		misEmpleados[0]=new Empleado("AGUSTIN BROCANI",5000,2022,12,3);
		misEmpleados[1]=new Empleado("Ana Lopez",9500,1995,6,2);
		misEmpleados[2]=new Empleado("Maria Martin",10500,2002,3,15);
		
		for(int i=0;i<misEmpleados.length;i++)
		{
			misEmpleados[i].setAumentoSueldo(5);
		}
		
		for(int i=0;i<misEmpleados.length;i++)
		{
			System.out.println("Nombre: "+misEmpleados[i].getNombre()+"\n"+"Sueldo: "+misEmpleados[i].getSueldo()+"\n"+"Fecha de alta: "+misEmpleados[i].getAltaContrato()+"\n"+"Id: "+misEmpleados[i].getId()+"\n");
		}
		
		//invoco a la clase para usar algun metodo de esta.
		System.out.println(Empleado.dameIdSiguiente());
		
	}

}

class Empleado //CLASE EMPLEADO
{
	public Empleado(String nombre,double sueldo,int year,int mes,int dia)
	{
		this.nombre=nombre;
		this.sueldo=sueldo;
		//CLASE GregorianCalendar
		GregorianCalendar fecha=new GregorianCalendar(year,mes-1,dia);//PARA EL CALENDARIO, ENERO ES 0	
		this.altaContrato=fecha.getTime();//No aparece en la API porque la clase GregorianCalendar hereda de otra clase padre
		this.Id=IdSiguiente;
		IdSiguiente++;
	}
	
	//GETTERS
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public double getSueldo()
	{
		return this.sueldo;
	}
	
	public Date getAltaContrato()
	{
		return this.altaContrato;
	}
	
	public void setAumentoSueldo(double porcentaje)
	{
		double aumento=(this.sueldo)*porcentaje/100;//Calcula cuanta plata mas va a cobrar
		
		this.sueldo+=aumento;
	}
	
	public int getId()
	{
		return this.Id;
	}
	
	public static String dameIdSiguiente()
	{
		return "El IdSiguiente es: "+IdSiguiente+"\n";
	}
	
	//Clase String pertenece al paquete java.lang(paquete por defecto)
	//Clase Date pertenece al paquete java.util, hay otra pero pertenece al paquete de sql
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;//VARIABLE DE TIPO DATE
	private int Id;//Cada objeto tiene su id
	private static int IdSiguiente=1;//ESTE PERTENECE A LA CLASE, NO ES DE CADA OBJETO,por eso siempre me va a decir el Id del nuevo objeto que voy a crear.
}