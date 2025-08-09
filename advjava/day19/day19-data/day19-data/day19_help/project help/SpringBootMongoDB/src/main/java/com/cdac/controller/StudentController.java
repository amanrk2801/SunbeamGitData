package com.cdac.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dao.StudentDao;
import com.cdac.model.Student;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {   
    private final StudentDao dao;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return dao.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return dao.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        student.setId(id);
        return dao.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        dao.deleteById(id);
    }
}
