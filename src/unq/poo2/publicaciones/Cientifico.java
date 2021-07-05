package unq.poo2.publicaciones;


import java.util.List;

public class Cientifico {

	//protected List<ArticuloCientifico> articulos = new ArrayList<ArticuloCientifico>();
	private Sensor sensor;
	
	public Cientifico() {
		this.sensor = new Sensor(this);
	}
	
	public void update(ArticuloCientifico articulo) {
		
	}

	public Sensor getSensor() {
		return this.sensor;
	}
	
	
	public void agregarTituloInteres(String titulo) {
		this.getSensor().agregarTituloInteres(titulo);
	}
	
	public void agregarAutorInteres(String autor) {
		this.getSensor().agregarAutorInteres(autor);
	}
	
	public void agregarFiliacionInteres(String filiacion) {
		this.getSensor().agregarFiliacionInteres(filiacion);
	}
	
	public void agregarTipoInteres(String tipo) {
		this.getSensor().agregarTipoInteres(tipo);
	}
	
	public void agregarLugarPublicadoInteres(String lugarPublicado) {
		this.getSensor().agregarLugarPublicadoInteres(lugarPublicado);
	}
	
	public void agregarPalabrasClaveInteres(List<String> palabrasClave) {
		this.getSensor().agregarPalabrasClaveInteres(palabrasClave);
	}
	
}
