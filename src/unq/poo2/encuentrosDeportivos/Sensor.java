package unq.poo2.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

	private Listener listener;
	private List<String> deportesDeInteres;
	private List<String> contrincantesDeInteres;
	
	
	public Sensor(Listener listener) {
		this.listener = listener;
		deportesDeInteres = new ArrayList<String>();
		contrincantesDeInteres = new ArrayList<String>();
	}
	
	
	public void agregarDeporteInteres(String deporte) {
		this.deportesDeInteres.add(deporte);
	}
	
	public void agregarContrincanteInteres(String contrincante) {
		this.contrincantesDeInteres.add(contrincante);
	}
	
	
	public void notify(Partido partido) {
		if(deportesDeInteres.contains(partido.getDeporte()) || this.hayAlgunContrincanteDeInteres(partido.getContrincantes())) {
			listener.update(partido);
		}
	}
	
	
	public boolean hayAlgunContrincanteDeInteres(List<String> contrincantes) {	
		for (String contrincante : contrincantes) {
			if (this.contrincantesDeInteres.indexOf(contrincante) != -1) {
				return true;
			}
		}
		return false;
	}
	
}
