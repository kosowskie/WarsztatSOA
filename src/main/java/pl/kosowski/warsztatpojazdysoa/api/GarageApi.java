package pl.kosowski.warsztatpojazdysoa.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import pl.kosowski.warsztatpojazdysoa.model.Car;

import javax.jms.Queue;

@RestController
@RequestMapping("/garage")
public class GarageApi {
    private JmsTemplate jmsTemplate;
    private Queue queue;

    @Autowired
    public GarageApi(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> patchChangeServiceNeeded(@RequestBody Car car, @RequestParam String serviceNeeded){
        car.setServiceNeeded(serviceNeeded);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonString = mapper.writeValueAsString(car);
            jmsTemplate.convertAndSend(queue,jsonString);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
