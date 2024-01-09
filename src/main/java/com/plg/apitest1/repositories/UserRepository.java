package com.plg.apitest1.repositories;

import com.plg.apitest1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}

