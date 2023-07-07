package EJ_01;

import java.util.ArrayList;

/*Implemente la estructura de Árbol Binario para búsquedas.
Métodos:
● Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List
getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?*/

public class ArbolBinarioBusqueda {
	
	private Nodo raiz;
	
	public ArbolBinarioBusqueda(){
		this.raiz = null;
	}
	
	public ArbolBinarioBusqueda(Nodo raiz){
		this.raiz = raiz;
	}
	
	public Integer getRoot(){
		return raiz.getValor();
	}
	
	public boolean hasElem(Integer valorBuscado, Nodo raiz){
		if (raiz == null) {
	        return false;
	    }
	    
	    if (raiz.getValor()==valorBuscado) {
	        return true;
	    }
	    
	    boolean encontradoIzquierdo = hasElem(valorBuscado, raiz.getIzquierdo());
	    boolean encontradoDerecho = hasElem(valorBuscado, raiz.getDerecho());
	    
	    return encontradoIzquierdo || encontradoDerecho;
	}
	
	public boolean isEmpty(){
		return true;
	}
	
	public void insert(Integer numero){
		
	}
	
	public boolean delete(Integer numero){
		return true;
	}
	
	public Integer getHeight(){
		return 1;
	}
	
	public void printPosOrder(){
		
	}
	
	public void printPreOrder(){
		
	}
	
	public void printInOrder(){
		
	}
	
	public ArrayList<Nodo> getLongestBranch(){
		ArrayList<Nodo> lista = new ArrayList<>();
		return lista; 
	}
	
	public ArrayList<Nodo> getFrontera(){
		ArrayList<Nodo> lista = new ArrayList<>();
		return lista;
	}
	
	public Integer getMaxElem(){
		return 1;
	}
	
	public ArrayList<Nodo> getElemAtLevel(Integer numero){
		ArrayList<Nodo> lista = new ArrayList<>();
		return lista;
	}
	
	@Override
	public String toString(){
		return toString(raiz);
	}
	
	private String toString(Nodo head) {
	    if (head == null) {
	        return "";
	    }
	    
	    String izquierdo = toString(head.getIzquierdo());
	    String derecho = toString(head.getDerecho());
	    
	    return izquierdo + head.getValor() + " " + derecho;
	}
}
