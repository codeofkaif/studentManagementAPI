package com.LearningRestApi.learningapiApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3 , max = 20 , message = "Name should be length 3 to 20 charactor")
    private String name;
    @Email
    @NotBlank(message ="Email is required")
    private String email;
}