package org.project.speaksmart.controllers;

import org.project.speaksmart.models.Roles;
import org.project.speaksmart.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Roles> getAllRoles(){
        return rolesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRolesById(@PathVariable Long id){
        Optional<Roles> roles = rolesRepository.findById(id);

        return roles.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build() );
    }

    @PostMapping
    public  ResponseEntity<Roles> createRoles(@RequestBody Roles roles) {
        Roles savedRoles = rolesRepository.save(roles);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoles(@PathVariable Long id) {
        if(!rolesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rolesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRoles(@PathVariable Long id, @RequestBody Roles updateRoles) {
        if(!rolesRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        updateRoles.setId(id);
        Roles savedRoles = rolesRepository.save(updateRoles);

        return ResponseEntity.ok(savedRoles);
    }
}
