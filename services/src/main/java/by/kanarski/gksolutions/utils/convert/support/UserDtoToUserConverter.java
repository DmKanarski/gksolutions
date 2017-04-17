package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.*;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class UserDtoToUserConverter extends EntityConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        Integer userId = userDto.getUserId();
        String firstName = userDto.getFirstName();
        String middleName = userDto.getMiddleName();
        String lastName = userDto.getLastName();
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        String skype = userDto.getSkype();
        Set<Phone> phoneSet = getConversionService().convert(userDto.getPhoneSet(), Phone.class);
        Company company = getConversionService().convert(userDto.getCompany(), Company.class);
        Set<User> childUsersSet = getConversionService().convert(userDto.getChildUsersSet(), User.class);
        User parentUser = getConversionService().convert(userDto.getParentUser(), User.class);
        Timestamp createTime = new Timestamp(userDto.getCreateTime().getTime());
        Set<Role> roleSet = getConversionService().convert(userDto.getRoleSet(), Role.class);
        Status userStatus = getConversionService().convert(userDto.getUserStatus(), Status.class);
        return User.builder().userId(userId).firstName(firstName).middleName(middleName).lastName(lastName).email(email)
                .password(password).skype(skype).phoneSet(phoneSet).company(company).childUsersSet(childUsersSet)
                .parentUser(parentUser).createTime(createTime).roleSet(roleSet).userStatus(userStatus).build();

    }
}
