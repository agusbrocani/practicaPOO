using System;

namespace Stack
{
    class Program
    {
        static void Main(string[] args)
        {
            Stack <int> numeros = new Stack<int>();

            foreach (int numero in new int[] { 1,2,3,4,5,6,7,8,9})
            {
                numeros.Push (numero);
            }

            foreach (int numero in numeros)
            { 
                Console.Write (numero+"\t");
            }

            Console.WriteLine ();

            numeros.Clear();

            if (numeros.Count==0)
            {
                Console.WriteLine("Pila vacia.");
            }
        }
    }
}
