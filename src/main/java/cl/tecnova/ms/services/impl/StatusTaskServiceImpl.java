package cl.tecnova.ms.services.impl;

import cl.tecnova.ms.dto.StatusTaskDTO;
import cl.tecnova.ms.entities.StatusTask;
import cl.tecnova.ms.repository.StatusTaskRepository;
import cl.tecnova.ms.services.StatusTaskService;
import cl.tecnova.ms.util.mapper.StatusTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StatusTaskServiceImpl implements StatusTaskService {

    @Autowired
    StatusTaskRepository statusTaskRepository;

    public StatusTaskServiceImpl() {
    }

    public List<StatusTaskDTO> getAllStatusTask() {
        List<StatusTask> statusTasks = this.statusTaskRepository.findAll();
        return (List)statusTasks.stream().map(StatusTaskMapper::convertToDto).collect(Collectors.toList());
    }

    public StatusTaskDTO createStatusTask(StatusTaskDTO statusTask) {
        StatusTask newStatusTaskEntity = StatusTaskMapper.convertToEntity(statusTask);
        StatusTask savedStatusTaskEntity = (StatusTask)this.statusTaskRepository.save(newStatusTaskEntity);
        return StatusTaskMapper.convertToDto(savedStatusTaskEntity);
    }

    public StatusTaskDTO modifiyStatusTaskById(Integer id, StatusTaskDTO statusTaskDTO) {
        StatusTask existingStatusTaskEntity = (StatusTask)this.statusTaskRepository.findById(id.longValue()).orElse(null);
        if (existingStatusTaskEntity != null) {
            existingStatusTaskEntity.setStatusTaskName(statusTaskDTO.getNameStatusTask());
            StatusTask updatedStatusTaskEntity = (StatusTask)this.statusTaskRepository.save(existingStatusTaskEntity);
            return StatusTaskMapper.convertToDto(updatedStatusTaskEntity);
        } else {
            return null;
        }
    }

    public void deleteStatusTaskById(Integer id) {
        this.statusTaskRepository.deleteById(id.longValue());
    }

    public StatusTaskDTO getStatusTaskById(Integer id) {
        StatusTask statusTaskEntity = (StatusTask)this.statusTaskRepository.findById(id.longValue()).orElse(null);
        return statusTaskEntity != null ? StatusTaskMapper.convertToDto(statusTaskEntity) : null;
    }
}
