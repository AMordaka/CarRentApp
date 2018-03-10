package com.rentcar.app.dao;

import com.rentcar.app.model.CarType;

import java.util.List;

public interface CarTypeDao {

    List<CarType> getAllCarType();

    CarType findById(int id);
}
