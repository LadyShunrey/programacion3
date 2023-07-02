package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Parte1.Arco;

public class Main {

	public static void main(String[] args) {
		
		GrafoNoDirigido2<String> grafo = new GrafoNoDirigido2<>();
		
		String path1 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset1.txt";
		String path2 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset2.txt";
		String path3 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset3.txt";
		String path4 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset4.txt";
	
		CSVReader<String> reader = new CSVReader<>(path3);
		
		reader.read(grafo);
		
		Backtracking<String> backtracking = new Backtracking<>();
		
		ArrayList<Arco<String>> solucion = new ArrayList<>();
		
		
		//Cargo todos los vertices en la lista de estaciones a visitar
		Iterator<String> it = grafo.obtenerVertices();
		String primeraEstacion = it.next();
		
		//Map<String,Integer> visitadas = new HashMap<>();
		List<String> visitadas = new ArrayList<>();
		visitadas.add(primeraEstacion);
		Timer timerBacktracking = new Timer();
		timerBacktracking.start();
		backtracking.backtracking(grafo, primeraEstacion, 0, solucion, visitadas);
		double tiempoBacktracking = timerBacktracking.stop();                        
		

		System.out.println("Mi red de subte queda: "+backtracking.getRedSubterraneo());
		System.out.println("La longitud red de subte queda: "+backtracking.longitudRedSubterraneo);
		System.out.println("El tiempo del backtracking es: "+tiempoBacktracking);

	}

} 
