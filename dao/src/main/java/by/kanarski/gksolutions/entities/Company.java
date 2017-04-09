package by.kanarski.gksolutions.entities;

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
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Company extends AbstactEntity {

    private String companyName;

    public Company(Integer companyId, String companyName) {
        setId(companyId);
        this.companyName = companyName;
    }

    @Column(nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
