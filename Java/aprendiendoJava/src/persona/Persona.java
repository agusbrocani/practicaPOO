package persona;
import java.util.*;

public abstract class Persona 
{
	private String nya;
	private int dni;
	private Date fechaNacimiento;
	private int Id;
	private static int IdSiguiente=1;
	
	public Persona(String nya,int dni,int day,int month,int year)
	{
		this.nya=nya;
		this.dni=dni;
		GregorianCalendar fechaNac=new GregorianCalendar(year,month-1,day);	
		this.fechaNacimiento=fechaNac.getTime();
		this.Id=IdSiguiente;
		IdSiguiente++;
	}
	
	
	public abstract String getDescripcion();
	
	public String getName()
	{
		return nya;
	}
	
	public int getDni()
	{
		return dni;
	}
	
	public Date getFNacimiento()
	{
		return fechaNacimiento;
	}
	
	public final int getId()
	{
		return Id;
	}
}
