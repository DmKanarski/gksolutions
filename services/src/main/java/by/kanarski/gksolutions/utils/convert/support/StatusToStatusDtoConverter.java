package by.kanarski.gksolutions.utils.convert.support;

import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.Status;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class StatusToStatusDtoConverter extends EntityConverter implements Converter<Status, StatusDto> {

    @Override
    public StatusDto convert(Status status) {
        Integer stateId = status.getId();
        String stateName = status.getStatusName();
        return StatusDto.builder().statusId(stateId).statusName(stateName).build();
    }
}
