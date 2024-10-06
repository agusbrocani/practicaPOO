package poo;

public class UsoVehiculo 
{

	public static void main(String[] args) 
	{
		Coche miCoche1=new Coche();

		Camioneta miCamioneta1=new Camioneta(7,580);
		
		miCoche1.establece_color("Rojo");
		
		miCamioneta1.configuraAsientos("si");
		
		miCamioneta1.configuraClimatizador("si");
	
		System.out.println(miCoche1.getEstadoGeneral());
		
		System.out.println(miCamioneta1.getEstadoGeneral());
	}

}
