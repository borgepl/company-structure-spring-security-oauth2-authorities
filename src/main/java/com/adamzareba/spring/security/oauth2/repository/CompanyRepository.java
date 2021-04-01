package com.adamzareba.spring.security.oauth2.repository;

import com.adamzareba.spring.security.oauth2.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByName(String name);
}
