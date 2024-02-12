package cl.tecnova.ms.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(
        name = "users"
)
public class Users {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_user",
            nullable = false
    )
    private Long idUser;
    @Column(
            name = "user_name"
    )
    private String userName;
    @Column(
            name = "user_lastname"
    )
    private String userLastName;
    @Column(
            name = "user_email"
    )
    private String userEmail;
    @Column(
            name = "user_password"
    )
    private String userPassword;
    @Column(
            name = "user_create_date"
    )
    private Date userCreateDate;
    @Column(
            name = "user_active"
    )
    private Boolean userActive;
}
