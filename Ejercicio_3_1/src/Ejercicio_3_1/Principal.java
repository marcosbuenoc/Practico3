package Ejercicio_3_1;

public class Principal {

	public static void main(String[] args) {

		
		
		Persona p1 = new Persona();
		
		
		Persona.ingresarDatos();
		Persona.mostrarDatos();
		Persona.sosMayor();
		
		System.out.println("Ingresar siguiente persona :");
		p1.ingresarDatos();
		p1.mostrarDatos();
		p1.sosMayor();
		

	}

}
