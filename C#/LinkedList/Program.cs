using System;
using System.Collections.Generic;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace LinkedList
{
    class Program
    {
        static void Main(string[] args)
        { 
            LinkedList <int> numeros1 = new LinkedList<int>();
            LinkedList<int> numeros2 = new LinkedList<int>();


            foreach (int numero in new int[] { 10,8,6,4,2,0})//Recorrer cada numero dentro del array
            { 
                numeros1.AddFirst(numero);
                numeros2.AddLast(numero);  
            }

            //numeros1.Remove(6);

            //CONSTRUI UN NODO Y LO AÑADI AL APRINCIPIO
            LinkedListNode<int> nodoImportante = new LinkedListNode<int>(15);//no existe en la lista

            numeros1.AddFirst(nodoImportante);

            /*Console.WriteLine("First:");

            foreach (int numero in numeros1)
            {
                Console.Write(numero+"\t");
            }

            Console.WriteLine("\nLast:");

            foreach (int numero in numeros2)
            {
                Console.Write(numero + "\t");
            }*/


            //utilizando atributos
            //inicio nodo en el primer elemento; finaliza cuando nodo apunta a null(el siguiente del ultimo); incremento el puntero de nodo con el siguiente
            Console.WriteLine("IZQ-DER");
            for (LinkedListNode <int> nodo=numeros1.First;nodo!=null; nodo=nodo.Next)
            { 
                int numero=nodo.Value;//Me trae el valor del nodo que estoy recorriendo
                Console.Write(numero+"\t");
            }

            Console.WriteLine("\nDER-IZQ");
            for (LinkedListNode <int> nodo=numeros1.Last; nodo!=null; nodo=nodo.Previous)
            {
                int numero = nodo.Value;
                Console.Write(numero + "\t");
            }

            //Remove()->quita la primera aparicion del valor especificado,RemoveFirst(),RemoveLast()


        }
    }
}
