package unq.poo2.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

	private ArrayList<String> titulosDeInteres;
	private ArrayList<String> autoresDeInteres;
	private ArrayList<String> filiacionesDeInteres;
	private ArrayList<String> tiposDeInteres;
	private ArrayList<String> lugaresPublicadosDeInteres;
	private ArrayList<String> palabrasClaveDeInteres;
	private Cientifico usuario;
	
	
	public Sensor(Cientifico usuario) {
		this.usuario = usuario;
		this.titulosDeInteres = new ArrayList<String>(); 
		this.autoresDeInteres = new ArrayList<String>(); 
		this.filiacionesDeInteres = new ArrayList<String>(); 
		this.tiposDeInteres = new ArrayList<String>(); 
		this.lugaresPublicadosDeInteres = new ArrayList<String>(); 
		this.palabrasClaveDeInteres = new ArrayList<String>(); 
	}
	

	public void agregarTituloInteres(String titulo) {
		titulosDeInteres.add(titulo);
	}
	
	public void agregarAutorInteres(String autor) {
		autoresDeInteres.add(autor);
	}
	
	public void agregarFiliacionInteres(String filiacion) {
		filiacionesDeInteres.add(filiacion);
	}
	
	public void agregarTipoInteres(String tipo) {
		tiposDeInteres.add(tipo);
	}
	
	public void agregarLugarPublicadoInteres(String lugarPublicado) {
		lugaresPublicadosDeInteres.add(lugarPublicado);
	}
	
	public void agregarPalabrasClaveInteres(List<String> palabrasClave) {
		palabrasClaveDeInteres.addAll(palabrasClave);
	}

	
	public void notify(ArticuloCientifico articulo) {
		if (this.titulosDeInteres.contains(articulo.getTitulo()) || 
			this.autoresDeInteres.contains(articulo.getAutor()) || 
			this.filiacionesDeInteres.contains(articulo.getFiliacion()) ||	
			this.tiposDeInteres.contains(articulo.getTipo()) ||
			this.lugaresPublicadosDeInteres.contains(articulo.getLugarPublicado()) ||
			this.hayPalabrasClaveDeInteres(articulo.getPalabrasClave())) {
			
				this.usuario.update(articulo);

		}
	}
	
	
	private boolean hayPalabrasClaveDeInteres(List<String> palabrasClave) {
		for (String palabra : palabrasClave) {
			if (this.palabrasClaveDeInteres.indexOf(palabra) != -1) {
				return true;
			}
		}
		return false;
	}
	
}
