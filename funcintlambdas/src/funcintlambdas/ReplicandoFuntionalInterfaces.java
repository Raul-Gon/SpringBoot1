package funcintlambdas;

import java.util.ArrayList;
import java.util.List;

public class ReplicandoFuntionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(5);
		numeros.add(6);
		numeros.add(7);	
		
		numeros.removeIf(x -> x == 2);
		/* LO DE ARRIVA EQUIVALE A ESTO DE AQUI ABAJO
		for (int i = 0; i < numeros.size(); i++) {
			if(numeros.get(i) == 2) numeros.remove(i);
		}
		*/
		
		numeros.forEach(s -> System.out.println(s + "..."));		
		/*LO DE ARRIVA EQUIVALE A ESTO DE AQUI ABAJO
		for (Integer n : numeros) {
			System.out.println(n + "...");
		}				
		*/
		
		numeros.sort((n1, n2) -> n1 - n2);
		System.out.println(numeros);
		
		numeros.sort((n1, n2) -> n2 - n1);
		System.out.println(numeros);
		
		
		List<String> palabras = new ArrayList<>();
		palabras.add("ooiyuoiu");
		palabras.add("uyuy");
		palabras.add("tttrt");
		palabras.add("fsfere");
		palabras.add("ffef");
		palabras.add("asdf");
		
		palabras.sort((n1, n2) -> n1.length() - n2.length());
		System.out.println(palabras);
		
		palabras.sort((n1, n2) -> -1);
		System.out.println(palabras);
		
		numeros.stream()
				.distinct()
				.limit(2)
				.map(x -> x + 5)
				.sorted()
				.forEach(System.out::println);
	}

}

/* DA ERROR PQ LO TENGO YA IMPLEMENTADO EN LA CLASE ReplicandoPredicate.java
@FunctionalInterface
interface _Predicate<T> {
	boolean test(T t);
}
*/

@FunctionalInterface
interface _Supplier<T> {
    T get();
}

@FunctionalInterface
interface _Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
interface _BiConsumer<T, U> {
    void accept(T t, U u);
}

@FunctionalInterface
interface _BiPredicate<T, U> {
    boolean test(T t, U u);
}

@FunctionalInterface
interface _Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
interface _BiFunction<T, U, R> {
    R apply(T t, U u);
}

@FunctionalInterface
interface _UnaryOperator<T> {
    T apply(T t);
}

@FunctionalInterface
interface _BinaryOperator<T> {
    T apply(T t1, T t2);
}