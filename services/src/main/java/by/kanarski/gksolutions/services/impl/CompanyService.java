package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.ICompanyDao;
import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dto.CompanyDto;
import by.kanarski.gksolutions.entities.Company;
import by.kanarski.gksolutions.services.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
public class CompanyService extends ExtendedBaseService<Company, CompanyDto> implements ICompanyService {

    @Autowired
    private ICompanyDao companyDao;

    @Override
    protected IExtendedBaseDao<Company> getDao() {
        return companyDao;
    }
}
