package by.kanarski.gksolutions.utils.criteria;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public abstract class AbstractRestriction implements Restriction {

    private String propertyName;
    private RestrictionType restrictionType;

    public AbstractRestriction(String propertyName, RestrictionType restrictionType) {
        this.propertyName = propertyName;
        this.restrictionType = restrictionType;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public abstract PropertyValue getValue();

    public RestrictionType getRestrictionType() {
        return restrictionType;
    }

}
