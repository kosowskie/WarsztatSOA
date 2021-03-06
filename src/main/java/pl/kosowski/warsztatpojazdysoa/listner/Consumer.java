package pl.kosowski.warsztatpojazdysoa.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kosowski.warsztatpojazdysoa.model.Car;

@Component
public class Consumer {

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message) throws JsonProcessingException {

        Car car = new ObjectMapper().readValue(message, Car.class);
        makePut(car);
    }

    public void makePut(Car car) {
        RestTemplate restTemplate = new RestTemplate();
        String link = "https://pkowaleckicarsapi.herokuapp.com/editCar/" + car.getId();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Car> requestEntity = new HttpEntity<>(car, requestHeaders);

        restTemplate.exchange(
                link,
                HttpMethod.PUT,
                requestEntity,
                HttpStatus.class);
    }
}
