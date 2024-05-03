package ar.edu.unju.fi.ejercicio06.model;

public class FelinoDomestico {
	private String name;
	private byte age;
	private float weight;

	public FelinoDomestico() {
	}

	public FelinoDomestico(String name, byte age, float weight) {
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
		return "Felino Domestico\nNombre: " + name + "\nEdad: " + age + " anios\nPeso: " + weight + "kg";
	}

}
