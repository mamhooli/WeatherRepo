package weather.controller;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import weather.repo.WeatherRepo;

/**
 * JUnit to check location data
 * @author Mamata Hooli
 *
 */
public class LocationControllerTests extends BaseWebApplicationContextTests {

	private JsonNode createTree(String jsonString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonString, JsonNode.class);
	}

	@Test
	public void testGetLocationsAsJSon() throws Exception {
		request.setMethod("GET");
		request.addHeader("Accept", "application/json");
		request.setRequestURI("/location");

		servlet.service(request, response);
		String result = response.getContentAsString();
		Assert.assertEquals(200, response.getStatus());

		WeatherRepo weatherRepo = new WeatherRepo();

		ObjectMapper mapper = new ObjectMapper();

		String expectedJSON = mapper.writeValueAsString(weatherRepo
				.getLocations());

		Assert.assertEquals(createTree(expectedJSON), createTree(result));
	}

}
