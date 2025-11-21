package generics;

public class BoxBicicleta {

	private Bicicleta contenido;

	public BoxBicicleta(Bicicleta contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return "Box [contenido= " + contenido + "]";
	}



	public static void main(String[] args) {
		
		BoxBicicleta b1 = new BoxBicicleta(new Bicicleta(20));
		System.out.println(b1);
		
		BoxBicicleta b2 = new BoxBicicleta(new Bicicleta(50));
		System.out.println(b2);
		
		BoxBicicleta b3 = new BoxBicicleta(new Bicicleta(70));
		System.out.println(b3);
	}
	
}
