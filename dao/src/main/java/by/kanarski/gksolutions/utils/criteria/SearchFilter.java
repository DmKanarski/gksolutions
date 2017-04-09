package by.kanarski.gksolutions.utils.criteria;

import java.util.List;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class SearchFilter {

    private List<Restriction> restrictionList;

    public SearchFilter addRestriction(Restriction restriction) {
        restrictionList.add(restriction);
        return this;
    }

    public List<Restriction> getRestrictionList() {
        return restrictionList;
    }

}
