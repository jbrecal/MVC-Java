package org.project.speaksmart.controllers;

import org.project.speaksmart.models.Users;
import org.project.speaksmart.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAllUsersById(){
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getCategoriesById(@PathVariable Long id) {
        Optional<Users> users = usersRepository.findById(id);

        return  users.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users){
        Users savedUsers = usersRepository.save(users);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        if(!usersRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usersRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users updateUsers){
        if(!usersRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        updateUsers.setId(id);
        Users savedUsers = usersRepository.save(updateUsers);

        return ResponseEntity.ok(savedUsers);

    }


    }

