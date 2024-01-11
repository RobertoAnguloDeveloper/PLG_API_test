package com.plg.apitest1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sport_name", length = 255, nullable = false)
    private String sportName;

    // Puedes agregar relaciones adicionales o métodos según sea necesario

    @OneToMany(mappedBy = "sport")
    @JsonIgnore
    private List<UserSport> userSports;
}
