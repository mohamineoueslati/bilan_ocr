package com.amenbank.bilan_ocr.entity;

import com.amenbank.bilan_ocr.dto.UserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 64, nullable = false)
    private String lastName;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @ManyToOne
    private Role role;

    public User(UserRequest userRequest) {
        this.username = userRequest.getUsername();
        this.password = userRequest.getPassword();
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
    }
}
