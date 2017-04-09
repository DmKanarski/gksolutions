package by.kanarski.gksolutions.utils.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class PropertyValue<T> {

    private List<T> propertyValues = new ArrayList<T>();

    private PropertyValue(T ... propertyValues) {
        Collections.addAll(this.propertyValues, propertyValues);
    }

    public List<T> getList() {
        return propertyValues;
    }

    public T get() {
        return propertyValues.get(0);
    }

//    public void setPropertyValues(List<T> propertyValues) {
//        this.propertyValues = propertyValues;
//    }
//
//    public void setRestictionValues(T ... propertyValues) {
//        Collections.addAll(this.propertyValues, propertyValues);
//    }

    public static <D> PropertyValue<D> newInstance(D ... propertyValues) {
        return new PropertyValue<D>(propertyValues);
    }
}
