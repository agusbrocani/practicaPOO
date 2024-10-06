using System;

namespace UsoArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arrayElementos = LeerDatos();
            int[] copia = arrayElementos;

            arrayElementos[0] =-20;

            Console.WriteLine("Imprimiendo desde el Main:");

            foreach (int i in arrayElementos)
            { 
                Console.WriteLine(i);
            }
            Console.WriteLine($"Copia en la posicion 0: {copia[0]}");
        }

        static int[] LeerDatos()
        {
            Console.WriteLine("¿Cuántos elementos quiere que tenga el Array?");
            string respuesta = Console.ReadLine();
            int cantidadElementos=int.Parse(respuesta);
            int[] datos = new int[cantidadElementos];

            for (int i=0;i<datos.Length;i++)
            {
                Console.WriteLine($"Introduce el dato para la posición {i}");

                respuesta= Console.ReadLine();
                datos[i]= int.Parse(respuesta);
            }
            return datos;
        }

    }
}