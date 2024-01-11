package com.plg.apitest1.repositories;

import com.plg.apitest1.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
