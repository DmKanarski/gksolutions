package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.utils.SystemLanguagesManager;
import by.kanarski.gksolutions.utils.convert.service.IEntityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class EntityConverter {

    @Autowired
    protected SystemLanguagesManager systemLanguagesManager;
    @Autowired
    protected ApplicationContext applicationContext;

    protected IEntityConversionService getConversionService() {
        return applicationContext.getBean(IEntityConversionService.class);
    }


}
