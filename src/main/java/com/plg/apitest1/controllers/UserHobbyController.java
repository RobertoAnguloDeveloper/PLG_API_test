package com.plg.apitest1.controllers;

import com.plg.apitest1.models.UserHobby;
import com.plg.apitest1.services.UserHobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-hobby")
@CrossOrigin(origins = "*")
public class UserHobbyController {

    @Autowired
    private UserHobbyService userHobbyService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserHobby(@RequestBody UserHobby userHobby) {
        userHobbyService.createUserHobby(userHobby);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserHobby>> getAllUserHobbies() {
        List<UserHobby> userHobbies = userHobbyService.getAllUserHobbies();
        if (userHobbies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(userHobbies);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserHobby> getUserHobbyById(@PathVariable("id") Integer id) {
        Optional<UserHobby> userHobbyOptional = userHobbyService.getUserHobbyById(id);

        return userHobbyOptional.map(userHobby -> ResponseEntity.ok(userHobby))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserHobby> updateUserHobby(@RequestBody UserHobby userHobby) {
        UserHobby updatedUserHobby = userHobbyService.updateUserHobby(userHobby);
        if (updatedUserHobby == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedUserHobby);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserHobby(@PathVariable("id") Integer id) {
        userHobbyService.deleteUserHobby(id);
    }
}
