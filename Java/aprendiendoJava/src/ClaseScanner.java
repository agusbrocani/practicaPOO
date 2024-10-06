import java.util.*;

public class ClaseScanner 
{

	public static void main(String[] args) 
	{
		//Construir un objeto de tipo scanner desde el origen donde toma la info, en este caso, la consola
		//Instancio un nuevo objeto de tipo Scanner ->PUEDE ESTAR INICIALIZADO CON EL CONTRUCTOR POR DEFECTO.
		//SABE EL TAMAÑO DE LO QUE VOY A INGRESAR EN CONSOLA PORQUE LLAMO A UN METODO ESPECIFICO PARA EL TIPO DE DATO QUE VOY A INGRESAR.
		
		Scanner entrada=new Scanner(System.in);

		System.out.println("INTRODUCIR TU NOMBRE: ");
		
		//Capto lo que ingrese por consola en la variable de tipo String miNombre
		String miNombre=entrada.nextLine();
		
		System.out.println("INTRODUCIR TU EDAD: ");
		
		int edad=entrada.nextInt();
		
		System.out.println("Mi nombre: "+miNombre);
		System.out.println("Mi edad: "+edad);
		
		entrada.close();
	}

}
