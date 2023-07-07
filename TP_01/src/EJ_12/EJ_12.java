package EJ_12;

/*Implemente un algoritmo recursivo que convierta un número en notación decimal a su
equivalente en notación binaria. Por ejemplo el 26 en binario es 11010*/

public class EJ_12 {

	public static void main(String[] args) {
		int numeroDecimal = 26;
		String numeroBinario = convertirABinario(numeroDecimal,"");
		System.out.println("El número "+numeroDecimal+" en binario es: "+numeroBinario);
		
		int numeroDecimal5 = 5;
		String numeroBinario5 = convertirABinario(numeroDecimal5,"");
		System.out.println("El número "+numeroDecimal5+" en binario es: "+numeroBinario5);
	}
	
	public static String convertirABinario(int numero, String numeroBinario){
		
		int cociente = numero/2;
		int resto = numero%2;
		
		System.out.println(numero + " - " + resto);
		
		if(cociente==1){
			System.out.println(cociente + " - " + resto);
			return numeroBinario+= "1" + resto;
		}
		if(cociente==0){
			System.out.println(cociente + " - " + resto);
			return numeroBinario+=0 + resto;
		}
		
		return numeroBinario += convertirABinario(cociente, numeroBinario) + resto;
	}
}
