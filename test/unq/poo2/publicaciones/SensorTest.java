package unq.poo2.publicaciones;

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

	
	Sensor sensor;
	Cientifico einsteinProgramador;
	
	
	@BeforeEach
	void setUp() {
		
		einsteinProgramador = mock(Cientifico.class);
		sensor = new Sensor(einsteinProgramador);
		
		sensor.agregarAutorInteres("David Duarte");
		sensor.agregarTituloInteres("Programación Cuántica");
		sensor.agregarFiliacionInteres("Laboratorio");
		sensor.agregarLugarPublicadoInteres("España");
		sensor.agregarTipoInteres("Programación Cuántica");
		sensor.agregarPalabrasClaveInteres(Arrays.asList("Programación", "Cuántica", "Laboratorio"));
		
		
	}
	
	@Test
	void articuloInteresPorAutor() {

		ArticuloCientifico paperJAVA = mock(ArticuloCientifico.class);
		
		when(paperJAVA.getAutor()).thenReturn("David Duarte");
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	@Test
	void articuloInteresPorTitulo() {
		
		ArticuloCientifico paperJAVA = mock(ArticuloCientifico.class);
		
		when(paperJAVA.getTitulo()).thenReturn("Programación Cuántica");
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	@Test
	void articuloInteresPorFiliacion() {
		
		ArticuloCientifico paperJAVA = mock(ArticuloCientifico.class);
		
		when(paperJAVA.getFiliacion()).thenReturn("Laboratorio");
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	@Test
	void articuloInteresPorLugarPublicado() {
		
		ArticuloCientifico paperJAVA = mock(ArticuloCientifico.class);
		
		when(paperJAVA.getLugarPublicado()).thenReturn("España");
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	@Test
	void articuloInteresPorPalabraClave() {
		
		ArticuloCientifico paperJAVA = mock(ArticuloCientifico.class);
		
		when(paperJAVA.getPalabrasClave()).thenReturn(Arrays.asList("Cuántica"));
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	
	@Test
	void articuloSinInteres() {
		
		ArticuloCientifico paperC = mock(ArticuloCientifico.class);
		
		when(paperC.getAutor()).thenReturn("Ricardo Milos");
		when(paperC.getTitulo()).thenReturn("Programación Lógica");
		when(paperC.getPalabrasClave()).thenReturn(Arrays.asList("Lógica", "Matemáticas"));
		when(paperC.getFiliacion()).thenReturn("Universidad");
		
		sensor.notify(paperC);
		
		verify(einsteinProgramador, never()).update(paperC);
		
	}
	

}
