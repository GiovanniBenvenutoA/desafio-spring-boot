package cl.tecnova.ms.controller;


import cl.tecnova.ms.dto.StatusTaskDTO;
import cl.tecnova.ms.services.StatusTaskService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping({"/api/status/task"})
@CrossOrigin(
        origins = {"*"}
)
@OpenAPIDefinition(
        tags = {@Tag(
                name = "StatusTask",
                description = "Operaciones relacionadas con el estado de las tareas"
        )}
)
public class StatusTaskController {

    @Autowired
    StatusTaskService statusTaskService;

    @GetMapping({"/getall"})
    @Operation(
            summary = "Obtener todos los estados de las tareas",
            description = "Devuelve una lista de todos los estados de las tareas."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(
                                    implementation = StatusTaskDTO.class
                            )
                    )
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontraron estados de tareas"
    )})
    ResponseEntity<List<StatusTaskDTO>> getAllStatusTask() {
        return new ResponseEntity(statusTaskService.getAllStatusTask(), HttpStatus.OK);
    }

    @PostMapping({"/create/{id}"})
    @Operation(
            summary = "Crear un nuevo estado de tarea",
            description = "Crea y devuelve un nuevo estado de tarea."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Estado de tarea creado exitosamente",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = StatusTaskDTO.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "400",
            description = "Solicitud incorrecta"
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el recurso"
    )})
    ResponseEntity<?> createStatusTask(@RequestBody StatusTaskDTO statusTask) {
        return new ResponseEntity(statusTaskService.createStatusTask(statusTask), HttpStatus.OK);
    }

    @GetMapping({"/get/{id}"})
    @Operation(
            summary = "Obtener un estado de tarea por su ID",
            description = "Devuelve un estado de tarea según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = StatusTaskDTO.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el estado de tarea"
    )})
    ResponseEntity<StatusTaskDTO> getStatusTaskById(@PathVariable Integer id) {
        StatusTaskDTO statusTask = statusTaskService.getStatusTaskById(id);
        return statusTask != null ? new ResponseEntity(statusTask, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping({"/modify/{id}"})
    @Operation(
            summary = "Modificar un estado de tarea por su ID",
            description = "Modifica y devuelve un estado de tarea según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Estado de tarea modificado exitosamente",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = StatusTaskDTO.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "400",
            description = "Solicitud incorrecta"
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el estado de tarea"
    )})
    ResponseEntity<StatusTaskDTO> modifiyStatusTaskById(@PathVariable Integer id, @RequestBody StatusTaskDTO updateStatusTask) {
        StatusTaskDTO updatedTask = statusTaskService.modifiyStatusTaskById(id, updateStatusTask);
        return updatedTask != null ? new ResponseEntity(updatedTask, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping({"/delete/{id}"})
    @Operation(
            summary = "Eliminar un estado de tarea por su ID",
            description = "Elimina un estado de tarea según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "204",
            description = "Estado de tarea eliminado exitosamente"
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el estado de tarea"
    )})
    ResponseEntity<Void> deleteStatusTaskById(@PathVariable Integer id) {
        StatusTaskDTO taskDto = statusTaskService.getStatusTaskById(id);
        if (taskDto != null) {
            statusTaskService.deleteStatusTaskById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}


