package persona;
import java.util.*;

public class Alumno extends Persona
{
	private double promedio;
	private Date fechaInicio;
	
	public Alumno(String nya,int dni,int day,int month,int year,double promedio,int dayIn,int monthIn,int yearIn)
	{
		super(nya,dni,day,month,year);
		this.promedio=promedio;
		GregorianCalendar fechaI=new GregorianCalendar(yearIn,monthIn-1,dayIn);
		fechaInicio=fechaI.getTime();
	}
	
	public String getDescripcion() 
	{
		return "\nNyA: "+this.getName()+"\nDNI: "+this.getDni()+"\nFecha de Nacimiento: "+this.getFNacimiento()+"\nID: "+this.getId()+"\nPromedio: "+promedio+"\nFecha de Inicio: "+fechaInicio;
	}
	
	public double getPromedio()
	{
		return promedio;
	}
	
	public Date getFechaInicio()
	{
		return fechaInicio;
	}
	
}
