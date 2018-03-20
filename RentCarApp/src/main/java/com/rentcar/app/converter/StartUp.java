package com.rentcar.app.converter;

import com.rentcar.app.model.Car;
import com.rentcar.app.model.User;
import com.rentcar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class StartUp {

    @Autowired
    private CarService carService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() throws ParseException {
        List<Car> cars = carService.findAllCars();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();
        for(Car car : cars){
            if(car.getReturnDate() != null){
                Date returnCarDate = formatter.parse(car.getReturnDate());
                if(today.compareTo(returnCarDate) > 0){
                    carService.freeCar(car,car.getRentUsers().get(0).getSsoId());
                }
            }
        }
    }
}
