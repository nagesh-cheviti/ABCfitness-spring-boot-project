package com.abc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abc.springboot.entity.ClassEntity;
import com.abc.springboot.service.ClassService;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<String> createClass(@RequestBody ClassEntity classEntity) {
        classService.createClass(classEntity);
        return ResponseEntity.status(201).body("Class created successfully.");
    }

    @GetMapping
    public List<ClassEntity> getClasses() {
        return classService.getClasses();
    }
}

