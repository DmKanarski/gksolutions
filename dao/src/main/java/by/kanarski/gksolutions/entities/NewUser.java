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
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
