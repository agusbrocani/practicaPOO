using System;

namespace ComienzodeCurso;

class Program
{
    static void Main(string[] args)
    {
        //StreamReader->Clase para leer archivos.
        System.IO.StreamReader archivo = null;//Apunto al archivo->Debo abrir el canal hacia ese archivo con el path

        try
        {
            string lecturaDeLinea;
            int contadorLineas = 0;
            string path = @"C:\Users\PC\Desktop\tirar.txt";//RUTA HACIA EL ARCHIVO QUE QUIER LEER, Click derecho en el archivo->propiedades-> copio ruta

            archivo = new System.IO.StreamReader(path);//fopen
            while ((lecturaDeLinea = archivo.ReadLine()) != null)
            {
                Console.WriteLine(lecturaDeLinea);
                contadorLineas++;
            }
        }
        catch (Exception e)
        {
            Console.WriteLine("HUBO UN ERROR CON LA LECTURA DEL ARCHIVO");
        }
        finally
        {
            //Para llegar acá, lei todos los registros del archivo
            //Si es null, no hay nada que cerrar. Archivo esta apuntando a algo(Supongo que a el EOF)
            if (archivo != null) 
            {
                archivo.Close();
            }
            Console.WriteLine("SE CERRO EL ARCHIVO CORRECTAMENTE");
        }
    }
    
}
