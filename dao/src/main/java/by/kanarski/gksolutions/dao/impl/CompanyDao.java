package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.ICompanyDao;
import by.kanarski.gksolutions.entities.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public class CompanyDao extends ExtendedBaseDao<Company> implements ICompanyDao {

    @Autowired
    public CompanyDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
