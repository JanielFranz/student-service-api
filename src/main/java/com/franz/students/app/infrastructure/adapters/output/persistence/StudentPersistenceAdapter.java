package com.franz.students.app.infrastructure.adapters.output.persistence;

import com.franz.students.app.application.ports.output.StudentPersistencePort;
import com.franz.students.app.domain.model.Student;
import com.franz.students.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.franz.students.app.infrastructure.adapters.output.persistence.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort{

    private final StudentPersistenceMapper studentPersistenceMapper;
    private final StudentJpaRepository studentJpaRepository;
    @Override
    public Optional<Student> findById(Long id) {
        return studentJpaRepository.findById(id)
                .map(studentPersistenceMapper::toStudentFromStudentEntity);
    }

    @Override
    public List<Student> findAll() {
        return studentPersistenceMapper
                .toStudentListFromStudentEntityList(studentJpaRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return studentPersistenceMapper.toStudentFromStudentEntity( studentJpaRepository
                .save(studentPersistenceMapper.toStudentEntityFromStudent(student)));

    }

    @Override
    public void deleteById(Long id) {
        studentJpaRepository.deleteById(id);
    }
}
