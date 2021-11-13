package com.comp.contactmanager.service;

import com.comp.contactmanager.constant.Status;
import com.comp.contactmanager.domain.dao.Person;
import com.comp.contactmanager.domain.dto.PersonCreateRequest;
import com.comp.contactmanager.domain.dto.PersonDeleteRequest;
import com.comp.contactmanager.domain.exception.InvalidCompanyException;
import com.comp.contactmanager.domain.exception.InvalidPhoneNumberException;
import com.comp.contactmanager.mapper.PersonFromCreateMapper;
import com.comp.contactmanager.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.comp.contactmanager.util.PersonValidatorUtil.isInCompanies;
import static com.comp.contactmanager.util.PersonValidatorUtil.isValidPhoneFormat;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final CompanyService companyService;
    private final PersonFromCreateMapper personFromCreateMapper;
    private final PersonRepository personRepository;

    public void createPerson(PersonCreateRequest personCreateRequest) {
        if (!isValidPhoneFormat(personCreateRequest.getPhoneNumber())) {
            throw new InvalidPhoneNumberException("Requested phone number is not valid");
        }

        List<String> companyNames = companyService.getCompanyNames();
        if (!isInCompanies(personCreateRequest.getCompany(), companyNames)) {
            throw new InvalidCompanyException("Requested company is not valid");
        }

        Person person = personFromCreateMapper.apply(personCreateRequest);
        personRepository.save(person);
    }

    public void deletePerson(PersonDeleteRequest personDeleteRequest) {
        Person person = personRepository.findPersonByFirstNameAndLastName(
                personDeleteRequest.getFirstName(),
                personDeleteRequest.getLastName());

        person.setStatus(Status.DELETED);
        person.setModifiedAt(LocalDateTime.now());

        personRepository.save(person);
    }

}
