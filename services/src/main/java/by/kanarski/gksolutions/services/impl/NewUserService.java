package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.INewUserDao;
import by.kanarski.gksolutions.dto.user.NewUserDto;
import by.kanarski.gksolutions.entities.NewUser;
import by.kanarski.gksolutions.services.interfaces.INewUserService;
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
public class NewUserService extends BaseService<NewUser, NewUserDto> implements INewUserService {

    @Autowired
    private INewUserDao newUserDao;

    @Override
    protected IExtendedBaseDao<NewUser> getDao() {
        return newUserDao;
    }
}
