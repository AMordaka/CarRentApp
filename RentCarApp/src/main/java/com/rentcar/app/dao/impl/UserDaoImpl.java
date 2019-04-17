package com.rentcar.app.dao.impl;

import com.rentcar.app.dao.AbstractDao;
import com.rentcar.app.dao.UserDao;
import com.rentcar.app.exception.UserNotFoundException;
import com.rentcar.app.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    private static final String SSO_ID_PROPERTY = "ssoId";
    private static final String FIRST_NAME_PROPERTY = "firstName";

    public User findById(int id) {
        Optional<User> optionalUser = Optional.ofNullable(getByKey(id));
        optionalUser.ifPresent(u -> Hibernate.initialize(u.getUserProfiles()));
        return optionalUser.orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
    }

    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(SSO_ID_PROPERTY, sso));
        Optional<User> optionalUser = Optional.ofNullable((User) crit.uniqueResult());
        optionalUser.ifPresent(u -> Hibernate.initialize(u.getUserProfiles()));
        return optionalUser.orElseThrow(() -> new UserNotFoundException(String.valueOf(sso)));
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc(FIRST_NAME_PROPERTY));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<User>) criteria.list();
    }

    @Override
    public boolean checkIfNotExists(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(SSO_ID_PROPERTY, sso));
        return crit.uniqueResult() == null;
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq(SSO_ID_PROPERTY, sso));
        delete((User) crit.uniqueResult());
    }


}
