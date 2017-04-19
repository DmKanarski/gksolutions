package by.kanarski.gksolutions.entities;

import lombok.Builder;
import lombok.Data;
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
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class NewUser extends AbstractEntity {

    private static final long serialVersionUID = 4151799960482680421L;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String skype;
    private String phone;

    @Builder
    public NewUser(Integer userId, String firstName, String middleName, String lastName, String email,
                   String password, String passwordConfirmation, String skype, String phone) {
        super(userId);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.skype = skype;
        this.phone = phone;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    @Column
    public String getMiddleName() {
        return middleName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    @Column
    public String getEmail() {
        return email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    @Column
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    @Column
    public String getSkype() {
        return skype;
    }

    @Column
    public String getPhone() {
        return phone;
    }
}
