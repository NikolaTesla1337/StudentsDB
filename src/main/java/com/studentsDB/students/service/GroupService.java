package com.studentsDB.students.service;

import com.studentsDB.students.models.Groupu;
import com.studentsDB.students.models.Student;
import com.studentsDB.students.repository.GroupRepository;
import com.studentsDB.students.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    final
    GroupRepository repository;
    final
    StudentsRepository studentsRepository;


    public GroupService(GroupRepository repository, StudentsRepository studentsRepository) {
        this.repository = repository;
        this.studentsRepository = studentsRepository;
    }

    public Groupu get(Long id) {
        return repository.getById(id);
    }

    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    public void update(Groupu oldGroup, Groupu newGroup) {
        Groupu group = repository.getById(oldGroup.getId());
        group.setId(newGroup.getId());
        group.setNameOfFacultet(newGroup.getNameOfFacultet());
        group.setStudentList(newGroup.getStudentList());
        repository.saveAndFlush(group);
    }

    public Groupu save(Groupu group) {
        return repository.save(group);
    }

    public List<Groupu> getAll() {
        return repository.findAll();
    }

    public List<Student> getStudents(Long groupId) {
        return studentsRepository.getStudentByGroupID(groupId);
    }
}
