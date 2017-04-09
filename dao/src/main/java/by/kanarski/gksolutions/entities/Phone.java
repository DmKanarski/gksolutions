package by.kanarski.gksolutions.entities;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "phone_id"))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Phone extends AbstactEntity {

    private static final long serialVersionUID = 3481339942436327182L;
    private String phoneNumber;
    private PhoneType phoneType;

    public Phone(Integer phoneId, String phoneNumber, PhoneType phoneType) {
        setId(phoneId);
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    @Column(nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ManyToOne
    @JoinColumn(
            name = "phoneType_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_phone_phone_type")
    )
    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
