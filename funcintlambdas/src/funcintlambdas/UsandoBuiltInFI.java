package funcintlambdas;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class UsandoBuiltInFI {

	private static void metodo(String[] palabras, int[] numeros) {
		BiPredicate<String, Integer> textoMayorQueLosNumerosCaracteres = (s, n) -> s.length() > n;
		for (int i = 0; i < numeros.length; i++) {
			if(textoMayorQueLosNumerosCaracteres.test(palabras[i], numeros[i])) System.out.println(palabras[i] + " " + numeros[i]);			
		}
	}
	
	private static int sumaFiltradaPorArray(int[] numeros, boolean[] filtros) {
		int suma = 0;
		for (int i = 0; i < numeros.length; i++) {
			if(filtros[i]) suma += numeros[i];
		}		
		return suma;
	}
	
	public static void main(String[] args) {
		
		Predicate<String> textoLargo = s -> s.length() > 10;
		/*
		 * Predicate<String> textoLargo =
		 * 				(String s) -> {
		 * 					return s.length() > 10;
		 * 				};
		 * */		
		textoLargo.test("fkjklsjfksjjw fsj  klkk");
		
		BiPredicate<String, Integer> textoMayorNCaracteres = (s, n) -> s.length() > n;
		System.out.println(textoMayorNCaracteres.test("hola a todos", 40));
		
		String[] palabras = {"hola", "java", "array", "test", "corto", "ejemplo", "string", "idea", "lista", "algo"};
		int[] numeros = {2, 4, 3, 6, 7, 2, 3, 8, 8, 3};
		boolean[] boleanos = {true, false, false, false, true, true, true, false, false, true};

		metodo(palabras, numeros);
		System.out.println(sumaFiltradaPorArray(numeros, boleanos));
	}

	
}
