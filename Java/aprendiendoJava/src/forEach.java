public class forEach 
{
	public static void main(String[] args)
	{
		final int fila=5;
		final int columna=5;
		
		int[][] matriz=new int [fila][columna];
		
		for(int i=0;i<fila;i++)
		{
			for(int j=0;j<columna;j++)
			{
				matriz[i][j]=(int)(Math.random()*100);
			}
		}
		
		for(int[] nFila:matriz)
		{
			System.out.println();
			for(int contenido:nFila)
			{
				System.out.print(contenido+"\t");
			}
		}
		
		/*int[][] matriz= 
		{
				{0,1,2,3,4},
				{5,6,7,8,9},
				{10,11,12,13,14},
				{15,16,17,18,19},
				{20,21,22,23,24}
		};
		
		for(int[] i:matriz)//Recorro por fila -> ES UN VECTOR DE FILAS, por eso la nomenclatura del for each
		{
			System.out.println();
			for(int contenido:i)//MUESTRO LA FILA QUE RECORRI, LUEGO DE MOSTRARLA, AVANZO A LA SIGUIENTE
			{
				System.out.print(contenido+"\t");
			}
		}
		*/
	}
}
