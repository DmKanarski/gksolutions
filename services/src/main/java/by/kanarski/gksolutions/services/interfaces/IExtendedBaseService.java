package by.kanarski.gksolutions.services.interfaces;

import java.util.Collection;

/**
 * Extended base service interface. Uses DTO as return parameter.
 * For transformations entity <--> DTO uses DtoToEntityConverter
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IExtendedBaseService<E, D> {
    
    /**
     * Appends entity in the database
     * @param t DTO to be appended to database
     */
    void add(D t);

    /**
     * Recives DTO from databse by id
     * @param id the entity id
     * @return DTO with the corresponding id
     */
    D getById(Long id);

    /**
     * Updates entity in database
     * @param t DTO to be update
     */
    void update(D t);

    /**
     * Deletes entity in database
     * @param t DTO to delete
     */
    void delete(D t);

    /**
     * Updates list of entities
     * @param tList list of DTOs to update
     */
    void updateAllOf(Collection<D> tList);

    /**
     * Adds list of entities
     * @param tList  list of DTOs to addRestriction
     */
    void addAllOf(Collection<D> tList);
}
