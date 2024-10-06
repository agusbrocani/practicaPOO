package practica.agustin.zoologico;

public class Gato extends Animal
{	
	private boolean rayoMueblesConGarras;
	
	public Gato(boolean rayoMueblesConGarras)
	{
		super();
		this.rayoMueblesConGarras = rayoMueblesConGarras;
	}
	
	public boolean getEstadoDeLosMuebles()
	{
		return rayoMueblesConGarras;
	}
	@Override
	public void hacerSonido()
	{
		System.out.println("Miau dijo Mauricio.");
	}
}
