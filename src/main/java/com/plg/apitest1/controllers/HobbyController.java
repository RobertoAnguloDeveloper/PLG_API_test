package com.plg.apitest1.controllers;

import com.plg.apitest1.models.Hobby;
import com.plg.apitest1.services.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hobby")
@CrossOrigin(origins = "*")
public class HobbyController {

    @Autowired
    private HobbyService hobbyService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHobby(@RequestBody Hobby hobby) {
        hobbyService.createHobby(hobby);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hobby>> getAllHobbies() {
        List<Hobby> hobbies = hobbyService.getAllHobbies();
        if (hobbies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(hobbies);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hobby> getHobbyById(@PathVariable("id") Integer id) {
        Optional<Hobby> hobbyOptional = hobbyService.getHobbyById(id);

        return hobbyOptional.map(hobby -> ResponseEntity.ok(hobby))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Hobby> updateHobby(@RequestBody Hobby hobby) {
        Hobby updatedHobby = hobbyService.updateHobby(hobby);
        if (updatedHobby == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedHobby);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHobby(@PathVariable("id") Integer id) {
        hobbyService.deleteHobby(id);
    }
}
