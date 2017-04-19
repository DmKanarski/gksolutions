package by.kanarski.gksolutions.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Company extends AbstractEntity {

    private Boolean companyIsLocked;
    private String companyName;
    private Country country;
    private Region region;
    private Document document;
    private Expeditor expeditor;
    private Forwarder forwarder;
    private Adress jurAdress;
    private Adress factAdress;
    private Adress postAdress;
    private CompanyType companyType;
    private String companyRegistrationNumber;
    private String companyAdditionNumber;
    private Integer companyTariffPlan;
    private Double companyBallance;
    private String companySite;
    private Integer companyIsDebt;
    private Date companyLockDate;
    private Double companyKPI;
    private LegalForm legalForm;


    @Column(nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    @Column(nullable = false)
    public Boolean getCompanyIsLocked() {
        return companyIsLocked;
    }

    @Column(nullable = false)
    public Country getCountry() {
        return country;
    }

    @Column
    public Region getRegion() {
        return region;
    }

    @Column(nullable = false)
    public Document getDocument() {
        return document;
    }

    @Column
    public Expeditor getExpeditor() {
        return expeditor;
    }

    @Column
    public Forwarder getForwarder() {
        return forwarder;
    }

    @Column(nullable = false)
    public Adress getJurAdress() {
        return jurAdress;
    }

    @Column
    public Adress getFactAdress() {
        return factAdress;
    }

    public Adress getPostAdress() {
        return postAdress;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public String getCompanyAdditionNumber() {
        return companyAdditionNumber;
    }

    public Integer getCompanyTariffPlan() {
        return companyTariffPlan;
    }

    public Double getCompanyBallance() {
        return companyBallance;
    }

    public String getCompanySite() {
        return companySite;
    }

    public Integer getCompanyIsDebt() {
        return companyIsDebt;
    }

    public Date getCompanyLockDate() {
        return companyLockDate;
    }

    public Double getCompanyKPI() {
        return companyKPI;
    }

    public LegalForm getLegalForm() {
        return legalForm;
    }
}
