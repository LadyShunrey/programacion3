package Parte2;

import java.util.ArrayList;
import java.util.Iterator;

import Parte1.Arco;

public class Main {

	public static void main(String[] args) {
		
		GrafoNoDirigido<String> grafo = new GrafoNoDirigido<String>();
		
		String path = "/TrabajoPracticoEspecial/src/Datasets/dataset1.txt";
		
		CSVReader<Integer> reader = new CSVReader<Integer>(path);
		
		reader.read(grafo);
		
		Backtracking<String> backtracking = new Backtracking<>();
		
		/*grafoInicial, estacion actual, metrosConstruidos, solucionParcial*/
		String primerEstacion = grafo.obtenerVertices().next(); 
		
		if (backtracking.backtracking(grafo, primerEstacion, 0, new ArrayList<Arco<String>>())){
			System.out.println(backtracking.getRedSubterraneo());
		}
	}

} 
