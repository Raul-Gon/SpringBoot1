package funcintlambdas;

public class CalculoEntero {
	private int cuadrado(int x) {return x * x;}
	private int cubo(int x) {return x * x * x;}
	private int doble(int x) {return 2 * x;}
	private int triple(int x) {return 3 * x;}
	private int cuadruple(int x) {return 4 * x;}
	private int polinomio(int x) {return 5 * x * x * x + 7 * x * x + 9;}
	private int polinomioVariable(int a, int b, int c, int x) {
		return a * x * x * x + b * x * x + c;
		}
	
	public static void main(String[] args) {
		int x = 10;
		int a = 20;
		int b = 12;
		int c = 9;
		
		
		CalculoEntero ce = new CalculoEntero();
		System.out.println(ce.cuadrado(x));
		System.out.println(ce.cubo(x));
		System.out.println(ce.doble(x));
		System.out.println(ce.triple(x));
		System.out.println(ce.polinomio(x));
		System.out.println(ce.polinomioVariable(a, b, c, x));	
		
		
		System.out.println("Interface Funcional");
		
		UsaIntDevuelveInt cuadrado  = s -> s * s;
		UsaIntDevuelveInt cubo  = s -> s * s * s;
		Usa4IntDevuelveInt polinomioValriable = 
				(int a1, int b1, int c1, int x1) -> a1 * x1 * x1 * x1 + b1 * x1 * x1 + c1;
		
		System.out.println(cuadrado.m(x));
		System.out.println(cubo.m(x));
		System.out.println(polinomioValriable.m(a, b, c, x));
	}
}
