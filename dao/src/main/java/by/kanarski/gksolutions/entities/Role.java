package by.kanarski.gksolutions.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Role extends AbstractEntity {

    private static final long serialVersionUID = 2321941631442869449L;
    private String stateName;

    @Builder
    public Role(Integer roleId, String stateName) {
        setId(roleId);
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
