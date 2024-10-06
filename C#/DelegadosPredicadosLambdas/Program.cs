using System;

namespace DelegadosPredicadosLambdas
{
    class Program
    {
        static void Main(string[] args) 
        {
            //Creación del ObjetoDelegado miDelegado apuntando al método SaludoBienvenida de la Clase Mensaje Bienvenida
            ObjetoDelegado miDelegado = new ObjetoDelegado(MensajeBienvenida.SaludoBienvenida);

            string msg =",como estas.";

            //Utilización del delegado para invocar al método referenciado.
            miDelegado(msg);

            //Reutilizo mi objeto y lo hago apuntar a otro método de otra clase
            ObjetoDelegado2 miDelegado2 = new ObjetoDelegado2(MensajeDespedida.SaludoDespedida);

            //Utilización del delegado para invocar al método referenciado.
            miDelegado2();
        }
        //Definición de los OBJETOS de tipo ObjetoDelegado
        delegate void ObjetoDelegado(string msg);
        delegate void ObjetoDelegado2();
    }

    class MensajeBienvenida
    { 
        public static void SaludoBienvenida(string msg)
        {
            Console.WriteLine("Hola acabo de llegar. Qué tal"+msg);
        }
    }
    class MensajeDespedida
    {
        public static void SaludoDespedida()
        {
            Console.WriteLine("Hola ya me marcho. Hasta luego");
        }
    }
}
