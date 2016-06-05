package weather.service;

import org.junit.Test;

import weather.controller.BaseWebApplicationContextTests;

/**
 * Simple test class to fire getWeatherData.
 * @author Mamata Hooli
 *
 */
public class WeatherServiceImplTest extends BaseWebApplicationContextTests {

	@Test
	public void test() {
		weatherService.getWeatherData("Sydney");
	}

}
