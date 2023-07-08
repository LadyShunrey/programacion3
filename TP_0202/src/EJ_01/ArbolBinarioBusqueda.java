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
		return raiz!=null;
	}
	
	public void insert(Integer nuevoValor, Nodo raiz){
		if(!this.hasElem(nuevoValor, raiz)){
			if(nuevoValor<raiz.getValor()){
				if(raiz.getIzquierdo()==null){
					Nodo nuevoNodo = new Nodo(nuevoValor);
					raiz.setIzquierdo(nuevoNodo);
				}
				if(raiz.getIzquierdo()!=null){
					insert(nuevoValor, raiz.getIzquierdo());
				}
			}
			if(nuevoValor>raiz.getValor()){
				if(raiz.getDerecho()==null){
					Nodo nuevoNodo = new Nodo(nuevoValor);
					raiz.setDerecho(nuevoNodo);
				}
				if(raiz.getDerecho()!=null){
					insert(nuevoValor, raiz.getDerecho());
				}
			}
		}
	}
	
	public boolean delete(Integer valorABorrar, Nodo raiz, Nodo padre){
		if(!this.hasElem(valorABorrar, raiz)){
			return false;
		}
		if(raiz.getValor()==valorABorrar){
			if(raiz.getDerecho()==null && raiz.getIzquierdo()==null){ //sin hijos
				raiz.setValor(null);
				return true;
			}
			if(raiz.getDerecho()==null && raiz.getIzquierdo()!=null){
				//si padre hijo derecho == raiz
				if(padre.getDerecho()==raiz){
					//padre hijo derecho == raiz.unicoHijo
					padre.setDerecho(raiz.getIzquierdo());
				}
				//si padre hijo izquierdo == raiz
				if(padre.getIzquierdo()==raiz){
					//padre hijo izquierdo == raiz.unicoHijo
					padre.setIzquierdo(raiz.getIzquierdo());
				}
				raiz.setValor(null);
				return true;
			}
			if(raiz.getDerecho()!=null && raiz.getIzquierdo()==null){
				//si padre hijo derecho == raiz
				if(padre.getDerecho()==raiz){
					//padre hijo derecho == raiz.unicoHijo
					padre.setDerecho(raiz.getDerecho());
				}
				//si padre hijo izquierdo == raiz
				if(padre.getIzquierdo()==raiz){
					//padre hijo izquierdo == raiz.unicoHijo
					padre.setIzquierdo(raiz.getDerecho());
				}
				raiz.setValor(null);
				return true;
			}
			if(raiz.getDerecho()!=null && raiz.getIzquierdo()!=null){
				//NMDSI o NMISD
				//encuentro el NMDSI
				Nodo nmdsi = new Nodo();
				nmdsi = raiz.getIzquierdo();
				if(nmdsi.getDerecho()==null){
					nmdsi = nmdsi.getDerecho();
				}
				else{
					while(nmdsi.getDerecho()!=null){
						nmdsi = nmdsi.getDerecho();	
					}
				}
				
				//padre apunta al NMISD
				if(padre.getDerecho()==raiz){
					padre.setDerecho(nmdsi);	
				}
				
				if(padre.getIzquierdo()==raiz){
					padre.setIzquierdo(nmdsi);	
				}
				
				//reemplaza el numero a borrar con este
				Nodo hijoIzquierdo = new Nodo();
				Nodo hijoDerecho = new Nodo();
				
				hijoIzquierdo = raiz.getIzquierdo();
				hijoDerecho = raiz.getDerecho();
				
				nmdsi.setDerecho(hijoDerecho);
				nmdsi.setIzquierdo(hijoIzquierdo);
				
				raiz.setValor(null);
				raiz.setDerecho(null);
				raiz.setIzquierdo(null);
				
				return true;
			}
		}

		boolean subarbolIzquierdo = delete(valorABorrar, raiz.getIzquierdo(), raiz);
		boolean subarbolDerecho = delete(valorABorrar, raiz.getDerecho(), raiz);
		
		return subarbolIzquierdo || subarbolDerecho;
	}
	
	public Integer getHeight(Nodo raiz){
		if (raiz == null) {
	        return 0;
	    }
		else{
			int alturaIzquierda = getHeight(raiz.getIzquierdo());
	        int alturaDerecha = getHeight(raiz.getDerecho());
	        
	        if (alturaIzquierda > alturaDerecha) {
	            return alturaIzquierda + 1;
	        } else {
	            return alturaDerecha + 1;
	        }
		}
	}
	
	
	public void printPreOrder(Nodo raiz){
		if (raiz != null) {
	        System.out.print(raiz.getValor() + " "); 
	        printPreOrder(raiz.getIzquierdo()); 
	        printPreOrder(raiz.getDerecho()); 
	    }
	}
	
	public void printInOrder(Nodo raiz){
		if (raiz != null) { 
	        printInOrder(raiz.getIzquierdo());
	        System.out.print(raiz.getValor() + " ");
	        printInOrder(raiz.getDerecho()); 
	    }
	}
	
	public void printPosOrder(Nodo raiz){
		if (raiz != null) { 
	        printPosOrder(raiz.getIzquierdo());
	        printPosOrder(raiz.getDerecho()); 
	        System.out.print(raiz.getValor() + " ");
	    }
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
	    
	    return izquierdo + head + " " + derecho;
	}
}
