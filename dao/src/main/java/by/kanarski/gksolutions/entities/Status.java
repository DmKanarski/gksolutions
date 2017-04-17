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
@AttributeOverride(name = "id", column = @Column(name = "status_id"))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Status extends AbstractEntity {

    private static final long serialVersionUID = 2321941631442869449L;

    private String statusName;

    @Builder
    public Status(Integer statusId, String statusName) {
        setId(statusId);
        this.statusName = statusName;
    }

    @Column(
            unique = true,
            nullable = false
    )
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String stateName) {
        this.statusName = stateName;
    }

    public enum Fields {statusName, serialVersionUID}
}
