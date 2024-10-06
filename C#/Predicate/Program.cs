using System;

namespace Predicate
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Personas> gente = new List<Personas>();

            Personas p1= new Personas();
            p1.Nombre = "AGUSTIN";
            p1.Edad = 24;

            Personas p2 = new Personas();
            p2.Nombre = "luca";
            p2.Edad = 24;
            
            Personas p3 = new Personas();
            p3.Nombre = "agustiN";
            p3.Edad = 25;

            gente.AddRange(new Personas[] { p1,p2,p3});

            Predicate<Personas> miPredicado = new Predicate<Personas>(ExisteAgustin);

            bool existeAgustin = gente.Exists(miPredicado);

            if(existeAgustin)
            {
                Console.WriteLine("¡Agustin EXISTE!");
            }

            List<Personas> losAgustin = gente.FindAll(miPredicado);

            foreach (Personas a in losAgustin)
            {
                Console.WriteLine("Nombre= "+a.Nombre +"\t Edad:"+a.Edad);
            }
        }

        static bool ExisteAgustin(Personas persona) => persona.Nombre.ToLower() == "agustin";

        class Personas
        {
            private string nombre="";
            private int edad;

            public string Nombre { get => nombre; set => nombre = value; }
            public int Edad { get => edad; set => edad = value; }
        }
        
    }
}
