package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;

import ar.edu.unju.fi.ejercicio01.model.Producto.Category;
import ar.edu.unju.fi.ejercicio01.model.Producto.MadeIn;
import ar.edu.unju.fi.ejercicio05.interfaces.IPago;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.Product;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<>();
		Product p = new Product("abc", "Desc", 1234f, MadeIn.ARGENTINA, Category.INFORMATICA, true);
		IPago pago = new PagoEfectivo(); 
		pago.imprimirRecibo();
	}

}
