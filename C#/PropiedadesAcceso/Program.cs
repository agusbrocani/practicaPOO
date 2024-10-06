using System;

namespace PropiedadesAcceso
{
    class Program
    { 
        static void Main(string[] args)
        {
            Empleado Agustin = new Empleado("Juan");

            //Para establecer un salario:
            
            Agustin.SALARIO = -1200;
            //Ventajas: la sintaxis es como si el campo fuese public
            //          NO PUEDO VIOLAR LAS REGLAS QUE YO ESTABLECÍ(para eso utilizo el método de control). ej: salario negativo

            //Desventajas: la sintaxis por ahi es más complicada que el encapsulamiento.

            Agustin.SALARIO += 500;

            Console.WriteLine("El salario del empleado es: " + Agustin.SALARIO);
        }
    }
    //Quiero incrementar el sueldo sin modificar la clase Empleado

    class Empleado
    {
        private string _nombre;
        private double _salario;
        public Empleado(string nombre)
        {
            _nombre = nombre;
        }

        /*public void setSalario(double salario) 
        {
            if (salario<0)
            {
                Console.WriteLine();
                this.salario = 0;
            }
            else
            {
                this.salario = salario;
            }
        }
        public double getSalario() 
        {
            return salario;
        }*/

        //Utilizando Properties
        //Creo un método de control
        private double evaluaSalario(double salario)
        {
            if (salario<0)
            { 
                return 0; 
            }
            else
            { 
                return salario;
            }
        }
        //CREACIÓN DE PROPIEDAD: Permite acceder directo a la Propiedad como si fuera un campo public pero a la vez impide violar reglas que no quiero que se violen. EJ: salario negativo
        //POR CONVENCION: NOMBRE EN MAYUSCULAS
       
        //Simplificación de codigo
        /*public double SALARIO
        {
            //Funciona como el getter y el setter
            get { return this.salario; }
            set { this.salario = evaluaSalario(value); }//PARA PASAR PARAMETRO AL METODO UTILIZO LA PALABRA RESERVADA value: hace referencia al valor que le va a mandar.
        }*/

        public double SALARIO
        {
            get => _salario;
            set => _salario = evaluaSalario(value);
        }
    }
}
