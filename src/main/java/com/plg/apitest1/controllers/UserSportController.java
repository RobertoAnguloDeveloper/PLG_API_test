package com.plg.apitest1.controllers;

import com.plg.apitest1.models.UserSport;
import com.plg.apitest1.services.UserSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-sport")
@CrossOrigin(origins = "*")
public class UserSportController {

    @Autowired
    private UserSportService userSportService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserSport(@RequestBody UserSport userSport) {
        userSportService.createUserSport(userSport);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserSport>> getAllUserSports() {
        List<UserSport> userSports = userSportService.getAllUserSports();
        if (userSports.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(userSports);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSport> getUserSportById(@PathVariable("id") Integer id) {
        Optional<UserSport> userSportOptional = userSportService.getUserSportById(id);

        return userSportOptional.map(userSport -> ResponseEntity.ok(userSport))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserSport> updateUserSport(@RequestBody UserSport userSport) {
        UserSport updatedUserSport = userSportService.updateUserSport(userSport);
        if (updatedUserSport == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedUserSport);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserSport(@PathVariable("id") Integer id) {
        userSportService.deleteUserSport(id);
    }
}
