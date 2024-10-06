package persona;


//La interfaz Jefes hereda la interfaz Trabajadores->Estan implementando 2 metodos 
public interface Jefes extends Trabajadores
{
	//METODO TOMAR DECISIONES->TODOS LOS QUE IMPLEMENTAN ESTA INTERFAZ TIENEN QUE IMPLEMENTAR ESTE METODO EN LA CLASE
	
	//SI NO LOS ESCRIBO A LOS MODIFICADORES DE ACCESO, NO LOS ESCRIBO Y LOS TOMA POR DEFECTO
	//Los METODOS se definen pero NO se DESARROLLAN
	public abstract String tomarDecisiones(String decision);
	
}

//Jerarquia de Interfaces

//Trabajadores->Jefes
//Ejemplo: si Jefatura implementa Jefes pero esta a su vez hereda Trabajadores, TENGO que implementar los METODOS de trabajadores en Jefatura
