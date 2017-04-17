package by.kanarski.gksolutions.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Root abstract entity
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 5677570538293781869L;

    private Integer id;

    @Id
    @GenericGenerator(
            name = "increment",
            strategy = "increment"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "increment"
    )
    @Column(
            unique = true,
            nullable = false
    )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
