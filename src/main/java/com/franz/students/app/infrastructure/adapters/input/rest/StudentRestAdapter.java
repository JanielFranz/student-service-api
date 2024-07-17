package com.franz.students.app.infrastructure.adapters.input.rest;

import com.franz.students.app.application.ports.input.StudentInputPort;
import com.franz.students.app.domain.model.Student;
import com.franz.students.app.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.franz.students.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.franz.students.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentRestAdapter {
    private final StudentInputPort studentInputPort;
    private final StudentRestMapper studentRestMapper;

    @GetMapping("/v1/students")
    public List<StudentResponse> getAllStudents(){
        return studentRestMapper.toStudentResponsesFromStudents(studentInputPort.findAll());
    }

    @GetMapping("/v1/students/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return studentRestMapper.toStudentResponseFromStudent(studentInputPort.findById(id));
    }

    @PostMapping("/v1/students")
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCreateRequest request){

        //Transform a request to student, then student to a response
        StudentResponse response = studentRestMapper.toStudentResponseFromStudent(studentRestMapper.toStudentFromRequest(request));

//        return ResponseEntity.status(HttpStatus.CREATED).body(response);

        //returning the new url of the resource (better practice)
        return ResponseEntity.created(URI.create("api/v1/students".concat(response.getId().toString()))).body(response);
    }

    @PutMapping("/v1/students/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request){
        StudentResponse response =  studentRestMapper
                .toStudentResponseFromStudent(studentInputPort.update(id, studentRestMapper.toStudentFromRequest(request)));
        return response;
    }

    @DeleteMapping("v1/students/{id}")
    public void delete(@PathVariable Long id){
        studentInputPort.deleteById(id);
    }
}
