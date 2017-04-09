package by.kanarski.gksolutions.controllers;

import by.kanarski.gksolutions.constants.Pages;
import by.kanarski.gksolutions.constants.Parameter;
import by.kanarski.gksolutions.dto.UserDto;
import by.kanarski.gksolutions.services.interfaces.IUserService;
import by.kanarski.gksolutions.utils.SystemLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private static final SystemLogger LOGGER = SystemLogger.getInstance().setSender(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestParam(Parameter.USER) UserDto userDto,
                                          BindingResult bindingResult, Model model) {
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            model.addAttribute(Parameter.REGISTRATION_MESSAGE, "empty fields");
            headers.add("Response-Status", "validation error");
            return new ResponseEntity<>(errorList, headers, HttpStatus.OK);
        }
        userService.registerUser(userDto);
        return new ResponseEntity<>("Succesful created", HttpStatus.CREATED);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request) {
        LOGGER.logError("ERROR");
        return Pages.PAGE_ERROR;
    }

}
