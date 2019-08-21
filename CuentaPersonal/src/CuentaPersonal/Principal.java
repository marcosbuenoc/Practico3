package CuentaPersonal;

///////////////////
//EJERCICIO 3.6////
//////////////////


import java.util.Scanner;

public class Principal {

	public static int buscarNumeroCuenta(int n, Cuenta listadoCuentas[]) {
		// Búsqueda secuencial
		int i = 0, indice = 0;
		boolean encontrado = false;

		while ((i < listadoCuentas.length) && (encontrado == false)) {
			if (listadoCuentas[i].getNumeroCuenta() == n) {
				encontrado = true;
				indice = i;
			}
			i++;
		}

		if (encontrado == false) {
			indice = -1;
		}
		return indice;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Variable Cliente
		String nombreCliente;
		double cantidad = 0;

		// Variable Cuenta
		int numeroCuenta = 0;
		double tipoInteres = 0;
		double saldo = 0;
		double ingreso;
		double reingreso;
		int cantidadCuentas;
		int tipoCuenta = 0;
		int transferir;
		boolean operacion = false;
		int saldoPositivo = 0;

		// Variables Menu
		int opcion = 0;
		// Variable indice donde se encuentra la cuenta en el arrays
		int indiceCuenta;
		// Arrelgo cuenta
		Cuenta listadoCuentas[];
		// Objeto Cliente
		Cuenta cliente;
		// Solicitamos los datos del Cliente y la cantidad de cuentas
		System.out.println(":::::INGRESE NOMBRE Y DATOS DE LA CUENTA:::::::::\n");
		System.out.println("Ingrese su nombre completo :");
		nombreCliente = sc.nextLine();

		System.out.println("Cuantas cuentas quiere registrar : ");
		cantidadCuentas = sc.nextInt();

		cliente = new Cuenta(nombreCliente);
		listadoCuentas = new Cuenta[cantidadCuentas];

		// Rellenamos el arreglo cantidad de cuentas
		for (int i = 0; i < listadoCuentas.length; i++) {
			sc.nextLine();
			System.out.println("Digite los datos de la cuenta " + (i + 1) + " : \n");

			System.out.println("Digite el tipo de cuenta : \nSeleccione una opcion \n");
			System.out.println("\t1.Caja ahorro\n\t2.Plazo fijo");
			opcion = sc.nextInt();
			switch (opcion) { // si el tipo de cuenta es 1 sera Caja de ahorro, si estipo 2 plazo fijo
			case 1:
				tipoCuenta = 1;
				System.out.println("Digite el numero de cuenta : ");
				numeroCuenta = sc.nextInt();
				break;
			case 2:
				tipoCuenta = 2;
				System.out.println("Digite el numero de cuenta : ");
				numeroCuenta = sc.nextInt();
				sc.nextLine();
				System.out.println(" Ingrese el interes :");
				tipoInteres = sc.nextDouble();
				break;

			}

			System.out.println("Digite el saldo inicial de la cuenta :");
			saldo = sc.nextDouble();
			
			while( saldo < 0) {
				System.out.println(" El saldo  inicial no puede ser menor que cero\nIngrese nuevamente...");
				saldo = sc.nextDouble();
				
			}

			listadoCuentas[i] = new Cuenta(numeroCuenta, saldo, tipoCuenta, tipoInteres);
			listadoCuentas[i].setSaldo(saldo);

		}

		do {
			System.out.println("\t.:MENU:.");
			System.out.print("Digite la opcion de menu: \n");

			System.out.println("1. Ingresar dinero en cuenta");
			System.out.println("2. Retirar dinero de la cuenta");
			System.out.println("3. Consultar dinero de la cuenta");
			System.out.println("4. Transferir dinero a otra cuenta");
			System.out.println("5. Salir\n");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.print("\nDigite el numero de cuenta: ");
				numeroCuenta = sc.nextInt();
				indiceCuenta = buscarNumeroCuenta(numeroCuenta, listadoCuentas);

				if (indiceCuenta == -1) {
					System.out.println("\nEl numero de cuenta no existe");
				} else {
					System.out.print("\nDigite la cantidad de dinero a ingresar: \n");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("Cantidad no puede ser menor que cero\nIngrese nuevamente :\n");
						cantidad = sc.nextDouble();
					}

					if (cantidad > 0) {
						listadoCuentas[indiceCuenta].setSaldo(listadoCuentas[indiceCuenta].getSaldo() + cantidad);
						System.out.println("\nDinero Ingresado correctamente...");

					} else {
						System.out.println("No se pudo ingresar dinero\n");
					}
					System.out.println("Saldo disponible: " + listadoCuentas[indiceCuenta].getSaldo() + "\n");
				}
				break;

			case 2:
				System.out.print("\nDigite el numero de cuenta: ");
				numeroCuenta = sc.nextInt();
				indiceCuenta = buscarNumeroCuenta(numeroCuenta, listadoCuentas);

				if (indiceCuenta == -1) {
					System.out.println("\nEl numero de cuenta no existe");
				} else {
					System.out.print("\nDigite la cantidad de dinero a retirar: \n");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("Cantidad no puede ser menor que cero\nIngrese nuevamente :\n");
						cantidad = sc.nextDouble();
					}

					if (listadoCuentas[indiceCuenta].getSaldo() < cantidad) {
						System.out.println("No tiene saldo suficiente");
						System.out.println("Puede retirar " + listadoCuentas[indiceCuenta].getSaldo() + "$");
					} else if (listadoCuentas[indiceCuenta].getSaldo() >= cantidad) {
						listadoCuentas[indiceCuenta].setSaldo(listadoCuentas[indiceCuenta].getSaldo() - cantidad);
						System.out.println("\nOperacion exitosa");
						System.out.println("Ustede retiro " + cantidad + "$ y tiene saldo disponible: "
								+ listadoCuentas[indiceCuenta].getSaldo() + "$\n");
					}

				}
				break;

			case 3:
				System.out.print("\nDigite el numero de cuenta: ");
				numeroCuenta = sc.nextInt();
				indiceCuenta = buscarNumeroCuenta(numeroCuenta, listadoCuentas);

				if (indiceCuenta == -1) {
					System.out.println("\nEl numero de cuenta no existe");
				} else {
					System.out.println("El saldo de su cuenta es :" + listadoCuentas[indiceCuenta].getSaldo() + "$\n");

				}

				break;

			case 4:
				System.out.print("\nDigite el numero de cuenta de origen : ");
				numeroCuenta = sc.nextInt();
				indiceCuenta = buscarNumeroCuenta(numeroCuenta, listadoCuentas);

				if (indiceCuenta == -1) {
					System.out.println("\nEl numero de cuenta no existe");
				} else {
					System.out.print("\nDigite la cantidad de dinero a transferir ! : \n");
					cantidad = sc.nextDouble();

					while (cantidad < 0) {
						System.out.println("Cantidad no puede ser menor que cero\nIngrese nuevamente :\n");
						cantidad = sc.nextDouble();
					}

					saldoPositivo = 0;

					while (listadoCuentas[indiceCuenta].getSaldo() < cantidad) {
						System.out.println("No tiene saldo suficiente");
						System.out.println("Puede retirar " + listadoCuentas[indiceCuenta].getSaldo() + "$");

						System.out.println("Ingrese nuevamente cantidad :");
						cantidad = sc.nextDouble();
					}

					System.out.println("Puede realizar la transferencia...");

					System.out.println("Desea realizar la tranferencia\n1. Si\n2.No");
					transferir = sc.nextInt();

					while (transferir < 1 && transferir > 2) {
						System.out.println("Ingrese nuevamente la opcion \n1. Si\n2.No");
						transferir = sc.nextInt();
					}
					if (transferir == 1) {
						listadoCuentas[indiceCuenta].setSaldo(listadoCuentas[indiceCuenta].getSaldo() - cantidad);

						System.out.print("\nDigite el numero de cuenta  destino : ");
						numeroCuenta = sc.nextInt();
						indiceCuenta = buscarNumeroCuenta(numeroCuenta, listadoCuentas);

						if (indiceCuenta == -1) {
							System.out.println("\nEl numero de cuenta no existe");
						} else {

							System.out.println("\nIniciando...");

							listadoCuentas[indiceCuenta].setSaldo(listadoCuentas[indiceCuenta].getSaldo() + cantidad);
							System.out.println("\nOperacion exitosa");

						}
						System.out.println("Transferencia de " + cantidad + "$ a la cuenta ("
								+ listadoCuentas[indiceCuenta].getNumeroCuenta() + ") saldo disponible en esta cuenta: "
								+ listadoCuentas[indiceCuenta].getSaldo() + "$\n");
					}
					break;
				}
			case 5:
				break;
			default:
				System.out.println("Se equivoco de opcion de menu");
			}

		} while (opcion != 5);
		System.out.println("::::::GRACIAS POR SU PREFRENCIA::::::");
	}
}
