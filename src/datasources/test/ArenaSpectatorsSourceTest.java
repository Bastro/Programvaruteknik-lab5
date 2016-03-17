package datasources.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datasources.ArenaSpectatorsSource;

public class ArenaSpectatorsSourceTest {

	ArenaSpectatorsSource spectators;
	Map<LocalDate, Double> spectatorData;
	
	@Before
	public void setUp() throws Exception {
		spectators = new ArenaSpectatorsSource();
		spectatorData = spectators.getData();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals("Strömvallen", spectators.getName());
	}

	@Test
	public void testGetUnit() {
		assertEquals("Audience numbers", spectators.getUnit());
	}

	@Test
	public void testGetData() {
		assertEquals(6711.0, spectatorData.get(LocalDate.of(2014, 4, 6)), 0.001);
		assertEquals(3060.0, spectatorData.get(LocalDate.of(2014, 5, 11)), 0.001);
		assertEquals(4227.0, spectatorData.get(LocalDate.of(2014, 10, 19)), 0.001);
		assertEquals(4013.0, spectatorData.get(LocalDate.of(2014, 7, 19)), 0.001);
	}
	
	@Test
	public void testDataSize(){
		assertEquals(14, spectatorData.size());
	}

}
