using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ListBoxPractica
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            List <Poblaciones> listaPob = new List <Poblaciones>();
            
            listaPob.Add(new Poblaciones() { Poblacion1 = "Madrid", Poblacion2 = "Barcelona", Temperatura1 = 15, Temperatura2 = 17} );
            listaPob.Add(new Poblaciones() { Poblacion1 = "Valencia", Poblacion2 = "Alicante", Temperatura1 = 19, Temperatura2 = 20 });
            listaPob.Add(new Poblaciones() { Poblacion1 = "Málaga", Poblacion2 = "Bilbao", Temperatura1 = 20, Temperatura2 = 7});
            listaPob.Add(new Poblaciones() { Poblacion1 = "Sevilla", Poblacion2 = "Coruña", Temperatura1 = 22, Temperatura2 = 8 });
            //Lo que hay dentro del listbox es lo que acabo de meter a esta lista
            //Meté listaPob en el ListBox(en listaPoblaciones, nombre que use en el codigo XAML)
            listaPoblaciones.ItemsSource = listaPob;

            //Console.WriteLine(listaPob[0].DiferenciaTemp);

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                    //Ventana emergente que muestre la info del item seleccionado
                    MessageBox.Show((listaPoblaciones.SelectedItem as Poblaciones).Poblacion1+" "+
                    (listaPoblaciones.SelectedItem as Poblaciones).Temperatura1 + " ºC " +
                    (listaPoblaciones.SelectedItem as Poblaciones).Poblacion2 + " " +
                    (listaPoblaciones.SelectedItem as Poblaciones).Temperatura2 + " ºC " );
            }catch(NullReferenceException ex)
            {
                MessageBox.Show("Seleccione una item de la lista y vuelva a presionar el Botón","ERROR"); 
                Console.WriteLine(ex.Message);
            }
        }
    }

    public class Poblaciones
    {
        public string Poblacion1 { get; set; }
        public int Temperatura1 { get; set; }

        public string Poblacion2 { get; set; }
        public int Temperatura2 { get; set; }

        //Para los gráficos, creo una propiedad más que maneja las diferencias de temperatura

        public int DiferenciaTemp
        {
            get => Math.Abs(Temperatura1 - Temperatura2);
            set{}
        }

    }

}
