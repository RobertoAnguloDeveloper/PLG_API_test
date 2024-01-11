package com.plg.apitest1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "hobbies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hobbie_name", length = 255, nullable = false)
    private String hobbieName;

    @OneToMany(mappedBy = "hobby")
    @JsonIgnore
    private List<UserHobby> userHobbies;
}
