package datasources;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Lab1.DataSource;

public class IceCreamSalesSource implements DataSource {

	@Override
	public String getName() {
		return "Ice Creams";
	}

	@Override
	public String getUnit() {
		return "Amount";
	}

	@Override
	public Map<LocalDate, Double> getData() {
		 Map<LocalDate, Double> iceCreamSales = new HashMap<>();
		 Random rand = new Random();
		 LocalDate date = LocalDate.of(2014, 1, 1);
		 
		 for (int i = 1; i <= 365; i++) {
			 double rndIceCreamSales = rand.nextInt(2000);
			 iceCreamSales.put(date, rndIceCreamSales);
			 date = date.plusDays(1);
		 }
		 
		 return iceCreamSales;
	}

}
