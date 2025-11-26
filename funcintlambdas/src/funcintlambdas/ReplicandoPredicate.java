package funcintlambdas;

public class ReplicandoPredicate {

	public static void main(String[] args) {
		_Predicate<String> empiezaPorA = s -> s.startsWith("A");
		System.out.println(empiezaPorA.test("Adios"));
		System.out.println(empiezaPorA.test("Hola"));
		_Predicate<Integer> mayorDeEdad = n -> n >= 18;
		System.out.println(mayorDeEdad.test(16));
		System.out.println(mayorDeEdad.test(19));
	}

}

@FunctionalInterface
interface _Predicate<T> {
	boolean test(T t);
}


