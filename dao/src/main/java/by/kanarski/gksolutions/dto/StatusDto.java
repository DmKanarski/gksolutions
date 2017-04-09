package by.kanarski.gksolutions.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@Builder
public class StatusDto {

    private Integer statusId;
    private String statusName;

}
