package unq.poo2.encuentrosDeportivos;

public abstract class Listener {

	protected Sensor miSensor;
	
	
	public abstract void update(Partido partido);
	
	public Sensor getSensor() {
		return miSensor;
	}
	
	public void agregarDeporteInteres(String deporte) {
		this.getSensor().agregarDeporteInteres(deporte);
	}
	
}
