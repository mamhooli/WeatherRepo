package weather.service;

import org.junit.Test;

import org.junit.Assert;
import weather.controller.BaseWebApplicationContextTests;
import weather.domain.WeatherData;

/**
 * Simple test class to fire getWeatherData.
 * @author Mamata Hooli
 *
 */
public class WeatherServiceImplTest extends BaseWebApplicationContextTests {

	@Test
	public void testWebService() {
	  Assert.assertNotNull("Did not receive data from API",weatherService.getWeatherData("Sydney"));
	}
	
	@Test
    public void testWebServiceData() {
	  WeatherData weatherData = weatherService.getWeatherData("Sydney");
	  
      Assert.assertNotNull("Location is null",weatherData.getLocation());
      Assert.assertNotNull("Weather condition is null",weatherData.getWeatherCondition());
      Assert.assertNotNull("Temperature is null",weatherData.getTemperature());
      Assert.assertTrue("Expecting Sydney but received something else","Sydney"==weatherData.getLocation());
    }

}
