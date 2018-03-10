package com.rentcar.app.dao;

import com.rentcar.app.model.Car;
import com.rentcar.app.model.CarType;
import com.rentcar.app.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("carDao")
public class CarDaoImpl extends AbstractDao<Integer, Car> implements CarDao{

    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public Car findById(int id) {
        return null;
    }

    @Override
    public Car findByRegNo(String regNo) {
        logger.info("RegNo : {}", regNo);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("regNo", regNo));
        Car car = (Car)crit.uniqueResult();
        return car;
    }

    @Override
    public void save(Car car) {
        persist(car);
    }

    @Override
    public void deleteByRegNo(String regNo){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("regNo", regNo));
        Car car = (Car)crit.uniqueResult();
        delete(car);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Car> cars = (List<Car>) criteria.list();
        return cars;
    }

}
