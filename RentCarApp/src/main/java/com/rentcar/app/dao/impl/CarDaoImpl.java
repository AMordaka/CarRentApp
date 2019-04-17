package com.rentcar.app.dao.impl;

import com.rentcar.app.dao.AbstractDao;
import com.rentcar.app.dao.CarDao;
import com.rentcar.app.exception.CarNotFoundException;
import com.rentcar.app.model.Car;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("carDao")
public class CarDaoImpl extends AbstractDao<Integer, Car> implements CarDao {

    private static final String REG_NO_PROPERTY = "regNo";

    @Override
    public Car findById(int id) {
        Optional<Car> optionalCar = Optional.ofNullable(getByKey(id));
        return optionalCar.orElseThrow(() -> new CarNotFoundException(String.valueOf(id)));
    }

    @Override
    public Car findByRegNo(String regNo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(REG_NO_PROPERTY, regNo));
        Optional<Car> optionalCar = Optional.ofNullable((Car) crit.uniqueResult());
        return optionalCar.orElseThrow(() -> new CarNotFoundException(String.valueOf(regNo)));
    }

    @Override
    public void save(Car car) {
        persist(car);
    }

    @Override
    public void deleteByRegNo(String regNo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(REG_NO_PROPERTY, regNo));
        delete((Car) crit.uniqueResult());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Car>) criteria.list();
    }

    @Override
    public boolean checkIfNotExists(String regNo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(REG_NO_PROPERTY, regNo.toUpperCase()));
        return crit.uniqueResult() == null;
    }

}
