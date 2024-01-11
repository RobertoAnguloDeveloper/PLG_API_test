package com.plg.apitest1.services;

import com.plg.apitest1.models.Hobby;
import com.plg.apitest1.repositories.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HobbyService {

    @Autowired
    private HobbyRepository hobbyRepository;

    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }

    public Optional<Hobby> getHobbyById(Integer id) {
        return hobbyRepository.findById(id);
    }

    public Hobby createHobby(Hobby hobby) {
        return hobbyRepository.save(hobby);
    }

    public Hobby updateHobby(Hobby hobby) {
        if (hobby != null && hobby.getId() != null) {
            Optional<Hobby> existingHobby = hobbyRepository.findById(hobby.getId());

            if (existingHobby.isPresent()) {
                Hobby updatedHobby = existingHobby.get();

                // Actualiza los campos según sea necesario
                updatedHobby.setHobbieName(hobby.getHobbieName());

                // Puedes actualizar otros campos aquí

                return hobbyRepository.save(updatedHobby);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void deleteHobby(Integer id) {
        hobbyRepository.deleteById(id);
    }
}
