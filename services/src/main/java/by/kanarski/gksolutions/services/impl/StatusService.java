package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.IStatusDao;
import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.Status;
import by.kanarski.gksolutions.services.interfaces.IStatusService;
import by.kanarski.gksolutions.utils.criteria.Restrictions;
import by.kanarski.gksolutions.utils.criteria.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class StatusService extends ExtendedBaseService<Status, StatusDto> implements IStatusService {

    @Autowired
    private IStatusDao statusDao;

    public Status findByStatusName(String statusName) {
        SearchFilter searchFilter = new SearchFilter()
                .addRestriction(Restrictions.eq(Status.Fields.statusName.name(), statusName));
        return statusDao.getUniqueByFilter(searchFilter);
    }

    @Override
    protected IExtendedBaseDao<Status> getDao() {
        return this.statusDao;
    }
}
