package by.kanarski.gksolutions.services.interfaces;

import by.kanarski.gksolutions.dto.user.UserDto;
import by.kanarski.gksolutions.entities.User;

/**
 * User service service interface
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IUserService extends IExtendedBaseService<User, UserDto> {

    /**
     * Recives user DTO with status active by email
     * @param email user email
     * @return required user DTO
     */
    UserDto getByEmail(String email);

    /**
     * Checks whether a user with given credentials in the database
     * @param userDto user DTO, that contains required credentials
     * @return true, if with same credentials exist, else false
     */
    boolean isNewUser(UserDto userDto);

    /**
     * Adds user into database
     * @param userDto an user to addRestriction
     */
    void registerUser(UserDto userDto);

}
