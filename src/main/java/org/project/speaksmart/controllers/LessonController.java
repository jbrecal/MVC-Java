package org.project.speaksmart.controllers;

import org.project.speaksmart.models.Lessons;
import org.project.speaksmart.repositories.LessonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired   // autocableamos
    private LessonsRepository lessonsRepository;

    @GetMapping
    public List<Lessons> getAllLessons(){
        return lessonsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lessons> getLessonsById(@PathVariable Long id){
        Optional<Lessons> lessons = lessonsRepository.findById(id);
        return lessons.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lessons> createLessons(@RequestBody Lessons lessons){
        Lessons savedLessons = lessonsRepository.save(lessons);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedLessons);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessons(@PathVariable Long id) {
        if (!lessonsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lessonsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Lessons> updateLessons(@PathVariable Long id, @RequestBody Lessons updateLessons){
        if(!lessonsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updateLessons.setId(id);
        Lessons savedLessons = lessonsRepository.save(updateLessons);

        return ResponseEntity.ok(savedLessons);
    }

}
