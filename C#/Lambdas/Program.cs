using System;
using System.Globalization;

namespace Lambdas
{
    class Program
    {
        static void Main(string[] args)
        {
            Persona p1 = new Persona();
            p1.Nombre = "AGUSTIN";
            p1.Edad = 24;

            Persona p2 = new Persona();
            p2.Nombre = "agustin";
            p2.Edad = 24;

            ComparaEdades comparaEdades = (persona1, persona2) => persona1 == persona2;

            Console.WriteLine(comparaEdades(p1.Edad, p2.Edad) ? "Tienen la misma edad" :"No tienen la misma edad") ;

            ComparaNombres comparaNombres = (persona1, persona2) => persona1.ToLower() == persona2.ToLower();

            Console.WriteLine(comparaNombres(p1.Nombre,p2.Nombre)?"Tienen exactamente el mismo nombre":"El nombre de las dos personas es distinto");
        }

        public delegate bool ComparaEdades(int edad1, int edad2);
        public delegate bool ComparaNombres(string n1, string n2);

        class Persona
        {
            private string nombre = "";
            private int edad;

            public string Nombre { get => nombre; set => nombre = value; }
            public int Edad { get => edad; set => edad = value; }
        }
    }
}