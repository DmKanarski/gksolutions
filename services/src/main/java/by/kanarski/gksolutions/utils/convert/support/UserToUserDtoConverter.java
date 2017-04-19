package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.CompanyDto;
import by.kanarski.gksolutions.dto.PhoneDto;
import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class UserToUserDtoConverter extends EntityConverter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        Integer userId = user.getId();
        String firstName = user.getFirstName();
        String middleName = user.getMiddleName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        String skype = user.getSkype();
        Set<PhoneDto> phoneDtoSet = getMapper().map(user.getPhoneSet(), PhoneDto.class);
        CompanyDto companyDto = getMapper().map(user.getCompany(), CompanyDto.class);
        Set<User> childUsersSet = user.getChildUsersSet();
        Set<UserDto> childUserDtosSet = CollectionUtils.isNotEmpty(childUsersSet)
                ? getMapper().map(childUsersSet, UserDto.class)
                : null;
        User parentUser = user.getParentUser();
        UserDto parentUserDto = (parentUser != null)
                ? getMapper().map(parentUser, UserDto.class)
                : null;
        Date createTime = user.getCreateTime();
        Set<String> roleSet = getMapper().map(user.getRoleSet(), String.class);
        String userStatus = getMapper().map(user.getUserStatus(), String.class);
        return UserDto.builder().userId(userId).firstName(firstName).middleName(middleName).lastName(lastName)
                .email(email).password(password).skype(skype).phoneSet(phoneDtoSet).company(companyDto)
                .childUsersSet(childUserDtosSet).parentUser(parentUserDto).createTime(createTime).roleSet(roleSet)
                .userStatus(userStatus).build();
    }
}
