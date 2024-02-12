package cl.tecnova.ms.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import cl.tecnova.ms.dto.TaskDTO;
import cl.tecnova.ms.entities.Task;
import cl.tecnova.ms.repository.TaskRepository;
import cl.tecnova.ms.services.TaskService;
import cl.tecnova.ms.util.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskServiceImpl() {
    }

    public List<TaskDTO> getAllTask() {
        List<Task> tasks = this.taskRepository.findAll();
        return (List)tasks.stream().map(TaskMapper::convertToDto).collect(Collectors.toList());
    }

    public TaskDTO createTask(TaskDTO newTask) {
        Task newTaskEntity = TaskMapper.convertToEntity(newTask);
        Task savedTaskEntity = (Task)this.taskRepository.save(newTaskEntity);
        return TaskMapper.convertToDto(savedTaskEntity);
    }

    public TaskDTO modifiyTaskById(Integer id, TaskDTO updateTask) {
        Task existingTaskEntity = (Task)this.taskRepository.findById(id.longValue()).orElse(null);
        if (existingTaskEntity != null) {
            existingTaskEntity.setTaskName(updateTask.getStackName());
            existingTaskEntity.setTaskDescription(updateTask.getTaskDescription());
            Task updatedTaskEntity = (Task)this.taskRepository.save(existingTaskEntity);
            return TaskMapper.convertToDto(updatedTaskEntity);
        } else {
            return null;
        }
    }

    public void deleteTaskById(Integer id) {
        this.taskRepository.deleteById(id.longValue());
    }

    public TaskDTO getTaskById(Integer id) {
        Task taskEntity = (Task)this.taskRepository.findById(id.longValue()).orElse(null);
        return taskEntity != null ? TaskMapper.convertToDto(taskEntity) : null;
    }


}
