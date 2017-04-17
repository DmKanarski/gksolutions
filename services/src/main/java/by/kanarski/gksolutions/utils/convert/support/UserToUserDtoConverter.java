package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.CompanyDto;
import by.kanarski.gksolutions.dto.PhoneDto;
import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class UserToUserDtoConverter extends EntityConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        Integer userId = user.getId();
        String firstName = user.getFirstName();
        String middleName = user.getMiddleName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        String skype = user.getSkype();
        Set<PhoneDto> phoneDtoSet = getConversionService().convert(user.getPhoneSet(), PhoneDto.class);
        CompanyDto companyDto = getConversionService().convert(user.getCompany(), CompanyDto.class);
        Set<User> childUsersSet = user.getChildUsersSet();
        Set<UserDto> childUserDtosSet = CollectionUtils.isNotEmpty(childUsersSet)
                ? getConversionService().convert(childUsersSet, UserDto.class)
                : null;
        User parentUser = user.getParentUser();
        UserDto parentUserDto = (parentUser != null)
                ? getConversionService().convert(parentUser, UserDto.class)
                : null;
        Date createTime = user.getCreateTime();
        Set<String> roleSet = getConversionService().convert(user.getRoleSet(), String.class);
        String userStatus = getConversionService().convert(user.getUserStatus(), String.class);
        return UserDto.builder().userId(userId).firstName(firstName).middleName(middleName).lastName(lastName)
                .email(email).password(password).skype(skype).phoneSet(phoneDtoSet).company(companyDto)
                .childUsersSet(childUserDtosSet).parentUser(parentUserDto).createTime(createTime).roleSet(roleSet)
                .userStatus(userStatus).build();
    }
}
