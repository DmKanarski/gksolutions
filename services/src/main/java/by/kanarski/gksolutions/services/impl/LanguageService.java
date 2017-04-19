package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.dao.interfaces.ILanguageDao;
import by.kanarski.gksolutions.entities.Language;
import by.kanarski.gksolutions.services.interfaces.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LanguageService extends BaseService<Language, String> implements ILanguageService {

    @Autowired
    private ILanguageDao languageDao;

    @Override
    protected IExtendedBaseDao<Language> getDao() {
        return languageDao;
    }
}
