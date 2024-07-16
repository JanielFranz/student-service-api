package com.franz.students.app.infrastructure.adapters.output.persistence.repository;

import com.franz.students.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
