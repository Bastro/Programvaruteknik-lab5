package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import workshop.TemperatureSource;

/**
 * 
 * @author ofk14den 
 * @author Jonas Öster
 */
public class TemperatureSourceTest {
	private TemperatureSource temperatureSource;
	private Map<LocalDate,Double> mapWithValues;

	@Before
	public void setUp() throws Exception {
		temperatureSource = new TemperatureSource();
		mapWithValues = temperatureSource.getData();
	}

	@After
	public void tearDown() throws Exception {
		temperatureSource = null;
	}


	@Test
	public void testFirstAndLastDateValues() {
		mapWithValues = temperatureSource.getData();
		Double valuefirstDate = mapWithValues.get(LocalDate.of(1995, 8, 1));
		Double valueLastDate = mapWithValues.get(LocalDate.of(2015, 10, 31));
		assertEquals((double) valuefirstDate, 19.1, 000.1);
		assertEquals((double) valueLastDate, 8.0, 000.1);
	}

}
