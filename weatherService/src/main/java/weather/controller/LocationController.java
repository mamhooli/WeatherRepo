package weather.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import weather.domain.Location;
import weather.service.WeatherService;

/**
 * Controller to return location
 * @author Mamata Hooli
 *
 */
@RestController
@RequestMapping("/location")
public class LocationController {

	private WeatherService weatherService;

	private Logger logger = LoggerFactory.getLogger(LocationController.class);

	@Inject
	public LocationController(
			@Named("weatherService") WeatherService weatherService) {
		logger.debug("I am initiliized");
		this.weatherService = weatherService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Location> getLocations() {
		logger.debug("Provider has received request to get location");
		return weatherService.getLocations();
	}

}
