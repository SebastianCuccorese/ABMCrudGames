package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(path="/demo")
public class MainController {
    private final CompanyRepository companyRepository;
    private final GamesRepository gamesRepository;
    private final PersonRepository personRepository;

    public MainController(CompanyRepository companyRepository, GamesRepository gamesRepository, PersonRepository personRepository) {
        this.companyRepository = companyRepository;
        this.gamesRepository = gamesRepository;
        this.personRepository = personRepository;
    }

    @PostMapping(path = "/company")
    public @ResponseBody String company(@RequestBody Company company) {
        companyRepository.save(company);
        return "Saved";
    }
    @PostMapping(path="/game")
    public @ResponseBody String Game (@RequestBody Games games) {
        gamesRepository.save(games);
        return "saved";
    }
    @PostMapping(path = "/person")
    public @ResponseBody String Person(@RequestBody Person person) {
        personRepository.save(person);
        return "saved";
    }

    @GetMapping(path="/allcompany")
    public @ResponseBody Iterable<Company> allCompany() {
        return companyRepository.findAll();
    }

    @GetMapping(path = "/companybyname")
    public @ResponseBody Iterable<Company> CompanyByName(@RequestParam String name) {
       return companyRepository.findByName(name);
    }

   @GetMapping(path = "/allgames")
    public @ResponseBody Iterable<Games> allGames() {
        return gamesRepository.findAll();
   }

   @GetMapping(path = "/gamesbyname")
    public @ResponseBody Iterable<Games> gamesByName(@RequestParam String name) {
        return gamesRepository.findByName(name);
   }
   @GetMapping(path = "/gamesbydev")
    public @ResponseBody Iterable<Games> gamesByDev(@RequestParam String dev_Name) {
        return gamesRepository.findByDev_Name(dev_Name);
   }
    @GetMapping(path = "/allpersons")
    public @ResponseBody Iterable<Person> allPersons() {
       return personRepository.findAll();
   }
    @GetMapping(path = "/personsbyName")
    public @ResponseBody Iterable<Person> personsByName(String name) {
        return personRepository.findByName(name);
    }
    @GetMapping(path = "/personsbySurname")
    public @ResponseBody Iterable<Person> personsBySurname(String surname) {
        return personRepository.findBySurname(surname);
    }
    @GetMapping(path = "/personsbynameandsurname")
    public @ResponseBody Iterable<Person> personsByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
    @GetMapping(path = "/personsbycompanyname")
    public @ResponseBody Iterable<Person> personaByCompanyName(String companyName) {
        return personRepository.findByCompany_Name(companyName);
    }
}
