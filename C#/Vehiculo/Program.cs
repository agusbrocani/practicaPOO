using System;

namespace Vehiculo
{
    class Program
    {
        static void Main(string[] args)
        {
            Avion miAvion = new Avion();

            Console.WriteLine("Probando el Avion:\n");
            miAvion.ArrancarMotor();
            miAvion.Despegar();
            miAvion.Conducir();
            miAvion.Aterrizar();
            miAvion.PararMotor();

            Coche miCoche = new Coche();
            Console.WriteLine("\nProbando el Coche:\n");
            miCoche.ArrancarMotor();
            miCoche.Acelerar();
            miCoche.Conducir();
            miCoche.Frenar();
            miCoche.PararMotor();

            Console.WriteLine("\nPolimorfismo en accion:\n");
            Vehiculo miVehiculo = miCoche;//PRINCIPIO DE SUSTITUCIÓN "es un", miCoche es un Vehiculo-> guardo un OBJETO de tipo Coche en un OBJETO de tipo Vehiculo
            //Primer comportamiento del OBJETO:
            miVehiculo.Conducir();
            miVehiculo = miAvion;   //PRINCIPIO DE SUSTITUCIÓN "es un"
            //Segundo comportamiento del OBJETO:
            miVehiculo.Conducir();
        }
    }

    class Vehiculo : Object
    {
        protected bool encendidoVehiculo = false;
        protected bool estoyConduciendo = false;//Llamo conducir a estar en movimiento

        public void ArrancarMotor()
        {
            if (encendidoVehiculo)
            {
                Console.WriteLine("El motor ya ha sido arrancado anteriormente.");
            }
            else
            {
                Console.WriteLine("Arranqué el motor.");
                encendidoVehiculo = true;
                estoyConduciendo = true;
            }
        }

        public void PararMotor()
        {
            if (encendidoVehiculo)
            {
                Console.WriteLine("Paré el motor.");
            }
            else
            {
                Console.WriteLine("El motor ya estaba parado.");
            }
        }

        public virtual void Conducir()
        {
            if (estoyConduciendo)
            {
                Console.Write("Estoy conduciendo");
            }
            else
            {
                Console.Write("No estoy conduciendo");
            }
        }
    }

    class Avion : Vehiculo
    {
        private bool despegueInicial = false;
        public void Despegar()
        {
            if (encendidoVehiculo == false)
            {
                Console.WriteLine("No puedo despegar si no encendí el avión.");
            }
            else if (despegueInicial == false)
            {
                Console.WriteLine("Estoy despegando.");
                despegueInicial = true;
                estoyConduciendo = true;
            }
            else
            {
                Console.WriteLine("El avion ya habia despegado.");
            }
        }
        public void Aterrizar()
        {
            if (despegueInicial == false)
            {
                Console.WriteLine("No puedo aterrizar si no despegue.");
            }
            else
            {
                Console.WriteLine("Estoy aterrizando.");
            }
        }

        public override void Conducir()
        {
            base.Conducir();//Invoco al metodo de la Clase Padre para que ejecute su código. Puedo o no invocarlo
            Console.Write(" un avion.\n");
        }


    }
    class Coche : Vehiculo
    {
        public void Acelerar()
        {
            if (estoyConduciendo)
            {
                Console.WriteLine("Estoy acelerando.");
            }
            else
            {
                Console.WriteLine("No puedo acelerar con el Coche apagado.");
            }
        }

        public void Frenar()
        {
            if (encendidoVehiculo)
            {
                Console.WriteLine("Estoy frenando.");//Estoy presionando el freno independientemente si esta en movimiento o no
            }
            else
            {
                Console.WriteLine("Estoy frenando con el Coche apagado.");
            }
        }
        public override void Conducir()
        {
            base.Conducir();//Invoco al metodo de la Clase Padre para que ejecute su código
            Console.Write(" un coche.\n");
        }
    }
}
