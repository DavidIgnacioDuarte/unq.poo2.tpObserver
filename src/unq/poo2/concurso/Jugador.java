package unq.poo2.concurso;

import java.util.List;

public class Jugador {
	
	
	String nombre;
	List<String> preguntas;
	boolean habilitadoParaJugar;
	
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.ponerEnEspera();
	}
	
	public void avisoDeInicio(List<String> preguntas) {
		this.preguntas = preguntas;
		this.habilitarParaJugar();
	}

	public void avisoRespuestaCorrecta(String pregunta) {
		this.habilitarParaJugar();
		//recibe el aviso de respuesta correcta
	}

	public void avisoRespuestaIncorrecta(String pregunta) {
		this.habilitarParaJugar();
		//recibe el aviso de respuesta incorrecta
	}
	
	public void avisoHuboUnaRespuestaCorrecta(String nombreJugador, String pregunta) {
		// Recibe el aviso de que alguien contesto bien.
	}
	
	public void avisoGanador() {
		this.ponerEnEspera();
	}
	
	public void ponerEnEspera() {
		this.habilitadoParaJugar = false;
	}

	public void habilitarParaJugar() {
		this.habilitadoParaJugar = true;
	}

	public boolean habilitadoParaJugar() {
		return this.habilitadoParaJugar; 
	}

	public List<String> preguntas(){
		return this.preguntas;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
