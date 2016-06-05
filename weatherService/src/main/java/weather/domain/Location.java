package weather.domain;

/**
 * Location object to map the location list
 * @author Mamata Hooli
 *
 */
public class Location {

	private String id;
	private String locationName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
}
