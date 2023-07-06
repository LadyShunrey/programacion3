package EJ_09;

/*Implemente un algoritmo recursivo que verifique si una cadena de texto es palindroma
(capicua).*/

public class EJ_09 {
	
	public static void main(String[] args) {
		String texto1 = "anitalavalatina";
		String texto2 = "abcded";
		String texto3 = "amamaromaleavivaelamorapapayapaparomaleavivaelamoramama";
		
		int inicio = 0;
		int fin = texto1.length()-1;
		int fin2 = texto2.length()-1;
		int fin3 = texto3.length()-1;
		
		System.out.println("El texto1 = " + texto1);
		System.out.println("El texto2 = " + texto2);
		System.out.println("El texto3 = " + texto3);
		
		System.out.println(esPalindromico(texto1, inicio, fin));
		System.out.println(esPalindromico(texto2, inicio, fin2));
		System.out.println(esPalindromico(texto3, inicio, fin3));
		
	}
	
	public static boolean esPalindromico(String texto, int inicio, int fin){
		System.out.println("El char inicio y fin son: " + texto.charAt(inicio) + " -- " + texto.charAt(fin));
		if(inicio==texto.length()-1 && fin==0){
			return true;
		}
		
		if(texto.charAt(inicio) == texto.charAt(fin)){
			return esPalindromico(texto, inicio+1, fin-1);
		}
		
		return false;
	}
}
