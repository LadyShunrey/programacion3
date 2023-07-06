package EJ_11;

/*Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente.*/

public class EJ_11 {
	public static void main(String[] args) {
		int [] arreglo = new int [5];
		
		arreglo[0] = 1;
		arreglo[1] = 2;
		arreglo[2] = 5;
		arreglo[3] = 7;
		arreglo[4] = 10;
		
		for(int i=0;i < arreglo.length;i++){
			System.out.println(arreglo[i]);	
		}
		
		int numeroBuscado = 7;
		System.out.println(encontrarNumero(arreglo, 0, numeroBuscado));
	}

	public static int encontrarNumero(int[] arreglo, int i, int buscado){
		if(arreglo[i]==buscado){
			return i;
		}
		if((arreglo[i]>buscado) || (i==arreglo.length)){
			return -1;
		}
		if(arreglo[i]<buscado){
			return encontrarNumero(arreglo, i+1, buscado);
		}
		return -1;
	}
}
