package com.LearningRestApi.learningapiApplication.service;


import com.LearningRestApi.learningapiApplication.dto.AddStudentRequestDto;
import com.LearningRestApi.learningapiApplication.dto.Studentdto;
import org.modelmapper.internal.util.Objects;


import java.util.List;
import java.util.Map;

public interface StudentServices {
    List<Studentdto> getAllStudents();

    Studentdto getStudentsById(Long id);

    Studentdto creatNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudetnById(Long id);

    Studentdto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    Studentdto updatePartialStudent(Long id, Map<String, Object> updates);
}
