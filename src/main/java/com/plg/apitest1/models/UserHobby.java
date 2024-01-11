package com.plg.apitest1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "users_hobbies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "register_date", length = 255)
    private String registerDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "hobbie_id", nullable = false)
    private Hobby hobby;
}
