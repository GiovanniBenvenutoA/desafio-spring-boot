package cl.tecnova.ms.controller;

import cl.tecnova.ms.dto.UserDTO;
import cl.tecnova.ms.services.UserService;
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
@RequestMapping({"/api/user"})
@CrossOrigin(
        origins = {"*"}
)
@OpenAPIDefinition(
        tags = {@Tag(
                name = "User",
                description = "Operaciones relacionadas con los usuarios"
        )}
)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"/getall"})
    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Devuelve una lista de todos los usuarios."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = {@Content(
                    mediaType = "application/json"
            )}
    )
    ResponseEntity<List<UserDTO>> getAllUser() {
        return new ResponseEntity(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping({"/create/{id}"})
    @Operation(
            summary = "Crear un nuevo usuario",
            description = "Crea y devuelve un nuevo usuario."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Usuario creado exitosamente",
            content = {@Content(
                    mediaType = "application/json"
            )}
    )
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUsers) {
        UserDTO createUsers = userService.createUser(newUsers);
        return new ResponseEntity(createUsers, HttpStatus.OK);
    }

    @GetMapping({"/get/{id}"})
    @Operation(
            summary = "Obtener un usuario por su ID",
            description = "Devuelve un usuario según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = {@Content(
                    mediaType = "application/json"
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el usuario"
    )})
    ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO users = userService.getUserById(id);
        return users != null ? new ResponseEntity(users, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping({"/modify/{id}"})
    @Operation(
            summary = "Modificar un usuario por su ID",
            description = "Modifica y devuelve un usuario según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Usuario modificado exitosamente",
            content = {@Content(
                    mediaType = "application/json"
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el usuario"
    )})
    ResponseEntity<UserDTO> modifiyUserById(@PathVariable Integer id, @RequestBody UserDTO updateUser) {
        UserDTO userTask = userService.modifiyUserById(id, updateUser);
        return userTask != null ? new ResponseEntity(userTask, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping({"/delete/{id}"})
    @Operation(
            summary = "Eliminar un usuario por su ID",
            description = "Elimina un usuario según el ID proporcionado."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "204",
            description = "Usuario eliminado exitosamente"
    ), @ApiResponse(
            responseCode = "404",
            description = "No se encontró el usuario"
    )})
    ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        UserDTO userDto = userService.getUserById(id);
        if (userDto != null) {
            userService.deleteUserById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
