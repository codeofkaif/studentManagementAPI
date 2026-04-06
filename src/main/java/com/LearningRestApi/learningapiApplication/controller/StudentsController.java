package com.LearningRestApi.learningapiApplication.controller;
import com.LearningRestApi.learningapiApplication.dto.AddStudentRequestDto;
import com.LearningRestApi.learningapiApplication.dto.Studentdto;
import com.LearningRestApi.learningapiApplication.service.StudentServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentsController {
    private final StudentServices studentServices;

    @GetMapping
    public ResponseEntity<List<Studentdto>> getStudents(){

        //return ResponseEntity.status(HttpStatus.OK).body(studentServices.getAllStudents());
        return ResponseEntity.ok(studentServices.getAllStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentsById(@PathVariable Long id){
        return ResponseEntity.ok(studentServices.getStudentsById(id));
    }

    @PostMapping
    public ResponseEntity<Studentdto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentServices.creatNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudetn(@PathVariable Long id){
        studentServices.deleteStudetnById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto> updateStudent(@PathVariable Long id ,@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentServices.updateStudent(id , addStudentRequestDto));

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Studentdto> updatePartialStudent(@PathVariable Long id , @RequestBody Map<String , Object> updates){
        return ResponseEntity.ok(studentServices.updatePartialStudent(id , updates));
    }



}

