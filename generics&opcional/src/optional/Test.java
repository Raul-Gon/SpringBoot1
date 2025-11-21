package optional;

import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		
		Optional<Double> o1 = Optional.of(3.5);
		System.out.println(o1);
		
		/*
		Optional<Double> o2 = Optional.of(null);
			Exception in thread "main" java.lang.NullPointerException
			at java.base/java.util.Objects.requireNonNull(Objects.java:233)
			at java.base/java.util.Optional.of(Optional.java:113)
			at generics/optional.Test.main(Test.java:12)
		System.out.println(o2); <-NO FUNCIONA PQ DA EL ERROR ANTERIOR
		*/
		
		Optional<Double> o3 = Optional.empty();
		System.out.println(o3);
		
		Optional<Double> o4 = Optional.ofNullable(3.5);
		System.out.println(o4);
		Optional<Double> o5 = Optional.ofNullable(null);
		System.out.println(o5);
	}
}
