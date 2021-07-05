package unq.poo2.publicaciones;

import java.util.List;

public class ArticuloCientifico {
	
	private String titulo;
	private String autor;
	private String filiacion;
	private String tipo;
	private String lugarPublicado;
	private List<String> palabrasClave;
	
	public ArticuloCientifico(String titulo,String autor,String filiacion,String tipo,String lugarPublicado,List<String> palabrasClave) {
		this.titulo = titulo;
		this.autor = autor;
		this.filiacion = filiacion;
		this.tipo = tipo;
		this.lugarPublicado = lugarPublicado;
		this.palabrasClave = palabrasClave;		
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getFiliacion() {
		return filiacion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getLugarPublicado() {
		return lugarPublicado;
	}

	public List<String> getPalabrasClave() {
		return palabrasClave;
	}

	

}
