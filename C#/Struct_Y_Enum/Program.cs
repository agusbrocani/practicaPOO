using System;

namespace Struct_Y_Enum
{
    enum Bonus { bajo=500, normal=1000, bueno=1500, extra=3000}
    class Program
    {
        static void Main(string[] args) 
        {
            Empleado empleado1 = new Empleado(1200, 250);
            empleado1.cambiarSalario(empleado1,100);
            Console.WriteLine(empleado1);//lo puedo hacer por sobreescritura del método ToString

            //enum
            Console.WriteLine("\nEnum:");
            Bonus Antonio = Bonus.bueno;
            Console.WriteLine("Desempeño: "+Antonio);

            //Si quiero el valor del Bonus, tengo que hacer un casting

            double bonusAntonio = (double)Antonio;
            Console.WriteLine("Valor del bonus: "+bonusAntonio);

        }
    }

    public struct Empleado  //CAMBIAR struct por class y se aprecia 
    {
        public double salarioBase, comision;
        public Empleado(int salarioBase, int comision)
        { 
            this.salarioBase = salarioBase;
            this.comision = comision;
        }

        public override string ToString()
        {
            return string.Format("Salario y comisión del empleado ({0},{1})",salarioBase,comision);
        }

        public void cambiarSalario(Empleado emp, double incremento)
        { 
            emp.salarioBase += incremento;
            emp.comision+= incremento;

            Console.WriteLine(emp.salarioBase);
            Console.WriteLine(emp.comision);
        }
    }
}