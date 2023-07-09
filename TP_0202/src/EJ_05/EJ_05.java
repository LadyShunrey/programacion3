package EJ_05;
import java.util.ArrayList;
/*Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del
árbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
que posea exactamente N vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con
una entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N = 2, debería
retornar [“MANA”, “MANO”, “MISA”].
*/

public class EJ_05 {
	private static ArrayList<ArrayList<Nodo>> solucion = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Nodo a3 = new Nodo('a');
		Nodo o2 = new Nodo('o');
		Nodo a2 = new Nodo('a');
		
		Nodo o = new Nodo('o');
		Nodo s = new Nodo('s', null, a3);
		
		Nodo n = new Nodo('n', a2, o2);
		Nodo l = new Nodo('l');
		
		Nodo i = new Nodo('i', s, o);
		Nodo a = new Nodo('a', l, n);
		
		//Raiz
		Nodo m = new Nodo('m', a, i);
		
		
		//Árbol
		ArbolBinarioCaracter arbol = new ArbolBinarioCaracter(m);
		
		System.out.println(arbol);
		ArrayList<Nodo> solucionParcial = new ArrayList<>();
		
		imprimirRama(m, solucionParcial);
		System.out.println("Todas las ramas: "+solucion);
		solucion.clear();
		
		int vocalesPermitidas = 1;
		imprimirRamaConVocales(m, solucionParcial, vocalesPermitidas);
		System.out.println("Todas las ramas con una sola vocal: "+solucion);
		solucion.clear();
		
		vocalesPermitidas = 2;
		imprimirRamaConVocales(m, solucionParcial, vocalesPermitidas);
		System.out.println("Todas las ramas con dos vocales: "+solucion);
	}
	
	//imprimir cada rama entera
	public static void imprimirRama(Nodo raiz, ArrayList<Nodo> solucionParcial){
		solucionParcial.add(raiz);
		if(raiz.getDerecho()==null && raiz.getIzquierdo()==null){
			ArrayList<Nodo> aux = new ArrayList<>();
			for(Nodo nodo: solucionParcial){
				aux.add(nodo);
			}
			solucion.add(aux);
		}
		if(raiz.getIzquierdo()!=null){
			imprimirRama(raiz.getIzquierdo(), solucionParcial);
		}
		
		if(raiz.getDerecho()!=null){
			imprimirRama(raiz.getDerecho(), solucionParcial);
		}
		solucionParcial.remove(raiz);	
	}
	
	//imprimirramaconvocal
	public static void imprimirRamaConVocales(Nodo raiz, ArrayList<Nodo> solucionParcial, int vocalesPermitidas){
		solucionParcial.add(raiz);
		if(raiz.getDerecho()==null && raiz.getIzquierdo()==null){
			int contador = 0;
			for(Nodo nodo: solucionParcial){
				if (nodo.getValor()=='a'){
					System.out.println("Contiene a");
					contador++;
				}
				if (nodo.getValor()=='e'){
					System.out.println("Contiene e");
					contador++;
				}
				if (nodo.getValor()=='i'){
					System.out.println("Contiene i");
					contador++;
				}
				if (nodo.getValor()=='o'){
					System.out.println("Contiene o");
					contador++;
				}
				if (nodo.getValor()=='u'){
					System.out.println("Contiene u");
					contador++;
				}
			}
			System.out.println("Esta palabra tiene vocales: " + contador);
			if(contador==vocalesPermitidas){
				ArrayList<Nodo> aux = new ArrayList<>();
				for(Nodo nodo: solucionParcial){
					aux.add(nodo);
				}
				solucion.add(aux);			
			}
		}
		if(raiz.getIzquierdo()!=null){
			imprimirRamaConVocales(raiz.getIzquierdo(), solucionParcial, vocalesPermitidas);
		}
		
		if(raiz.getDerecho()!=null){
			imprimirRamaConVocales(raiz.getDerecho(), solucionParcial, vocalesPermitidas);
		}
		solucionParcial.remove(raiz);	
	}
}
