package enumerados;

public enum FinDe {

	VI(5, "viernes"), SA(6, "sabado"), DO(7, "domingo");
	
	private int numDia;
	private String nombreES;

	private FinDe(int numDia, String nombreES) {
		this.numDia = numDia;
		this.nombreES = nombreES;
	}

	public int getNumDia() {
		return numDia;
	}

	public String getNombreES() {
		return nombreES;
	}
	
	@Override
	public String toString() {
		return nombreES;
	}
}
