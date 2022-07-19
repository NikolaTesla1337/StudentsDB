package com.studentsDB.students.repository;

import com.studentsDB.students.models.Groupu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groupu, Long> {
}
