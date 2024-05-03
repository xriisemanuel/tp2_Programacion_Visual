package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.model.Producto.Category;
import ar.edu.unju.fi.ejercicio01.model.Producto.MadeIn;
import ar.edu.unju.fi.ejercicio05.model.Product;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<>();
		loadProducts(products);

		int option = 0;

		do {
			menu();
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					availableProducts(products);
					break;
				case 2:
					System.out.println(noAvailableProducts(products));
					;
					break;
				case 3:
					// products.removeAll(products);
					// products.addAll(increasePrices(products));
					products = new ArrayList<>(increasePrices(products));
					products.forEach(p -> System.out.println(p));
					break;
				case 4:
					System.out.println(electrohogar(products));
					;
					break;
				case 5:
					System.out.println(reverseOrder(products));
					break;
				case 6:
					System.out.println(capitalNames(products));
					break;
				case 7:
					System.out.println("Store Closed");
					break;
				default:
					System.out.println("La opcion ingresada NO EXISTE");
				}
			} catch (Exception x) {
				System.err.println("Ingrese solo un numero por favor");
			}
		} while (option != 7);
		sc.close();
	}

	private static List<Product> capitalNames(ArrayList<Product> products) {
		Function<Product, Product> newName = p -> {
			p.setDesc(p.getDesc().toLowerCase()); // in my case, I changed to Lower case 'cause the Description values
													// of my products are in Upper Case
			return p;
		};

		return products.stream().map(newName).collect(Collectors.toList());
	}

	private static List<Product> reverseOrder(ArrayList<Product> products) {
		Comparator<Product> c = Comparator.comparing(Product::getPrice).reversed();
		products.sort(c);
		return products;
	}

	private static List<Product> electrohogar(ArrayList<Product> products) {
		Predicate<Product> condicion = p -> p.isStatus() && p.getCat().equals(Category.ELECTROHOGAR);
		return products.stream().filter(condicion).collect(Collectors.toList());
	}

	private static List<Product> increasePrices(ArrayList<Product> products) {
		Function<Product, Product> newPrice = p -> {
			p.setPrice(p.getPrice() * 1.20f);
			return p;
		};

		return products.stream().map(newPrice).collect(Collectors.toList());
	}

	private static List<Product> noAvailableProducts(ArrayList<Product> products) {
		Predicate<Product> condicion = p -> !p.isStatus();
		return products.stream().filter(condicion).collect(Collectors.toList());
	}

	private static void availableProducts(ArrayList<Product> products) {
		Consumer<Product> newList = p -> {
			if (p.isStatus())
				System.out.println(p);
		};
		products.forEach(newList);
	}

	private static void loadProducts(ArrayList<Product> products) {
		Product p1 = new Product("AAA", "Iphone", 1500, MadeIn.BRASIL, Category.TELEFONIA, true);
		Product p2 = new Product("BBB", "Lenovo", 5999, MadeIn.CHINA, Category.INFORMATICA, false);
		Product p3 = new Product("CCC", "Tv70", 3600, MadeIn.ARGENTINA, Category.ELECTROHOGAR, true);
		Product p4 = new Product("DDD", "Picadora", 333, MadeIn.URUGUAY, Category.HERRAMIENTAS, false);
		Product p5 = new Product("EEE", "Samsung", 1400, MadeIn.CHINA, Category.TELEFONIA, true);
		Product p6 = new Product("FFF", "Sony", 2000, MadeIn.BRASIL, Category.TELEFONIA, true);
		Product p7 = new Product("GGG", "Hp", 799, MadeIn.CHINA, Category.INFORMATICA, false);
		Product p8 = new Product("HHH", "Lg", 3500, MadeIn.ARGENTINA, Category.ELECTROHOGAR, true);
		Product p9 = new Product("III", "Philiphs", 120, MadeIn.URUGUAY, Category.ELECTROHOGAR, false);
		Product p10 = new Product("JJJ", "Lumia", 899, MadeIn.BRASIL, Category.TELEFONIA, true);
		Product p11 = new Product("KKK", "Microsoft", 2500, MadeIn.CHINA, Category.INFORMATICA, true);
		Product p12 = new Product("LLL", "Amoladora", 1888, MadeIn.ARGENTINA, Category.HERRAMIENTAS, true);
		Product p13 = new Product("MMM", "KitDestornillador", 999, MadeIn.URUGUAY, Category.HERRAMIENTAS, true);
		Product p14 = new Product("NNN", "KitDental", 120, MadeIn.BRASIL, Category.HERRAMIENTAS, false);
		Product p15 = new Product("OOO", "SmartTransparente", 8000, MadeIn.CHINA, Category.INFORMATICA, false);
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

	private static void menu() {
		System.out.println(" -> Menu de Opciones <- ");
		System.out.println("1 - Mostrar productos disponibles");
		System.out.println("2 - Mostrar productos no disponibles");
		System.out.println("3 - Incrementar el 20% a todos los productos");
		System.out.println("4 - Mostrar los productos disponibles en Electrohogar");
		System.out.println("5 - Ordenar los productos por precio de forma descendente");
		System.out.println("6 - Mostrar los productos con los nombres en mayusculas");
		System.out.println("7 - Cerrar el programa");
		System.out.println("Ingrese una opcion: ");
	}
}
