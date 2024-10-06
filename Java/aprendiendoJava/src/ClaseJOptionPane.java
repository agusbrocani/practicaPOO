import javax.swing.*;

public class ClaseJOptionPane 
{

	public static void main(String[] args) 
	{
		//NO TENGO QUE INSTANCIAR OBJETOS PORQUE SON METODOS ESTATICOS
		//String es un objeto perteneciente a la clase String
		
		String mensaje=JOptionPane.showInputDialog("INTRODUCE TU NOMBRE");
		
		
		System.out.println(mensaje);
		
		String edad=JOptionPane.showInputDialog("INTRODUCIR LA EDAD");
		
		System.out.println(Integer.parseInt(edad)+1);
		
		String cadena="52.25";
		
		System.out.println(Double.parseDouble(cadena)+1+0.25);

	}

}
