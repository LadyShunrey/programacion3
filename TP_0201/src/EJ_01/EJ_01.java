package EJ_01;

/*Implemente un algoritmo de ordenamiento por selección en un arreglo.
Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
1. ¿Qué complejidad O tienen estos algoritmos?
*/

public class EJ_01 {

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
		
		ordenarPorSeleccion(arreglo);
		
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
		
		ordenarPorBurbujeo(arreglo2);
		
		System.out.println("\n\nEl arreglo2 ORDENADO queda: \n");
		for(int i=0;i < arreglo2.length;i++){
			System.out.print("["+arreglo2[i]+"] ");	
		}
	}

	public static void ordenarPorSeleccion(int[]arreglo){
		for(int i=0;i<arreglo.length-1;i++){
			int minIndex = i;
			for(int j=i+1; j<arreglo.length;j++){
				if(arreglo[j]<arreglo[minIndex]){
					minIndex = j;
				}
			}
			int aux = arreglo[i];
			arreglo[i] = arreglo[minIndex];
			arreglo[minIndex] = aux;
		}
	}
	
	public static void ordenarPorBurbujeo(int[]arreglo){
		for(int i=0; i<arreglo.length;i++){
			for(int j=i+1;j<arreglo.length-i;j++){
				
			}
		}
	}
}
