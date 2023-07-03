package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Parte1.Arco;

public class Main {

	public static void main(String[] args) {
		
		Timer timerBacktracking = new Timer();
		Timer timerGreedy = new Timer();
		
		String path1 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset1.txt";
		String path2 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset2.txt";
		String path3 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset3.txt";
		String path4 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset4.txt";
	
		CSVReader<Integer> reader = new CSVReader<>(path1);
		
		GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
		
		reader.read(grafo);
		
		Backtracking backtracking = new Backtracking(grafo,440);
		
		ArrayList<Arco<String>> solucion = new ArrayList<>();
		
		
		//Cargo todos los vertices en la lista de estaciones a visitar
		Iterator<Integer> it = grafo.obtenerVertices();
//		String primeraEstacion = it.next();
		
		//Map<String,Integer> visitadas = new HashMap<>();
		List<String> visitadas = new ArrayList<>();
//		visitadas.add(primeraEstacion);
		
		Greedy<Integer> greedy = new Greedy<Integer>();
		
		timerGreedy.start();
		greedy.aplicarGreedy(grafo);
		double tiempoGreedy = timerGreedy.stop();
		
		System.out.println("Greedy");
		System.out.println(greedy.getRedSubterraneos());
		System.out.println(greedy.getSuma() + " kms");
		System.out.println(greedy.getContadorGreedy() + " metrica" );
		System.out.println(tiempoGreedy + " tiempo de greedy" );
//		
//		
//		timerBacktracking.start();
//		backtracking.back();
//		double tiempoBacktracking = timerBacktracking.stop();
//		long ciclos = backtracking.getContadorCiclos();
//		
//
//		System.out.println("Mi red de subte queda: "+backtracking.getRedSubterraneo());
//		System.out.println("La longitud red de subte queda: "+backtracking.getLongitudSubterraneo());
//		System.out.println("El tiempo del backtracking es: "+tiempoBacktracking);
//		System.out.println("Ciclos del backtracking es: " + ciclos);

	}

} 
