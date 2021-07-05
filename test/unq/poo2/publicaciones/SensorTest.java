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
		sensor.agregarTituloInteres("Programaci�n Cu�ntica");
		sensor.agregarFiliacionInteres("Laboratorio");
		sensor.agregarLugarPublicadoInteres("Espa�a");
		sensor.agregarTipoInteres("Programaci�n Cu�ntica");
		sensor.agregarPalabrasClaveInteres(Arrays.asList("Programaci�n", "Cu�ntica", "Laboratorio"));
		
		
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
		
		when(paperJAVA.getTitulo()).thenReturn("Programaci�n Cu�ntica");
		
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
		
		when(paperJAVA.getLugarPublicado()).thenReturn("Espa�a");
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	@Test
	void articuloInteresPorPalabraClave() {
		
		ArticuloCientifico paperJAVA = mock(ArticuloCientifico.class);
		
		when(paperJAVA.getPalabrasClave()).thenReturn(Arrays.asList("Cu�ntica"));
		
		sensor.notify(paperJAVA);
		
		verify(einsteinProgramador, times(1)).update(paperJAVA);
		
	}
	
	
	@Test
	void articuloSinInteres() {
		
		ArticuloCientifico paperC = mock(ArticuloCientifico.class);
		
		when(paperC.getAutor()).thenReturn("Ricardo Milos");
		when(paperC.getTitulo()).thenReturn("Programaci�n L�gica");
		when(paperC.getPalabrasClave()).thenReturn(Arrays.asList("L�gica", "Matem�ticas"));
		when(paperC.getFiliacion()).thenReturn("Universidad");
		
		sensor.notify(paperC);
		
		verify(einsteinProgramador, never()).update(paperC);
		
	}
	

}
