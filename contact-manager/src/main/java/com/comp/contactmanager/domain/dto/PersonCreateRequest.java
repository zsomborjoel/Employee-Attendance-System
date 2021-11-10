package com.comp.contactmanager.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class PersonCreateRequest {

    @NotBlank(message = "Please enter your first name")
    private String firstName;

    @NotBlank(message = "Please enter your last name")
    private String lastName;

    @NotBlank(message = "Please enter your email address")
    @Email(message = "Please enter a valid email address")
    private String emailAddress;

    private String phoneNumber;

    @NotBlank(message = "Please choose a company")
    private String company;

    private String comment;

}
