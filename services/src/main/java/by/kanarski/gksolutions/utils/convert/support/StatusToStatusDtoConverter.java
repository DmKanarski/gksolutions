package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.Status;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StatusToStatusDtoConverter extends EntityConverter<Status, StatusDto> {

    @Override
    public StatusDto convert(Status status) {
        Integer stateId = status.getId();
        String stateName = status.getStatusName();
        return StatusDto.builder().statusId(stateId).statusName(stateName).build();
    }
}
