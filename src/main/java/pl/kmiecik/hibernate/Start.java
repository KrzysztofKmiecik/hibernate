package pl.kmiecik.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private final CarRepository repository;


    @Autowired
    public Start(CarRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        Car car1 = new Car("Polonez", "Caro", Color.BLACK);
        Car car2 = new Car("Fiat", "Polo", Color.RED);
        repository.save(car1);
        repository.save(car2);

    }

}
