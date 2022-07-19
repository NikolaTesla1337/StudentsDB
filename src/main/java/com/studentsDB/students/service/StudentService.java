package com.studentsDB.students.service;

import com.studentsDB.students.models.Student;
import com.studentsDB.students.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    final
    StudentsRepository repository;

    public StudentService(StudentsRepository repository) {
        this.repository = repository;
    }

    public Student get(Long id) {
        return repository.getById(id);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void update(Student oldStudent, Student newStudent) {
        Student student = repository.getById(oldStudent.getId());
        student.setId(newStudent.getId());
        student.setFirstName(newStudent.getFirstName());
        student.setSecondName(newStudent.getSecondName());
        student.setLastName(newStudent.getLastName());
        student.setBirthday(newStudent.getBirthday());
        repository.saveAndFlush(student);
    }


}
