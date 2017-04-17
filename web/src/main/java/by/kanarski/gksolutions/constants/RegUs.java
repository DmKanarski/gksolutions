package by.kanarski.gksolutions.constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegUs implements Serializable {

    private static final long serialVersionUID = -28116580794827858L;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String skype;
    private String phoneNumber;

}
