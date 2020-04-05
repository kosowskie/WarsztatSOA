package pl.kosowski.warsztatpojazdysoa;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarsztatMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/addMessage")
    public String get(@RequestParam String message) {
        rabbitTemplate.convertAndSend("Warsztat",message);
        return "sent";
    }

    @GetMapping("/receiveMessage")
    public String get(){
        Object message = rabbitTemplate.receiveAndConvert("Warsztat");
        return message.toString();
    }

    @RabbitListener(queues = "Warsztat")
    public void rabbitListener(String s){
        System.out.println(s);
    }
}