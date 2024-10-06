package prueba1;

public class Main 
{

	public static void main(String[] args) 
	{
		Coche miAuto1=new Coche();
		Coche miAuto2=new Coche("Peugeot","207",2500000,2016,false);
		Coche miAuto3=new Coche("Peugeot","207",2500000,2016,true);
		
		miAuto2.mostrarAuto();
		System.out.println();
		miAuto3.mostrarAuto();

	}

}
