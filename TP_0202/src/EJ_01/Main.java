package EJ_01;

public class Main {

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
		
		System.out.println(arbol);
		
		System.out.println(arbol.hasElem(5, ocho));
		
		System.out.println(cuatro.getDerecho());
		
		arbol.insert(5, ocho);
		
		System.out.println(arbol.hasElem(5, ocho));
		
		System.out.println(cuatro.getDerecho());
		
		System.out.println(arbol.getHeight(ocho));
		
	}

}
