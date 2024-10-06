using System;

namespace GenericosRestricciones
{
    class Program
    {
        static void Main(string[] args)
        {
            AlmacenEmpleados<Jubilado> empleados = new AlmacenEmpleados<Jubilado>(3);

            empleados.agregar(new Jubilado(75));
            empleados.agregar(new Jubilado(65));
            empleados.agregar(new Jubilado(60));

            //Cambiar Jubilado por cualquier otra clase y funciona bien.



        }
    }
    //Clase Genérica con restricciones: clausula where
    class AlmacenEmpleados<T> where T : IParaEmpleados
    {
        private int i = 0;
        private T[] datosEmpleado;

        public AlmacenEmpleados(int z)
        {
            datosEmpleado = new T[z];
        }

        public void agregar(T obj)
        {
            datosEmpleado[i] = obj;
            i++;
        }

        public T getEmpleados(int pos) => datosEmpleado[pos];  
    }
    interface IParaEmpleados
    {
        double getSalario();
    }
    class Director : IParaEmpleados
    {
        private double salario;
        public Director(double salario)
        {
            this.salario = salario;
        }

        public double getSalario() => salario;
    }
    class Secretaria : IParaEmpleados
    {
        private double salario;
        public Secretaria(double salario)
        {
            this.salario = salario;
        }

        public double getSalario() => salario;
    }
    class Electricista : IParaEmpleados
    {
        private double salario;
        public Electricista(double salario)
        {
            this.salario = salario;
        }

        public double getSalario() => salario;
    }

    class Jubilado
    {
        private int edad;

        public Jubilado(int edad) 
        {
            this.edad = edad; 
        }
    }
}
