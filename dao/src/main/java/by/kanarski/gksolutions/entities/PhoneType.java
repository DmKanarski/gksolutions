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
@AttributeOverride(name = "id", column = @Column(name = "phone_type_id"))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PhoneType extends AbstactEntity {

    private String phoneTypeName;

    @Builder
    public PhoneType(Integer phoneTypeId, String phoneTypeName) {
        setId(phoneTypeId);
        this.phoneTypeName = phoneTypeName;
    }

    @Column(
            unique = true,
            nullable = false
    )
    public String getPhoneTypeName() {
        return phoneTypeName;
    }

    public void setPhoneTypeName(String phoneTypeName) {
        this.phoneTypeName = phoneTypeName;
    }
}
