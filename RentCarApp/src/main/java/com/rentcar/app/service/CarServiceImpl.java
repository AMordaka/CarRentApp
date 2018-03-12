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

import java.util.List;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private CarTypeDao carTypeDao;

    @Autowired
    private UserDao userDao;


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


}
