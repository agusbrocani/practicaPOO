using System;
using System.Collections.Generic;

namespace List
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> miLista = new List<int>();

            int i;

            /*
            int cantElementos;
            int[] listanumeros = new int[] { 3, 6, 8, 10, 50 }; //durante la ejecución del programa, el array va a tener 5 elementos siempre. una coleccion puede ser modificada en tiempo de ejecución
              
            for (i = 0; i < listanumeros.length; i++)
            {
                milista.add(listanumeros[i]);
            }

            milista.add(5);
            milista.add(7);
            milista.add(9);

            milista.sort();

            for (i = 0; i < milista.count; i++)
            {
                console.writeline(milista[i]);
            }

            Console.WriteLine("¿Cuántos elementos quiere introducir?:");

            cantElementos = Int32.Parse(Console.ReadLine ());

            Console.WriteLine("Ingrese los elementos:");
            for (i=0;i<cantElementos;i++)
            {
                miLista.Add (Int32.Parse(Console.ReadLine()));
            }

            Console.WriteLine("Imprimiendo lista:");
            for (i = 0; i < miLista.Count; i++)
            {
                Console.WriteLine(miLista[i]);
            }*/

            int elem = 1;

            Console.WriteLine("Ingrese elementos, para finalizar: 0");
            while (elem != 0)
            {
                elem = Int32.Parse(Console.ReadLine());
                miLista.Add(elem);  
            }

            miLista.RemoveAt(miLista.Count - 1);//me guardó el 0 en la ultima posición que usé para salir

            foreach (int elemento in miLista)
            {
                Console.WriteLine(elemento);
            }

        }
    }
}

