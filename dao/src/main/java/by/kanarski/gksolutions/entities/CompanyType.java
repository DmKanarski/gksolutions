package by.kanarski.gksolutions.entities;

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
@AttributeOverride(name = "id", column = @Column(name = "company_type_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CompanyType extends AbstractEntity {

    private static final long serialVersionUID = 8654143971583271601L;
    private String companyTypeName;

    @Column(unique = true, nullable = false)
    public String getCompanyTypeName() {
        return companyTypeName;
    }
}
