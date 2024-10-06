class Program
{
    static void Main(string[] args)
    {
        Circulo miCirculo;  //Creacion de objeto de tipo Circulo.Variable-Objeto de tipo Circulo.

        miCirculo=new Circulo();//Intanciar una clase. Iniciacion de variable/objeto de tipo Circulo.
        //Instanciación. Ejemplarización. Creación de ejemplar de clase. [SINÓNIMOS DE INSTANCIAR]


        try
        {
            Console.WriteLine("Ingrese el radio a calcular el área(valor entero):");
            int radio = int.Parse(Console.ReadLine());
            Console.WriteLine($"Radio ingresado: {radio}");
            Console.WriteLine("Área del círculo: " + "{0:N2}", miCirculo.calculoArea(radio));//Encapsulación: No puedo acceder desde otra clase. Tengo que cambiar el nivel de acceso(uso el public en el método).
        }
        catch (Exception ex) when(ex.GetType()!=typeof(FormatException))
        {
            Console.WriteLine("Hubo un error.");
        }
        catch (FormatException ex)
        {
            Console.WriteLine("Error: se ingresó texto en vez de un número entero.");
            Console.WriteLine(ex.Message);
            
        } 
    }

}

class Circulo
{
    private const double pi = Math.PI;//Solo visible y accesible desde la propia clase. Es lo mismo poner el private que no ponerlo(Solo en C#)   
    public double calculoArea(int radio)
    {
        return pi * radio * radio;
    }
}

