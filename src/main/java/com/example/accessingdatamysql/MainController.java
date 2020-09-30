package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(path="/demo")

public class MainController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(path="/addDeveloper")
    public @ResponseBody String addNewDeveloper (@RequestParam String name, @RequestParam String email) {

        Company n = new Company();
        n.setCompanyName(name);
        n.setEmail(email);
        companyRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Company> getAllDevelopers() {
        return companyRepository.findAll();
    }
}