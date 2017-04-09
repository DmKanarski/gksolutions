package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.IPhoneDao;
import by.kanarski.gksolutions.dto.PhoneDto;
import by.kanarski.gksolutions.entities.Phone;
import by.kanarski.gksolutions.services.interfaces.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PhoneService extends ExtendedBaseService<Phone, PhoneDto> implements IPhoneService {

    @Autowired
    private IPhoneDao phoneDao;

    @Override
    protected IExtendedBaseDao<Phone> getDao() {
        return phoneDao;
    }
}
