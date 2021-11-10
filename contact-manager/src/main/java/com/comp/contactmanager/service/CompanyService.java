package com.comp.contactmanager.service;

import com.comp.contactmanager.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;

    public List<String> getCompanyNames() {
        return companyRepository.findAll()
                .stream()
                .map(company -> company.getCompanyName())
                .collect(Collectors.toList());
    }

}
