package cl.tecnova.ms.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(
        name = "task"
)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task", nullable = false)
    private Long idTask;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_description", nullable = false)
    private String taskDescription;

    @Column(name = "task_creation_date", nullable = false)
    private Date taskCreationDate;

    @Column(name = "task_limit_date", nullable = false)
    private Date taskLimitDate;

    @ManyToOne
    @JoinColumn(name = "task_user_id")
    private Users taskUserId;

    @ManyToOne
    @JoinColumn(name = "task_status_id")
    private StatusTask taskStatusId;
}
