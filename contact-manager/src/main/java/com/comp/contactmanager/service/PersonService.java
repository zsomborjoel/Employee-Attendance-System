package com.comp.contactmanager.service;

import com.comp.contactmanager.domain.dao.Person;
import com.comp.contactmanager.domain.dto.PersonCreateRequest;
import com.comp.contactmanager.domain.exception.InvalidPhoneNumberException;
import com.comp.contactmanager.mapper.PersonMapper;
import com.comp.contactmanager.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.comp.contactmanager.util.PersonValidatorUtil.isInCompanies;
import static com.comp.contactmanager.util.PersonValidatorUtil.isValidPhoneFormat;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final CompanyService companyService;
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public void createPerson(PersonCreateRequest personCreateRequest) {
        if (!isValidPhoneFormat(personCreateRequest.getPhoneNumber())) {
            throw new InvalidPhoneNumberException("Requested phone number is not valid");
        }

        List<String> companyNames = companyService.getCompanyNames();
        if (!isInCompanies(personCreateRequest.getCompany(), companyNames)) {
            throw new InvalidPhoneNumberException("Requested company is not valid");
        }

        Person person = personMapper.apply(personCreateRequest);
        personRepository.save(person);
    }

}
