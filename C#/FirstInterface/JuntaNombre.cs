using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FirstInterface
{
    public class JuntaNombre : INotifyPropertyChanged
    {
        //3 campos para almacenar la info que van a manejar las propiedades
        private string nombre;
        private string apellido;
        private string nombre_completo;

        public event PropertyChangedEventHandler PropertyChanged;//Referencia a un método que controla si hubo cambio en propiedades de un Componente

        private void OnPropertyChanged(string property)//una propiedad cualquiera llegue como parámetro y desencadene una acción
        {
            //Si no es null, reflejo el cambio en la propiedad
            if(PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(property));
            }
        }

        //Creo las PROPIEDADES DE LOS Objetos JuntaNombre
        //PARA QUE SE VEAN REFLEJADOS LOS CAMBIOS: CUANDO EL METODO DE LA INTERFAZ ME DETECTE UN CAMBIO EN LA PROPIEDAD DE LOS TextBox, el set de los atributos de los objetos JuntaNombre debería actualizarlo
        public string Nombre
        {
            get => nombre;
            set 
            { 
                    nombre = value;
                OnPropertyChanged("Nombre_completo");//cual es la propiedad a llamar si hubo algún cambio
            }
        }

        public string Apellido
        {
            get => apellido;
            set 
            { 
                apellido = value;
                OnPropertyChanged("Nombre_completo");
            }
        }

        public string Nombre_completo
        {
            get => nombre_completo=Nombre+" "+Apellido;
            set {}
        }
    }
}
