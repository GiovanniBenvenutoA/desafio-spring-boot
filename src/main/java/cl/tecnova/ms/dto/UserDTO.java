package cl.tecnova.ms.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UserDTO {

    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private Date userCreateDate;
    private boolean userActive;
}
