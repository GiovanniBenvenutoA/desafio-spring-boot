package cl.tecnova.ms.services.impl;

import cl.tecnova.ms.dto.UserDTO;
import cl.tecnova.ms.entities.Users;
import cl.tecnova.ms.repository.UserRepository;
import cl.tecnova.ms.services.UserService;
import cl.tecnova.ms.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl() {
    }

    public List<UserDTO> getAllUser() {
        List<Users> users = this.userRepository.findAll();
        return (List)users.stream().map(UserMapper::convertToDto).collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO newUser) {
        Users newUserEntity = UserMapper.convertToEntity(newUser);
        Users savedUserEntity = (Users)this.userRepository.save(newUserEntity);
        return UserMapper.convertToDto(savedUserEntity);
    }

    public UserDTO modifiyUserById(Integer id, UserDTO updateUser) {
        Users existingUserEntity = (Users)this.userRepository.findById(id.longValue()).orElse(null);
        if (existingUserEntity != null) {
            existingUserEntity.setUserName(updateUser.getUserName());
            existingUserEntity.setUserLastName(updateUser.getUserLastName());
            existingUserEntity.setUserEmail(updateUser.getUserEmail());
            existingUserEntity.setUserPassword(updateUser.getUserPassword());
            Users updatedUserEntity = (Users)this.userRepository.save(existingUserEntity);
            return UserMapper.convertToDto(updatedUserEntity);
        } else {
            return null;
        }
    }

    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id.longValue());
    }

    public UserDTO getUserById(Integer id) {
        Users userEntity = (Users)this.userRepository.findById(id.longValue()).orElse(null);
        return userEntity != null ? UserMapper.convertToDto(userEntity) : null;
    }

}
