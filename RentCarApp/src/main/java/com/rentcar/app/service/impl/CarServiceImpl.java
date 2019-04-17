package com.rentcar.app.service.impl;

import com.rentcar.app.dao.CarDao;
import com.rentcar.app.dao.CarTypeDao;
import com.rentcar.app.dao.UserDao;
import com.rentcar.app.model.Car;
import com.rentcar.app.model.CarType;
import com.rentcar.app.model.User;
import com.rentcar.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;

    @Autowired
    CarTypeDao carTypeDao;

    @Autowired
    UserDao userDao;

    public void saveCar(Car car, String SSO) {
        car.setRegNo(car.getRegNo().toUpperCase());
        carDao.save(car);
        User user = userDao.findBySSO(SSO);
        user.getOwnedCars().add(car);
    }

    public List<Car> findAllCars() {
        return carDao.findAllUsers();
    }

    public void deleteCarByRegNo(String regNo) {
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
        return carDao.checkIfNotExists(regNo);
    }

    public void rentCar(Car car, String SSO) {
        Car entity = carDao.findByRegNo(car.getRegNo());
        User user = userDao.findBySSO(SSO);
        user.getCars().add(entity);
        update(entity, car);
    }

    public void freeCar(Car car, String SSO) {
        Car entity = carDao.findByRegNo(car.getRegNo());
        User user = userDao.findBySSO(SSO);
        user.getCars().remove(entity);
        update(entity, car);
    }

    @Override
    public boolean checkIfExists(String regNo) {
        return !carDao.checkIfNotExists(regNo);
    }

    public List<Car> findUserCars(String SSO) {
        User user = userDao.findBySSO(SSO);
        return (List) new ArrayList(user.getOwnedCars());
    }

    private void update(Car entity, Car car) {
        entity.setRegNo(car.getRegNo());
        entity.setYear(car.getYear());
        entity.setAvailable(false);
        entity.setCarType(car.getCarType());
        entity.setStartDate(car.getStartDate());
        entity.setReturnDate(car.getReturnDate());
    }
}
