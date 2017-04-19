package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.utils.convert.service.ModelMapperWrapper;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public abstract class EntityConverter<S, D> extends AbstractConverter<S, D> {

    @Autowired
    protected ApplicationContext applicationContext;

    protected ModelMapperWrapper getMapper() {
        return applicationContext.getBean(ModelMapperWrapper.class);
    }


}
