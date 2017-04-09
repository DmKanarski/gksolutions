package by.kanarski.gksolutions.utils.convert.support;


import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.Status;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class StatusDtoToStatusConverter extends EntityConverter implements Converter<StatusDto, Status> {

    @Override
    public Status convert(StatusDto statusDto) {
        Integer stateId = statusDto.getStatusId();
        String stateName = statusDto.getStatusName();
        return Status.builder().statusId(stateId).statusName(stateName).build();
    }
}
