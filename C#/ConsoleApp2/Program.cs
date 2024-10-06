using System;
using System.IO;

namespace Destructores
{
    class Program
    {
        static void Main(string[] args) 
        {
            ManejoArchivos miArchivo= new ManejoArchivos();
            miArchivo.numeroLineas();
        }
    }

    class ManejoArchivos
    {
        StreamReader archivo = null;

        int contador = 0;

        string linea;

        public ManejoArchivos() 
        {
            archivo = new StreamReader(@"C:\Users\PC\Desktop\tirar.txt");
            //Conexion abierta entre mi app y el sistema de archivos. Abri el flujo de datos.
            //Cuando termino, tengo que cerrar la conexion para dejar de consumir recursos.

            while ((linea=archivo.ReadLine()) != null)
            { 
                Console.WriteLine(linea);
                contador++;
            }

        }
        public void numeroLineas()
        {
            Console.WriteLine("Hay {0} líneas.", contador);
        }

        ~ManejoArchivos()
        {
            //Si fuese una BBDD, vendria la instrucción para cerrar la conexión con la BBDD
            archivo.Close();
        }
    }
}
