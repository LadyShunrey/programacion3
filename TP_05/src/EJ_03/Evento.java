package EJ_03;

public class Evento {
	private int comienzo;
	private int fin;
	
	public Evento(int comienzo, int fin){
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public int getComienzo() {
		return comienzo;
	}

	public void setComienzo(int comienzo) {
		this.comienzo = comienzo;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}
	
	public String toString(){
		return "[" + comienzo + ", " + fin + "]";
	}
}
