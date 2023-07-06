package EJ_06;
import java.util.ArrayList;
import java.util.Iterator;

/*Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar
ordenada. b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.*/

public class ListaCombinada<T>{ //podría ser un método en la clase ListaVinculada mejor la verdad
	ArrayList<Integer> listaImpar;
	ArrayList<Integer> listaPar;
	ArrayList<Integer> listaCombinada;
	
	public ListaCombinada(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		listaCombinada = new ArrayList<Integer>();
		
		if(!estaOrdenada(lista1)){
			System.out.println("lista 1 no está ordenada");
			ordenar(lista1);
		}
		if(!estaOrdenada(lista2)){
			System.out.println("lista 2 no está ordenada");
			ordenar(lista2);
		}
		
		this.combinar(lista1, lista2);
	}
	
	public boolean estaOrdenada(ArrayList<Integer> lista){
		Iterator<Integer> iterador = lista.iterator();
		while(iterador.hasNext()){
			Integer actual = iterador.next();
			if(iterador.hasNext()){
				if(actual>iterador.next()){
					return false;
				}
			}
		}
		return true;
	}
	
	public void ordenar(ArrayList<Integer> lista){
		int size = lista.size();
		for(int i = 0; i<size-1; i++){
			int minIndex = i;
			for(int j = i+1; j<size; j++){
				System.out.println("i vale: "+ i + " y j vale: "+ j + " y size: " + size + " y la lista: " + lista);
				if(lista.get(j)<lista.get(minIndex)){
					minIndex = j;
				}
			}
			int aux = lista.get(i);
			lista.set(i, lista.get(minIndex));
			lista.set(minIndex, aux);
		}
	}
	
	public void combinar(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		
		//recorro y traigo
		Iterator<Integer> iterador1 = lista1.iterator();
		Iterator<Integer> iterador2 = lista2.iterator();
		
		Integer uno = iterador1.next();
		Integer dos = iterador2.next();
		
		while (uno!=null || dos!=null){
			
			System.out.println(uno);	
			System.out.println(dos);
			
			if(uno==null && dos!=null){
				if(!listaCombinada.contains(dos)){
					listaCombinada.add(dos);
				}
				if(iterador2.hasNext()){
					dos = iterador2.next();	
				}
				else{
					dos = null;
				}
			}
			if(dos==null && uno!=null){
				if(!listaCombinada.contains(uno)){
					listaCombinada.add(uno);
				}
				if(iterador1.hasNext()){
					uno = iterador1.next();	
				}
				else{
					uno = null;
				}
			}
			
			if (uno!=null && dos!=null){
				if(uno<dos){
					if(!listaCombinada.contains(uno)){
						listaCombinada.add(uno);
						System.out.println(listaCombinada);
					}
					if(iterador1.hasNext()){
						uno = iterador1.next();	
					}
					else{
						uno = null;
					}
				}
				else if(uno==dos){
					if(!listaCombinada.contains(uno)){
						listaCombinada.add(uno);
					}
					if(!listaCombinada.contains(dos)){
						listaCombinada.add(dos);
					}
					System.out.println(listaCombinada);
				}
				else if(uno>dos){
					if(!listaCombinada.contains(dos)){
						listaCombinada.add(dos);
						System.out.println(listaCombinada);
					}
					if(iterador2.hasNext()){
						dos = iterador2.next();	
					}
					else{
						dos = null;
					}	
				}	
			}
		}
	}
	
	@Override
	public String toString(){
		String result;
		result = "Mi lista tiene estos elementos: ";
		Iterator<Integer> iteradorLista = listaCombinada.iterator();
		Integer head = iteradorLista.next();
		if(head!=null){
			result += "[" + head + "]";
			while(iteradorLista.hasNext()){
				head = iteradorLista.next();
				result += ", ["+head+ "]";	
			}	
		}
		return result +=".";
	}
}
