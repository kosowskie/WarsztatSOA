package pl.kosowski.warsztatpojazdysoa.listner;

import org.springframework.http.*;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kosowski.warsztatpojazdysoa.model.Car;

@Component
public class Consumer {

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message) {


        String serviceNeededCheck = car.getServiceNeeded();
        boolean serviceNeeded = serviceNeededCheck.substring(serviceNeededCheck.indexOf(" ") + 1).equals("true");

        RestTemplate restTemplate = new RestTemplate();
        String link = "https://pkowaleckicarsapi.herokuapp.com/editCar/" + car.getId();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Car> requestEntity = new HttpEntity<>(car, requestHeaders);
        if (serviceNeeded) {
            ResponseEntity<HttpStatus> exchange = restTemplate.exchange(
                    link,
                    HttpMethod.PUT,
                    requestEntity,
                    HttpStatus.class);
        }
    }
}
