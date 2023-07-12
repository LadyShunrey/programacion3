package Redoing;

public class Billete {
	private int valorDelBillete;
	
	public Billete(int valorDelBillete){
		this.valorDelBillete = valorDelBillete;
	}
	
	public int getValorDelBillete(){
		return valorDelBillete;
	}
	
	@Override
	public String toString() {
		String result = "Un billete de " + valorDelBillete;
		return result;
	}
}
