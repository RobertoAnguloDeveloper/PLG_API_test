package com.plg.apitest1.controllers;

import com.plg.apitest1.models.Sport;
import com.plg.apitest1.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sport")
@CrossOrigin(origins = "*")
public class SportController {

    @Autowired
    private SportService sportService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSport(@RequestBody Sport sport) {
        sportService.createSport(sport);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sport>> getAllSports() {
        List<Sport> sports = sportService.getAllSports();
        if (sports.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(sports);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getSportById(@PathVariable("id") Integer id) {
        Optional<Sport> sportOptional = sportService.getSportById(id);

        return sportOptional.map(sport -> ResponseEntity.ok(sport))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Sport> updateSport(@RequestBody Sport sport) {
        Sport updatedSport = sportService.updateSport(sport);
        if (updatedSport == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedSport);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSport(@PathVariable("id") Integer id) {
        sportService.deleteSport(id);
    }
}
