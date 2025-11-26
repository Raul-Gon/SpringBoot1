package funcintlambdas;

public class EjemploArrayFiltrado {
	
	private static int suma(int[] array, IntToBoolean filtro) {
		int suma = 0;
		
		for (int elemento : array) {
			if (filtro.comprueba(elemento)) suma += elemento;			
		}
		
		return suma;
	}
	
	public static void main(String[] args) {
		
		IntToBoolean filtroPares = x -> x % 2 == 0;
		
		int[] miArray = {1, 2, 3, 4, 5};
		suma(miArray, x -> true);
		suma(miArray, filtroPares);
		suma(miArray, x -> x % 2 != 0);
		suma(miArray, x -> x > 0);
		suma(miArray, x -> x > 8);
	}

}

@FunctionalInterface
interface IntToBoolean {
	boolean comprueba(int x);
}
