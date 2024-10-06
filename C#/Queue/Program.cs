using System;

namespace Queue
{
    class Program
    {
        static void Main(string[] args)
        { 
            Queue <int> numeros = new Queue<int>();

            foreach (int numero in new int[] { 1,2,3,4,5,6,7,8,9})
            {
                numeros.Enqueue(numero);
            }

            foreach (int numero in numeros)
            {
                Console.Write(numero+"\t");
            }

            Console.WriteLine();
            //Guardo la cantidad antes de desacolar
            int valor = numeros.Count;

            Console.WriteLine("Cantidad de elementos= "+valor);
            //DATO A TENER EN CUENTA:
            //                  (i < numeros.Count) con esta instruccion, cada vez que haga el ciclo, me esta actualizando el valor de i, por lo tanto, cuando 5>4 termina y me quedan 4 elementos
            //                  cantidad de elementos de un array es inmutable a lo largo del codigo       
            for (int i = 0; i < valor ; i++)
            {
                numeros.Dequeue();
            }

            //numeros.Clear();

            Console.WriteLine(/*"\nValor de aux= "+aux+*/"\n\nVolviendo a imprimir queue despues de vaciar");

            foreach (int numero in numeros)
            {
                Console.Write(numero + "\t");
            }

            Console.WriteLine("\nCantidad de elementos= " + (valor=numeros.Count));

            if (valor==0)
            {
                Console.WriteLine("Queue vacia");
            }
        }
    }
}
