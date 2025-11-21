package generics;

import java.util.ArrayList;
import java.util.List;

public class Trio<R,S,T> {
	
	R elemento1;
	S elemento2;
	T elemento3;
	
	public Trio(R elemento1, S elemento2, T elemento3) {
		this.elemento1 = elemento1;
		this.elemento2 = elemento2;
		this.elemento3 = elemento3;
	}

	public R getElemento1() {
		return elemento1;
	}

	public S getElemento2() {
		return elemento2;
	}

	public T getElemento3() {
		return elemento3;
	}

	@Override
	public String toString() {
		return "Trio [elemento1=" + elemento1 + ", elemento2=" + elemento2 + ", elemento3=" + elemento3 + "]";
	}
	
	public static void main(String[] args) {
		Trio<String,String,String> t1 = new Trio<>("Hola", "Don", "Pepito");
		
		System.out.println(t1);
		
		
	}

}
