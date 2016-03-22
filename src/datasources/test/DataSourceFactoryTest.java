package datasources.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import databuilding.DataSource;
import datasources.DataSourceFactory;

public class DataSourceFactoryTest {
	
	DataSourceFactory factory;
	DataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		factory = new DataSourceFactory();
	}

	@After
	public void tearDown() throws Exception {
		factory = null;
	}
	
	@Test
	public void testGetArenaSpectatorsSource(){
		assertEquals("Audience numbers", factory.getDataSource("arenaspectators").getUnit());
	}
	
	@Test
	public void testGetFootballGoalsSource(){
		assertEquals("Antal mål", factory.getDataSource("footballgoals").getUnit());
	}
	
	@Test
	public void testGetTemperatureSource(){
		assertEquals("C", factory.getDataSource("temperature").getUnit());
	}
	
	@Test
	public void testGetIceCreamSalesSource(){
		assertEquals("Amount", factory.getDataSource("icecreamsales").getUnit());
	}

}
