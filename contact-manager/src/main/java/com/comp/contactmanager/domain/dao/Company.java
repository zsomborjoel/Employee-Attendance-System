package com.comp.contactmanager.domain.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(generator="COMPANY_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    @JsonIgnore
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @CreatedDate
    @Column(name = "creation_time")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modification_time")
    private LocalDateTime modifiedAt;

}
