package com.plg.apitest1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 8)
    private String password;

    @Column(name = "email", length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
