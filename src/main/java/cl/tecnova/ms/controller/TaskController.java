package cl.tecnova.ms.controller;


import cl.tecnova.ms.dto.TaskDTO;
import cl.tecnova.ms.services.TaskService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/task"})
@CrossOrigin(
        origins = {"*"}
)
@OpenAPIDefinition(
        tags = {@Tag(
                name = "Task",
                description = "Operaciones relacionadas con las tareas"
        )}
)
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping({"/getall"})
    @Operation(
            summary = "Obtener todas las tareas",
            description = "Devuelve una lista de todas las tareas."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = {@Content(
                    mediaType = "application/json"
            )}
    )
    ResponseEntity<List<TaskDTO>> getAllTask() {
        return new ResponseEntity(taskService.getAllTask(), HttpStatus.OK);
    }

    @PostMapping({"/create"})
    @Operation(
            summary = "Crear una nueva tarea",
            description = "Crea y devuelve una nueva tarea."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Tarea creada exitosamente",
            content = {@Content(
                    mediaType = "application/json"
            )}
    )
    ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO newTask) {
        TaskDTO createTask = taskService.createTask(newTask);
        return new ResponseEntity(createTask, HttpStatus.OK);
    }

    @GetMapping({"/get/{id}"})
    @Operation(
            summary = "Obtener una tarea por su ID",
            description = "Devuelve una tarea según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = {@Content(
                    mediaType = "application/json"
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró la tarea"
    )})
    ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id) {
        TaskDTO task = taskService.getTaskById(id);
        return task != null ? new ResponseEntity(task, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping({"/modify/{id}"})
    @Operation(
            summary = "Modificar una tarea por su ID",
            description = "Modifica y devuelve una tarea según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Tarea modificada exitosamente",
            content = {@Content(
                    mediaType = "application/json"
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró la tarea"
    )})
    ResponseEntity<TaskDTO> modifiyTaskById(@PathVariable Integer id, @RequestBody TaskDTO updateTask) {
        TaskDTO updatedTask = taskService.modifiyTaskById(id, updateTask);
        return updatedTask != null ? new ResponseEntity(updatedTask, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping({"/delete/{id}"})
    @Operation(
            summary = "Eliminar una tarea por su ID",
            description = "Elimina una tarea según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "204",
            description = "Tarea eliminada exitosamente"
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró la tarea"
    )})
    ResponseEntity<Void> deleteTaskById(@PathVariable Integer id) {
        TaskDTO taskDto = taskService.getTaskById(id);
        if (taskDto != null) {
            taskService.deleteTaskById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

