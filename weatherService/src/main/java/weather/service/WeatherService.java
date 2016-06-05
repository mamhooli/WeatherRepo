package weather.service;

import java.util.List;

import weather.domain.Location;
import weather.domain.WeatherData;

/**
 * Interface for Weather information to retrieve data and location.
 * @author Mamata Hooli
 *
 */
public interface WeatherService {
	
	public WeatherData getWeatherData(String location);
	
	public List<Location> getLocations();
}
