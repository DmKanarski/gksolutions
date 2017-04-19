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
@AttributeOverride(name = "id", column = @Column(name = "document_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DocumentStatus {

    private String documentStatusName;

    @Column(unique = true, nullable = false)
    public String getDocumentStatusName() {
        return documentStatusName;
    }
}
