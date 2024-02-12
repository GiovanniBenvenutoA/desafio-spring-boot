package cl.tecnova.ms.util.mapper;

import cl.tecnova.ms.dto.UserDTO;
import cl.tecnova.ms.entities.Users;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public UserMapper() {
    }

    public static UserDTO convertToDto(Users users) {
        return (UserDTO)modelMapper.map(users, UserDTO.class);
    }

    public static Users convertToEntity(UserDTO userDTO) {
        return (Users)modelMapper.map(userDTO, Users.class);
    }


}
