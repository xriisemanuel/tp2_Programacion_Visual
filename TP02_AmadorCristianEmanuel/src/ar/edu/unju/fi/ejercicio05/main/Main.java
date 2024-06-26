package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto.Category;
import ar.edu.unju.fi.ejercicio01.model.Producto.MadeIn;
import ar.edu.unju.fi.ejercicio05.interfaces.IPago;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Product;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int option = 0;
		ArrayList<Product> products = new ArrayList<>();
		ArrayList<Product> shoppingCart = new ArrayList<>();
		loadProducts(products);

		do {
			menu();
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					showProducts(products);
					break;
				case 2:
					shopping(products, shoppingCart);
					break;
				case 3:
					System.out.println("Programa finalizado");
					break;
				default:
					System.out.println("No existe la opcion ingresada");
				}
			} catch (Exception x) {
				System.err.println("Solo se permiten valores numericos");
				sc.nextLine();
			}
		} while (option != 3);
	}

	private static void checkCode(String code, ArrayList<Product> products, ArrayList<Product> shoppingCar) {
		boolean exist = false, available = false;
		Product aux = new Product();
		for (Product p : products) {
			if (p.getCode().equals(code)) {
				if (p.isStatus()) {
					shoppingCar.add(p);
					aux = p;
					available = true;
				}
				exist = true;
				break;
			}
		}

		if (exist) {
			if (available) {
				System.err.println("\nElegiste comprar: " + aux.getDesc());
				System.out.println(aux.toString());
				System.out.println("El Producto fue agregado al carrito de compras");
			} else {
				System.out.println("Lamentamos informar que el producto se quedo sin Stock");
			}
		} else {
			System.out.println("No existe el codigo de producto ingresado");
		}
	}

	private static void textCode(ArrayList<Product> products, ArrayList<Product> shoppingCar) {
		boolean loop = false;
		do {
			System.out.println("Ingrese el \"CODIGO\" del producto que desea comprar: ");
			try {
				String code = sc.next();
				if (code.length() == 3) {
					if (code.matches("[A-Z]+")) {
						checkCode(code, products, shoppingCar);
						loop = false;
					} else {
						System.out.println("Hubo un error, Solo 3 letras MAYUSCULAS debe ingresar");
					}
				} else {
					System.out.println("Hubo un error, Solo 3 letras se debe ingresar");
				}
			} catch (Exception x) {
				System.err.println("SOLO SE PERMITEN CODIGOS CON 3 LETRAS");
				sc.nextLine();
			}
		} while (loop);
	}

	private static void submenu() {
		System.out.println("1 - Pagar con efectivo");
		System.out.println("2 - Pagar con tarjeta");
		System.out.println("Seleccione una opcion: ");
	}

	private static void checkCard(PagoTarjeta pay) {
		boolean loop = true;
		do {
			System.out.println("Ingresa el numero de tu tarjeta para continuar");
			try {
				String cardnumber = sc.next();
				if (cardnumber.matches("[0-9]+")) {
					pay.setCardNumber(cardnumber);
					loop = false;
				} else {
					System.out.println("Incorrecto, solo se debe ingresar numeros");
				}
			} catch (Exception z) {
				System.err.println("Incorrecto, solo se debe ingresar numeros");
				sc.nextLine();
			}
		} while (loop);
	}

	private static float totalDue(ArrayList<Product> shoppingCar) {
		float total = 0;

		for (Product p : shoppingCar) {
			total += p.getPrice();
		}
		return total;
	}

	private static void cashPayment(ArrayList<Product> shoppingCar) {
		PagoEfectivo pay = new PagoEfectivo(LocalDate.now()); // create only objects from Class pinned in class
		pay.realizarPago(totalDue(shoppingCar));
		pay.imprimirRecibo();
	}

	private static void cardPayment(ArrayList<Product> shoppingCar) {
		PagoTarjeta pay = new PagoTarjeta(LocalDate.now());
		checkCard(pay);
		pay.realizarPago(totalDue(shoppingCar));
		pay.imprimirRecibo();
	}

	private static void checkPaymentMethod(ArrayList<Product> shoppingCar) {
		boolean loop = true;
		System.out.println("¡Excelente!, ahora eliga un metodo de pago");
		do {
			submenu();
			try {
				int op = sc.nextInt();

				switch (op) {
				case 1:
					cashPayment(shoppingCar);
					loop = false;
					break;
				case 2:
					cardPayment(shoppingCar);
					loop = false;
					break;
				default:
					System.out.println("Opcion ingresada, no existe, reintente");
				}
			} catch (Exception x) {
				System.out.println("Debe ingresar unicamente un numero");
				sc.nextLine();
			}
		} while (loop);
	}

	private static void shopping(ArrayList<Product> products, ArrayList<Product> shoppingCar) {
		char answer = 'n';
		do {
			textCode(products, shoppingCar);
			System.out.println("¿Desea continuar comprando? s/n");
			try {
				answer = sc.next().charAt(0);
				if (answer == 's' || answer == 'S') {
					showProducts(products);
				}
			} catch (Exception x) {
				System.err.println("Solo debe ingresar 's' o 'n'");
				sc.nextLine();
			}
		} while (answer == 's' || answer == 'S');

		if (shoppingCar.size() > 0) {
			System.out.println("Total Productos en el carrito de compras: " + shoppingCar.size());
			checkPaymentMethod(shoppingCar);
			System.out.println("¡Muchas Gracias por su compra!");
			shoppingCar.removeAll(shoppingCar);
		}
	}

	private static void showProducts(ArrayList<Product> products) {
		System.err.println("\nMostrando Unicamente Productos con Stock Disponibles");
		for (Product p : products) {
			if (p.isStatus()) {
				System.out.println(p.toString());
			}
		}
	}

	private static void menu() {
		System.out.println("\n*** MENU DE OPCIONES ***");
		System.out.println("1 - Mostrar Productos");
		System.out.println("2 - Realizar Compras");
		System.out.println("3 - Salir");
		System.out.println("Ingresa una opcion: ");
	}

	private static void loadProducts(ArrayList<Product> products) {
		Product p1 = new Product("AAA", "IPHONE", 1500, MadeIn.BRASIL, Category.TELEFONIA, true);
		Product p2 = new Product("BBB", "LENOVO", 5999, MadeIn.CHINA, Category.INFORMATICA, false);
		Product p3 = new Product("CCC", "TV70", 3600, MadeIn.ARGENTINA, Category.ELECTROHOGAR, true);
		Product p4 = new Product("DDD", "PICADORA", 333, MadeIn.URUGUAY, Category.HERRAMIENTAS, false);
		Product p5 = new Product("EEE", "SAMSUNG", 1400, MadeIn.CHINA, Category.TELEFONIA, true);
		Product p6 = new Product("FFF", "SONY", 2000, MadeIn.BRASIL, Category.TELEFONIA, true);
		Product p7 = new Product("GGG", "HP", 799, MadeIn.CHINA, Category.INFORMATICA, false);
		Product p8 = new Product("HHH", "LG", 3500, MadeIn.ARGENTINA, Category.ELECTROHOGAR, true);
		Product p9 = new Product("III", "PHILIPS", 120, MadeIn.URUGUAY, Category.ELECTROHOGAR, false);
		Product p10 = new Product("JJJ", "MOTOROLA", 899, MadeIn.BRASIL, Category.TELEFONIA, true);
		Product p11 = new Product("KKK", "DELL", 2500, MadeIn.CHINA, Category.INFORMATICA, true);
		Product p12 = new Product("LLL", "TOYOTA", 30000, MadeIn.ARGENTINA, Category.HERRAMIENTAS, true);
		Product p13 = new Product("MMM", "FIAT", 15000, MadeIn.URUGUAY, Category.HERRAMIENTAS, true);
		Product p14 = new Product("NNN", "NIKE", 120, MadeIn.BRASIL, Category.HERRAMIENTAS, false);
		Product p15 = new Product("OOO", "ADIDAS", 80, MadeIn.CHINA, Category.INFORMATICA, false);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		products.add(p6);
		products.add(p7);
		products.add(p8);
		products.add(p9);
		products.add(p10);
		products.add(p11);
		products.add(p12);
		products.add(p13);
		products.add(p14);
		products.add(p15);
	}
}
//IPago pay = new PagoEfectivo(LocalDate.now()); - No recommended to do
/*
 * p = new PagoTarjeta(aux.getCardNumber(), LocalDate.now());
 * p.realizarPago(totalDue(shoppingCar)); p.imprimirRecibo();
 */