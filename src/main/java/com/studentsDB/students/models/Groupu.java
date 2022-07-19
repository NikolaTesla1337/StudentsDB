package com.studentsDB.students.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GROUPUS")
public class Groupu {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nameoffacultet")
    private String nameOfFacultet;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Student> studentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Groupu() {
    }

    public Groupu(Long id, String nameOfFacultet, List<Student> studentList) {
        this.id = id;
        this.nameOfFacultet = nameOfFacultet;
        this.studentList = studentList;
    }

    public String getNameOfFacultet() {
        return nameOfFacultet;
    }

    public void setNameOfFacultet(String nameOfFacultet) {
        this.nameOfFacultet = nameOfFacultet;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getStudentListToString() {
        return studentList.toString();
    }
}
