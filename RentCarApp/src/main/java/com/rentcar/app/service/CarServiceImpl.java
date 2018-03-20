package com.rentcar.app.service;

import com.rentcar.app.dao.CarDao;
import com.rentcar.app.dao.CarTypeDao;
import com.rentcar.app.dao.UserDao;
import com.rentcar.app.model.Car;
import com.rentcar.app.model.CarType;
import com.rentcar.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private CarTypeDao carTypeDao;

    @Autowired
    private UserDao userDao;


    public void saveCar(Car car, String SSO) {
        carDao.save(car);
        User user = userDao.findBySSO(SSO);
        user.getOwnedCars().add(car);
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

    public void updateCar(Car car) {
        Car entity = carDao.findByRegNo(car.getRegNo());
        if(entity!=null){
            entity.setRegNo(car.getRegNo());
            entity.setYear(car.getYear());
            entity.setAvailable(false);
            entity.setCarType(car.getCarType());
            entity.setStartDate(car.getStartDate());
            entity.setReturnDate(car.getReturnDate());
        }
    }

    public void rentCar(Car car, String SSO){
        Car entity = carDao.findByRegNo(car.getRegNo());
        User user = userDao.findBySSO(SSO);
        if(entity!=null){
            entity.setRegNo(car.getRegNo());
            entity.setYear(car.getYear());
            entity.setAvailable(false);
            entity.setCarType(car.getCarType());
            entity.setStartDate(car.getStartDate());
            entity.setReturnDate(car.getReturnDate());
            user.getCars().add(car);
        }
    }

    public void freeCar(Car car, String SSO){
        Car entity = carDao.findByRegNo(car.getRegNo());
        User user = userDao.findBySSO(SSO);
        if(entity!=null){
            user.getCars().remove(entity);
            entity.setRegNo(car.getRegNo());
            entity.setYear(car.getYear());
            entity.setAvailable(true);
            entity.setCarType(car.getCarType());
            entity.setStartDate(null);
            entity.setReturnDate(null);

        }
    }

    public List<Car> findUserCars(String SSO) {
        User user = userDao.findBySSO(SSO);
        List cars = new ArrayList();
        cars.addAll(user.getOwnedCars());
        return cars;
    }
}
