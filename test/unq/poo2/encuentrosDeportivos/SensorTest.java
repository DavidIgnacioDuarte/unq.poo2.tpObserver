package unq.poo2.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SensorTest {

	
	private Sensor sensor;
	private Listener someListener;
	
	private Partido partidoRandom;
	
	
	@BeforeEach
	void setUp() {
		
		someListener = mock(Listener.class);
		
		sensor = new Sensor(someListener);
		
		partidoRandom = mock(Partido.class);
		
		when(partidoRandom.getDeporte()).thenReturn("fulbo");
		when(partidoRandom.getContrincantes()).thenReturn(Arrays.asList("Boca", "River"));
		
	}
	
	
	@Test
	void testNotificacionEfectivaPorContrincante() {
		
		sensor.agregarContrincanteInteres("River");
		
		sensor.notify(partidoRandom);
		
		verify(someListener, times(1)).update(partidoRandom);
		
	}
	
	@Test
	void testNotificacionEfectivaPorDeporte() {
		
		sensor.agregarDeporteInteres("fulbo");
		
		sensor.notify(partidoRandom);
		
		verify(someListener, times(1)).update(partidoRandom);
		
	}
	
	@Test
	void testNotificacionInexistentePorContrincante() {
		
		sensor.agregarContrincanteInteres("Huachipato");
		sensor.agregarContrincanteInteres("Boston");
		
		sensor.notify(partidoRandom);
		
		verify(someListener, never()).update(partidoRandom);
		
	}
	
	@Test
	void testNotificacionInexistentePorDeporte() {
		
		sensor.agregarDeporteInteres("basket");
		sensor.agregarDeporteInteres("handball");
		
		sensor.notify(partidoRandom);
		
		verify(someListener, never()).update(partidoRandom);
		
	}

}
