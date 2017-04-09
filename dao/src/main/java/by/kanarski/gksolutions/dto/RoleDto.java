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
public class RoleDto implements Serializable {

    private Integer roleId;
    private String roleName;

}
