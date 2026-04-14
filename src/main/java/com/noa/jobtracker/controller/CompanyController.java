package com.noa.jobtracker.controller;

import com.noa.jobtracker.model.Company;
import com.noa.jobtracker.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")

public class CompanyController {

    private final CompanyRepository companyRepository;
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    // client asks for all companies, we return all companies from the database- asks for information about all companies, server responds with all companies in the database.
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // client sends a new company to the server, we save it to the database and return the saved company with an id.
    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }


}
