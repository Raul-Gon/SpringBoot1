package funcintlambdas;

public class EjemploArrayStringFiltrado {

	private static void muestraSelectivamente(String[] array, StringToBoolean filtro){
		
		for (String string : array) {
			if(filtro.filtra(string)) System.out.print(string + " , ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] strings = {"hola", "cositas", "buenas tardes", "temprano"};
		
		muestraSelectivamente(strings, s -> s.length() < 5);
		
		StringToBoolean terminanPorS = s -> s.endsWith("s");
		muestraSelectivamente(strings, terminanPorS);
		
	}	
	
}

@FunctionalInterface
interface StringToBoolean {	
	boolean filtra(String string);	
}
