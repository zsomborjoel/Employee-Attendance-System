package com.comp.contactmanager.controller;

import com.comp.contactmanager.domain.dto.CompanyCreateRequest;
import com.comp.contactmanager.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company/create")
    private ResponseEntity<?> createCompany(@RequestBody CompanyCreateRequest request) {
        if (request == null) {
            return ResponseEntity.badRequest().body("Empty request");
        }

        try {
            companyService.createCompany(request);
            return ResponseEntity.ok("Company created");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

}
