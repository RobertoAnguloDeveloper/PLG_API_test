package com.plg.apitest1.repositories;

import com.plg.apitest1.models.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
