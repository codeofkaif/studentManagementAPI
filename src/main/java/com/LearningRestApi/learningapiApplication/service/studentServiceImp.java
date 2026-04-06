package com.LearningRestApi.learningapiApplication.service;

import com.LearningRestApi.learningapiApplication.dto.AddStudentRequestDto;
import com.LearningRestApi.learningapiApplication.dto.Studentdto;
import com.LearningRestApi.learningapiApplication.entity.Student;
import com.LearningRestApi.learningapiApplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.modelmapper.internal.util.Objects;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class studentServiceImp implements StudentServices{
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Studentdto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<Studentdto> list = students.stream().map(student -> new Studentdto(student.getId(), student.getName(), student.getEmail())).toList();
        return list;
    }

    @Override
    public Studentdto getStudentsById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id:"));
        return modelMapper.map(student , Studentdto.class);
    }

    @Override
    public Studentdto creatNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto , Student.class);
        Student student = studentRepository.save(newStudent);

        return modelMapper.map(student , Studentdto.class);
    }

    @Override
    public void deleteStudetnById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Studentdto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id:"));
        modelMapper.map(addStudentRequestDto , student);
        student = studentRepository.save(student);
        return modelMapper.map(student , Studentdto.class);
    }

    @Override
    public Studentdto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id:"));
        updates.forEach((field , value) ->{
            switch(field){
                case "name":
                    student.setName(value.toString());
                    break;
                case "email":
                    student.setEmail(value.toString());
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");

            }

        });
        Student savedStudent = studentRepository.save(student);


        return modelMapper.map(savedStudent , Studentdto.class);
    }

}
