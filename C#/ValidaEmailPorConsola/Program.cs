using System;
using System.Globalization;
using System.Text.RegularExpressions;

namespace ValidaEmailPorConsola
{
    class Program
    {
        static void Main(string[] args)
        {
            string? email;

            do
            {
                Console.Write("Ingrese email: ");
                email = Console.ReadLine();
                Console.WriteLine();

                if (!String.IsNullOrEmpty(email))
                {
                    if(IsValidEmail(email))
                    {
                        Console.WriteLine("La dirección de email es válida.");
                    }
                    else
                    {
                        Console.WriteLine("La dirección de email es inválida.");
                    }
                }

            } while (String.IsNullOrEmpty(email));
            
        }

        public static bool IsValidEmail(string email)
        {
            if (string.IsNullOrWhiteSpace(email))   //No haria falta
                return false;

            try
            {
                // Normalize the domain
                email = Regex.Replace(email, @"(@)(.+)$", DomainMapper,
                                      RegexOptions.None, TimeSpan.FromMilliseconds(200));

                // Examines the domain part of the email and normalizes it.
                string DomainMapper(Match match)
                {
                    // Use IdnMapping class to convert Unicode domain names.
                    var idn = new IdnMapping();

                    // Pull out and process domain name (throws ArgumentException on invalid)
                    string domainName = idn.GetAscii(match.Groups[2].Value);

                    return match.Groups[1].Value + domainName;
                }
            }
            catch (RegexMatchTimeoutException e)
            {
                return false;
            }
            catch (ArgumentException e)
            {
                return false;
            }

            try
            {
                return Regex.IsMatch(email,
                    @"^[^@\s]+@[^@\s]+\.[^@\s]+$",
                    RegexOptions.IgnoreCase, TimeSpan.FromMilliseconds(250));
            }
            catch (RegexMatchTimeoutException)
            {
                return false;
            }
        }
        //gmail entre minimo:6 y maximo:30 caracteres aparte del dominio.
        //HOTMAIL Y OUTLOOK: email debe comenzar con una letra,minimo:1 maximo: 64 caracteres aparte del dominio.// se permiten -- y __ seguidos, se permite letra.letra // se permiten numeros y letras
    }
}