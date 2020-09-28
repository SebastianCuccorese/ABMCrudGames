package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(path="/demo")

public class MainController {
    @Autowired
    private DeveloperRepository developerRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewDeveloper (@RequestParam String name, @RequestParam String email) {

        Developer n = new Developer();
        n.setName(name);
        n.setEmail(email);
        developerRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }
}