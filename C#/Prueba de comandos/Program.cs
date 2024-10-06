try
{
    Func<int, int> factorial = (n) =>
    {
        int fact = 1;
        int i;

        for (i = 0; i < n; i++)
        {
            fact *= n - i;
        }
        Console.WriteLine(fact);
        return fact;

    };

    Func<int, Boolean> valida = (x) => x >= 0;

    int n;

    Console.WriteLine("INGRESE UN VALOR A CALCULAR EL FACTORIAL:");

    //uint es unsigned

    bool res = int.TryParse(Console.ReadLine(),out n);


    if(!res)
    {
        throw new Exception("NO SE PUDO CONVERTIR A ENTERO LO CAPTADO POR TECLADO");
    }

    if(!valida(n))
    {
        throw new Exception("NO EXISTE EL FACTORIAL DE LOS NUMEROS NEGATIVOS");
    }

    Console.WriteLine($"EL FACTORIAL DE {n} ES {factorial((int)n)}");

}
catch (Exception ex)//LAS EXCEPTIONS SON UN OBJETO, POR ESO, LAS CAPTO COMO TAL Y DEPENDIENDO CUAL SEA, LO MUESTRO AL MENSAJE POR PANTALLA
{
    Console.WriteLine(ex.Message);
}
