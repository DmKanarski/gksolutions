package by.kanarski.gksolutions.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@Builder
public class PhoneTypeDto implements Serializable {

    private Integer phoneTypeId;
    private String phoneTypeName;

}
