package com.rentcar.app.dao.impl;

import com.rentcar.app.dao.AbstractDao;
import com.rentcar.app.dao.UserProfileDao;
import com.rentcar.app.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {

    private static final String TYPE_PROPERTY = "type";

    public UserProfile findById(int id) {
        return getByKey(id);
    }

    public UserProfile findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(TYPE_PROPERTY, type));
        return (UserProfile) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc(TYPE_PROPERTY));
        return (List<UserProfile>) crit.list();
    }

}
