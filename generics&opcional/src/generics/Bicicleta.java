package generics;

public class Bicicleta {

	private double precio;

	public Bicicleta(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Bicicleta [precio= " + precio + "]";
	}
	
}
