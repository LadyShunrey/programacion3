package Redoing;

import java.util.ArrayList;

public class EJ_01 {
	private static ArrayList<ArrayList<String>> soluciones = new ArrayList<>();
	private static ArrayList<String> solucionesParciales = new ArrayList<>();
	static int menorCantidadDeSaltos = 0;
	
	public static void main(String[] args) {
		GrafoDirigido salas = new GrafoDirigido();
		String salaEntrada = "1";
		String salaSalida = "100";
		int cantidadDeSaltosHastaAhora = 0;

		salas.agregarVertice(salaEntrada);
		salas.agregarVertice("7");
		salas.agregarVertice("-5");
		salas.agregarVertice("14");
		salas.agregarVertice("-12");
		salas.agregarVertice("-26");
		salas.agregarVertice("37");
		salas.agregarVertice("11");
		salas.agregarVertice("9");
		salas.agregarVertice("20");
		salas.agregarVertice(salaSalida);
		
		salas.agregarArco(salaEntrada, "7");
		salas.agregarArco("7", "-12");
		salas.agregarArco("7", "20");
		salas.agregarArco("20", salaSalida);
		
		backtracking(salaEntrada, salaSalida, salas, cantidadDeSaltosHastaAhora);
		System.out.println(solucionesParciales);
		System.out.println(soluciones);
	}
	
	public static void backtracking(String verticeEntrada, String verticeSalida, GrafoDirigido salas, int saltos){
		//me paro en un vertice
		//pido los adyacentes
		ArrayList<String> conexiones = new ArrayList<>();
		conexiones.addAll(salas.obtenerConexiones(verticeEntrada));
		//itero los adyacentes
		//agarro el primero de los adyacentes
		for(String verticeAdyacente: conexiones){
			System.out.println("soluciones parciales: "+solucionesParciales);
			System.out.println("soluciones: "+soluciones);
			System.out.println("menor saltos: "+menorCantidadDeSaltos);
			System.out.println("saltos: "+saltos);
			//pregunto si ese es el de destino
			if (verticeAdyacente.equals(verticeSalida)){
				//si es el destino
				//lo agrego a la lista si no esta todavia
				if(!solucionesParciales.contains(verticeAdyacente)){
					solucionesParciales.add(verticeAdyacente);
					//copio parciales y lo vacio
					ArrayList<String> solucionEncontrada = new ArrayList<>();
					solucionEncontrada.addAll(solucionesParciales);
					soluciones.add(solucionEncontrada);
					solucionesParciales.clear();;
					saltos++;
					if(saltos<=menorCantidadDeSaltos){
						menorCantidadDeSaltos = saltos;
						saltos = 0;
					}
				}
				//termino
				return;
			}
			//si NO es el destino
			if(!verticeAdyacente.equals(verticeSalida)){
				//lo agrego a la solucion parcial si todavia no esta
				if(!solucionesParciales.contains(verticeAdyacente)){
					solucionesParciales.add(verticeAdyacente);
					saltos++;
				}
				//le pido a ese su backtrack.
				if(!podar(saltos)){
					backtracking(verticeAdyacente, verticeSalida, salas, saltos);	
				}
				if(podar(saltos)){
					return;
				}
			}
		}
	}
	
	public static boolean podar(int saltos){
		if(saltos>menorCantidadDeSaltos){
			return true;
		}
		return false;
	}
}
