package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(path="/demo")
public class MainController {
    @Autowired private CompanyRepository companyRepository;
    @Autowired private GamesRepository gamesRepository;
    @Autowired private PersonRepository personRepository;

    @PostMapping(path = "/company")
    public @ResponseBody String company(@RequestBody String name) {
        Company n = new Company();
        n.setName(name);
        companyRepository.save(n);
        return "Saved";
    }
    @PostMapping(path="/game")
    public @ResponseBody String Game (@RequestBody String name, @RequestBody String genre, @RequestBody double timeAmount, @RequestBody Integer missionAmount, @RequestBody Company dev) {
        Games n = new Games();
        n.setName(name);
        n.setGenre(genre);
        n.setHoursAmount(timeAmount);
        n.setMissionsAmount(missionAmount);
        n.setDev(dev);
        gamesRepository.save(n);
        return "saved";
    }
    @PostMapping(path = "/person")
    public @ResponseBody String Person(@RequestBody String name, @RequestBody String surname, @RequestBody Integer cellphone, @RequestBody Company company) {
        Person n = new Person();
        n.setName(name);
        n.setSurname(surname);
        n.setCellphoneNro(cellphone);
        n.setCompany(company);
        personRepository.save(n);
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
