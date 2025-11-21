package generics;

public class BoxString {

	private String contenido;

	public BoxString(String contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return "Box [contenido= " + contenido + "]";
	}



	public static void main(String[] args) {
		
		BoxString b1 = new BoxString("coche");
		System.out.println(b1);
		
		BoxString b2 = new BoxString("casa");
		System.out.println(b2);
		
		BoxString b3 = new BoxString("coche");
		System.out.println(b3);
	}
	
}
