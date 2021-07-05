package unq.poo2.concurso;

import java.util.List;

public class Sensor {

	Jugador jugador;
	
	
	public Sensor(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void notificarInicio(List<String> preguntas) {
		jugador.avisoDeInicio(preguntas);
	}
	
	public void notificarRespuestaCorrecta(Jugador jugador, String pregunta) {
		if (this.jugador == jugador) {
			jugador.avisoRespuestaCorrecta(pregunta);
		}
		else {
			jugador.avisoHuboUnaRespuestaCorrecta(jugador.getNombre(), pregunta);
		}
	}

	public void notificarRespuestaIncorrecta(Jugador jugador, String pregunta) {
		if(this.jugador == jugador) {
			jugador.avisoRespuestaIncorrecta(pregunta);
		}
	}

	public void notificarGanador(Jugador jugador) {
		jugador.avisoGanador();		
	}

}
