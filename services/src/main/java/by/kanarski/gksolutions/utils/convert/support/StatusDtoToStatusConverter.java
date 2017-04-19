package by.kanarski.gksolutions.utils.convert.support;


import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.Status;
import org.springframework.stereotype.Component;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class StatusDtoToStatusConverter extends EntityConverter<StatusDto, Status> {

    @Override
    public Status convert(StatusDto statusDto) {
        Integer stateId = statusDto.getStatusId();
        String stateName = statusDto.getStatusName();
        return Status.builder().statusId(stateId).statusName(stateName).build();
    }
}
