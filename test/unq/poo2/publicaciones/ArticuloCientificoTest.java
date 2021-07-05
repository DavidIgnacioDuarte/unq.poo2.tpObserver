package unq.poo2.publicaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArticuloCientificoTest {

	
	ArticuloCientifico paperJAVA;
	
	@BeforeEach
	void setUp() {
		
		paperJAVA = new ArticuloCientifico("Java mas alla de todo", "David Duarte", "Universidad", "Paper", "Argentina", Arrays.asList("Programación", "Java", "UNQ"));
		
	}
	
	@Test
	void testConstructor() {
		
		assertEquals("David Duarte", paperJAVA.getAutor());
		assertEquals("Java mas alla de todo", paperJAVA.getTitulo());
		assertEquals("Universidad", paperJAVA.getFiliacion());
		assertEquals("Paper", paperJAVA.getTipo());
		assertEquals("Argentina", paperJAVA.getLugarPublicado());
		assertEquals(Arrays.asList("Programación", "Java", "UNQ"), paperJAVA.getPalabrasClave());
		
	}

}
