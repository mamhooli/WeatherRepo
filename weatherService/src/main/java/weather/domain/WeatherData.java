package weather.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * WeatherData object to hold the required information. 
 * @author Mamata Hooli
 *
 */
public class WeatherData {

	private String location;
	private Date updatedTime;
	private String weatherCondition;
	private int temperature;
	private BigDecimal windSpeed;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public BigDecimal getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	
}
