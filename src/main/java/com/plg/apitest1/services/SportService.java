package com.plg.apitest1.services;

import com.plg.apitest1.models.Sport;
import com.plg.apitest1.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }

    public Optional<Sport> getSportById(Integer id) {
        return sportRepository.findById(id);
    }

    public Sport createSport(Sport sport) {
        return sportRepository.save(sport);
    }

    public Sport updateSport(Sport sport) {
        if (sport != null && sport.getId() != null) {
            Optional<Sport> existingSport = sportRepository.findById(sport.getId());

            if (existingSport.isPresent()) {
                Sport updatedSport = existingSport.get();

                // Actualiza los campos según sea necesario
                updatedSport.setSportName(sport.getSportName());

                // Puedes actualizar otros campos aquí

                return sportRepository.save(updatedSport);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void deleteSport(Integer id) {
        sportRepository.deleteById(id);
    }
}
