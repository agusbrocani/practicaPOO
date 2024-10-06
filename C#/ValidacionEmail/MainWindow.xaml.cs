using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
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

namespace ValidacionEmail
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        public static bool ValidaEmail(string email)
        {
            string emailFormato;

            emailFormato = "\\w([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

            if (Regex.IsMatch(email, emailFormato))
            {
                if (Regex.Replace(email, emailFormato, String.Empty).Length == 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (ValidaEmail(txt.Correo.Text) == false)
            {
                lblValido.Text = "DIRECCIÓN INVALIDA";
                lblValido.ForeColor = Color.Red;
            }
            else
            {
                lblValido.Text = "DIRECCIÓN VALIDA";
                lblValido.ForeColor = Color.Green;
            }
        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }
    }
}
