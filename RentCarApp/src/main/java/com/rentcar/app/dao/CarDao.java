package com.rentcar.app.dao;

import com.rentcar.app.model.Car;

import java.util.List;

public interface CarDao {

    Car findById(int id);

    Car findByRegNo(String regNo);

    void save(Car car);

    void deleteByRegNo(String regNo);

    List<Car> findAllUsers();

    boolean checkIfNotExists(String regNo);

}
