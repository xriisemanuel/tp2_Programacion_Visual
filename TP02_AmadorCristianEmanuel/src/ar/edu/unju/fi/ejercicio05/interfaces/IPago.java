package ar.edu.unju.fi.ejercicio05.interfaces;

public interface IPago {
	//Attributes only can be final and constant
	//we can create only abstract methods 
	public void realizarPago(double monto);
	public void imprimirRecibo();
}
