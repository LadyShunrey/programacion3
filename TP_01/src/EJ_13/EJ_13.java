package EJ_13;

/*Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
Fibonacci.
Por ej. los 6 primeros términos son: 0 1 1 2 3 5*/

public class EJ_13 {

	public static void main(String[] args) {
		int cantidadDeNumeros = 2;
		int primero = 0;
		int segundo = 1;
		String secuencia = ""+primero+", "+ segundo;
		int tamanoSecuencia = 10;
		
		System.out.println(secuenciaFibonacci(cantidadDeNumeros, primero, segundo, secuencia, tamanoSecuencia));
	}
	
	public static String secuenciaFibonacci(int cantidad, int primero, int segundo, String secuencia, int tamano){
		if(cantidad==tamano){
			return secuencia+".";
		}
		else{
			cantidad++;
			secuencia += ", ";
			secuencia += primero+segundo;
			return secuenciaFibonacci(cantidad, segundo, primero+segundo, secuencia, tamano);
		}
	}
}
