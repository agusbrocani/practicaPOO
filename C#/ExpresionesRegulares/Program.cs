using System;
using System.Text.RegularExpressions;//namespace de Clase Regex

namespace ExpresionesRegulares
{
    class Program
    {
        static void Main(string[] args)
        {
            //https://www.pildorasinformaticas.es
            string frase = "Mi web es http://pildorasinformaticas.es";

            //Expresión regular a utilizar
            string patron = "https?://(www.)?pildorasinformaticas.es";//con el ? delante de la s le digo que puede haber 1 o ninguna[NO USE PARÉNTESIS, ASI QUE SOLO AFECTA A LA s y no al http]- con el ? le digo que las 3 w pueden estar una o ninguna [ESTABLECÍ UN GRUPO EN LAS 3 w con los paréntesis]

            Regex miRegex = new Regex(patron);  //Le envio por parámetro la expresión regular
            //Todas las coincidencias las pone en una Coleccion

            MatchCollection elMatch = miRegex.Matches(frase);//Buscar coincidencias en la frase y guardarlas en el objeto MatchCollection

            if(elMatch.Count>0)
            {
                Console.WriteLine("Se ha encontrado web");
            }
            else 
            {
                Console.WriteLine("No se ha encontrado web");
            }
        }
    }
}
