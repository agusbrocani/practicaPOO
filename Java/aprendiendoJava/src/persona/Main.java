package persona;
import java.util.Arrays;
//Como quiero implementar el metodo sort, necesito hacer que la clase a ordenar implemente la interfaz

public class Main 
{
	public static void main(String[] args)
	{
		Director Agustin=new Director("Agustin Brocani",22222222,30,1,1998,50000,04,10,2022,"CEO",1000,1,20,10,2022);
		
		System.out.print("Descripcion:");
		System.out.println(Agustin.getDescripcion());

		//Alumno Indra=new Alumno("EL GALLETAS",26062011,01,01,2000,5,20,10,2022);
		//System.out.println(Indra.getDescripcion());
		
		Empleado[] misEmpleados= {
				new Empleado("Agustin2 Brocani",22222222,30,1,1998,1,04,10,2022,"CEO"),
				new Empleado("Juan Perez",1111111,1,1,2000,2,04,10,2022,"RRHH"),
				new Empleado("Maria Martinez",1111111,25,5,1978,3,4,5,2022,"Limpieza"),
				new Empleado("Cristina Rodriguez",1111111,6,8,2001,4,4,5,2022,"Ventas"),
 				new Empleado("Laura Diaz",1111111,1,1,2000,3001,20,1,2022,"Compras")
				};
		
		
		Empleado empleado1=new Empleado("Agustin Brocani",22222222,30,1,1998,50000,04,10,2022,"ASD");
		
		System.out.println(empleado1.getDescripcion());
		
		
		
//		Empleado[] misEmpleados=new Empleado[5];
//		
//				misEmpleados[0]=new Empleado("Agustin Brocani",22222222,30,1,1998,50000,04,10,2022,"CEO");
//				misEmpleados[1]=new Empleado("Juan Perez",1111111,1,1,2000,19422,04,10,2022,"RRHH");
//				misEmpleados[2]=new Empleado("Maria Martinez",1111111,25,5,1978,4000,4,5,2022,"Limpieza");
//				misEmpleados[3]=new Empleado("Cristina Rodriguez",1111111,6,8,2001,121235,4,5,2022,"Ventas");
//				misEmpleados[4]=new Empleado("Laura Diaz",1111111,1,1,2000,8785,20,1,2022,"Compras");
				
		
		//---------PRINCIPIO DE SUSTITUCION E INTERFAZ---------
		
		Empleado director_comercial=new Jefatura("Nicolas Brocani",12345678,30,1,1998,4500.5,29,10,2022,"DIRECTOR COMERCIAL",50);
		//POR EL PRINCIPIO DE SUSTITUCION: Un Jefe es un Director Comercial
		
		Comparable ejemplo=new Empleado("Nicolas Brocani",12345678,30,1,1998,4500.5,29,10,2022,"ALGO");
		
		//PROGRAMA COMPLEJO CON MUCHAS CLASES->uso instanceof y un if
		
		
		//SI DIRECTOR COMERCIAL ES UNA INSTANCIA DE LA CLASE EMPLEADO O PERTENECE A LA CLASE EMPLEADO
		if(director_comercial instanceof Empleado)
		{
			System.out.println("Es un tipo Jefatura");
		}
		//SI ejemplo IMPLEMENTA LA INTERFAZ COMPRABLE
		if(ejemplo instanceof Comparable)
		{
			System.out.println("Implementa la interfaz Comparable");
		}
		
		//8:04- Video 50 Jerarquia de Interfaces
		
		System.out.print("EJEMPLO: "+ejemplo+"\n");//Deberia hacer sobrecarga con @Override del metodo mostrar
		
		//-----------------------------------------------------
		
		//---------------------------INFERFAZ---------------------------
		
		System.out.println("ORIGINAL: ");
		
		for(Empleado e:misEmpleados)
		{
			
			System.out.println(e.getDescripcion());	
		}
		
		System.out.println("ORDENADO: ");
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e:misEmpleados)
		{
			
			System.out.println(e.getDescripcion());	
		}
		
		System.out.println("\n"+Agustin.tomarDecisiones("SUBIR SUELDOS"));
		
		System.out.println("ANTES DEL BONUS NAVIDEÑO: ");
		
		for(Empleado e:misEmpleados)
		{
			
			System.out.println("\nEmpleado: "+e.getName()+"\nSueldo:"+ e.getSueldo());	
		}
		
		for(Empleado e:misEmpleados)
		{
			System.out.println(e.bonusNavidadBase(5)+" ID: "+e.getId());
		}
		
		System.out.println("DESPUES DEL BONUS NAVIDEÑO: ");
		
		for(Empleado e:misEmpleados)
		{
			System.out.println("\nEmpleado: "+e.getName()+"\nSueldo:"+ e.getSueldo());
		}
		
		Jefatura nuevoJefe=new Jefatura("Cristiano Ronaldo",20412698,5,2,1985,50000,31,10,2022,"El BICHO",10);
	
		System.out.println("ANTES DEL BONUS NAVIDEÑO DEL JEFE: ");
		
		//Los JEFES cobran un BONO sobre el sueldo basico del 5%, COMO ES 50000, SE VUELVE 55000
		System.out.println("\nJefe: "+nuevoJefe.getName()+"\nSueldo:"+ nuevoJefe.getSueldo());
		
		System.out.println(nuevoJefe.bonusNavidadBase(5));
		
		System.out.println("DESPUES DEL BONUS NAVIDEÑO DEL JEFE: ");
		
		System.out.println("\nJefe: "+nuevoJefe.getName()+"\nSueldo:"+ nuevoJefe.getSueldo());
		
		System.out.println(nuevoJefe.tomarDecisiones("SALUDAR A TODOS"));
	
		//--------------------------------------------------------------
		//INTERFACES IV video 52
		
		
	}
	

}
