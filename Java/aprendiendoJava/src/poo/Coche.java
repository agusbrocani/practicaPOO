package poo;

public class Coche
{
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso;
	private String color;
	private int peso_total;
	private boolean asientos_cuero,climatizador;
	
	public Coche()//CARROCERIA DE UN COCHE BASICA
	{
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso=500;
	}
	
	public String getLargo()
	{
		return "El largo del coche es de "+largo+ " cm";
	}
	
	public void establece_color(String color)//setter
	{
		this.color=color;
	}
	
	public String dime_color()
	{
		return color;
	}
	
	public void configuraAsientos(String opc)
	{
		if(opc.equalsIgnoreCase("SI"))
		{
			this.asientos_cuero=true;
		}
		else
		{
			this.asientos_cuero=false;
		}
	}
	
	public void configuraClimatizador(String opc)
	{
		if(opc.equalsIgnoreCase("SI"))
		{
			this.climatizador=true;
		}
		else
		{
			this.climatizador=false;
		}
	}
	
//	private int ruedas;
//	private int largo;
//	private int ancho;
//	private int motor;
//	private int peso;
//	private String color;
//	private int peso_total;
//	private boolean asientos_cuero,climatizador;
	
	public String getEstadoGeneral()
	{
		return "\nRuedas: "+ruedas+"\nLargo: "+largo+"\nAncho: "+ancho+"\nMotor: "+motor+"\nPeso: "+peso+"\nColor: "+color+"\nPeso total: "+peso_total+"\nAsientos de cuero: "+(asientos_cuero?"SI":"NO")+"\nClimatizador: "+(climatizador?"SI":"NO");
	}
}
