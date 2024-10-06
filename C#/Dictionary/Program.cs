using System;

namespace Dictionary
{
    class Program
    {
        static void Main(string[] args) 
        {
            //Cada elemento que tiene un valor determinado esta identificado con una clave(como si fuesen los indices de un vector, pero pueden ser cualquier cosa las claves)
            //Las claves NO se pueden repetir.

            Dictionary <string,int> claveValor=new Dictionary<string,int> ();

            claveValor.Add("Agustin Brocani",24);
            claveValor.Add("Luca Brocani",24);
            //otra sintaxis valida
            claveValor["Maria"]=25;
            claveValor["Antonio"]=29;

            foreach(KeyValuePair <string,int> miPar in claveValor)
            {
                Console.WriteLine("Clave: "+ miPar.Key + " Valor: " + miPar.Value);
            }

        }
    }
}
