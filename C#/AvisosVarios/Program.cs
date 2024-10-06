using System;

namespace AvisosVarios
{
    class Program
    {
        static void Main(string[] args) 
        {
            AvisosTrafico aviso1=new AvisosTrafico();

            aviso1.mostrarAviso();

            AvisosTrafico aviso2= new AvisosTrafico("Direccion Municipal de Transito", "Sanción de exceso velocidad: $6000","30/12/2022");

            Console.WriteLine(aviso2.getFecha());
            aviso2.mostrarAviso();
        }
    }
}
