package org.project.speaksmart.controllers;

import org.project.speaksmart.models.Levels;
import org.project.speaksmart.repositories.LevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/levels")
public class LevelController {

    @Autowired
    private LevelsRepository levelsRepository;

    @GetMapping
    public List<Levels> getAllLevels(){
        return levelsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Levels> getLevelsById(@PathVariable Long id){
        Optional<Levels> levels = levelsRepository.findById(id);

        return levels.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Levels> createLevels(@PathVariable Levels levels){
        Levels savedLevels = levelsRepository.save(levels);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedLevels);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevels(@PathVariable Long id) {
        if(!levelsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        levelsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Levels> updateLevels(@PathVariable Long id, @RequestBody Levels updateLevels){
        if(!levelsRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        updateLevels.setId(id);
        Levels savedLevels = levelsRepository.save(updateLevels);

        return ResponseEntity.ok(savedLevels);
    }
}
