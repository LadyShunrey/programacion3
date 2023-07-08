package EJ_03;

import java.util.ArrayList;

import EJ_01.ArbolBinarioBusqueda;
import EJ_01.Nodo;

/*Dado un árbol binario de búsqueda que almacena
números enteros y un valor de entrada K, implementar un
algoritmo que permita obtener un listado con los valores
de todas las hojas cuyo valor supere K. Por ejemplo, para
el árbol de la derecha, con un valor K = 8, el resultado
debería ser [9, 11]*/

public class EJ_03 {

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
		
		
		//Árbol
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda(ocho);
		
		ArrayList<Integer> solucion = new ArrayList<>();
		
		System.out.println(encontrarHojasMayoresQue(0, ocho, solucion));
		
		//Hojas
		Nodo uno2 = new Nodo(1);
		Nodo cuatro2 = new Nodo(4);
		Nodo siete2 = new Nodo(7);
		Nodo nueve2 = new Nodo(9);
		Nodo once2 = new Nodo(11);
		
		//Nodos internos
		Nodo ocho2 = new Nodo(8, siete2, nueve2);
		
		Nodo dos2 = new Nodo(2, uno2, cuatro2);
		Nodo diez2 = new Nodo(10, ocho2, once2);
		
		//Raiz
		Nodo seis2 = new Nodo(6, dos2, diez2);
		
		
		//Árbol
		ArbolBinarioBusqueda arbol2 = new ArbolBinarioBusqueda(seis2);
		
		ArrayList<Integer> solucion2 = new ArrayList<>();
		
		System.out.println(encontrarHojasMayoresQue(8, seis2, solucion2));

	}
	
	public static ArrayList<Integer> encontrarHojasMayoresQue(int k, Nodo raiz, ArrayList<Integer> solucion){
		if(raiz==null){
			return solucion=null;
		}
		//si no tiene hijos y es mayor a k
		if(raiz.getDerecho()==null&&raiz.getIzquierdo()==null){
			if(raiz.getValor()>k){
				solucion.add(raiz.getValor());	
			}
		}
		if(raiz.getDerecho()!=null){
			encontrarHojasMayoresQue(k, raiz.getDerecho(), solucion);	
		}
		if(raiz.getIzquierdo()!=null){
			encontrarHojasMayoresQue(k, raiz.getIzquierdo(), solucion);	
		}
		return solucion;
	}
}
