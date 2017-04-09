package by.kanarski.gksolutions.controllers;

import by.kanarski.gksolutions.constants.Pages;
import by.kanarski.gksolutions.constants.Parameter;
import by.kanarski.gksolutions.dto.UserDto;
import by.kanarski.gksolutions.utils.SystemLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
@RequestMapping(Pages.PAGE_START)
public class IndexController {

    private static final SystemLogger LOGGER = SystemLogger.getInstance().setSender(UserController.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {Pages.PAGE_INDEX, Pages.PAGE_START}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView toMainPage(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject(Parameter.USER, new UserDto());
        modelAndView.setViewName(Pages.PAGE_INDEX);
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request) {
        LOGGER.logError("ERROR");
        return Pages.PAGE_ERROR;
    }

    private String getMessage(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

}
