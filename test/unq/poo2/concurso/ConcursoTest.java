package unq.poo2.concurso;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;


import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcursoTest {
	
	Juego juego;
	
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugador3;
	Jugador jugador4;
	Jugador jugador5;
	
	
	@BeforeEach
	void setup() throws Exception{
		
		juego = new Juego(Arrays.asList("1","2","3","4","5"),Arrays.asList("A","B","C","D","E"));
		
		jugador1 = mock(Jugador.class);
		jugador2 = mock(Jugador.class);
		jugador3 = mock(Jugador.class);
		jugador4 = mock(Jugador.class);
		jugador5 = mock(Jugador.class);

		juego.sumarAPartida(jugador1);
		juego.sumarAPartida(jugador2);
		juego.sumarAPartida(jugador3);
		juego.sumarAPartida(jugador4);
		juego.sumarAPartida(jugador5);
		
	}
	
	
	@Test
	void testJuego1() throws Exception {
		//Configure
		when(jugador5.habilitadoParaJugar()).thenReturn(true);
		
		
		//excercise
		juego.responderPregunta(jugador5, "1", "C");
		
		
		//verify
		verify(jugador5).avisoRespuestaIncorrecta("1");
		verify(jugador4, never()).avisoRespuestaIncorrecta(any());
	}

}
