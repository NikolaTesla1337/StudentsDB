package com.studentsDB.students.repository;

import com.studentsDB.students.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentByGroupID(Long groupId);
}
