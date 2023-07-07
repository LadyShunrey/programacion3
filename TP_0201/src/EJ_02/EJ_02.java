package EJ_02;

/*Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
1. ¿Cuál es su complejidad en el peor caso?
2. ¿Cuál es su complejidad promedio?*/

/*
 * 1)
 * MergeSort: Tanto en el peor caso como en el mejor caso, MergeSort tiene una
 * complejidad de O(n log n), donde "n" es el tamaño del arreglo.
 * 
 * QuickSort: En el peor caso, el tiempo de ejecución de QuickSort es O(n^2),
 * donde "n" es el tamaño del arreglo. 
 * 
 * 2)
 * MergeSort: La complejidad promedio de MergeSort sigue siendo O(n log n).
 * 
 * QuickSort: En promedio, QuickSort también tiene una complejidad de O(n log n).
 * 
 * QuickSort depende mucho de dónde ponemos el pivote
 * 
 * */

public class EJ_02 {
	private static int [] numbers;
	private static int [] helper;
	private static int size;
	
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
		
		sort(arreglo);
		
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
		
		sort(arreglo2);
		
		System.out.println("\n\nEl arreglo2 ORDENADO queda: \n");
		for(int i=0;i < arreglo2.length;i++){
			System.out.print("["+arreglo2[i]+"] ");	
		}
		
		int [] arreglo3 = new int [20];
		
		arreglo3[0] = 12;
		arreglo3[1] = 2;
		arreglo3[2] = 35;
		arreglo3[3] = 7;
		arreglo3[4] = -10;
		arreglo3[5] = -50;
		arreglo3[6] = 100;
		arreglo3[7] = 60;
		arreglo3[8] = 111;
		arreglo3[9] = 22;
		arreglo3[10] = 23;
		arreglo3[11] = 90;
		arreglo3[12] = 10;
		arreglo3[13] = 7;
		arreglo3[14] = 7;
		arreglo3[15] = 65;
		arreglo3[16] = 56;
		arreglo3[17] = 44;
		arreglo3[18] = 33;
		arreglo3[19] = 1;

		System.out.println("\n----\nEl arreglo3 es: \n");
		for(int i=0;i < arreglo3.length;i++){
			System.out.print("["+arreglo3[i] + "] ");	
		}
		
		ordenarPorQuickSort(arreglo3);
		
		System.out.println("\n\nEl arreglo3 ORDENADO queda: \n");
		for(int i=0;i < arreglo3.length;i++){
			System.out.print("["+arreglo3[i]+"] ");	
		}
	}

	public static void sort(int[] values){
		numbers = values;
		size = values.length;
		helper = new int [size];
		ordenarPorMergeSort(0, size-1);
	}
	
	public static void ordenarPorMergeSort(int low, int high){
		if(low<high){
			int middle = (low+high)/2;
			ordenarPorMergeSort(low, middle);
			ordenarPorMergeSort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	public static void merge(int low, int middle, int high){
		for(int i = low; i<=high; i++){
			helper[i] = numbers[i];
		}
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i<=middle && j<=high){
			if(helper[i]<=helper[j]){
				numbers[k]= helper[i];
				i++;
			}
			else{
				numbers[k]=helper[j];
				j++;
			}
			k++;
		}
		while(i<=middle){
			numbers[k] = helper[i];
			k++;
			i++;
		}
		while(j<=high){
			numbers[k]=helper[j];
			k++;
			j++;
		}
	}
	
	public static void ordenarPorQuickSort(int[]arreglo){
		quickSort(arreglo, 0, arreglo.length - 1);
	}

	private static void quickSort(int[] arreglo, int low, int high) {
		if (low < high) {
	        int pivotIndex = partition(arreglo, low, high);
	        quickSort(arreglo, low, pivotIndex - 1);
	        quickSort(arreglo, pivotIndex + 1, high);
	    }
	}

	private static int partition(int[] arreglo, int low, int high) {
		int pivot = arreglo[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (arreglo[j] < pivot) {
	            i++;
	            swap(arreglo, i, j);
	        }
	    }
	    swap(arreglo, i + 1, high);
	    return i + 1;
	}

	private static void swap(int[] arreglo, int i, int j) {
		int temp = arreglo[i];
	    arreglo[i] = arreglo[j];
	    arreglo[j] = temp;
	}
}
