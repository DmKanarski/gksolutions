package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dao.interfaces.IStatusDao;
import by.kanarski.gksolutions.entities.Status;
import by.kanarski.gksolutions.utils.criteria.Restrictions;
import by.kanarski.gksolutions.utils.criteria.SearchFilter;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StringToStatusConverter extends EntityConverter<String, Status> {

    @Override
    public Status convert(String source) {
        IStatusDao statusDao = applicationContext.getBean(IStatusDao.class);
        SearchFilter searchFilter = new SearchFilter()
                .addRestriction(Restrictions.eq(Status.Fields.statusName.name(), source));
        return statusDao.getUniqueByFilter(searchFilter);
    }
}
