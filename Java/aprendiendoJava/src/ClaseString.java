
public class ClaseString 
{
	//String no es un tipo primitivo
	
	public static void main(String[] args)
	{
		String miNombre;//Es una instancia de la clase string
		//INSTANCIAR(EJEMPLARIZAR) UNA CLASE: DARLE UN NOMBRE Y UN VALOR A UN OBJETO
		
		miNombre="Agustin Brocani";
		
		String cadena2="Agustin Brocani";
		
		System.out.println("Mi nombre es: "+miNombre);
		
		//METODO LENGTH = RETORNA CANTIDAD DE CARACTERES(int), CUENTA ESPACIOS
		System.out.println("Tamaño de mi nombre= "+miNombre.length());
		
		//METODO charAt= RETORNA LETRA EN LA POSICION QUE LE INDIQUE, ARRANCA CONTANDO DESDE LA POSICION  0 COMO UN VECTOR
		System.out.println("Letra en la posicion 8: "+miNombre.charAt(8));
		
		System.out.println("Ultima letra de: "+miNombre+" es "+miNombre.charAt(miNombre.length()-1));
		
		//METODO substring(posicionInicio,posicionFin)=Devuelve la subpalabra desde la posicion del vector String de la palabra original que le indique
		
		System.out.println("Sub cadena= "+miNombre.substring(8,15));
		
		//METODO equals(cadena2)->TRUE=son iguales las 2 cadenas, FALSE=No son iguales
		
		System.out.println("");
		if(!miNombre.equals(cadena2))
		{
			System.out.println("Las cadenas son DISTINTAS");
			System.out.println("Cadena 1: "+miNombre);
			System.out.println("Cadena 2: "+cadena2);
		}
		else
		{
			System.out.println("Las cadenas son IGUALES");
		}
		
		System.out.println("");
		System.out.println("equalsIngnoreCase");
		
		cadena2=cadena2.toLowerCase();
		
		if(!miNombre.equalsIgnoreCase(cadena2))
		{
			System.out.println("Las cadenas son DISTINTAS");
			System.out.println("Cadena 1: "+miNombre);
			System.out.println("Cadena 2: "+cadena2);
		}
		else
		{
			System.out.println("Las cadenas son IGUALES");
			System.out.println("Cadena 1: "+miNombre);
			System.out.println("Cadena 2: "+cadena2);
		}
		
	}

}
