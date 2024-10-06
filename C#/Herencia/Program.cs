using System;

//Mamiferos
//Caballos-Humanos-Gorilas

namespace ProgramaHerencia
{
    class Program
    {
        static void Main(string[] args)
        {
            Caballos caballo = new Caballos("Babieca");
            Humanos humano = new Humanos("Agustin");
            Gorilas gorila = new Gorilas("Copito");

            Caballos[] almacenAnimales = new Caballos[3];
            almacenAnimales[0] = caballo;
            //almacenAnimales[1]=humano;No puedo convertir un humano en un caballo

            //SOLUCION: creo un array de Mamiferos, ya que puede contener Caballos,Gorilas y Humanos
            Mamiferos[] almacenMamiferos = new Mamiferos[3];
            almacenMamiferos[0] = caballo;    //pensar de la clase Mamiferos, porque no tengo uno propio
            almacenMamiferos[1] = humano;   //pensar de la clase Humanos
            almacenMamiferos[2] = gorila;   //pensar de la clase Gorilas


            for (int i = 0; i < almacenMamiferos.Length; i++)
            {
                almacenMamiferos[i].pensar();   //POLIMORFISMO: el Array contiene OBJETOS Mamiferos y estos se comportan de manera distinta según a qué Mamifero llame.
            }
            almacenMamiferos[1].getNombre();
            //almacenMamiferos[1]->tengo almacenada un OBJETO Humanos, pero como el Array es de tipo Mamiferos, SOLO puedo ACCEDER a los METODOS de la clase Mamiferos y los de sus padres.

            /*
            caballo.getNombre();
            humano.getNombre();
            gorila.getNombre();
            */

            //Caballos animal = new Mamiferos("Bucéfalo");  ERROR: NO esta bien aplicado el PRINCIPIO DE SUSTITUCIÓN. Dentro de un objeto de tipo Caballos no puedo almacenar un objeto de tipo Mamiferos 

            Mamiferos animal = new Caballos("Bucéfalo");//COMO EL OBJETO animal ES DE TIPO Mamiferos, SOLO PUEDO ACCEDER A LOS METODOS DE Mamiferos y sus clases padres
            //Mamiferos persona = new Humanos("Juan");
            Caballos Bucefalo = new Caballos("Bucéfalo");
            animal = Bucefalo;  //Un Mamifero es un Caballo, Humano o Gorila
            //Bucefalo = animal; ERROR: Un Caballo no puede albergar a un Mamifero

            Object miAnimal = new Caballos("Bucéfalo");
            Object miPersona = new Humanos("Juan");
            Object miMamifero = new Mamiferos("Wally");

            //protected: no es accesible desde fuera del entorno de las Clases.
            //Mamiferos pruebaProtected = new Mamiferos("");
            //pruebaProtected.respirar(); NO ES VALIDO

            Ballenas myWally = new Ballenas("Wally");
            myWally.nadar();

            IMamiferosTerrestres ImiCaballo1 = new Caballos("Babieca");
            Console.WriteLine($"Numero de patas del Caballo: {ImiCaballo1.numeroPatas()}");

            ISaltoConPatas ImiCaballo2 = new Caballos("Babieca");
            Console.WriteLine($"Numero de patas con las que salta el Caballo: {ImiCaballo2.numeroPatas()}");

            Lagartijas Juancho = new Lagartijas("Juancho");
            Juancho.respirar();
            Juancho.getNombre();
            
            animal.respirar();
            animal.getNombre();
           

        }
    }
}
//LOS METODOS SE ESCRIBEN EN PascalCase

interface IMamiferosTerrestres
{
    int numeroPatas();
}

interface IAnimalesYDeportes
{
    string tipoDeporte();

    bool esOlimpico();
}

interface ISaltoConPatas
{ 
    int numeroPatas();
}

abstract class Animales
{
    public void respirar()  //Común para TODAS las clases que Hereden-> lo puedo desarrollar acá
    {
        Console.WriteLine("Soy capaz de respirar");
    }

    public abstract void getNombre();   //Se deja como si fuera una interfaz-> TODAS LAS CLASES QUE HEREDEN DE ANIMALES, LO TIENEN QUE IMPLEMENTAR
}

class Lagartijas : Animales
{
    private string nombreReptil;

    public Lagartijas(string nombreReptil)
    {
        this.nombreReptil = nombreReptil;
    }
    public override void getNombre()
    {
        Console.WriteLine($"El nombre del reptil es: {nombreReptil}");
    }
}

//Da lo mismo poner o no poner la Herencia de Object porque siempre hereda igual
class Mamiferos : Animales
{
    private string nombreSerVivo;

    public Mamiferos(string nombreSerVivo) 
    { 
        this.nombreSerVivo= nombreSerVivo;
    }
    public virtual void pensar()    
    {
        Console.WriteLine("Pensamiento basico instintivo");
    }

    public void cuidarCrias()
    {
        Console.WriteLine("Cuido a mis crias hasta que se valgan por si solas");
    }


    public override void getNombre()
    {
        Console.WriteLine($"El nombre del mamifero es: {nombreSerVivo}");
    }

    public string getNSerVivo()
    {
        return nombreSerVivo;
    }
}

class Ballenas : Mamiferos 
{
    public Ballenas(string nombreBallena) : base(nombreBallena)
    { 
    }

    public void nadar()
    {
        Console.WriteLine("Soy capaz de nadar");
    }
}

//Cuando heredo de Mamiferos, implicitamente escribo los 2 metodos en la clase Caballos
//Le digo a las subclases que llamen al constructor de la clase padre para inicializar todos los objetos
class Caballos : Mamiferos, IMamiferosTerrestres, IAnimalesYDeportes, ISaltoConPatas
{
    public Caballos(string nombreCaballo) : base(nombreCaballo)//Le paso al constructor de la clase padre el dato que necesita dentro de base()
    {
    }
    public void galopar()
    {
        Console.WriteLine("Soy capaz de galopar");
        respirar();
    }
    //Metodos de interfaz IMamiferosTerrestres
    int IMamiferosTerrestres.numeroPatas()
    {
        return 4;
    }

    //Metodos de interfaz IAnimalesYDeportes
    public string tipoDeporte()
    {
        return "Hípica";
    }

    public bool esOlimpico()
    {
        return true;
    }
    //Metodos de interfaz ISaltoConPatas
    int ISaltoConPatas.numeroPatas() //quito el public, sino, se vuelve a generar la ambiguedad.
    { 
        return 2; 
    }
}
//Cuando heredo de Mamiferos, implicitamente escribo los 2 metodos en la clase Humanos
class Humanos : Mamiferos
{
    public Humanos(string nombreHumano) : base(nombreHumano)
    { 
    }
    public sealed override void pensar()//Es una modificación del método public virtual void pensar() de la clase padre, no es un método independiente -> PARA QUE SE TRATE DE UNA MODIFICACION Y NO UN MÉTODO DIFERENTE-> utilizo override
    {
        Console.WriteLine("Soy capaz de pensar ¿?");
    }

}

class Adolescentes : Humanos
{
    public Adolescentes(string nombreAdolescente) : base(nombreAdolescente)
    { 
    }
    /* NO PUEDO SOBREESCRIBIR UN MÉTODO SI EN LA CLASE PADRE UTILICE EL MODIFICADOR sealed
    public override void pensar()
    {
        base.pensar();
        Console.WriteLine("Las hormonas me impiden pensar con claridad");
    }
    */
}

//Cuando heredo de Mamiferos, implicitamente escribo los 2 metodos en la clase Gorilas
sealed class Gorilas : Mamiferos ,IMamiferosTerrestres
{
    public Gorilas(string nombreGorila) : base(nombreGorila)
    { 
    }

    public override void pensar()
    {
        Console.WriteLine("Pensamiento instintivo avanzado");
    }
    public void trepar() 
    {
        Console.WriteLine("Soy capaz de trepar");
    }
    public int numeroPatas() 
    {
        return 2;
    }
}

/* //uso de sealed class
class Chimpances: Gorilas   //Quiero extender la Herencia de la Clase Gorilas, si lo quiero impedir, utilizo el modificador sealed en Gorilas
{
    public Chimpances(string nombreChimpance) : base(nombreChimpance)
    { 
    }
}
*/