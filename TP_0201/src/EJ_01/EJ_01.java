package EJ_01;

public class EJ_01 {
	public int max;
	public int[] arreglo = new int[max];
	
	//ordenar por seleccion
	public void ordenarPorSeleccion(int[] arregloParaOrdenar){
		for(int i = 0; i < max - 1; i++){
			int min = i;
			for(int j = i + 1; j<max; j++){
				if(arreglo[j]<arreglo[min]){
					min = j;
				}
			}
			int aux = arreglo[min];
			arreglo[min] = arreglo[i];
			arreglo[i] = aux;
		}
	}
	
	//ordenar por burbujeo
	public void ordenarPorBurbujeo(int[] arregloParaOrdenar){
		int i;
		int j;
		int aux;
		for (i=0;i<max-1;i++){
			for(j=0;j<max-1-i;j++){
				if(arreglo[j]>arreglo[j+1]){
					aux = arreglo[j+1];
					arreglo[j+1] = arreglo[j];
					arreglo[j] = aux;
				}
			}
		}
	}
	//Qué complejidad tienen estos algoritmos?
	//rta: O(n^2)
}
