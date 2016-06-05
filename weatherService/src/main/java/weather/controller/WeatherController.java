package weather.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import weather.domain.WeatherData;
import weather.service.WeatherService;

/**
 * Controller to return weather data
 * @author Mamata Hooli
 *
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

	private WeatherService weatherService;

	private Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Inject
	public WeatherController(
			@Named("weatherService") WeatherService weatherService) {
		logger.debug("I am initiliized");
		this.weatherService = weatherService;
	}

	@RequestMapping(value = "/{location}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public WeatherData getWeatherData(@PathVariable("location") String location) {
		logger.debug("Provider has received request to get person with location: "
				+ location);
		return weatherService.getWeatherData(location);
	}

}
