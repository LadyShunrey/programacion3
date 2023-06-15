package EJ_01;

import java.util.List;

public class ArbolBinario<T> {
	
	private Nodo raiz;
	
	public ArbolBinario(){
		
	}
	
	public Integer getRoot(){
		return raiz.getClave();
	}
	
	public boolean hasElem(Integer num, Nodo nodo){
		
		if(nodo == null){
			return false;
		}
		
		if(num == nodo.getClave()){
			return true;
		}
		
		if(num > nodo.getClave()){
			return hasElem(num, nodo.getNodoDerecho());	
		}
		
		if(num < nodo.getClave()){
			return hasElem(num, nodo.getNodoIzquierdo());
		}
		
		return false;
	}
	
	public boolean isEmpty(){
		if(raiz.getClave()!=null){
			return false;
		}
		return true;
	}
	
	public void insert(Integer num){
		boolean yaExiste = hasElem(num, raiz);
		if(isEmpty()==false){
			
			if(yaExiste == true){
				System.out.println("El numero que esta ingresando ya está en el árbol");
			}
			
			if(yaExiste == false){
				insertarOrdenado(num, raiz);
			}	
		}
		else{
			raiz = new Nodo(num);
		}
		
	}

	public void insertarOrdenado(Integer num, Nodo nodo){
		
		if(num>nodo.getClave()){
			if(nodo.getNodoDerecho() == null){
				nodo.setNodoDerecho(num);
			}
			insertarOrdenado(num, nodo.getNodoDerecho());
		}
		
		if(num<nodo.getClave()){
			if(nodo.getNodoIzquierdo() == null){
				nodo.setNodoIzquierdo(num);
			}
			insertarOrdenado(num, nodo.getNodoIzquierdo());
		}
	}
	
	public boolean delete(Integer num){
		if(isEmpty()==true){
			return false;
		}
		if(hasElem(num, raiz)==false){
			return false;
		}
		borrarNodo(num, raiz, null);
		return false;
	}
	
	public boolean borrarNodo(Integer num, Nodo nodo, Nodo anterior){
		Nodo padre = anterior;
		if (nodo.getClave() == num){

			//si no tiene hijos
			if((nodo.getNodoDerecho()==null) && (nodo.getNodoIzquierdo()==null)){
				//borrar directamente
				if(padre.getNodoDerecho().getClave() == num){
					padre.setNodoDerecho(null);
				}
				if(padre.getNodoIzquierdo().getClave() == num){
					padre.setNodoIzquierdo(null);
				}
			}
			//si tiene 1 hijo
			if(((nodo.getNodoDerecho()!=null) && (nodo.getNodoIzquierdo()==null)) || ((nodo.getNodoDerecho()==null) && (nodo.getNodoIzquierdo()!=null))){
				//el padre ahora apunta al hijo
				if(padre.getNodoDerecho().getClave() == num){
					if(nodo.getNodoDerecho()!=null){
						padre.setNodoDerecho(nodo.getNodoDerecho().getClave());	
					}
					if(nodo.getNodoIzquierdo()!=null){
						padre.setNodoIzquierdo(nodo.getNodoIzquierdo().getClave());
					}
				}
				if(padre.getNodoIzquierdo().getClave() == num){
					if(nodo.getNodoDerecho()!=null){
						padre.setNodoDerecho(nodo.getNodoDerecho().getClave());	
					}
					if(nodo.getNodoIzquierdo()!=null){
						padre.setNodoIzquierdo(nodo.getNodoIzquierdo().getClave());
					}
				}
			}
			//si tiene 2 hijos
			if((nodo.getNodoDerecho()!=null) && (nodo.getNodoIzquierdo()!=null)){
				//reemplazo con el NMI
				//busco el NMI del subarbol derecho
				Nodo nodoMasDerecho = null;
				Nodo hijoDerecho = nodo.getNodoDerecho();
				Nodo hijoIzquierdo = nodo.getNodoIzquierdo();
				nodo = nodo.getNodoIzquierdo();
				while (nodo.getNodoDerecho()!=null){
					nodo = nodo.getNodoDerecho();
					if(nodo.getNodoDerecho() == null){
						nodoMasDerecho = nodo;
						nodo = null;
					}
				}
				padre.setNodoIzquierdo(nodoMasDerecho.getClave());
				nodoMasDerecho.setNodoIzquierdo(hijoIzquierdo.getClave());
				nodoMasDerecho.setNodoDerecho(hijoDerecho.getClave());
			}
			
			return true;
		}
		if(num > nodo.getClave()){
			return borrarNodo(num, nodo.getNodoDerecho(), nodo);
		}
		if(num < nodo.getClave()){
			return borrarNodo(num, nodo.getNodoIzquierdo(), nodo);
		}
		return false;
	}
	
	public int getHeight(){
		return 0;
	}
	
	public void printPosOrder(Nodo nodo){
		if(nodo==null){
			return;
		}
		printPosOrder(nodo.getNodoIzquierdo());
		printPosOrder(nodo.getNodoDerecho());
		System.out.println("la clave es " + nodo.getClave());
	}
	
	public void printPreOrder(Nodo nodo){
		if(nodo==null){
			return;
		}
		System.out.println("la clave es " + nodo.getClave());
		printPreOrder(nodo.getNodoIzquierdo());
		printPreOrder(nodo.getNodoDerecho());
	}
	
	public void printInOrder(Nodo nodo){
		if(nodo==null){
			return;
		}
		printPosOrder(nodo.getNodoIzquierdo());
		System.out.println("la clave es " + nodo.getClave());
		printPosOrder(nodo.getNodoDerecho());
	}
	
	public List<T> getLongestBranch(){
		return null;
	}
	
	public List<T> getFrontera(){
		return null;
	}
	
	public Integer getMaxElem(){
		return null;
	}
	
	public List<T> getElemAtLevel(int num){
		return null;
	}
}
