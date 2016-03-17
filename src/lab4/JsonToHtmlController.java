package lab4;

import com.owlike.genson.Genson;

import Lab1.DataCollectionBuilder;
import Lab1.DataSource;
import Lab1.Resolution;
import datasources.DataSourceFactory;
import datasources.FootballGoalsSource;
import datasources.TemperatureSource;

/**
 * Controller of data to JsonToHtml class
 */
public class JsonToHtmlController {
	private DataCollectionBuilder dataCollectionBuilder;

	/**
	 * Json string from data
	 * @return
	 */
	public String getJsonString(String dataSource1, String dataSource2) {
		DataSourceFactory factory = new DataSourceFactory();
		DataSource dataSourceOne = factory.getDataSource("icecreamsales");
		DataSource dataSourceTwo = factory.getDataSource("temperature");
		
		System.out.println(dataSourceOne.getData());
		System.out.println(dataSourceTwo.getData());
		
		dataCollectionBuilder = new DataCollectionBuilder(dataSourceOne, dataSourceTwo, Resolution.DAY);
		
		String jsonString = new Genson().serialize(dataCollectionBuilder.getResult());
		
		return jsonString;
	}	
}
