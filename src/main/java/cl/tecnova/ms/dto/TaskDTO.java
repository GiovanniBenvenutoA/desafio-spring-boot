package cl.tecnova.ms.dto;

import cl.tecnova.ms.entities.StatusTask;
import cl.tecnova.ms.entities.Users;
import lombok.Data;

import java.util.Date;


@Data
public class TaskDTO {

    private String stackName;
    private String taskDescription;
    private Date taskCreationDate;
    private Date taskLimitDate;
    private Users user;
    private StatusTask statusTask;
}
