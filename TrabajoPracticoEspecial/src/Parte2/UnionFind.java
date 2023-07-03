package Parte2;

import java.util.HashMap;

public class UnionFind {

   /* private ArrayList<Integer> vertices;
    private int total;

    //Complejidad O(Log cantidadVertices)
    
    
    public UnionFind(int cantidadVertices) {
        this.vertices = new ArrayList<>();
        for(int v = 0; v <= cantidadVertices; v++) {
            vertices.add(-1);
        }
        this.total = cantidadVertices;
    }

    //Para la Union, en la posición pos seteo valor
    public void union(int pos, int val) {
        this.vertices.set(pos, val);
        this.total--;
    }

    //Busco encadenadas las posiciones
    public int find(int pos) {
        while(this.vertices.get(pos) >= 0) {
            pos = this.vertices.get(pos);
        }
        return pos;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    */
	
    private HashMap<Integer, Integer> parent;
    private int total;

    public int getTotal() {
		return total;
	}

	public UnionFind(int n) {
        parent = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
        }
        total = n;
    }

    public int find(int x) {
        while (parent.get(x) != x) {
            x = parent.get(x);
        }
        return x;
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (parent.get(xRoot).intValue() < parent.get(yRoot).intValue()) {
            parent.put(xRoot, yRoot);
        } else {
            parent.put(yRoot, xRoot);
        }
        total--;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
	
}