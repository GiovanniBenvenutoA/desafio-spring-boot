package cl.tecnova.ms.services;

import cl.tecnova.ms.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUser();

    UserDTO createUser(UserDTO user);

    UserDTO modifiyUserById(Integer id, UserDTO updateUser);

    void deleteUserById(Integer id);

    UserDTO getUserById(Integer id);
}
