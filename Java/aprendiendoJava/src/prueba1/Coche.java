package prueba1;

public class Coche 
{
	private String marca;
	private String modelo;
	private double precio;
	private int year;
	private boolean extras;
	
	public Coche(String marca,String modelo,double precio,int year,boolean extras)
	{
		this.marca=marca;
		this.modelo=modelo;
		this.year=year;
		this.extras=extras;
		
		if(!extras)
		{
			this.precio=precio;
		}
		else
		{
			this.precio=(precio*0.2)+precio;
		}
	}
	
	public Coche()
	{
		marca="";
		modelo="";
		precio=0.0;
		year=0;
		extras=false;
	}
	
	public double getPrecio()
	{
		return this.precio;
	}
	
	public Coche getAuto()
	{
		return this;
	}
	
	public void setPrecio(double precio)
	{
		this.precio=precio;
	}
	
	public void mostrarAuto()
	{
		String verdadero="SI";
		String falso="NO";
		
		System.out.println("Marca: "+this.marca);
		System.out.println("Modelo: "+this.modelo);
		System.out.println("Año: "+this.year);
		System.out.println("Precio: $"+this.precio);
		
		if(!(this.extras))
		{
			System.out.println("¿Posee extras?: "+falso);
		}
		else
		{
			System.out.println("¿Posee extras?: "+verdadero);
		}
		
	}
	
	
}
