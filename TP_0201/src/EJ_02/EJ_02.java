package EJ_02;

/*Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
1. ¿Cuál es su complejidad en el peor caso?
2. ¿Cuál es su complejidad promedio?*/

public class EJ_02 {
	public static void main(String[] args) {
		int [] arreglo = new int [5];
		
		arreglo[0] = 1;
		arreglo[1] = 12;
		arreglo[2] = 5;
		arreglo[3] = 77;
		arreglo[4] = 10;

		System.out.println("El arreglo1 es: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i] + "] ");	
		}
		
		ordenarPorMergeSort(arreglo);
		
		System.out.println("\n\nEl arreglo1 ORDENADO queda: \n");
		for(int i=0;i < arreglo.length;i++){
			System.out.print("["+arreglo[i]+"] ");	
		}
		
		int [] arreglo2 = new int [5];
		
		arreglo2[0] = 12;
		arreglo2[1] = 2;
		arreglo2[2] = 35;
		arreglo2[3] = 7;
		arreglo2[4] = -10;

		System.out.println("\n----\nEl arreglo2 es: \n");
		for(int i=0;i < arreglo2.length;i++){
			System.out.print("["+arreglo2[i] + "] ");	
		}
		
		ordenarPorQuickSort(arreglo2);
		
		System.out.println("\n\nEl arreglo2 ORDENADO queda: \n");
		for(int i=0;i < arreglo2.length;i++){
			System.out.print("["+arreglo2[i]+"] ");	
		}
	}

	public static void ordenarPorMergeSort(int[]arreglo){
		
	}
	
	public static void ordenarPorQuickSort(int[]arreglo){
		
	}
}
