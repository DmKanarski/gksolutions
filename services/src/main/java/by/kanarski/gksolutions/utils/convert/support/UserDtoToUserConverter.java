package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class UserDtoToUserConverter extends EntityConverter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        Integer userId = userDto.getUserId();
        String firstName = userDto.getFirstName();
        String middleName = userDto.getMiddleName();
        String lastName = userDto.getLastName();
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        String skype = userDto.getSkype();
        Set<Phone> phoneSet = getMapper().map(userDto.getPhoneSet(), Phone.class);
        Company company = getMapper().map(userDto.getCompany(), Company.class);
        Set<User> childUsersSet = getMapper().map(userDto.getChildUsersSet(), User.class);
        User parentUser = getMapper().map(userDto.getParentUser(), User.class);
        Timestamp createTime = new Timestamp(userDto.getCreateTime().getTime());
        Set<Role> roleSet = getMapper().map(userDto.getRoleSet(), Role.class);
        Status userStatus = getMapper().map(userDto.getUserStatus(), Status.class);
        return User.builder().userId(userId).firstName(firstName).middleName(middleName).lastName(lastName).email(email)
                .password(password).skype(skype).phoneSet(phoneSet).company(company).childUsersSet(childUsersSet)
                .parentUser(parentUser).createTime(createTime).roleSet(roleSet).userStatus(userStatus).build();

    }
}
