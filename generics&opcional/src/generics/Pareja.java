package generics;

public class Pareja<R,S> {

	R clave;
	S valor;
	
	public Pareja(R clave, S valor) {
		this.clave = clave;
		this.valor = valor;
	}

	public R getClave() {
		return clave;
	}

	public void setClave(R clave) {
		this.clave = clave;
	}

	public S getValor() {
		return valor;
	}

	public void setValor(S valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pareja [clave=" + clave + ", valor=" + valor + "]";
	}
	
	public static void main(String[] args) {
		Pareja<String,Integer> p1 = new Pareja<>("carro", 12453);
		Pareja<Bicicleta,Integer> p2 = new Pareja<>(new Bicicleta(12), 12453);
		Pareja<String,Bicicleta> p3 = new Pareja<>("BTX", new Bicicleta(250));
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}	
	
}
