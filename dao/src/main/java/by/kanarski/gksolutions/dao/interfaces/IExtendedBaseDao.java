package by.kanarski.gksolutions.dao.interfaces;

import by.kanarski.gksolutions.utils.criteria.SearchFilter;

import java.util.List;

/**
 * Extended bsae dao interface. Provides additional methods for simple operation with a database
 * @author Dzmitry Kanarski
 * @version 1.0
 * @see IBaseDao
 */
public interface IExtendedBaseDao<T> extends IBaseDao<T> {

    /**
     * Updates list of entities
     * @param tList list of entities to update
     */
    void updateList(List<T> tList);
    
    /**
     * Adds list of entities
     * @param tList list of entities to add
     */
    void addList(List<T> tList);

    /**
     * Recives all entities from table. Not recommended for use
     * @return all entities
     */
    List<T> getAll();

    T getUniqueByFilter(SearchFilter searchFilter);

    List<T> getListByFilter(SearchFilter searchFilter);

}



