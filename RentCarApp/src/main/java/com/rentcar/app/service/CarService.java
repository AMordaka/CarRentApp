package com.rentcar.app.service;

import com.rentcar.app.model.Car;
import com.rentcar.app.model.CarType;

import java.util.List;

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

    void rentCar(Car car, String SSO);

    void freeCar(Car car, String SSO);

    boolean checkIfExists(String regNo);
}
