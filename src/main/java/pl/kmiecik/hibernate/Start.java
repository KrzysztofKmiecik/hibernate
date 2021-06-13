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
        Car car3 = new Car("Fiat", "126p", Color.RED);
        Car car4 = new Car("BMW", "A1", Color.RED);
        repository.save(car1);
        repository.save(car2);
        repository.save(car3);
        repository.save(car4);

        //repository.findAll().forEach(System.out::println);
        //  repository.findCarsByColor(Color.RED).forEach(System.out::println);
      //  repository.findCarsByColorAndMark(Color.RED, "Fiat").forEach(System.out::println);
        repository.findCarsByModelMyImpl("Caro").forEach(System.out::println);

    }

}
