package datasources;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Lab1.DataSource;
import workshop.JsonToMapParser;
import workshop.UrlFetcher;

public class ArenaSpectatorsSource implements DataSource {

	private String arenaName = "Strömvallen";
	
	@Override
	public String getName() {
		return arenaName;
	}

	@Override
	public String getUnit() {
		return "Audience numbers";
	}

	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher fetcher = new UrlFetcher(
				"http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=240");
		JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());

		Map<String, Object> data = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();

		for (Map event : (List<Map>) data.get("events")) {
			Map<String, Object> facts = (Map<String, Object>) event.get("facts");

			if (facts.toString().contains(arenaName)) {
				LocalDate date = LocalDate.parse(event.get("startDate")
						.toString().substring(0, 10));		
				int spectators = Integer.parseInt(facts.get("spectators").toString());
				addSpectatorsToDate(result, date, spectators);
			}
		}
		return result;
	}

    private void addSpectatorsToDate(Map<LocalDate, Double> result, LocalDate date, int spectators) {
        if (!result.containsKey(date)) {
            result.put(date, new Double(spectators));
        } else {
            result.put(date, result.get(date) + spectators);
        }
    }
}
