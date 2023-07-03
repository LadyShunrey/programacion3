package Parte2;

import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;

public class Main {

	public static void main(String[] args) {
		Timer timerBacktracking = new Timer();
		Timer timerGreedy = new Timer();
		
		GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();
		
		String path1 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset1.txt";
		String path2 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset2.txt";
		String path3 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset3.txt";
		
		CSVReader<String> reader = new CSVReader<>(path1);

		reader.read(grafo);
		
		Backtracking<String> backtracking = new Backtracking<>();
		
		/*grafoInicial, estacion actual, metrosConstruidos, solucionParcial*/
		String primerEstacion = grafo.obtenerVertices().next(); 
		
		ArrayList<Arco<String>> solucion = new ArrayList<>();
		
//		solucion.add(primerEstacion);
		ArrayList<String> estacionesVisitadas = new ArrayList<>();
//		estacionesVisitadas.add(primerEstacion);
		
		
		timerBacktracking.start();
		backtracking.backtracking(grafo, null, 0, solucion, estacionesVisitadas);
		double tiempoBacktracking = timerBacktracking.stop();
		
		System.out.println("Mi red de subte queda: "+backtracking.getRedSubterraneo());
		System.out.println("La longitud red de subte queda: "+backtracking.longitudRedSubterraneo);
		System.out.println("El tiempo del backtracking es: "+tiempoBacktracking);
		
		
		
		Greedy<String> greedy = new Greedy<String>();
		
		timerGreedy.start();
		greedy.aplicarGreedy(grafo);
		double tiempoGreedy = timerGreedy.stop();
		
		System.out.println("Greedy");
		System.out.println(greedy.getRedSubterraneos());
		System.out.println(greedy.getSuma() + " kms");
		System.out.println(greedy.getContadorGreedy() + " metrica" );
		System.out.println(tiempoGreedy + " tiempo de greedy" );
//		
	}

} 
