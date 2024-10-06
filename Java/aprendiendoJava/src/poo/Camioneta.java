package poo;

public class Camioneta extends Coche
{
	private int capacidad_carga;
	private int plazas_extra;
	
	public Camioneta(int capacidad_carga,int plazas_extra)
	{
		super();//llama al constructor de la clase padre con el objetivo de darle un estado inicial a las variables heredadas
		
		this.capacidad_carga=capacidad_carga;
		this.plazas_extra=plazas_extra;
	}
}
