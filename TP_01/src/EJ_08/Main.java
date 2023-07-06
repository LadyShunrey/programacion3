package EJ_08;

public class Main {

	public static void main(String[] args) {
		
		NodoDoblementeVinculado<String> ultimo = new NodoDoblementeVinculado<>("ultimo", null);
		NodoDoblementeVinculado<String> tercero = new NodoDoblementeVinculado<>("tercero", ultimo);
		NodoDoblementeVinculado<String> segundo = new NodoDoblementeVinculado<>("segundo", tercero);
		NodoDoblementeVinculado<String> primero = new NodoDoblementeVinculado<>("primero", segundo);
		
		System.out.println(primero);
		System.out.println(segundo);
		System.out.println(tercero);
		System.out.println(ultimo);
		
		ListaDoblementeVinculada<String> listaDoblementeVinculada = new ListaDoblementeVinculada<>();
		
		listaDoblementeVinculada.insertFront(ultimo);
		listaDoblementeVinculada.insertFront(tercero);
		listaDoblementeVinculada.insertFront(segundo);
		listaDoblementeVinculada.insertFront(primero);
		
		System.out.println(listaDoblementeVinculada);
		
		NodoDoblementeVinculado<String> actual = listaDoblementeVinculada.getPrimerNodo();
		
		while(actual.getNext()!=null){
			System.out.println("el actual es: "+actual +" y su anterior es: " + actual.getAnterior());
			actual = actual.getNext();
		}
		System.out.println("el actual es: "+actual +" y su anterior es: " + actual.getAnterior());
	}
}
