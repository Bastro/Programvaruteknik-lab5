package datasources;

import Lab1.DataSource;

public class DataSourceFactory {
	
	public DataSource getDataSource(String dataSource){
		
		switch (dataSource.toLowerCase()) {
		case "footballgoals": 
			return new FootballGoalsSource("Strömvallen"); 
		case "arenaspectators": 
			return new ArenaSpectatorsSource(); 
		case "temperature": 
			return new TemperatureSource(); 
		case "icecreamsales": 
			return new IceCreamSalesSource(); 
		default: return null;
		}
		
	}
	
}
