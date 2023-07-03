package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Parte1.Arco;

public class Backtracking {
	private GrafoNoDirigido<Integer> grafo;
	private List<Arco<Integer>> redSubterraneo;
	private Integer longitudSubterraneo;
	private int sumaParcial;
	private List<Arco<Integer>> arcos;
	private List<Arco<Integer>> solucionParcial;
	private int contadorCiclos;
	private double tiempoBacktracking;

	public Backtracking(GrafoNoDirigido<Integer> grafo, int maxValue) {
		this.grafo = grafo;
		this.redSubterraneo = new LinkedList<>();
		this.longitudSubterraneo = Integer.MAX_VALUE;
		this.arcos = new ArrayList<>();
		inicializarArcos();
		this.solucionParcial = new LinkedList<>();
		this.contadorCiclos = 0;
	}
	
	public Integer getLongitudSubterraneo() {
		return longitudSubterraneo;
	}

	public void setLongitudSubterraneo(Integer longitudSubterraneo) {
		this.longitudSubterraneo = longitudSubterraneo;
	}

	public List<Arco<Integer>> getRedSubterraneo() {
		return redSubterraneo;
	}

	public void setRedSubterraneo(List<Arco<Integer>> redSubterraneo) {
		this.redSubterraneo = redSubterraneo;
	}

	public double getTiempoBacktracking() {
		return tiempoBacktracking;
	}

	public int getContadorCiclos() {
		return this.contadorCiclos;
	}
	public List<Arco<Integer>> getSolucionParcial() {
		return this.solucionParcial;
	}

	public List<Arco<Integer>> getArcos() {
		return this.arcos;
	}

	public void setArcos(List<Arco<Integer>> arcos) {
		this.arcos = arcos;
	}

	public int getSumaParcial() {
		return this.sumaParcial;
	}

	public void sumarASumaParcial(Arco<Integer> arco) {
		this.sumaParcial += arco.getEtiqueta();

	}

	public void RestarDeSumaParcial(Arco arco) {
		this.sumaParcial -= arco.getEtiqueta();
	}

	public Integer getCostoMenor() {
		return this.longitudSubterraneo;
	}

	public void inicializarArcos() {
		Iterator<Arco<Integer>> itArcos = grafo.obtenerArcos();
		while (itArcos.hasNext()) {
			Arco<Integer> a = itArcos.next();
			arcos.add(a);
		}
	}

	public List<Arco<Integer>> back() {
		Timer timerBacktracking = new Timer();
		timerBacktracking.start();
		back(arcos, solucionParcial, sumaParcial);
		tiempoBacktracking = timerBacktracking.stop();
		return redSubterraneo;
	}

	private void back(List<Arco<Integer>> arcos, List<Arco<Integer>> solucionParcial, int sumaParciall) {
		contadorCiclos++;
		if (arcos.isEmpty() ) {
			if (esConexo() && (!solucionParcial.isEmpty())) {
					if (sumaParcial < longitudSubterraneo) {
						longitudSubterraneo = sumaParcial;
						redSubterraneo.clear();
						redSubterraneo.addAll(solucionParcial);
						System.out.println(" *****************************************************************************");
						System.out.println(" ****************************** Tengo un resultado ***************************");
						System.out.println("Red de subte en construccion: " + solucionParcial);
						System.out.println("Longitud de la red de subte en construccion: " + sumaParcial);
						System.out.println("Cantidad de iteraciones: " + contadorCiclos);
						System.out.println(" *****************************************************************************");
						System.out.println(" *****************************************************************************");
					}
			}
		} else {
			
			Arco<Integer> arco = arcos.get(0);  //Primer arco disponible
			arcos.remove(0); 			//Quitarlo de la lista de arcos disponibles

			//Primer llamado a backtracking
			solucionParcial.add(arco); // Agrega el arco a la solucion parcial
			sumarASumaParcial(arco); // Suma la etiqueta

			//Condicón de poda
			if (sumaParcial < longitudSubterraneo &&  solucionParcial.size() <= grafo.cantidadVertices())      {
				back(arcos, solucionParcial, sumaParcial);
			}
			//Deshacemos la suma del arco y el agregado a la solución parcial
			RestarDeSumaParcial(arco);
			solucionParcial.remove(arco);
			
			//Segundo llamado a backtracking. No agrega arco a la solución parcial
			if (sumaParcial < longitudSubterraneo &&  solucionParcial.size() <= grafo.cantidadVertices()) {
				back(arcos, solucionParcial, sumaParcial);
			}
			
			//Agregamos el arco a la lista 
			arcos.add(0, arco);
		}
	}

	public boolean esConexo() {
		UnionFind componentes = new UnionFind(grafo.cantidadVertices());
		for (Arco<Integer> a : solucionParcial) {
			int u = a.getVerticeOrigen();
			int v = a.getVerticeDestino();
			if (!componentes.connected(u - 1, v - 1))
				componentes.union(u - 1, v - 1);
		}
		return (componentes.getTotal()==1);
	}

}
