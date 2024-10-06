package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class getLocalGraphicsEnvir 
{

	public static void main(String[] args) 
	{
		String[] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		String nombreDeFuente=JOptionPane.showInputDialog("Introducir fuente");
		
		boolean estaLaFuente=false;
		
		for(String NF:nombresDeFuentes)
		{
			//System.out.println(NF);
			
			if(nombreDeFuente.equalsIgnoreCase(NF))
			{
				estaLaFuente=true;
			}
		}
		
		if(!estaLaFuente)
		{
			System.out.println("NO ESTA LA FUENTE INSTALADA");
		}
		else
		{
			System.out.println("FUENTE INSTALADA");
		}

	}

}
