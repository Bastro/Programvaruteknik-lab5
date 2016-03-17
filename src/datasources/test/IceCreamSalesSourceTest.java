package datasources.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datasources.IceCreamSalesSource;

public class IceCreamSalesSourceTest {
	
	private IceCreamSalesSource iceCreamSales;
	private Map<LocalDate, Double> iceCreamData;

	@Before
	public void setUp() throws Exception {
		iceCreamSales = new IceCreamSalesSource();
		iceCreamData = iceCreamSales.getData();
	}

	@After
	public void tearDown() throws Exception {
		iceCreamSales = null;
		iceCreamData = null;
	}
	
	@Test
	public void testDataSize() {
		assertEquals(365, iceCreamData.size());
	}
	
	@Test
	public void testGetData() {
		for (Double sales : iceCreamData.values()) {
		    assertTrue(ifIntervall(0, 2000, sales));
		}
	}
	
	private boolean ifIntervall(double min, double max, double value) {
		return (value >= min && value <= max);
	}

}
