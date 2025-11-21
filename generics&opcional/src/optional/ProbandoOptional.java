package optional;

import java.util.Iterator;
import java.util.Optional;

public class ProbandoOptional {

	private static int suma(int[] datos) {
		int suma = 0;
		for (int dato : datos) {
			suma += dato;
		}
		return suma;
	}
	
	private static Optional<Double> media(int[] datos) {
		return datos == null || datos.length == 0 ? Optional.empty() : Optional.of(suma(datos)/(double)datos.length);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2};
		System.out.println(suma(array));
		media(array).ifPresent(e -> System.out.println(e));
	}
	
}
