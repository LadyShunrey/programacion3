package EJ_07;

/*Tablero m�gico. Dado un tablero de tama�o n x n, construir un algoritmo que ubique (si es posible)
n*n n�meros naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de
las columnas y de las filas sea igual a S.*/

public class EJ_07 {

	public static void main(String[] args) {
		int[][] tablero = new int [2][2];
		
	}
	
	public static void backtracking(){
		//sumar filas
		//sumar columnas
		//filas + columnas = S
		
		//ubicar numeros desde 1 hasta 2x2
		
		
		
		
		//solucion -> cuando suma fila = S y suma columna = S
		
		//buscarSolucion ->
			//pruebo una solucion -> elijo un numero y lo agrego a la matriz
			//backtracking -> matrizParcial
			//la quito ->quito ese numero
		
	}
	
	public static boolean solucion(int[][]tablero, int[][]solucionParcial){
		
		for(int i = 0; i<=solucionParcial.length;i++){ //columnas
			for(int j = 0; j<=solucionParcial.length;j++){ //filas
				
			}
		}
		return false;
	}
}
