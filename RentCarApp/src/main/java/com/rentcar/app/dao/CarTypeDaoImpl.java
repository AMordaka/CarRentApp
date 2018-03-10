package com.rentcar.app.dao;

import com.rentcar.app.model.CarType;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("carTypeDao")
public class CarTypeDaoImpl extends AbstractDao<Integer, CarType> implements CarTypeDao {

    public List<CarType> getAllCarType() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<CarType> carTypes = (List<CarType>) criteria.list();
        return carTypes;
    }


    public CarType findById(int id) {
        return getByKey(id);
    }
}
