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
//		String path4 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset4.txt"; 
		/*Este último dataset se agregó a modo de prueba, es más largo que el 2 pero no tanto como el 3*/
	
		CSVReader<Integer> reader = new CSVReader<>(path1);
		
		GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
		
		reader.read(grafo);
		
		

		
		
		
		Greedy<Integer> greedy = new Greedy<Integer>();
//		
		timerGreedy.start();
		greedy.aplicarGreedy(grafo);
		double tiempoGreedy = timerGreedy.stop();
		
//		int longitudGreedy = greedy.getSuma();
		
		System.out.println("Greedy");
		System.out.println(greedy.getRedSubterraneos());
		System.out.println(greedy.getSuma() + " kms");
		System.out.println(greedy.getContadorGreedy() + " metrica" );
		System.out.println(tiempoGreedy + " tiempo de greedy" );
		
		Backtracking backtracking = new Backtracking(grafo,500); /*longitudGreedy*/
		timerBacktracking.start();
		backtracking.back();
		double tiempoBacktracking = timerBacktracking.stop();
		long ciclos = backtracking.getContadorCiclos();
		

		System.out.println("Mi red de subte queda: "+backtracking.getRedSubterraneo());
		System.out.println("La longitud red de subte queda: "+backtracking.getLongitudSubterraneo());
		System.out.println("El tiempo del backtracking es: "+tiempoBacktracking);
		System.out.println("Ciclos del backtracking es: " + ciclos);

	}

} 
