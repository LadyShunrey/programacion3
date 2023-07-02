package Parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class GrafoAbstracto<T> {
	protected HashMap<T, ArrayList<ArcoAbstracto<T>>> compGrafo;
	protected int cantArcos;
	
	//Complejidad: O(1) 
	public void agregarVertice(T verticeId){
		compGrafo.putIfAbsent(verticeId, new ArrayList<ArcoAbstracto<T>>());
	}
	
	//Complejidad: O(m)  m->cantidad de arcos
	public void borrarVertice(T verticeId){
		for(ArcoAbstracto<T> a: compGrafo.get(verticeId)) {
			if(a.getVerticeDestino()==verticeId && a.getVerticeOrigen()==verticeId) {
				compGrafo.get(verticeId).remove(a);
		}
	}
		compGrafo.remove(verticeId);
	}
	
	//Complejidad: O(1)
	public abstract void agregarArco(T verticeId1, T verticeId2, int etiqueta);
	
	//Complejidad : O(m) m-> cantidad de arcos
	public abstract void borrarArco(T verticeId1, T verticeId2);
	
	//Complejidad : O(1)
	public boolean contieneVertice(T verticeId){
		return compGrafo.containsKey(verticeId);
	}
	
	//Complejidad : O(m) m-> cantidad de arcos
	public boolean existeArco(T verticeId1, T verticeId2){
		boolean existe=false;
		ArcoAbstracto<T> a = new ArcoAbstracto<T>(verticeId1, verticeId2, null);
		for(ArcoAbstracto<T> ar: compGrafo.get(verticeId1)) {
			if(a.equals(ar)) {
				existe=true;
			}else {
				existe=false;
			}
		}
		return existe;
	}
	
	//Complejidad : O(m ) m-> cantidad de arcos
	public ArcoAbstracto<T> obtenerArco(T verticeId1, T verticeId2){
		ArcoAbstracto<T> a = new ArcoAbstracto<T>(verticeId1, verticeId2, null);
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<ArcoAbstracto<T>>arcos =compGrafo.get(verticeId1);
			for(ArcoAbstracto<T> arco : arcos) {
				if(arco.getVerticeDestino().equals(verticeId2)) { //FIXME FIXME para que ande tambien en GND
					return arco;
				}
			}
		}
		return null;
	}
	
	//Complejidad: O(1)
	public int cantidadVertices(){
		return compGrafo.keySet().size();
	}
	
	
	public int cantidadArcos(){
		return cantArcos;
	}
	
	//Complejidad: O(1)
	public Iterator<T> obtenerVertices(){
		return compGrafo.keySet().iterator();
	}
	
	//Complejidad : O(m) m-> cantidad de arcos
	public Iterator<T> obtenerAdyacentes(T verticeId){
		ArrayList<T> ady = new ArrayList<>();
		if(compGrafo.containsKey(verticeId)) {
			for(ArcoAbstracto<T> arcos : compGrafo.get(verticeId)) {
				ady.add(arcos.getVerticeDestino());
			}
			}
		return ady.iterator();
	}
	
	//Complejidad : O(n+m) n->cantidad de vertices m-> cantidad de arcos
	public Iterator<ArcoAbstracto<T>> obtenerArcos(){
		ArrayList<ArcoAbstracto<T>> arcos=new ArrayList<>();
		for(Entry<T, ArrayList<ArcoAbstracto<T>>> key : compGrafo.entrySet()) {
			arcos.addAll(key.getValue());
		}
		return arcos.iterator();
	}
	
	//Complejidad : O(1)
	public Iterator<ArcoAbstracto<T>> obtenerArcos(T verticeId){
		ArrayList<ArcoAbstracto<T>> values = compGrafo.get(verticeId);
		return values.iterator();	
	}
	
}
