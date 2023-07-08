package EJ_02;

import EJ_01.ArbolBinarioBusqueda;
import EJ_01.Nodo;

/*Dado un �rbol binario de b�squedas que almacena n�meros enteros, implementar un algoritmo
que retorne la suma de todos los nodos internos del �rbol.*/

public class EJ_02 {

	public static void main(String[] args) {
		//Hojas
		Nodo uno = new Nodo(1);
		Nodo cuatro = new Nodo(4);
		Nodo siete = new Nodo(7);
		Nodo trece = new Nodo(13);
		
		//Nodos internos
		Nodo seis = new Nodo(6, cuatro, siete);
		Nodo catorce = new Nodo(14, trece, null);
		
		Nodo tres = new Nodo(3, uno, seis);
		Nodo diez = new Nodo(10, null, catorce);
		
		//Raiz
		Nodo ocho = new Nodo(8, tres, diez);
		
		
		//�rbol
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda(ocho);
		
		System.out.println(contarNodosInternos(ocho, 0));
	}

	public static int contarNodosInternos(Nodo raiz, int result){
		if(raiz==null){
			return 0;
		}
		
		if(raiz.getDerecho()!=null || raiz.getIzquierdo()!=null){
			result = raiz.getValor() + contarNodosInternos(raiz.getDerecho(), result) + contarNodosInternos(raiz.getIzquierdo(), result);
		}
		return result;
	}
}
