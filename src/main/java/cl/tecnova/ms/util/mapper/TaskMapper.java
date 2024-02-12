package cl.tecnova.ms.util.mapper;

import cl.tecnova.ms.dto.TaskDTO;
import cl.tecnova.ms.entities.Task;
import org.modelmapper.ModelMapper;

public class TaskMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public TaskMapper() {
    }

    public static TaskDTO convertToDto(Task task) {
        return (TaskDTO)modelMapper.map(task, TaskDTO.class);
    }

    public static Task convertToEntity(TaskDTO taskDTO) {
        return (Task)modelMapper.map(taskDTO, Task.class);
    }

}
