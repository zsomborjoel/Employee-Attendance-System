package com.comp.contactmanager.mapper;

import com.comp.contactmanager.domain.dao.Company;
import com.comp.contactmanager.domain.dto.CompanyCreateRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CompanyFromCreateMapper implements Function<CompanyCreateRequest, Company> {

    @Override
    public Company apply(CompanyCreateRequest request) {
        return Company.builder()
                .companyName(request.getCompanyName())
                .build();
    }

}
