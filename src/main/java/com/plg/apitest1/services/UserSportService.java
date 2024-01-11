package com.plg.apitest1.services;

import com.plg.apitest1.models.UserSport;
import com.plg.apitest1.repositories.UserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSportService {

    @Autowired
    private UserSportRepository userSportRepository;

    public List<UserSport> getAllUserSports() {
        return userSportRepository.findAll();
    }

    public Optional<UserSport> getUserSportById(Integer id) {
        return userSportRepository.findById(id);
    }

    public UserSport createUserSport(UserSport userSport) {
        return userSportRepository.save(userSport);
    }

    public UserSport updateUserSport(UserSport userSport) {
        if (userSport != null && userSport.getId() != null) {
            Optional<UserSport> existingUserSport = userSportRepository.findById(userSport.getId());

            if (existingUserSport.isPresent()) {
                UserSport updatedUserSport = existingUserSport.get();

                // Actualiza los campos según sea necesario
                updatedUserSport.setUser(userSport.getUser());
                updatedUserSport.setSport(userSport.getSport());

                // Puedes actualizar otros campos aquí

                return userSportRepository.save(updatedUserSport);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void deleteUserSport(Integer id) {
        userSportRepository.deleteById(id);
    }
}
