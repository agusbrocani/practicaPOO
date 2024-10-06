public class ClaseMath 
{

	public static void main(String[] args) 
	{
		int valor=9;
		
		//METODO DE RAIZ CUADRADA
		
		double raiz=Math.sqrt(valor);
		
		double num1=5.85;
		
		//METODO DE REDONDEO-> SI NO ES UN NUMERO, DA 0, SINO, REDONDEA PARA ARRIBA O PARA ABAJO SEGUN CORRESPONDA.
		long resultado=Math.round(num1);
		
		double base=2;
		double exp=3;
		double potencia;
		
		potencia=Math.pow(base, exp);
		
		System.out.println("RAIZ CUADRADA DEL NUMERO "+valor+"="+(int)raiz);
		
		System.out.println(resultado);
		
		System.out.println("Potencia: "+(int)base+" Exponente: "+(int)exp+"= "+(int)potencia);
	}

}
