package by.kanarski.gksolutions.utils.criteria;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

class SimpleRestriction extends AbstractRestriction {

    private PropertyValue propertyValue;

    public SimpleRestriction(String propertyName, PropertyValue propertyValue, RestrictionType restrictionType) {
        super(propertyName, restrictionType);
        this.propertyValue = propertyValue;
    }

    @Override
    public PropertyValue getValue() {
        return this.propertyValue;
    }
}
