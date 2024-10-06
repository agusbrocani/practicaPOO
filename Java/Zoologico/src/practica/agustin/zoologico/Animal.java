package practica.agustin.zoologico;

public class Animal 
{
	private String nombre;
	private int edad;
	
	public Animal()
	{
		
	}
	
	public Animal(String nombre, int edad)
	{
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getEdad()
	{
		return edad;
	}
	
	public void setEdad(int edad) throws Exception
	{
		if(edad < 0)
		{
			throw new Exception("Edad inexistente");
		}
		
		this.edad = edad;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void mostrar()
	{
		System.out.println("Mostrando animal:\n");
		System.out.println("Nombre del animal: " + nombre);
		System.out.println("Edad: " + edad);
	}
	
	public void hacerSonido()
	{
		System.out.println("Sonido RANDOM Animal.");
	}
}
