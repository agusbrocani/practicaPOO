using System;

namespace ValidaEMails
{
    class Program
    {
        static void Main(string[] args)
        {
            Menu();
            Console.WriteLine("El programa se ejecutó correctamente.");
        }

        delegate bool ValidacionComun1(string email);//Nombre de la "Clase" que va a recibir la referencia(Pongo tipo de parametro que recibe el método al cual voy a referir)
        delegate bool ValidacionComun2(string email);
        delegate void MensajeEstado(bool esValido);//true= mensaje es valido, false= mensaje es invalido
        
        //Ya está validado que TODOS los mails empiezan y terminan con caracteres válidos
        static void validaGoogle(string email)
        {
            ValidacionComun1 valida1 = new ValidacionComun1(Validaciones.ValidaArrobaIFCorrecto);     //Valida que haya 1 solo arroba
            MensajeEstado emailCorrecto = new MensajeEstado(Validaciones.emailCorrecto);            //Me da el mensaje si es correcto o no
            ValidacionComun2 valida2 = new ValidacionComun2(Validaciones.ValidaPuntoCorrecto);      //Me dice si hay caracteresValidos y luego 1 solo punto

            char[] chars = email.ToCharArray();
            int lenght = chars.Length;

            if (!valida1(email) || !valida2(email))
            { 
                emailCorrecto(false);
                return;
            }

            for (int i=1 ; i< lenght-1; i++ )
            {
                if (    Validaciones.esPunto(chars[i]) && !Validaciones.caracteresValidosComunes(chars[i+1]) ||
                        !Validaciones.esPunto(chars[i]) && !Validaciones.caracteresValidosComunes(chars[i]) && !Validaciones.esArroba((chars[i]))
                   )
                {
                    emailCorrecto(false);
                    return;
                }
            }

            int posicionArroba = 0;
            while (chars[posicionArroba] != '@')
            {
                posicionArroba++;
            }

            string terminacion = "";

            for (int i = posicionArroba + 1; i < (email.Length); i++)
            {
                terminacion += $"{chars[i]}";
            }

            string[] terminaciones = { "gmail.com" };

            int j = 0;
            while (j < terminaciones.Length && !terminacion.Equals(terminaciones[j]))
            {
                j++;
            }

            if (j == terminaciones.Length)
            {
                emailCorrecto(false);
                return;
            }

            emailCorrecto(true);
        }

        static void validaMicrosoft(string email)
        {
            ValidacionComun1 valida1 = new ValidacionComun1(Validaciones.ValidaArrobaIFCorrecto);   
            MensajeEstado emailCorrecto = new MensajeEstado(Validaciones.emailCorrecto);
            ValidacionComun2 valida2 = new ValidacionComun2(Validaciones.ValidaPuntoCorrecto);

            char[] chars = email.ToCharArray();
            int lenght = chars.Length;

            if (!valida1(email) || !valida2(email))
            {
                emailCorrecto(false);
                return;
            }

            for (int i = 1; i < lenght - 1; i++)
            {
                if (!Validaciones.esPunto(chars[i]) && !Validaciones.caracteresValidosComunes(chars[i]) && !Validaciones.esArroba((chars[i])) && !(chars[i]=='_') && !(chars[i] == '-')    )
                {
                    emailCorrecto(false);
                    return;
                }
            }

            int posicionArroba = 0;
            while (chars[posicionArroba] !='@')
            {
                posicionArroba++;
            }

            string terminacion="";

            for(int i=posicionArroba+1; i<(email.Length);i++)
            {
                terminacion+=$"{chars[i]}";
            }

            string[] terminaciones = { "outlook.com", "outlook.es", "hotmail.com" };

            int j = 0;
            while(j<terminaciones.Length && !terminacion.Equals(terminaciones[j]))
            {
                j++;
            }

            if(j==terminaciones.Length)
            {
                emailCorrecto(false);
                return;
            }

            emailCorrecto(true);    

        }

        static void validaPersonalizado(string email)
        {
            ValidacionComun1 valida1 = new ValidacionComun1(Validaciones.ValidaArrobaIFCorrecto);
            MensajeEstado emailCorrecto = new MensajeEstado(Validaciones.emailCorrecto);
            ValidacionComun2 valida2 = new ValidacionComun2(Validaciones.ValidaPuntoCorrecto);//NECESITO HACER MODIFICACION CON ALGUN y

            char[] chars = email.ToCharArray();
            int lenght = chars.Length;

            if (!valida1(email) || !valida2(email))
            {
                emailCorrecto(false);
                return;
            }

            for (int i = 1; i < lenght - 1; i++)
            {
                if (!Validaciones.esPunto(chars[i]) && !Validaciones.caracteresValidosComunes(chars[i]) && !Validaciones.esArroba((chars[i])) && !(chars[i] == '_') && !(chars[i] == '-'))
                {
                    emailCorrecto(false);
                    return;
                }
            }

            emailCorrecto(true);

        }

        //Ingresa y valida opción del menú y si el email ingresado es valido o no según la opción elegida -> Si se ingresa un enter sin escribir mail se da como invalido.
        //Mi menú trabaja bajo la lógica: "Si cumplo todas las condiciones dejo de repetir, sino cumplo alguna, repito". 
        //Uso return en vez de break para notener que utilizar repetir=false, directamente fuerzo a salir del método.
        static void Menu()
        {
            string? cadenaOpcion;
            int opcion;
            string? email;

            do
            {
                Console.WriteLine("Seleccione que tipo de e-mail quiere ingresar:");
                Console.WriteLine("\nOPCION 1: Gmail.\nOPCION 2: Outlook/Hotmail\nOPCION 3: Email personalizado con formato. ej: texto.de-_prueba_-generico@ejemplo.com.ar\nOPCION 0: SALIR.");
                cadenaOpcion = Console.ReadLine();

                if (!String.IsNullOrEmpty(cadenaOpcion) && (cadenaOpcion.Equals("0") || cadenaOpcion.Equals("1") || cadenaOpcion.Equals("2") || cadenaOpcion.Equals("3")))
                {
                    opcion = Int32.Parse(cadenaOpcion);

                    if (0 == opcion)
                    {
                        Console.WriteLine("Terminando la ejecución del Menú");
                        return;
                    }

                    do
                    {
                        Console.Write("Ingrese el email: ");
                        email = Console.ReadLine();
                    } while (String.IsNullOrEmpty(email));

                    Console.WriteLine();
                    switch (opcion)
                    {
                        case 1:
                            validaGoogle(email.ToLower());
                            return;
                        case 2:
                            validaMicrosoft(email.ToLower());
                            return;
                        case 3:
                            validaPersonalizado(email.ToLower());
                            return;
                    }
                }
                Console.WriteLine("\nOPCION INVALIDA, INTENTE NUEVAMENTE.\n");
            } while (true);
        }

        sealed class Validaciones
        {
            public static bool ValidaArrobaIFCorrecto(string email)//Valida que haya 1 solo arroba y que inicie y finalice el mail con caracteres validos
            {
                char[] chars = email.ToCharArray();
                int lenght = chars.Length;

                //El primer caracter no es un numero o una letra
                if (!caracteresValidosComunes(chars[0]))
                {
                    return false;
                }

                //El ultimo caracter no es un numero o una letra
                if (!caracteresValidosComunes(chars[lenght-1]))
                {
                    return false;
                }
                
                int hayArroba=0;

                for (int i = 1; i< (lenght - 1);i++)    //[HICE LENGHT-1  e i= 1 para que sea más eficiente, ya que NUNCA puede haberun @ en la primer posicion ni en la ultima]
                {
                        if (chars[i] == '@')
                        {
                            hayArroba++;
                        }
                }
                
                return 1==hayArroba;    //Si hay 1 solo, hay arroba, sino, NO
            }

            public static bool ValidaPuntoCorrecto(string email)//Comun a todos, no puede haber 2 puntos juntos
            {
                char[] chars = email.ToCharArray();
                int lenght = chars.Length;

                for (int i = 1 ; i< (lenght-1); i++)
                {
                    if (esPunto(chars[i])&& !caracteresValidosComunes(chars[i+1]))//Nunca me voy a ir de mambo porque paro 1 antes
                    {
                        return false;
                    }
                }

                return true;
            }

            //No hago _  y - porque en hotmail y outlook puedo concatenar muchos
            public static bool caracteresValidosComunes(char caracter) => caracter >= 'a' && caracter <= 'z' || caracter >= '0' && caracter <= '9';
            public static bool esArroba(char caracter) => caracter == '@';
            public static bool esPunto(char caracter) => caracter == '.';
            public static void emailCorrecto(bool esValido)
            {
                if (!esValido)
                {
                    Console.WriteLine("El email ingresado es INVÁLIDO.");
                    return;
                }

                Console.WriteLine("El email ingresado es VÁLIDO.");
            }
        }


    }

}

