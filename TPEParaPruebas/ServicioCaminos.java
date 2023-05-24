
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ServicioCaminos<T> {
	private Grafo<T> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap <Arco<T>,Boolean> visitado;
	private HashMap <Integer, String> colores;
	
	public ServicioCaminos(Grafo<T> g ,int origen, int destino, int lim) {
		this.grafo = g;
		this.origen=origen;
		this.destino=destino;
		this.lim=lim;
		this.visitado= new HashMap<>();
		this.colores= new HashMap<>();

	}
	
	public List<List<Integer>> caminos(){
		Iterator <Integer> vertices = this.grafo.obtenerVertices();
		Iterator<Arco<T>> arcos = this.grafo.obtenerArcos();
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();		
		List<Integer> v = new ArrayList<Integer>();		

		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			colores.put(vertice,"blanco");
			v.add(vertice);

		}while(arcos.hasNext()) {
			Arco<T> arco = arcos.next();
			visitado.put(arco, false);
		} 
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer ver  = vertices.next();
			if(ver==this.origen) {
				resultado.addAll(buscarCaminos(this.origen));
			}
		}
		
		return resultado;
	}
	
	private List<List<Integer>> buscarCaminos(Integer v){
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
//		
		int cantidad =0;
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
		Iterator<Arco<T>> arcos = this.grafo.obtenerArcos(v);
		colores.put(v, "amarillo");
		
		if(v.equals(this.destino)) {
			ArrayList<Integer> unicoCamino = new ArrayList<>();
			unicoCamino.add(v);
			resultado.add(unicoCamino);
		}else {
			while(it.hasNext()) {
			Arco<T> arco = arcos.next();
			Integer ady = it.next();
			
			if(cantidad <= lim && visitado.get(arco)==false) {
				List<List<Integer>> caminosParciales = new ArrayList<List<Integer>>();
				caminosParciales.addAll(buscarCaminos(ady));
				visitado.put(arco, true);
				cantidad ++;
				
				for(List<Integer> caminoParcial : caminosParciales) {
					List<Integer> nuevoCamino = new ArrayList<>(caminoParcial);
					nuevoCamino.add(0, v);
					resultado.add(nuevoCamino);
					}
				
			}
			
		}
		}
		colores.put(v, "blanco");
		return resultado;
		
		
}
}
