package ar.edu.unju.fi.ejercicio06.model;

public class FelinoSalvaje {
	private String name;
	private byte age;
	private float weight;

	public FelinoSalvaje() {
	}

	public FelinoSalvaje(String name, byte age, float weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Felino Salvaje\nNombre: " + name + "\nEdad: " + age + " anios\nPeso: " + weight + "kg";
	}
}
