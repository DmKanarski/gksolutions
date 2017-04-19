package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.INewUserDao;
import by.kanarski.gksolutions.entities.NewUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class NewUserDao extends ExtendedBaseDao<NewUser> implements INewUserDao {

    @Autowired
    public NewUserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
