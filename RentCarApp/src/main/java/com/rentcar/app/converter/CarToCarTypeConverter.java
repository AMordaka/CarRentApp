package com.rentcar.app.converter;

import com.rentcar.app.model.CarType;
import com.rentcar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarToCarTypeConverter implements Converter<Object, CarType> {

    @Autowired
    CarService carService;

    public CarType convert(Object element) {
        String carTypeToString = (String) element;

        if (carTypeToString.contains("-")) {
            carTypeToString = carTypeToString.substring(0, carTypeToString.indexOf("-")).replaceAll("\\s+", "");
        }

        Integer id = Integer.parseInt(carTypeToString);
        CarType carType = carService.findCarTypeById(id);
        return carType;
    }

}