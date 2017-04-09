package by.kanarski.gksolutions.services.impl;

import by.kanarski.gksolutions.dao.interfaces.IExtendedBaseDao;
import by.kanarski.gksolutions.services.interfaces.IExtendedBaseService;
import by.kanarski.gksolutions.utils.convert.service.IEntityConversionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public abstract class ExtendedBaseService<E, D> implements IExtendedBaseService<E, D> {
    
    @Autowired
    protected IEntityConversionService conversionService;

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public void add(D dto) {
        E entity = conversionService.convert(dto, getEntityClass());
        getDao().add(entity);
    }

    @Override
    public D getById(Long id) {
        E entity = getDao().getById(id);
        return conversionService.convert(entity, getDtoClass());
    }

    @Override
    public void update(D dto) {
        E entity = conversionService.convert(dto, getEntityClass());
        getDao().update(entity);
    }

    @Override
    public void delete(D dto) {
        E entity = conversionService.convert(dto, getEntityClass());
        getDao().delete(entity);
    }

    @Override
    public void updateAllOf(Collection<D> dtoCollection) {
        getDao().updateList(convertToEntityList(dtoCollection));
    }

    @Override
    public void addAllOf(Collection<D> dtoCollection) {
        getDao().addList(convertToEntityList(dtoCollection));
    }

    protected Class<E> getEntityClass() {
        Type superclass = getClass().getGenericSuperclass();
        Class<E> persistentClass = null;
        if (!superclass.equals(Object.class)) {
            ParameterizedType classType = (ParameterizedType) superclass;
            persistentClass = (Class<E>) classType.getActualTypeArguments()[0];
        }
        return persistentClass;
    }

    protected Class<D> getDtoClass() {
        Type superclass = getClass().getGenericSuperclass();
        Class<D> persistentClass = null;
        if (!superclass.equals(Object.class)) {
            ParameterizedType classType = (ParameterizedType) superclass;
            persistentClass = (Class<D>) classType.getActualTypeArguments()[1];
        }
        return persistentClass;
    }

    private List<E> convertToEntityList(Collection<D> dtoCollection) {
        List<E> entityList = null;
        if (dtoCollection instanceof Set) {
            entityList = conversionService.convertSetToList((Set<D>) dtoCollection, getEntityClass());
        }
        if (dtoCollection instanceof List) {
            entityList = conversionService.convert((List<D>) dtoCollection, getEntityClass());
        }
        return entityList;
    }

    protected abstract IExtendedBaseDao<E> getDao();

}
