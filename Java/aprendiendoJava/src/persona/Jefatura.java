package persona;

public class Jefatura extends Empleado implements Jefes
{
	private int personasACargo;
	private double bonificacion;
	private static final double porcentajeBono=0.1;
	
	public Jefatura(String nya,int dni,int day,int month,int year,double sueldo,int dayAlta,int monthAlta,int yearAlta,String area,int personasACargo)
	{
		super(nya,dni,day,month,year,sueldo,dayAlta,monthAlta,yearAlta,area);
		this.personasACargo=personasACargo;
		this.bonificacion=sueldo*porcentajeBono;
		this.sueldo=(sueldo+bonificacion);
	}
	
	public String getDescripcion() 
	{
		return "\nNyA: "+this.getName()+"\nDNI: "+this.getDni()+"\nFecha de Nacimiento: "+this.getFNacimiento()+"\nID: "+this.getId()+"\nSueldo: "+this.getSueldo()+"\nFecha Alta Constrato: "+this.getFechaAltaContrato()+"\nArea: "+this.getArea()+"\nPersonas a cargo: "+personasACargo+"\nBonificacion de sueldo: "+bonificacion;
	}
	
	public int getPersonasACargo()
	{
		return personasACargo;
	}
	
	public double getBonificacion()
	{
		return bonificacion;
	}
	
	public String tomarDecisiones(String decision)
	{
		return "Un Jefe ha tomado la decision: "+decision;
	}
	
	public String bonusNavidadBase(double porcentaje)
	{
		 double prima=2000;
		 porcentaje=porcentaje/100;
		 this.sueldo=this.sueldo+(this.sueldo*porcentaje)+Trabajadores.bonusBaseNavidad+prima;
		 return "Bonus del "+(int)(porcentaje*100)+"% aplicado a TODOS los JEFES seleccionados mas la prima de: $"+prima;
	}
}


//QUIERO CREAR 2 METODOS DE OBLIGADO CUMPLIMIENTO EN LA CLASE JEFATURA, POR LO TANTO, IMPLEMENTO UNA INTERFAZ
//T es el tipo del objeto de la comparacion
//Interfaz Comparable->1 metodo-> compareTo->devuelve 1,-1 o 0 segun el resultado de la comparacion