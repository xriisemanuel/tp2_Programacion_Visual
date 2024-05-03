package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.IConverter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {

		createDomesticPet();
		System.out.println();
		createWildPet();

	}

	public static void createDomesticPet() {
		// Pet: Garfield
		FelinoDomestico garfield = new FelinoDomestico("Garfield", (byte) 45, 12f);
		// FelinoDomestico garfield = null; //objeto sin datos para testear

		// definicion de la expresion lambda que define el convertidor de
		// FelinoDomestico a FelinoDalvaje

		IConverter<FelinoDomestico, FelinoSalvaje> converter = x -> {
			if (IConverter.isNotNull(x)) {
				return new FelinoSalvaje(x.getName(), x.getAge(), x.getWeight());
			} else {
				return null;
			}
		};

		// conversion process
		FelinoSalvaje felino1 = converter.convert(garfield);

		// only show details when object is not null
		if (felino1 == null) {
			System.err.println("No existe el objeto");
		} else {
			converter.mostrarObjeto(felino1);
		}
	}

	private static void createWildPet() {
		// Pet: Tanner
		// FelinoSalvaje tanner = new FelinoSalvaje("Tanner", (byte)20, 186f);
		FelinoSalvaje tanner = null;

		IConverter<FelinoSalvaje, FelinoDomestico> converter1 = x -> {
			if (IConverter.isNotNull(x)) {
				return new FelinoDomestico(x.getName(), x.getAge(), x.getWeight());
			} else {
				return null;
			}
		};

		FelinoDomestico felino2 = converter1.convert(tanner);

		if (felino2 == null) {
			System.err.println("No existe el objeto");
		} else {
			converter1.mostrarObjeto(felino2);
		}
	}
}
