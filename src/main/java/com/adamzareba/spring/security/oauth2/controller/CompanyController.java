package com.adamzareba.spring.security.oauth2.controller;

import com.adamzareba.spring.security.oauth2.model.Company;
import com.adamzareba.spring.security.oauth2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secured/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    List<Company> getAll() {
        return companyService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Company get(@PathVariable Long id) {
        return (Company) companyService.get(id);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Company get(@RequestParam String name) {
        return companyService.get(name);
    }

//    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public ResponseEntity<?> create(@RequestBody Company company) {
//        companyService.create(company);
//        HttpHeaders headers = new HttpHeaders();
//        ControllerLinkBuilder linkBuilder = linkTo(methodOn(CompanyController.class).get(company.getId()));
//        headers.setLocation(linkBuilder.toUri());
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
//    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody Company company) {
        companyService.update(company);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}