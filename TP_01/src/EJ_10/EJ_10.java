package EJ_10;

/*Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?*/

/* 1) O(n-1) cantidad de recursiones
 * 2) Creo que no trae ningun problema.
 * 3) En la lista puede usarse el iterador 
 * */

public class EJ_10 {

	public static void main(String[] args) {
		int [] arreglo = new int [5];
		
		arreglo[0] = 1;
		arreglo[1] = 2;
		arreglo[2] = 5;
		arreglo[3] = 77;
		arreglo[4] = 10;
		
		for(int i=0;i < arreglo.length;i++){
			System.out.println(arreglo[i]);	
		}
		
		System.out.println(estaOrdenado(arreglo, 0, 1));
	}

	public static boolean estaOrdenado(int[] arreglo, int i, int j){
		if(j==arreglo.length){
			return true;
		}
		if(arreglo[i]>arreglo[j]){
			return false;
		}
		if(arreglo[i]<=arreglo[j]){
			return estaOrdenado(arreglo, i+1, j+1);
		}
		return false;
	}
}
