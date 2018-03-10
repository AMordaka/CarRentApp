package com.rentcar.app.service;

import com.rentcar.app.dao.CarDao;
import com.rentcar.app.dao.CarTypeDao;
import com.rentcar.app.model.Car;
import com.rentcar.app.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private CarTypeDao carTypeDao;


    public void saveCar(Car car) {
        carDao.save(car);
    }

    public List<Car> findAllCars() {
        return carDao.findAllUsers();
    }

    public void deleteCarByRegNo(String regNo){
        carDao.deleteByRegNo(regNo);
    }

    public List<CarType> findAllCarType() {
        return carTypeDao.getAllCarType();
    }


    public CarType findCarTypeById(int id) {
        return carTypeDao.findById(id);
    }

    public Car findCarById(int id) {
        return carDao.findById(id);
    }

    public Car findCarByRegNo(String regNo) {
        return carDao.findByRegNo(regNo);
    }

    public boolean isRegNoUnique(Integer id, String regNo) {
        Car car = carDao.findByRegNo(regNo);
        return ( car == null || ((id != null) && (car.getId() == id)));
    }


}
