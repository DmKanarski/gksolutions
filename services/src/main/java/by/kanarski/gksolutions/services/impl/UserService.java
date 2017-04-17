package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.constants.StateValue;
import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.IUserDao;
import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.User;
import by.kanarski.gksolutions.services.interfaces.ICompanyService;
import by.kanarski.gksolutions.services.interfaces.IPhoneService;
import by.kanarski.gksolutions.services.interfaces.IUserService;
import by.kanarski.gksolutions.utils.criteria.Restrictions;
import by.kanarski.gksolutions.utils.criteria.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserService extends ExtendedBaseService<User, UserDto> implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IPhoneService phoneService;

    @Override
    public void registerUser(UserDto userDto) {
        companyService.add(userDto.getCompany());
        phoneService.addAllOf(userDto.getPhoneSet());
        userDto.getRoleSet().add(StateValue.ROLE_USER);
        userDto.setUserStatus(StateValue.STATUS_ACTIVE);
        User user = conversionService.convert(userDto, User.class);
        userDao.add(user);
    }

    /**
     * Recives user DTO with status active by email
     *
     * @param email user email
     * @return required user DTO
     */
    @Override
    public UserDto getByEmail(String email) {
        SearchFilter searchFilter = new SearchFilter()
                .addRestriction(Restrictions.eq(User.Fields.email.name(), email));
        User user = userDao.getUniqueByFilter(searchFilter);
        return conversionService.convert(user, UserDto.class);
    }

    /**
     * Checks whether a user with given credentials in the database
     *
     * @param userDto user DTO, that contains required credentials
     * @return true, if with same credentials exist, else false
     */
    @Override
    public boolean isNewUser(UserDto userDto) {
        return false;
    }

    @Override
    protected IExtendedBaseDao<User> getDao() {
        return userDao;
    }
}