package EJ_05;

/*Dado un �rbol binario donde todos los nodos poseen un car�cter, de manera que cada rama del
�rbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
que posea exactamente N vocales (ni m�s ni menos). Por ejemplo, para el siguiente �rbol, con
una entrada de N = 1, el algoritmo deber�a retornar [�MAL�]. En cambio, para un N = 2, deber�a
retornar [�MANA�, �MANO�, �MISA�].
*/

public class EJ_05 {
	
	public static void main(String[] args) {
		
		Nodo a3 = new Nodo('a');
		Nodo o2 = new Nodo('o');
		Nodo a2 = new Nodo('a');
		
		Nodo o = new Nodo('o');
		Nodo s = new Nodo('s', null, a3);
		
		Nodo n = new Nodo('n', a2, o2);
		Nodo l = new Nodo('l');
		
		Nodo i = new Nodo('i', s, o);
		Nodo a = new Nodo('a', l, n);
		
		//Raiz
		Nodo m = new Nodo('m', a, i);
		
		
		//�rbol
		ArbolBinarioCaracter arbol = new ArbolBinarioCaracter(m);
		
		System.out.println(arbol);
		
	}
	
	//imprimir rama
	//imprimirramaconvocal
	
	//recorrer una rama e imprimirla
	
	//recorrer una rama e imprimirla solo si la suma de a,e,i,o,u es igual a N un contador++
	
	//IDEA:
	//un ArraList de ArrayList de Character/String donde voy guardando en un arraylist Char todos y cuando llego a una hoja agarro ese ArrayList
	//y lo agrego al array de arrays
		
	
}
