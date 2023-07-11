package EJ_02;

public class Celda {
	private int valor;
	private boolean norte;
	private boolean este;
	private boolean sur;
	private boolean oeste;
	
	public Celda (int valor, boolean norte, boolean este, boolean sur, boolean oeste){
		this.valor = valor;
		this.norte = norte;
		this.este = este;
		this.sur = sur;
		this.oeste = oeste;
	}

	public int getValor() {
		return valor;
	}

	public boolean isNorte() {
		return norte;
	}

	public boolean isEste() {
		return este;
	}

	public boolean isSur() {
		return sur;
	}

	public boolean isOeste() {
		return oeste;
	}
	
	@Override
	public String toString(){
		return "[" + valor + "]";
	}
}
