package Parte2;

import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;

public class Main {

	public static void main(String[] args) {
		
		GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();
		
		String path1 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset1.txt";
//		String path2 = "C:\\Users\\shunr\\workspace3\\TrabajoPracticoEspecial\\src\\Datasets\\dataset2.txt";
		
		CSVReader<String> reader = new CSVReader<>(path1);
		
		reader.read(grafo);
		
		Backtracking<String> backtracking = new Backtracking<>();
		
		/*grafoInicial, estacion actual, metrosConstruidos, solucionParcial*/
		String primerEstacion = grafo.obtenerVertices().next(); 
		
		ArrayList<Arco<String>> solucion = new ArrayList<>();
		
//		solucion.add(primerEstacion);
		
		backtracking.backtracking(grafo, primerEstacion, 0, solucion);
		System.out.println("Mi red de subte queda: "+backtracking.getRedSubterraneo());
		System.out.println("La longitud red de subte queda: "+backtracking.longitudRedSubterraneo);
	}

} 
