package by.kanarski.gksolutions.services.interfaces;

import by.kanarski.gksolutions.dto.StatusDto;
import by.kanarski.gksolutions.entities.Status;

/**
 * Language service interface
 * @author Dzmitry Kanarski
 * @version 1.0
 */
public interface IStatusService extends IBaseService<Status, StatusDto> {

    Status findByStatusName(String statusName);

}
