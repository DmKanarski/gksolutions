package by.kanarski.gksolutions.utils;

import by.kanarski.gksolutions.dao.interfaces.ILanguageDao;
import by.kanarski.gksolutions.entities.Language;
import by.kanarski.gksolutions.utils.wrappers.SystemLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class SystemLanguagesManager {

    @Autowired
    private ILanguageDao languageDao;

    private SystemLanguages systemLanguages;

    private SystemLanguages getSystemLanguages() {
        if (systemLanguages == null || systemLanguages.size() == 0) {
            systemLanguages = new SystemLanguages();
            List<Language> languageList = languageDao.getAll();
            for (Language language : languageList) {
                systemLanguages.add(language.getName());
            }
        }
        return systemLanguages;
    }

    public Long getLanguageId(String language) {
        return (Integer.toUnsignedLong(getSystemLanguages().indexOf(language.toUpperCase())) + 1);
    }

    public String getLanguage(Long languageId) {
        return getSystemLanguages().get(languageId.intValue() - 1);
    }

}
