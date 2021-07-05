package unq.poo2.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class AppPartidos {

	
	public List<Sensor> sensores;
	
	
	public AppPartidos() {
		this.sensores = new ArrayList<Sensor>();
	}
	
	public List<Sensor> getSensores() {
		return this.sensores;
	}
	
	public void agregarSensor(Sensor nuevoSensor) {
		this.sensores.add(nuevoSensor);
	}
	
	public void recibirPartido(Partido partido) {
		this.notify(partido);
	}
	
	private void notify(Partido partido) {
		for (Sensor sensor : this.sensores) {
			sensor.notify(partido);
		}
	}
	
	
	
}
