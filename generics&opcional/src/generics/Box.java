package generics;

public class Box<T> {
	
	T contenido;

	public Box(T contenido) {
		this.contenido = contenido;
	}

	public T getContenido() {
		return contenido;
	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return "Box [contenido=" + contenido + "]";
	}

	public static void main(String[] args) {
		Box<Integer> b1 = new Box<>(1);
		Box<String> b2 = new Box<>("hola");
		Box<Bicicleta> b3 = new Box<>(new Bicicleta(250));
		
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
	
}
