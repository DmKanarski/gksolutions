package by.kanarski.gksolutions.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "adress_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Adress extends AbstractEntity {

    private static final long serialVersionUID = 2863736577363347459L;
    private String adressZipcode;
    private String adressFull;
    private Integer adressType;
    private Country country;
    private Region region;

    @Column(nullable = false)
    public String getAdressZipcode() {
        return adressZipcode;
    }

    @Column(nullable = false)
    public String getAdressFull() {
        return adressFull;
    }

    @Column(nullable = false)
    public Integer getAdressType() {
        return adressType;
    }

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_adress_c_country1")
    )
    public Country getCountry() {
        return country;
    }

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_adress_c_region1")
    )
    public Region getRegion() {
        return region;
    }
}
