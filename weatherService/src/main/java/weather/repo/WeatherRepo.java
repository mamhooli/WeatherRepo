package weather.repo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import weather.domain.Location;

/**
 * Repo class to load locations from config and populate a list
 * @author Mamata Hooli
 *
 */
public class WeatherRepo {

	private static String CONFIG_FILE = "location.store";
	private static List<Location> locationList = new ArrayList<Location>();

	static {
		init();
	}

	private static void init() {
		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(CONFIG_FILE));
			int counter = 0;

			for (final String name : prop.stringPropertyNames()) {
				Location location = new Location();
				location.setId(String.valueOf(counter++));
				location.setLocationName(name);
				locationList.add(location);
			}

		} catch (IOException e) {
			// handle exception
		}
	}

	public List<Location> getLocations() {
		return locationList;
	}

}
