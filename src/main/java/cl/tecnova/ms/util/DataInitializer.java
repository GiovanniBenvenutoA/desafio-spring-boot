package cl.tecnova.ms.util;

import cl.tecnova.ms.entities.StatusTask;
import cl.tecnova.ms.entities.Task;
import cl.tecnova.ms.entities.Users;
import cl.tecnova.ms.repository.StatusTaskRepository;
import cl.tecnova.ms.repository.TaskRepository;
import cl.tecnova.ms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Component
public class DataInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StatusTaskRepository statusTaskRepository;

    public DataInitializer() {
    }

    @PostConstruct
    public void init() {
        Users example1 = new Users();
        example1.setUserName("giovanni");
        example1.setUserLastName("benvenuto");
        example1.setUserEmail("a@a.cl");
        example1.setUserPassword("prueba1234");
        example1.setUserActive(true);
        example1.setUserCreateDate(new Date());
        Users example2 = new Users();
        example2.setUserName("carlos");
        example2.setUserLastName("carmona");
        example2.setUserEmail("c@c.cl");
        example2.setUserPassword("prueba1234");
        example2.setUserActive(true);
        example2.setUserCreateDate(new Date());
        Users example3 = new Users();
        example3.setUserName("horacio");
        example3.setUserLastName("horcan");
        example3.setUserEmail("h@d.cl");
        example3.setUserPassword("prueba1234");
        example3.setUserActive(true);
        example3.setUserCreateDate(new Date());
        Users example4 = new Users();
        example4.setUserName("ernesto");
        example4.setUserLastName("erisno");
        example4.setUserEmail("t@t.cl");
        example4.setUserPassword("prueba1234");
        example4.setUserActive(true);
        example4.setUserCreateDate(new Date());
        Users example5 = new Users();
        example5.setUserName("erick");
        example5.setUserLastName("campanita");
        example5.setUserEmail("e@c.cl");
        example5.setUserPassword("prueba1234");
        example5.setUserActive(true);
        example5.setUserCreateDate(new Date());
        StatusTask example6 = new StatusTask();
        example6.setStatusTaskName("Refinada");
        StatusTask example7 = new StatusTask();
        example7.setStatusTaskName("Backlog");
        StatusTask example8 = new StatusTask();
        example8.setStatusTaskName("En curso");
        StatusTask example9 = new StatusTask();
        example9.setStatusTaskName("Bloqueada");
        StatusTask example10 = new StatusTask();
        example10.setStatusTaskName("Terminada");
        Task example11 = new Task();
        example11.setTaskName("prueba test");
        example11.setTaskDescription("probar test");
        example11.setTaskCreationDate(new Date());
        example11.setTaskLimitDate(new Date());
        example11.setTaskUserId(example1);
        example11.setTaskStatusId(example6);
        Task example12 = new Task();
        example12.setTaskName("prueba test");
        example12.setTaskDescription("probar test");
        example12.setTaskCreationDate(new Date());
        example12.setTaskLimitDate(new Date());
        example12.setTaskUserId(example2);
        example12.setTaskStatusId(example7);
        Task example13 = new Task();
        example13.setTaskName("prueba test");
        example13.setTaskDescription("probar test");
        example13.setTaskCreationDate(new Date());
        example13.setTaskLimitDate(new Date());
        example13.setTaskUserId(example3);
        example13.setTaskStatusId(example8);
        this.userRepository.saveAll(List.of(example1, example2, example3, example4, example5));
        this.statusTaskRepository.saveAll(List.of(example6, example7, example8, example9, example10));
        this.taskRepository.saveAll(List.of(example11, example12, example13));
    }
}
