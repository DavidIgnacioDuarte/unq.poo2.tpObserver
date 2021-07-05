package unq.poo2.encuentrosDeportivos;

import java.util.List;

public class Partido {

	private String deporte;
	private String resultado;
	private List<String> contrincantes;
	
	
	public Partido(String deporte, String resultado, List<String> contrincantes) {
		this.deporte = deporte;
		this.resultado = resultado;
		this.contrincantes = contrincantes;
	}


	public String getDeporte() {
		return deporte;
	}

	public String getResultado() {
		return resultado;
	}

	public List<String> getContrincantes() {
		return contrincantes;
	}
	
	
	
}
