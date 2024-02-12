package cl.tecnova.ms.services;

import cl.tecnova.ms.dto.StatusTaskDTO;

import java.util.List;

public interface StatusTaskService {

    List<StatusTaskDTO> getAllStatusTask();

    StatusTaskDTO createStatusTask(StatusTaskDTO statusTask);

    StatusTaskDTO modifiyStatusTaskById(Integer id, StatusTaskDTO statusTaskDTO);

    void deleteStatusTaskById(Integer id);

    StatusTaskDTO getStatusTaskById(Integer id);

}
