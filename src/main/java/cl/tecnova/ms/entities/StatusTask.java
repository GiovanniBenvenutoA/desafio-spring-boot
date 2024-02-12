package cl.tecnova.ms.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "status_task")
public class StatusTask {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_status_task",
            nullable = false
    )
    private Long idStatusTask;
    @Column(
            name = "status_task_name",
            nullable = false
    )
    private String statusTaskName;
}
