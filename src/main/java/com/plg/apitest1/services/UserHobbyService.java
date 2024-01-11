package com.plg.apitest1.services;

import com.plg.apitest1.models.UserHobby;
import com.plg.apitest1.repositories.UserHobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHobbyService {

    @Autowired
    private UserHobbyRepository userHobbyRepository;

    public List<UserHobby> getAllUserHobbies() {
        return userHobbyRepository.findAll();
    }

    public Optional<UserHobby> getUserHobbyById(Integer id) {
        return userHobbyRepository.findById(id);
    }

    public UserHobby createUserHobby(UserHobby userHobby) {
        return userHobbyRepository.save(userHobby);
    }

    public UserHobby updateUserHobby(UserHobby userHobby) {
        if (userHobby != null && userHobby.getId() != null) {
            Optional<UserHobby> existingUserHobby = userHobbyRepository.findById(userHobby.getId());

            if (existingUserHobby.isPresent()) {
                UserHobby updatedUserHobby = existingUserHobby.get();

                // Actualiza los campos según sea necesario
                updatedUserHobby.setRegisterDate(userHobby.getRegisterDate());
                updatedUserHobby.setUser(userHobby.getUser());
                updatedUserHobby.setHobby(userHobby.getHobby());

                // Puedes actualizar otros campos aquí

                return userHobbyRepository.save(updatedUserHobby);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void deleteUserHobby(Integer id) {
        userHobbyRepository.deleteById(id);
    }
}
