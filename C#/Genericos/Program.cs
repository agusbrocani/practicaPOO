using System;

namespace Genericos
{
    class Program
    {
        
        static void Main(string[] args)
        {

            /*
            AlmacenObjetos <Empleado> archivos = new AlmacenObjetos<Empleado>(4);
                            //<string>                            //<string>

            //archivos.agregar("Agustín");
            //archivos.agregar("Nicolas");
            //archivos.agregar("Brocani");
            //archivos.agregar("Luca");
            //string nombreEmpleado = (string)archivos.getElemento(2);
            //Console.WriteLine(nombreEmpleado);

            archivos.agregar(new Empleado(1500));
            archivos.agregar(new Empleado(2500));
            archivos.agregar(new Empleado(3500));
            archivos.agregar(new Empleado(4500));

            //SIN GENERICOS: Empleado salarioEmpleado = (Empleado)archivos.getElemento(2);//Me entero del error en tiempo de ejecución->Problema de utilizar la herencia.

            //CON GENERICOS:

            Empleado salarioEmpleado = archivos.getElemento(2);

            Console.Write(salarioEmpleado.getSalario());//Tengo que invocar al método porque sino me imprime Genericos.Empleado
            */

            AlmacenObjetos<DateTime> archivos = new AlmacenObjetos<DateTime>(4);//invoco al constructor

            archivos.agregar(new DateTime());
            archivos.agregar(new DateTime());
            archivos.agregar(new DateTime());
            archivos.agregar(new DateTime());

            DateTime algo = archivos.getElemento(2);

            Console.WriteLine(algo);
        }
    }

    /*class AlmacenObjetos
    {
        private Object[] datosElemento;
        private int i = 0;  //Contador que me permite almacenar elementos.

        //z->Cuántos elementos va a almacenar el Array
        public AlmacenObjetos(int z) 
        {
            datosElemento= new Object[z];
        }

        public void agregar(Object obj)
        {
            datosElemento[i] = obj;
            i++;
        }

        public Object getElemento(int pos)
        {
            return datosElemento[pos];
        }
    }*/
    class AlmacenObjetos <T>
    {
        private T[] datosElemento;
        private int i = 0;  

        public AlmacenObjetos(int z)
        {
            datosElemento = new T[z];
        }

        public void agregar(T obj)
        {
            datosElemento[i] = obj;
            i++;
        }

        public T getElemento(int pos)
        {
            return datosElemento[pos];
        }
    }

    class Empleado
    {
        private double salario;

        public Empleado(double salario) 
        { 
            this.salario = salario;
        }

        public double getSalario() => salario;
    }
}
