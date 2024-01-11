package com.plg.apitest1.repositories;

import com.plg.apitest1.models.UserSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSportRepository extends JpaRepository<UserSport, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
