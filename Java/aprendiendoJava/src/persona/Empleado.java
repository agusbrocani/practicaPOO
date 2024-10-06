package persona;
import java.util.*;

//La clase Empleado tiene que cumplir con el comportamiento que le marca la Interfaz Comparable, en castellano, tiene que implementar el metodo abstracto compareTo de la interfaz Comparable.
public class Empleado extends Persona implements Comparable,Trabajadores
{
	protected double sueldo;
	private Date fechaAltaContrato;
	private String area;
	
	
	public Empleado(String nya,int dni,int day,int month,int year,double sueldo,int dayAlta,int monthAlta,int yearAlta,String area)
	{
		super(nya,dni,day,month,year);
		this.sueldo=sueldo;
		GregorianCalendar fechaAlta=new GregorianCalendar(yearAlta,monthAlta-1,dayAlta);
		this.fechaAltaContrato=fechaAlta.getTime();
		this.area=area;
	}
	
	public String getDescripcion() 
	{
		return "\nNyA: "+this.getName()+"\nDNI: "+this.getDni()+"\nFecha de Nacimiento: "+this.getFNacimiento()+"\nID: "+this.getId()+"\nSueldo: "+sueldo+"\nFecha Alta Constrato: "+fechaAltaContrato+"\nArea: "+area;
	}
	
	public double getSueldo()
	{
		return sueldo;
	}
	
	public Date getFechaAltaContrato()
	{
		return fechaAltaContrato;
	}
	
	public String getArea() 
	{
		return area;
	}
	
	//IMPLEMENTO EL METODO compareTo de la interfaz Comparable
	
	public int compareTo(Object miObjeto)
	{
		//Tengo que hacer un casteo de Object a Empleado para poder comparar.
		Empleado otroEmpleado=(Empleado)miObjeto;
		
		if(this.sueldo>otroEmpleado.sueldo)
		{
			return 1;
		}
		if(this.sueldo<otroEmpleado.sueldo)
		{
			return -1;
		}
		
		return 0;
	}
	
	public String bonusNavidadBase(double porcentaje)
	{
		//Si el trabajador cobra a lo sumo $3000, recibe $1500 extra+ el porcentaje de los $3000
		
		porcentaje=porcentaje/100;
		
		double sueldoPrevio=this.sueldo;
		
		if(sueldoPrevio<=3000)
		{
			this.sueldo+=bonusBaseNavidad;
		}
		
		this.sueldo=this.sueldo+(sueldoPrevio*porcentaje);
		
		return "Bonus del "+(int)(porcentaje*100)+"% aplicado a TODOS los trabajadores seleccionados.";
	}
}
