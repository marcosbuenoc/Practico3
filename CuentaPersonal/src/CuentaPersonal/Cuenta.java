package CuentaPersonal;

public class Cuenta {
	private String nombreCliente;
	private int numeroCuenta;
	private double tipoInteres;
	private double saldo;
	private int tipoCuenta;
	Cuenta listadoCuentas[];

	public Cuenta() {

	}

	// Metodo constructor cliente
	public Cuenta(String nombreCliente) {
		this.nombreCliente = nombreCliente;

	}

	public Cuenta(String nombreCliente, int numeroCuenta, double tipoInteres, double saldo, Cuenta[] listadoCuentas) {

		this.nombreCliente = nombreCliente;
		this.numeroCuenta = numeroCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
		this.listadoCuentas = listadoCuentas;
	}

	// Metodo Constructor de la cuenta
	public Cuenta(int numeroCuenta, double saldo, int tipoCuenta, double tipoInteres) {

		this.numeroCuenta = numeroCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
		this.setTipoCuenta(tipoCuenta);

	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
		
	}


	public int getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	public void transferencia(int n, double cantidad) {
		
		
	}
	
}
