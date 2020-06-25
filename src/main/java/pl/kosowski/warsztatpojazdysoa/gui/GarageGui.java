package pl.kosowski.warsztatpojazdysoa.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.kosowski.warsztatpojazdysoa.listner.Consumer;
import pl.kosowski.warsztatpojazdysoa.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route("garageGUI")
public class GarageGui extends VerticalLayout {

    private Consumer consumer;
    private Grid<Car> carGrid;
    private Button button;
    private List<Car> carList=new ArrayList<>();

    @Autowired
    public GarageGui(Consumer consumer) {
        this.consumer = consumer;

        fieldsInit();
    }

    private void fieldsInit() {
        carGrid=new Grid<>(Car.class);
        getCars();
        button =new Button("Repaired");
        buttonListener();
        add(carGrid,button);
    }

    private void getCars() {
        String link ="https://pkowaleckicarsapi.herokuapp.com/allVechicles";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Car>> response=restTemplate.exchange(
                link,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>() {});
        List<Car> resultCarList =response.getBody();
        if(!resultCarList.isEmpty()) carList= resultCarList.stream().filter(e->e.getServiceNeeded().equalsIgnoreCase("true")).collect(Collectors.toList());
        carGrid.setItems(carList);
    }

    private void buttonListener(){
        button.addClickListener(EventListener ->{
            deleteCar();
        });

    }

    private void deleteCar() {
        if (carGrid.getSelectionModel().getFirstSelectedItem().isPresent()) {
            Car car=carGrid.getSelectionModel().getFirstSelectedItem().get();
            car.setServiceNeeded("false");
            consumer.makePut(car);
            carList.remove(car);
            carGrid.setItems(carList);
        } else {
            Notification.show("Something went wrong!",
                    5000, Notification.Position.TOP_CENTER);
        }
    }


}
