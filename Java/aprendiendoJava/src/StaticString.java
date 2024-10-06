public class StaticString 
{
	public static String Reverse(String cadena)
	{
		String cadenaInvertida="";
		int i;
		
		//cadena="HOLA";->0,1,2,3	=>LAS LETRAS ESTAN CONCATENADAS COMO UN VECTOR
		//cadena.length(); =>4
		//La A esta en la posicion 3, por ende, arrancaria en [cadena.length()-1];
		
		for(i=cadena.length()-1;i>=0;i--)
		{
			cadenaInvertida=cadenaInvertida+cadena.charAt(i);
		}
		
		return cadenaInvertida;
	}
}
