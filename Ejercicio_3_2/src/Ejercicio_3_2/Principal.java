package Ejercicio_3_2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int cont;
		
		Contador contador = new Contador();
		
		System.out.println(":::::::INICIANDO CONTADOR +- 1::::::::");
		
		System.out.println("Ingrese un numero entero :");
		cont = sc.nextInt();
		
		
		
		contador.setCont(cont);
		
		
		System.out.println("El numero ingresado es :"+contador.getCont());
		contador.incrementar();
		System.out.println("El contador incremento (1) :"+contador.getCont());
		
		contador.decrementar();
		contador.decrementar();
		
		System.out.println("El contador decremento (1) :"+contador.getCont() );
		
		
	}

}
