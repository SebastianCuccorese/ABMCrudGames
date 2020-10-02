package com.example.accessingdatamysql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(path="/demo")

public class MainController {
    private CompanyRepository companyRepository;
    private GamesRepository gamesRepository;
    private PersonRepository personRepository;

    @PostMapping(path="/Company")
    public @ResponseBody String Company (@RequestParam String name, @RequestParam String email, @RequestParam Games games, @RequestParam Person person) {

        Company n = new Company();
        n.setCompanyName(name);
        n.setEmail(email);
        n.addGames(games);
        n.addPerson(person);
        companyRepository.save(n);
        return "Saved";
    }
    @PostMapping(path="/Game")
    public @ResponseBody String Game (@RequestParam String name, @RequestParam String genre, @RequestParam double timeAmount, @RequestParam Integer missionAmount, @RequestParam Company dev) {
        Games n = new Games();
        n.setName(name);
        n.setGenre(genre);
        n.setHoursAmount(timeAmount);
        n.setMissionsAmount(missionAmount);
        n.setDev(dev);
        gamesRepository.save(n);
        return "saved";
    }
    @PostMapping(path = "/Person")
    public @ResponseBody String Person(@RequestParam String name, @RequestParam String surname, @RequestParam Integer cellphone, @RequestParam Company company) {
        Person n = new Person();
        n.setName(name);
        n.setSurname(surname);
        n.setCellphoneNro(cellphone);
        n.setCompany(company);
        personRepository.save(n);
        return "saved";
    }

    @GetMapping(path="/allCompany")
    public @ResponseBody Iterable<Company> allCompany() {
        return companyRepository.findAll();
    }

    @GetMapping(path = "/CompanyByName")
    public @ResponseBody Iterable<Company> CompanyByName(@RequestParam String name) {
       return companyRepository.findByCompanyName(name);
    }

   @GetMapping(path = "/allGames")
    public @ResponseBody Iterable<Games> allGames() {
        return gamesRepository.findAll();
   }

   @GetMapping(path = "/gamesByName")
    public @ResponseBody Iterable<Games> gamesByName(@RequestParam String name) {
        return gamesRepository.findByName(name);
   }
   @GetMapping(path = "/gamesByDev")
    public @ResponseBody Iterable<Games> gamesByDev(@RequestParam String dev_Name) {
        return gamesRepository.findByDev_CompanyName(dev_Name);
   }
    @GetMapping(path = "/allPersons")
    public @ResponseBody Iterable<Person> allPersons() {
       return personRepository.findAll();
   }
    @GetMapping(path = "/personsByName")
    public @ResponseBody Iterable<Person> personsByName(String name) {
        return personRepository.findByName(name);
    }
    @GetMapping(path = "/personsBySurname")
    public @ResponseBody Iterable<Person> personsBySurname(String surname) {
        return personRepository.findBySurname(surname);
    }
    @GetMapping(path = "/personsByNameAndSurname")
    public @ResponseBody Iterable<Person> personsByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAnAndSurname(name, surname);
    }
    @GetMapping(path = "/personsByCompanyName")
    public @ResponseBody Iterable<Person> personaByCompanyName(String companyName) {
        return personRepository.findByCompany_CompanyName(companyName);
    }
}
