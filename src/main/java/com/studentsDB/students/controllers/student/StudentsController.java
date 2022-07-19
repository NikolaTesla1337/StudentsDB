package com.studentsDB.students.controllers.student;


import com.studentsDB.students.models.Student;
import com.studentsDB.students.service.StudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/rest")
public class StudentsController {
    final StudentService service;

    public StudentsController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students/{id}")
    public String get(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("student", service.get(id));
        return "students";
    }

    @GetMapping("/students")
    public String getAll(@NotNull Model model) {
        List<Student> students = service.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @PutMapping("/students")
    public ResponseEntity<Student> save(Student student) {
        try {
            service.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> delete(@PathVariable(value = "id") long id) {

        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            if (id == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@PathVariable(name = "id") Long id,
                                          @RequestBody Student newStudent) {
        service.update(service.get(id), newStudent);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

}
