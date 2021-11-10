package com.comp.contactmanager.controller;

import com.comp.contactmanager.domain.dto.PersonCreateRequest;
import com.comp.contactmanager.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("create")
    private ResponseEntity<?> createPerson(@RequestBody PersonCreateRequest request) {
        if (request == null) {
            return ResponseEntity.badRequest().body("Empty request");
        }

        try {
            personService.createPerson(request);
            return ResponseEntity.ok("Person created");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
