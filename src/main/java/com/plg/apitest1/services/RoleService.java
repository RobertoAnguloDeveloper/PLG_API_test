package com.plg.apitest1.services;

import com.plg.apitest1.models.Role;
import com.plg.apitest1.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Role role) {
        if (role != null && role.getId() != null) {
            Optional<Role> existingRole = roleRepository.findById(role.getId());

            if (existingRole.isPresent()) {
                Role updatedRole = existingRole.get();

                // Actualiza los campos según sea necesario
                updatedRole.setRoleName(role.getRoleName());
                updatedRole.setRoleDescription(role.getRoleDescription());

                // Puedes actualizar otros campos aquí

                return roleRepository.save(updatedRole);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
