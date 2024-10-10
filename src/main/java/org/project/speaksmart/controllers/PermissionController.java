package org.project.speaksmart.controllers;

import org.project.speaksmart.models.Permissions;
import org.project.speaksmart.repositories.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionsRepository permissionsRepository;


    @GetMapping
    public List<Permissions> getAllPermissions(){
        return permissionsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissions> getPermissionsById(@PathVariable Long id){
        Optional<Permissions> permissions = permissionsRepository.findById(id);

        return permissions.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public  ResponseEntity<Permissions> createPermissions(@RequestBody Permissions permissions){
        Permissions savedPermissions = permissionsRepository.save(permissions);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPermissions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissions(@PathVariable Long id) {
        if(!permissionsRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        permissionsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permissions> updatePermissions(@PathVariable Long id, @RequestBody Permissions updatePermissions) {
        if(!permissionsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatePermissions.setId(id);
        Permissions savedPermissions = permissionsRepository.save(updatePermissions);

        return ResponseEntity.ok(savedPermissions);
    }
}
