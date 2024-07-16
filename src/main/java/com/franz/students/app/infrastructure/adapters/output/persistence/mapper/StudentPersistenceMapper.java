package com.franz.students.app.infrastructure.adapters.output.persistence.mapper;

import com.franz.students.app.domain.model.Student;
import com.franz.students.app.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface StudentPersistenceMapper {
    StudentEntity toStudentEntityFromStudent(Student student);
    Student toStudentFromStudentEntity(StudentEntity studentEntity);
    List<Student> toStudentListFromStudentEntityList(List<StudentEntity> entities);
}
