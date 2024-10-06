package persona;
import java.util.*;

public class Director extends Jefatura
{
	private int nroOficina;
	private Date fechaDeAsignacion;
	
	public Director(String nya,int dni,int day,int month,int year,double sueldo,int dayAlta,int monthAlta,int yearAlta,String area,int personasACargo,int nroOficina,int dayAsig,int monthAsig,int yearAsig)
	{
		super(nya,dni,day,month,year,sueldo,dayAlta,monthAlta,yearAlta,area,personasACargo);
	
		this.nroOficina=nroOficina;
		GregorianCalendar fechaAsig=new GregorianCalendar(yearAsig,monthAsig-1,dayAsig);
		this.fechaDeAsignacion=fechaAsig.getTime();
	
	}
	
	public String getDescripcion() 
	{
		return "\nNyA: "+this.getName()+"\nDNI: "+this.getDni()+"\nFecha de Nacimiento: "+this.getFNacimiento()+"\nID: "+this.getId()+"\nSueldo: "+this.getSueldo()+"\nFecha Alta Constrato: "+this.getFechaAltaContrato()+"\nArea: "+this.getArea()+"\nPersonas a cargo: "+this.getPersonasACargo()+"\nBonificacion de sueldo: "+this.getBonificacion()+"\nNro Oficina: "+nroOficina+"\nFecha de Asignacion: "+fechaDeAsignacion;
	}
	
	public int getNroOficina()
	{
		return nroOficina;
	}
	
	public Date getFechaAsignacion()
	{
		return fechaDeAsignacion;
	}
	
	

}
