package test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Lab1.DataCollectionBuilder;
import Lab1.ImplDataSource;
import Lab1.MatchedDataPair;
import Lab1.Resolution;

public class TestDataCollectionBuilder {

	DataCollectionBuilder testCollection;
	Resolution resolution;
	MatchedDataPair matchedDataPair;
	ArrayList<String> testData = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
	}	
	ImplDataSource xData = new ImplDataSource("Temperature", "C");
	ImplDataSource yData = new ImplDataSource("Gaols", "Z+");

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDay() {

		xData.addData(LocalDate.of(1994, 05, 27), 37.0);

		yData.addData( LocalDate.of(1994, 05, 27), 37.0);
		

		testCollection = new DataCollectionBuilder(xData, yData, Resolution.DAY);


		testData.add("1994-05-27");

		testOnData(testData);
	

	}



	private void testOnData(ArrayList<String> testCompareKey) {
		int i = 0;
		for (String testKey : testCollection.getResult().getData().keySet()) {

			assertEquals(testCompareKey.get(i), testKey);
			assertTrue(testCollection.getResult().getData().keySet() != null);
			i++;
		}
		testData.clear();

	}

	public void testOnNames(String xName, String yName) {

		assertEquals(xName + "/" + yName, testCollection.getTitle());

	}

	public void testOnUnit(String xUnit, String yUnit) {

		assertEquals(xUnit, testCollection.getResult().getXUnit());
		assertEquals(yUnit, testCollection.getResult().getYUnit());

	}

}
