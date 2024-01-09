package com.plg.apitest1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name", length = 255)
    private String roleName;

    @Column(name = "role_description", columnDefinition = "text")
    private String roleDescription;

    // Relación con la entidad User
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "role")
    @JsonIgnore
    private List<User> users;
}
