package unq.poo2.publicaciones;

import java.util.ArrayList;

public class SistemaReferencias {
	
	private ArrayList<ArticuloCientifico> articulos;
	private ArrayList<Sensor> sensores;
	
	public SistemaReferencias() {
		articulos = new ArrayList<ArticuloCientifico>();
		sensores = new ArrayList<Sensor>();
	}
	
	public void agregarSuscriptor(Sensor nuevoSuscriptor) {
		this.sensores.add(nuevoSuscriptor);
	}
	
	public void agregarArticulo(ArticuloCientifico nuevoArticulo) {
		this.articulos.add(nuevoArticulo);
		this.notify(nuevoArticulo);
	}
	
	private void notify(ArticuloCientifico nuevoArticulo) {
		for (Sensor sensor : this.sensores) {
			sensor.notify(nuevoArticulo);
		}
	}
}
