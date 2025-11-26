package funcintlambdas;

public class CalculoEnteroADouble {
	
		public static void main(String[] args) {
		        OperaIntDevuelveDouble mitad = x -> (double)x / 2;
		        OperaIntDevuelveDouble cuartaParte = x -> (double)x / 4;
		        OperaIntDevuelveDouble decimaParte = x -> (double)x / 10;
		        Opera2IntDevuelveDouble nsimaParte = (int x, int n) -> (double)x / n;
		        System.out.printf("Mitad: %.2f%n", mitad.actua(7));
		        System.out.printf("Cuarta parte: %.2f%n", cuartaParte.actua(7));
		        System.out.printf("Décima parte: %.2f%n", decimaParte.actua(7)); 
		        System.out.printf("16 ava parte: %.2f%n", nsimaParte.actua(7, 16)); 
		        
		        int[] enteros = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
		        sumaFiltrado(enteros, i -> true);
		        sumaFiltrado(enteros, i -> i % 2 == 0);
						sumaFiltrado(enteros, i -> i % 2 == 1);
		        sumaFiltrado(enteros, i -> i > 0);
		        sumaFiltrado(enteros, i -> i < 0);
		        sumaFiltrado(enteros, i -> i > 8);
		        int valorPrefijado = 7;
		        sumaFiltrado(enteros, i -> i > valorPrefijado);     
	    }   
	        
	    private static void sumaFiltrado(int[] array, OperaEnteroDevuelveBoolean filtro) {
	        int suma = 0;
	        for(int elem: array)
	            if(filtro.actua(elem))
	                suma = suma + elem;
	        System.out.println(suma);
	    }
}	    
