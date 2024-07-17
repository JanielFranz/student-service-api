package com.franz.students.app.infrastructure.adapters.input.rest.mapper;

import com.franz.students.app.domain.model.Student;
import com.franz.students.app.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.franz.students.app.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring"
        //ignoring unmapped properties in the target object
        , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

    //I receive a request
     Student toStudentFromRequest(StudentCreateRequest request);

     //I return a response
    @Mapping(target = "timeStamp", expression = "java(mapTimeStamp())")
      StudentResponse toStudentResponseFromStudent(Student student);

     //For findAll method, I return a list of StudentResponse
    List<StudentResponse> toStudentResponsesFromStudents(List<Student> students);


    //default method for mapping the timestamp
    default String mapTimeStamp(){
        return LocalDateTime.now().toString();
    }

}
