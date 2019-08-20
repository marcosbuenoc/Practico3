package Ejercicio_3_1;

import java.util.Scanner;

public class Persona {
	static Scanner sc = new Scanner(System.in);
	static String nombre;
	static String apellido;
	static String celular;
	static int edad;
	
	
	public Persona() {
		
		
		
	}

	
	public static void ingresarDatos() {
		
		System.out.println("Ingrese nombre :");
		nombre = sc.nextLine();
		System.out.println("Ingrese apellido :");
		apellido = sc.nextLine();
		System.out.println("Ingrese numero celular :");
		celular = sc.nextLine();
		System.out.println("Ingrese su edad :");
		edad = sc.nextInt();
		sc.nextLine();
	}
	
	public static void sosMayor() {
		if ( edad >= 18) {
			System.out.println("Sos mayor de edad");
			
		}else {
			System.out.println("Sos menor de edad");
		}
	}
	
	public static void mostrarDatos() {
		
		
		System.out.println( "Nombre :" + nombre + "\nApellido : "+ apellido +"\nCelular : "+celular+"\nEdad: "+edad+"\n");
	}
	
}
