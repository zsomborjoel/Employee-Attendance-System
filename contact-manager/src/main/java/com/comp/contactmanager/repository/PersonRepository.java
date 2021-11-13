package com.comp.contactmanager.repository;

import com.comp.contactmanager.domain.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.firstName = ?1 and p.lastName = ?2")
    Person findPersonByFirstNameAndLastName(String firstName, String lastName);

}
