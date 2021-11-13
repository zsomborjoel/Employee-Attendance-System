package com.comp.contactmanager.service;

import com.comp.contactmanager.domain.dao.Company;
import com.comp.contactmanager.domain.dto.CompanyCreateRequest;
import com.comp.contactmanager.mapper.CompanyFromCreateMapper;
import com.comp.contactmanager.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyFromCreateMapper companyFromCreateMapper;

    public List<String> getCompanyNames() {
        return companyRepository.findAll()
                .stream()
                .map(Company::getCompanyName)
                .collect(Collectors.toList());
    }

    public void createCompany(CompanyCreateRequest request) {
        companyRepository.save(companyFromCreateMapper.apply(request));
    }

}
