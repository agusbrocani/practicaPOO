using System;

namespace ConceptosPOO
{
    class Program
    { 
        static void Main(string[] args)
        {
            //realizarTarea();
            var miVariable = new
            {
                /*Puedo declarar campos e iniciarlos*/
                Nombre = "Agustin",
                Edad = 19
            };
            Console.WriteLine("OBJETO 1:");
            Console.WriteLine(miVariable.Nombre);
            Console.WriteLine(miVariable.Edad);

            var miOtraVariable = new { Nombre = "Ana", Edad = 25 };
            Console.WriteLine("OBJETO 2:");
            Console.WriteLine(miOtraVariable.Nombre);
            Console.WriteLine(miOtraVariable.Edad);

            miVariable = miOtraVariable;
            Console.WriteLine("OBJETO PISADO:");
            Console.WriteLine(miVariable.Nombre);
            Console.WriteLine(miVariable.Edad);
        }

        static void realizarTarea()
        {
            Punto origen = new Punto();
            Punto destino = new Punto(128,80);
            double distancia= origen.CalcularDistancia(destino);
            Console.WriteLine($"Distancia de origen a destino= {distancia}");
            Console.WriteLine($"Cantidad de objetos: {Punto.getContadorDeObjetos()}");
        }
    }
}
