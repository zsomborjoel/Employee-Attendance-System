package com.comp.contactmanager.mapper;

import com.comp.contactmanager.constant.Status;
import com.comp.contactmanager.domain.dao.Person;
import com.comp.contactmanager.domain.dto.PersonCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class PersonFromCreateMapper implements Function<PersonCreateRequest, Person> {

    @Override
    public Person apply(PersonCreateRequest request) {
        return Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .company(request.getCompany())
                .emailAddress(request.getEmailAddress())
                .status(Status.ACTIVE)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
    }

}
