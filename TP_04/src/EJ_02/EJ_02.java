package EJ_02;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

/*Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural
y cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este,
sur y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud
de un camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría
representarse el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y
cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.
*/

public class EJ_02 {

	/*IDEA: Mi estado inicial puede ser un arreglo de Celdas que esté vacío, y mi estado final un arreglo de celdas con la primera = inicio y la 
	 * ultima = destino; 
	 * 
	 * Mi espacio de busqueda va a empezar con la celda inicio y va a terminar cuando llegue a la celda destino, en cada paso
	 * voy a agarrar una celda adyacente, preguntar si esa direccion es = true y moverme llamando a la recursion.
	 * Marcar los visitados y llevar la cuenta del camino actual y la solucion actual 
	 * 
	 * Poda, si llego a un camino sin salida, si la longitud de mi camino ya es más larga que el mejor camino encontrado*/
	
	private static ArrayList<Celda> menorCamino = new ArrayList<>();
	private static Celda [][] matriz = new Celda[2][2];
	private static int longitudMenor = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Celda inicio = new Celda(0,false,true,true,false);
		Celda a2 = new Celda(9,false,false,true,true);
		Celda b1 = new Celda(5,true,true,false,false);
		Celda destino = new Celda(7,true,false,false,true);
		
		matriz[0][0] = inicio;
		matriz[0][1] = a2;
		matriz[1][0] = b1;
		matriz[1][1] = destino;
		
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				System.out.print(matriz[i][j]);		
			}
			System.out.println();
		}
		ArrayList<Celda> caminoParcial = new ArrayList<>();
		int longitud = inicio.getValor();
		
		encontrarCaminoMinimo(inicio, destino, caminoParcial, longitud);
		
		System.out.println(menorCamino);
	}

	public static void encontrarCaminoMinimo(Celda actual, Celda destino, ArrayList<Celda> caminoParcial, int longitudParcial){
		System.out.println(caminoParcial);
		if(actual==destino){
			//encontré solución!
			if(!caminoParcial.contains(destino)){
				caminoParcial.add(destino);
				System.out.println(caminoParcial);
				longitudParcial += destino.getValor();
				if(longitudParcial<longitudMenor){
					ArrayList<Celda> aux = new ArrayList<>();
					for (Celda celda: caminoParcial){
						aux.add(celda);
					}
					if(!menorCamino.containsAll(aux)){
						menorCamino = aux;
						longitudMenor = longitudParcial;
					}
				}
				caminoParcial.remove(destino);
				longitudParcial-=destino.getValor();
			}	
		}
		else{
			//busco una solucion
			if(!caminoParcial.contains(actual)){
				if(!poda(longitudParcial+=actual.getValor())){
					int i = getPosI(actual);
					int j = getPosJ(actual);
					if(actual.isNorte()){
						longitudParcial += actual.getValor();
						Celda siguiente = matriz[i-1][j];
						caminoParcial.add(actual);
						encontrarCaminoMinimo(siguiente, destino, caminoParcial, longitudParcial);
						caminoParcial.remove(actual);
						longitudParcial -= actual.getValor();
					}
					if(actual.isEste()){
						longitudParcial += actual.getValor();
						Celda siguiente = matriz[i][j+1];
						caminoParcial.add(actual);
						encontrarCaminoMinimo(siguiente, destino, caminoParcial, longitudParcial);
						caminoParcial.remove(actual);
						longitudParcial -= actual.getValor();
					}
					if(actual.isSur()){
						longitudParcial += actual.getValor();
						Celda siguiente = matriz[i+1][j];
						caminoParcial.add(actual);
						encontrarCaminoMinimo(siguiente, destino, caminoParcial, longitudParcial);
						caminoParcial.remove(actual);
						longitudParcial -= actual.getValor();
					}
					if(actual.isOeste()){
						longitudParcial += actual.getValor();
						Celda siguiente = matriz[i][j-1];
						caminoParcial.add(actual);
						encontrarCaminoMinimo(siguiente, destino, caminoParcial, longitudParcial);
						caminoParcial.remove(actual);
						longitudParcial -= actual.getValor();
					}
				}
			}
		}
	}
	
	public static boolean poda(int longitudParcial){
		return longitudParcial>longitudMenor;
	}
	
	public static int getPosI(Celda celda){
		int posI = 0;
		for(int i =0;i<2;i++){
			for(int j =0;j<2;j++){
				if(matriz[i][j]==celda){
					posI = i;
				}
			}
		}
		return posI;
	}
	
	public static int getPosJ(Celda celda){
		int posJ = 0;
		for(int i =0;i<2;i++){
			for(int j =0;j<2;j++){
				if(matriz[i][j]==celda){
					posJ = j;
				}
			}
		}
		return posJ;
	}
}
