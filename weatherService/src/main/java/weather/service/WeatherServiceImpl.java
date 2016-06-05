package weather.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Named;
import javax.xml.bind.JAXBException;

import weather.domain.Location;
import weather.domain.WeatherData;
import weather.repo.WeatherRepo;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;

/**
 * Implementing Yahoo weather service API to pull data.
 * @author Mamata Hooli
 *
 */
@Named("weatherService")
public class WeatherServiceImpl implements WeatherService {

    WeatherRepo weatherRepo = new WeatherRepo();

    public WeatherData getWeatherData(String location) {
        YahooWeatherService service;
        WeatherData weatherData = new WeatherData();
        try {
            service = new YahooWeatherService();
            List<Channel> channels = service.getForecastForLocation(location,
                    DegreeUnit.CELSIUS).first(1);
            for (Channel channel : channels) {
                weatherData.setLocation(channel.getTitle());
                weatherData.setTemperature(channel.getItem().getCondition()
                        .getTemp());
                weatherData.setWindSpeed(new BigDecimal(channel.getWind()
                        .getSpeed()).setScale(2, RoundingMode.CEILING));
                weatherData.setWeatherCondition(channel.getItem()
                        .getCondition().getText());
                weatherData.setUpdatedTime(channel.getItem().getCondition()
                        .getDate());
                weatherData.setLocation(location);
                break;

            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return weatherData;
    }

    @Override
    public List<Location> getLocations() {
        return weatherRepo.getLocations();
    }

}
