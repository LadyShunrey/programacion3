package Parte1;

public class ArcoNoDirigido<T> extends Arco<T> {

		public ArcoNoDirigido(T verticeOrigen, T verticeDestino, Integer etiqueta) {
			super(verticeOrigen, verticeDestino, etiqueta);
		}

		@Override
		public boolean equals(Arco<T> a) {
			return (
					(a.verticeOrigen.equals(this.verticeOrigen) && a.getVerticeDestino().equals(this.getVerticeDestino())) 
					|| 
					(a.verticeOrigen.equals(this.verticeDestino) && a.getVerticeDestino().equals(this.getVerticeOrigen())));
		}
	}
