package practica.agustin.zoologico;

public class Perro extends Animal
{
	private String raza;
	
	public Perro(String nombre, int edad, String raza)
	{
		super(nombre, edad);
		this.raza = raza;
	}
	
	public Perro(String nombre, int edad)
	{
		super(nombre, edad);
		raza = "";
	}
	
	public String getRaza()
	{
		return raza;
	}
	
	public void setRaza(String raza)
	{
		this.raza = raza;
	}
	
	public void mostrar()
	{
		super.mostrar();
		
		if(raza.isEmpty())
		{
			System.out.println("Raza: " + "no se setteo ninguna raza.");
		}
		else
		{
			System.out.println("Raza: " + raza);
		}
	}
	
	@Override
	public void hacerSonido()
	{
		System.out.println("Guau guau.");
	}
}
