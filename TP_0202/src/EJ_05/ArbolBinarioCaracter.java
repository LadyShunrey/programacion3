package EJ_05;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioCaracter {
	
	private Nodo raiz;
	
	public ArbolBinarioCaracter(){
		this.raiz = null;
	}
	
	public ArbolBinarioCaracter(Nodo raiz){
		this.raiz = raiz;
	}
	
	public char getRoot(){
		return raiz.getValor();
	}
	
	public boolean hasElem(char valorBuscado, Nodo raiz){
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
	
//	public void insert(String nuevoValor, Nodo raiz){
//		if(!this.hasElem(nuevoValor, raiz)){
//			if(nuevoValor<raiz.getValor()){
//				if(raiz.getIzquierdo()==null){
//					Nodo nuevoNodo = new Nodo(nuevoValor);
//					raiz.setIzquierdo(nuevoNodo);
//				}
//				if(raiz.getIzquierdo()!=null){
//					insert(nuevoValor, raiz.getIzquierdo());
//				}
//			}
//			if(nuevoValor>raiz.getValor()){
//				if(raiz.getDerecho()==null){
//					Nodo nuevoNodo = new Nodo(nuevoValor);
//					raiz.setDerecho(nuevoNodo);
//				}
//				if(raiz.getDerecho()!=null){
//					insert(nuevoValor, raiz.getDerecho());
//				}
//			}
//		}
//	}
	
//	public boolean delete(char valorABorrar, Nodo raiz, Nodo padre){
//		if(!this.hasElem(valorABorrar, raiz)){
//			return false;
//		}
//		if(raiz.getValor()==valorABorrar){
//			if(raiz.getDerecho()==null && raiz.getIzquierdo()==null){ //sin hijos
//				raiz.setValor(null);
//				return true;
//			}
//			if(raiz.getDerecho()==null && raiz.getIzquierdo()!=null){
//				//si padre hijo derecho == raiz
//				if(padre.getDerecho()==raiz){
//					//padre hijo derecho == raiz.unicoHijo
//					padre.setDerecho(raiz.getIzquierdo());
//				}
//				//si padre hijo izquierdo == raiz
//				if(padre.getIzquierdo()==raiz){
//					//padre hijo izquierdo == raiz.unicoHijo
//					padre.setIzquierdo(raiz.getIzquierdo());
//				}
//				raiz.setValor(null);
//				return true;
//			}
//			if(raiz.getDerecho()!=null && raiz.getIzquierdo()==null){
//				//si padre hijo derecho == raiz
//				if(padre.getDerecho()==raiz){
//					//padre hijo derecho == raiz.unicoHijo
//					padre.setDerecho(raiz.getDerecho());
//				}
//				//si padre hijo izquierdo == raiz
//				if(padre.getIzquierdo()==raiz){
//					//padre hijo izquierdo == raiz.unicoHijo
//					padre.setIzquierdo(raiz.getDerecho());
//				}
//				raiz.setValor(null);
//				return true;
//			}
//			if(raiz.getDerecho()!=null && raiz.getIzquierdo()!=null){
//				//NMDSI o NMISD
//				//encuentro el NMDSI
//				Nodo nmdsi = new Nodo();
//				nmdsi = raiz.getIzquierdo();
//				if(nmdsi.getDerecho()==null){
//					nmdsi = nmdsi.getDerecho();
//				}
//				else{
//					while(nmdsi.getDerecho()!=null){
//						nmdsi = nmdsi.getDerecho();	
//					}
//				}
//				
//				//padre apunta al NMISD
//				if(padre.getDerecho()==raiz){
//					padre.setDerecho(nmdsi);	
//				}
//				
//				if(padre.getIzquierdo()==raiz){
//					padre.setIzquierdo(nmdsi);	
//				}
//				
//				//reemplaza el numero a borrar con este
//				Nodo hijoIzquierdo = new Nodo();
//				Nodo hijoDerecho = new Nodo();
//				
//				hijoIzquierdo = raiz.getIzquierdo();
//				hijoDerecho = raiz.getDerecho();
//				
//				nmdsi.setDerecho(hijoDerecho);
//				nmdsi.setIzquierdo(hijoIzquierdo);
//				
//				raiz.setValor(null);
//				raiz.setDerecho(null);
//				raiz.setIzquierdo(null);
//				
//				return true;
//			}
//		}
//
//		boolean subarbolIzquierdo = delete(valorABorrar, raiz.getIzquierdo(), raiz);
//		boolean subarbolDerecho = delete(valorABorrar, raiz.getDerecho(), raiz);
//		
//		return subarbolIzquierdo || subarbolDerecho;
//	}
	
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
	
	public List<Character> getLongestBranch() {
        List<Character> longestBranch = new ArrayList<>();
        findLongestBranch(raiz, new ArrayList<>(), longestBranch);
        return longestBranch;
    }
	
	private void findLongestBranch(Nodo nodo, List<Character> currentBranch, List<Character> longestBranch) {
        if (nodo == null) {
            if (currentBranch.size() > longestBranch.size()) {
                longestBranch.clear();
                longestBranch.addAll(currentBranch);
            }
            return;
        }

        currentBranch.add(nodo.getValor());

        findLongestBranch(nodo.getIzquierdo(), currentBranch, longestBranch);
        findLongestBranch(nodo.getDerecho(), currentBranch, longestBranch);

        currentBranch.remove(currentBranch.size() - 1);
    }
	
	public List<Character> getFrontera() {
        List<Character> frontera = new ArrayList<>();
        findFrontera(raiz, frontera);
        return frontera;
    }

    private void findFrontera(Nodo nodo, List<Character> frontera) {
        if (nodo == null) {
            return;
        }

        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            frontera.add(nodo.getValor());
        }

        findFrontera(nodo.getIzquierdo(), frontera);
        findFrontera(nodo.getDerecho(), frontera);
    }
	
    public Character getMaxElem() {
        if (raiz == null) {
            return null;
        }

        return findMaxElem(raiz);
    }

    private Character findMaxElem(Nodo nodo) {
        if (nodo.getDerecho() == null) {
            return nodo.getValor();
        }

        return findMaxElem(nodo.getDerecho());
    }
	
    public List<Character> getElemAtLevel(int level) {
        List<Character> elements = new ArrayList<>();
        findElemAtLevel(raiz, level, 1, elements);
        return elements;
    }

    private void findElemAtLevel(Nodo nodo, int targetLevel, int currentLevel, List<Character> elements) {
        if (nodo == null) {
            return;
        }

        if (currentLevel == targetLevel) {
            elements.add(nodo.getValor());
        }

        findElemAtLevel(nodo.getIzquierdo(), targetLevel, currentLevel + 1, elements);
        findElemAtLevel(nodo.getDerecho(), targetLevel, currentLevel + 1, elements);
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
