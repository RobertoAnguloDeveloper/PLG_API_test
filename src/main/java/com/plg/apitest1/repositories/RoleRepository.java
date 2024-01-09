package com.plg.apitest1.repositories;

import com.plg.apitest1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}
