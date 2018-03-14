package com.rentcar.app.service;

import com.rentcar.app.model.Car;
import com.rentcar.app.model.CarType;

import java.util.List;
import java.util.Set;

public interface CarService {

    void saveCar(Car car, String SSO);

    List<Car> findAllCars();

    void deleteCarByRegNo(String rego);

    List<CarType> findAllCarType();

    List<Car> findUserCars(String SSO);

    boolean isRegNoUnique(Integer id, String regNo);

    CarType findCarTypeById(int id);

    Car findCarById(int id);

    Car findCarByRegNo(String regNo);

    void updateCar(Car car);

    void rentCar(Car car, String SSO);
}
