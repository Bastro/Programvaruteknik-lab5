package test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Lab1.DataCollection;
import Lab1.DataCollectionBuilder;
import Lab1.DataSource;
import Lab1.MatchedDataPair;
import Lab1.Resolution;
import workshop.FootballGoalsSource;
import workshop.TemperatureSource;

public class TemperatureGoalsCollectionTest {
	private DataSource footballGoals;
	private DataSource temperature;
	private DataCollectionBuilder dataCollectionBuilder;
	private DataCollection datacollection;
	private Map<String, MatchedDataPair> map;

	@Before
	public void setUp() throws Exception {
		footballGoals = new FootballGoalsSource("Strömvallen");
		temperature = new TemperatureSource();
		footballGoals.getData();
		temperature.getData();
		dataCollectionBuilder = new DataCollectionBuilder(footballGoals, temperature, Resolution.DAY);
		datacollection = dataCollectionBuilder.getResult();
		map = datacollection.getData();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDayValue() {
		double maxError = 0.001;
		
		double expectedXValue = 2.0;
		double expectedYValue = 9.3;
		
		assertEquals(expectedXValue, (double) map.get("2014-05-26").getXvalue(), maxError);
		assertEquals(expectedYValue, (double) map.get("2014-05-26").getYvalue(), maxError);
	}
	
	@Test
	public void testAllDayValues() {
		double maxError = 0.001;
		
		int gamesAtArenaYear = 14; // Our data only have 14 instead of 15 matches
		double goalsAtArenaYear = 28.0;
		double sumTempratureAtGames = 159.4;
		
		int countedGamesAtYearArena = 0;
		double countGaoslAtArenaYear = 0.0;
		double testSumTempratureAtGames = 0.0;
		
		for (String key : map.keySet()) {
			countedGamesAtYearArena++;
			countGaoslAtArenaYear += map.get(key).getXvalue();
			testSumTempratureAtGames += map.get(key).getYvalue();
		}
		
		assertEquals(countedGamesAtYearArena, gamesAtArenaYear);
		assertEquals(goalsAtArenaYear, countGaoslAtArenaYear, maxError);
		assertEquals(testSumTempratureAtGames, sumTempratureAtGames, maxError);
	}

}
