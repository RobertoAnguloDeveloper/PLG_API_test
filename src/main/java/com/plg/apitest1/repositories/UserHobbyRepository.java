package com.plg.apitest1.repositories;

import com.plg.apitest1.models.UserHobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHobbyRepository extends JpaRepository<UserHobby, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
