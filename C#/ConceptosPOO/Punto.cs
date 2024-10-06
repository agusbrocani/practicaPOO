using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConceptosPOO
{
    internal class Punto
    {
        private int x;
        private int y;
        private static int contadorDeObjetos=0;

        public Punto()
        {
            x = 0;
            y = 0;
            contadorDeObjetos++;
        }
        public Punto(int x,int y) 
        {
            this.x = x;
            this.y = y;
            contadorDeObjetos++;
        }

        public static int getContadorDeObjetos()
        {
            return contadorDeObjetos;
        }

        public double CalcularDistancia(Punto otroPunto) 
        {
            int xDif = this.x - otroPunto.x;
            int yDif= this.y - otroPunto.y;
            double distanciaPuntos = Math.Sqrt(Math.Pow(xDif, 2) + Math.Pow(yDif, 2));

            return distanciaPuntos;
        }
    }
}
