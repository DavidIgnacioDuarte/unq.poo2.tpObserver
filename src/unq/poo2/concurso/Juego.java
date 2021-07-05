package unq.poo2.concurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {

	
	List<String> preguntas; 
	List<String> respuestas; 
	List<Sensor> sensores;
	Map<Jugador, Integer> mapJugadores;
	
	
	public Juego(List<String> preguntas, List<String> respuestas) {
		this.preguntas = preguntas;
		this.respuestas = respuestas;
		this.sensores = new ArrayList<Sensor>();
		this.mapJugadores = new HashMap<Jugador, Integer>();
	}

	
	public void sumarAPartida(Jugador nuevoJugador) throws Exception{
		
		if(this.sensores.size() == 5) {
			throw new Exception("¡El juego ya comenzó! Espera a que termine.");
		}
		
		this.sensores.add(new Sensor(nuevoJugador));
		this.mapJugadores.put(nuevoJugador, 0);
		this.chequearInicioYNotificar();
		
	}
	
	
	private void chequearInicioYNotificar() {
		if (sensores.size() == 5) {
			for (Sensor sensor : this.sensores) {
				sensor.notificarInicio(this.preguntas);
			}		
		}
	}
		
	
	public void responderPregunta(Jugador jugador, String pregunta, String respuestaJugador) throws Exception{
		
		if(!jugador.habilitadoParaJugar()) {
			throw new Exception("El jugador " + jugador.getNombre() + " no está habilitado para responder.");
		}
		
		jugador.ponerEnEspera();
		Integer numeroRespuesta = this.preguntas.indexOf(pregunta);
		if(this.respuestas.get(numeroRespuesta) == respuestaJugador) {
			mapJugadores.put(jugador, mapJugadores.get(jugador) + 1);
			for (Sensor sensor : this.sensores) {
				sensor.notificarRespuestaCorrecta(jugador, pregunta);
			}		
		this.chequearPuntaje(jugador);
		} else {
			for (Sensor sensor : this.sensores) {
				sensor.notificarRespuestaIncorrecta(jugador, pregunta);
			}
		}

	}

	
	private void chequearPuntaje(Jugador jugador) {
		if(mapJugadores.get(jugador) == 5) {
			
			for(Sensor sensor : this.sensores) {
				sensor.notificarGanador(jugador);
			}
			
			this.finalizarJuego();
		}
	}

	//CLEAR
	private void finalizarJuego() {
		this.sensores = new ArrayList<Sensor>();
		this.mapJugadores = new HashMap<Jugador, Integer>();
	}
	
}
