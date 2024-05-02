package ar.edu.unju.fi.ejercicio05.model;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Product extends Producto {
	private boolean status;

	public Product() {
	}

	public Product(boolean status) {
		super();
		this.status = status;
	}

	public Product(String code, String desc, float price, MadeIn madeIn, Category cat, boolean status) {
		super(code, desc, price, madeIn, cat);
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return Product.super.toString(); //check it
	}

}
