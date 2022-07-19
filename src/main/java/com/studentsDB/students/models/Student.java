package com.studentsDB.students.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "secondname")
    private String secondName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "groupID")
    private Long groupID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(Long id, String firstName, String secondName, String lastName, Date birthday, Long groupID) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.groupID = groupID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", groupID=" + groupID +
                '}';
    }
}
