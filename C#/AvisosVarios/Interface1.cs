using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AvisosVarios
{
    internal interface IAvisos
    {
        //Todas las Multas SI o SI tienen esta Info, como es FUNDAMENTAL que este presente->utilizo una INTERFAZ para obligar a implementar los métodos.
        void mostrarAviso();    //Descripción de la Multa

        string getFecha();      //Fecha de multa
    }
}
