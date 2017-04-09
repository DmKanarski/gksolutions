package by.kanarski.gksolutions.utils;

import by.kanarski.gksolutions.utils.criteria.Restriction;
import by.kanarski.gksolutions.utils.criteria.RestrictionType;
import by.kanarski.gksolutions.utils.criteria.SearchFilter;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class CriteriaBuilder {

    private SessionFactory sessionFactory;

    @Autowired
    public CriteriaBuilder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> Criteria createCriteria(SearchFilter searchFilter, Class<T> entityClass) {
        return new Builder<>(searchFilter, entityClass).create();
    }

    private class Builder<E> {

        private Criteria criteria;
        private SearchFilter searchFilter;

        Builder(SearchFilter searchFilter, Class<E> entityClass) {
            this.searchFilter = searchFilter;
            this.criteria = sessionFactory
                    .getCurrentSession()
                    .createCriteria(entityClass);
        }

        Criteria create() {
            for (Restriction restriction : searchFilter.getRestrictionList()) {
                criteria.add(convert(restriction));
            }
            return criteria;
        }

        private Criterion convert(Restriction restriction) {
            RestrictionType restrictionType = restriction.getRestrictionType();
            switch (restrictionType) {
                case EQ: {
                    return Restrictions.eq(restriction.getPropertyName(), restriction.getValue().get());
                }
                default: {
                    throw new EnumConstantNotPresentException(RestrictionType.class, restrictionType.name());
                }
            }
        }
    }

}
