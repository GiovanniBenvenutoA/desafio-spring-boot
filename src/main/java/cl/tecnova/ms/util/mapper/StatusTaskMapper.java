package cl.tecnova.ms.util.mapper;

import cl.tecnova.ms.dto.StatusTaskDTO;
import cl.tecnova.ms.entities.StatusTask;
import org.modelmapper.ModelMapper;

public class StatusTaskMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public StatusTaskMapper() {
    }

    public static StatusTaskDTO convertToDto(StatusTask statusTask) {
        return (StatusTaskDTO) modelMapper.map(statusTask, StatusTaskDTO.class);
    }

    public static StatusTask convertToEntity(StatusTaskDTO statusTaskDTO) {
        return (StatusTask)modelMapper.map(statusTaskDTO, StatusTask.class);
    }

}
