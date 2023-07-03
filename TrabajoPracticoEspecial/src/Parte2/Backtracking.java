package Parte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import Parte1.Arco;

public class Backtracking {
	private GrafoNoDirigido<Integer> grafo;
	private List<Arco<Integer>> redSubterraneo;
	private Integer longitudSubterraneo;
	private int sumaParcial;
	private Set<Arco<Integer>> arcos;
	private List<Arco<Integer>> solucionParcial;
	private long contadorCiclos;
	private double tiempoBacktracking;
	private Map<Integer, Set<Arco<Integer>>> combinatorias;

	private boolean usaPodaAvanzada;

	public Backtracking(GrafoNoDirigido<Integer> grafo, int maxValue) {
		this.grafo = grafo;
		this.redSubterraneo = new LinkedList<>();
		this.longitudSubterraneo = maxValue;
		this.arcos = new HashSet<>();
		inicializarArcos();
		this.solucionParcial = new LinkedList<>();
		this.contadorCiclos = 0;
		usaPodaAvanzada = false;
		combinatorias = new HashMap<Integer, Set<Arco<Integer>>>();
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

	public long getContadorCiclos() {
		return this.contadorCiclos;
	}

	public List<Arco<Integer>> getSolucionParcial() {
		return this.solucionParcial;
	}

	public Set<Arco<Integer>> getArcos() {
		return this.arcos;
	}

	public void setArcos(Set<Arco<Integer>> arcos) {
		this.arcos = arcos;
	}

	public int getSumaParcial() {
		return this.sumaParcial;
	}

	public void sumarASumaParcial(Arco<Integer> arco) {
		this.sumaParcial += arco.getEtiqueta();

	}

	public void RestarDeSumaParcial(Arco<Integer> arco) {
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

	/*
	 * RESULTA DEMASIADO COSTOSA. DEJAMOS APAGADO PARA VER SI SE PUEDE MEJORAR
	 * 
	 * Poda avanzada: Tengo que guardar, por cada nivel de recursion (cantidad de
	 * arcos) las combinatorias ya analizadas para no repetir analisis ya hechos.
	 * Por ejemplo
	 * 
	 * 
	 * Para el caso de arcos [(E1,E2),(E2,E3),(E3,E4)] si ya analicé ese caso no
	 * tiene sentido que analice ninguno de las permutaciones:
	 * 
	 * [(E1,E2),(E3,E4),(E2,E3)] [(E2,E3),(E1,E2),(E3,E4)] [(E2,E3),(E3,E4),(E1,E2)]
	 * [(E3,E4),(E2,E3),(E1,E2)] [(E3,E4),(E1,E2),(E2,E3)]
	 * 
	 * Esto debe podarse por niveles entonces, tendre una estructura de mapa, que
	 * para una key tenga conjuntos de combinaciones Descarto la combinacion si la
	 * encuentro ya probada
	 * 
	 * 
	 * La estructura sera: Map<Integer,Set<Arco<T>>> combinatorias; donde: - La
	 * clave es un nro entero que indica la cantidad de elementos en el conjunto de
	 * arcos - El valor es un conjunto de arcos. Usamos conjunto porque no permite
	 * duplicados ni indica orden. Dos conjuntos son iguales si tienen dentro los
	 * mismos elementos (sin importar el orden)
	 */
	public boolean podaAvanzada(List<Arco<Integer>> arcosUsados, Arco<Integer> arcoSiguiente) {
		if (!usaPodaAvanzada)
			return false;
		Set<Arco<Integer>> set = arcosUsados.stream().collect(Collectors.toSet());
		set.add(arcoSiguiente);
		boolean result = (combinatorias.getOrDefault(arcosUsados.size(), new HashSet<Arco<Integer>>()).equals(set));
		if (!result)
			combinatorias.put(arcosUsados.size(), set);
		return result;
	}

	private void back(Set<Arco<Integer>> arcos, List<Arco<Integer>> solucionParcial, int sumaParciall) {
		contadorCiclos++;
		if (arcos.isEmpty()) {
			if (esConexo()) {

				if (sumaParcial <= longitudSubterraneo) {
					longitudSubterraneo = sumaParcial;
					redSubterraneo.clear();
					redSubterraneo.addAll(solucionParcial);
					System.out
							.println(" *****************************************************************************");
					System.out
							.println(" ****************************** Tengo un resultado ***************************");
					System.out.println("Red de subte en construccion: " + solucionParcial);
					System.out.println("Longitud de la red de subte en construccion: " + sumaParcial);
					System.out.println("Cantidad de iteraciones: " + contadorCiclos);
					System.out
							.println(" *****************************************************************************");
					System.out
							.println(" *****************************************************************************");
				}
			}

		} else {
			Arco<Integer> arco = arcos.iterator().next(); // Primer arco disponible
			arcos.remove(arco); // Quitarlo de la lista de arcos disponibles

			// Primer llamado a backtracking
			solucionParcial.add(arco); // Agrega el arco a la solucion parcial

			sumarASumaParcial(arco); // Suma la etiqueta

			// Condicón de poda
			if (!podaAvanzada(solucionParcial, arco) && sumaParcial < longitudSubterraneo
					&& solucionParcial.size() <= grafo.cantidadVertices()) {
				back(arcos, solucionParcial, sumaParcial);
			}
			// Deshacemos la suma del arco y el agregado a la solución parcial
			RestarDeSumaParcial(arco);
			solucionParcial.remove(arco);

			// Segundo llamado a backtracking. No agrega arco a la solución parcial
			if (sumaParcial < longitudSubterraneo && solucionParcial.size() <= grafo.cantidadVertices()) {
				back(arcos, solucionParcial, sumaParcial);
			}

			// Agregamos el arco a la lista
			arcos.add(arco);
		}

	}

	private ArrayList<Integer> obtenerVerticesLista(List<Arco<Integer>> solucionParcial) {
		HashSet<Integer> aux = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		for (Arco<Integer> a : solucionParcial) {
			aux.add(a.getVerticeOrigen());
			aux.add(a.getVerticeDestino());
		}
		res.addAll(aux);
		return res;
	}

	public boolean esConexo() {
		UnionFind componentes = new UnionFind(grafo.cantidadVertices());
		ArrayList<Integer> list = obtenerVerticesLista(solucionParcial);

		for (Arco<Integer> a : solucionParcial) {
			int i = a.getVerticeOrigen();
			int j = a.getVerticeDestino();

			int componenteI = componentes.find(list.indexOf(i));
			int componenteJ = componentes.find(list.indexOf(j));

			if (componenteI != componenteJ)
				componentes.union(componenteI, componenteJ);
		}
		return (componentes.getTotal() == 1);
	}

}
