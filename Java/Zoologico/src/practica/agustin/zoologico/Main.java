package practica.agustin.zoologico;

public class Main 
{
	public static void main(String[] args) 
	{
		Animal cala = new Perro("Cala", 6); //polimorfismo
		
		cala.mostrar();
		cala.hacerSonido();
		System.out.println("Polimorfismo: CALA es de clase Animal, pero ejecuta el mostrar de Perro(que a su vez llama al de Animal).\n");		
		System.out.println("CALA hace sonido de Perro sobrescribiendo el sonido generico de Animal.");
	}

}
