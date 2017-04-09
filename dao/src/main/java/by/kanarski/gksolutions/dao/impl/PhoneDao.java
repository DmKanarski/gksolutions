package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.IPhoneDao;
import by.kanarski.gksolutions.entities.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class PhoneDao extends ExtendedBaseDao<Phone> implements IPhoneDao {

    @Autowired
    public PhoneDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
