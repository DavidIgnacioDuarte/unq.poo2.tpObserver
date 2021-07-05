package unq.poo2.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppPartidosTest {

	
	private AppPartidos app;
	private Sensor sensor1;
	private Sensor sensor2;
	private Sensor sensor3;
	
	private Partido partidoRandom;
	
	@BeforeEach
	void setUp() {
		
		app = new AppPartidos();
		
		sensor1 = mock(Sensor.class);
		sensor2 = mock(Sensor.class);
		sensor3 = mock(Sensor.class);
		
		partidoRandom = mock(Partido.class);
		
	}
	
	
	@Test
	void testSensores() {

		assertEquals(0, app.getSensores().size());
		
		app.agregarSensor(sensor1);
		app.agregarSensor(sensor2);
		app.agregarSensor(sensor3);
		
		assertEquals(3, app.getSensores().size());
		
		app.recibirPartido(partidoRandom);
		
		verify(sensor1, times(1)).notify(partidoRandom);
		verify(sensor2, times(1)).notify(partidoRandom);
		verify(sensor3, times(1)).notify(partidoRandom);
		
	}

}
