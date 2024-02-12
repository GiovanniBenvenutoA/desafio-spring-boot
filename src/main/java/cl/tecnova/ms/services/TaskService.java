package cl.tecnova.ms.services;

import cl.tecnova.ms.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getAllTask();

    TaskDTO createTask(TaskDTO newTask);

    TaskDTO modifiyTaskById(Integer id, TaskDTO updateTask);

    void deleteTaskById(Integer id);

    TaskDTO getTaskById(Integer id);
}
