using System;

namespace Json
{
    class Program
    {
        static void Main(string[] args) 
        {
            Persona[] personas = new Persona[3] { new Persona( "Juan Pablo", "Lezcano", 24, 41197537 ), new Persona("Agustin Nicolas","Brocani",24,40123456 ),new Persona("Kevin","Drackers",21, 42123456 ) };

            /*personas[0] = new Persona("Juan Pablo", "Lezcano", 24, 41197537);
            personas[1] = new Persona("Agustin Nicolas", "Brocani", 24, 40123456);
            personas[2] = new Persona("Kevin", "Drackers", 21, 42123456);*/

            string json = Newtonsoft.Json.JsonConvert.SerializeObject(personas);
            string[] contenido = { json };
            File.WriteAllLines(@"C:\Users\PC\Desktop\Magnets\json.txt", contenido);//es como el fopen

            //StreamReader->Clase para leer archivos.
            System.IO.StreamReader archivo = null;//Apunto al archivo->Debo abrir el canal hacia ese archivo con el path

            try
            {
                string lecturaDeLinea;
                int contadorLineas = 0;
                string path = @"C:\Users\PC\Desktop\Magnets\json.txt";//RUTA HACIA EL ARCHIVO QUE QUIER LEER, Click derecho en el archivo->propiedades-> copio ruta

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
                Console.WriteLine("\n"+e.ToString()+"\n");
            }
            finally
            {
                if (archivo != null)
                {
                    archivo.Close();
                }
                Console.WriteLine("\nSE CERRO EL ARCHIVO CORRECTAMENTE");
            }
        }
    }

    public class Persona
    {
        public string name { get; set;} = String.Empty; // es lo mismo que poner comillas
        // public string name{ get; set;} es exactamente lo mismo que hacer
        /*private string name;
        public string Name
        {
            get
            {
                return this.name;
            }
            set
            {
                this.name = value;
            }
        }*/
        public string surname { get; set; } = String.Empty;
        public int age;
        public int id;

        public Persona(string name, string surname, int age, int id)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.id = id;
        }
    }
}