package EJ_02;

public class Elemento {
	private double peso;
	private double valor;
	
	public Elemento(double peso, double valor){
		this.peso= peso;
		this.valor=valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString(){
		return "[" + peso + ", " + valor + "]";
	}
}
